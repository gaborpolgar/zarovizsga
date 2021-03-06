package hu.nive.ujratervezes.zarovizsga.kennel;

import hu.nive.ujratervezes.zarovizsga.kennel.Dog;

public class Beagle extends Dog {

    private String name;
    private int happiness;

    public Beagle(String name) {
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
        happiness += 2;
    }

    @Override
    public void play(int hours) {
        happiness += hours * 2;
    }
}
