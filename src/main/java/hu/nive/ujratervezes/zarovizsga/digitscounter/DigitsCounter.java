package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DigitsCounter {

//    private static final int NON_DIGIT = -1;

    public int getCountOfDigits(String s) {
        if (isNull(s)) {
            return 0;
        }
        Set<Integer> variousNumbers = new HashSet<>();
        int temp;
        for (int i = 0; i < s.length(); i++) {
            if (isDigit(s, i)) {
                temp = Character.getNumericValue(s.charAt(i));
                variousNumbers.add(temp);
            }
        }
            return variousNumbers.size();
    }

    private boolean isDigit(String s, int i) {
        return Character.getNumericValue(s.charAt(i)) < 10 && Character.getNumericValue(s.charAt(i)) > 0;
    }

    private boolean isNull (String s){
            return s == null;
        }
}
