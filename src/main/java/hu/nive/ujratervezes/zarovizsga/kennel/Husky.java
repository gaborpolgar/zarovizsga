package hu.nive.ujratervezes.zarovizsga.kennel;

import hu.nive.ujratervezes.zarovizsga.kennel.Dog;

public class Husky extends Dog {

    private String name;
    private int happiness;

    public Husky(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHappiness() {
        return happiness;
    }

    @Override
    public void feed() {
        happiness += 4;
    }

    @Override
    public void play(int hours) {
        happiness += 3 * hours;
    }
}
