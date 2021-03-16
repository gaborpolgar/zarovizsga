package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class DogTypes {

    DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select name from dog_types where country = ?")) {
            stmt.setString(1, country.toUpperCase());
            return selectDogsByPreparedStatement(stmt);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot connect the database", sqlException);
        }
    }

    private List<String> selectDogsByPreparedStatement(PreparedStatement stmt) {
        List<String> results = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                results.add(rs.getString("name").toLowerCase());
            }
            results.sort(Collator.getInstance(new Locale("hu", "HU")));
            return results;
        } catch (SQLException sqlException) {
            throw new IllegalStateException("The preparedStatement is not appropriate", sqlException);
        }
    }
}
