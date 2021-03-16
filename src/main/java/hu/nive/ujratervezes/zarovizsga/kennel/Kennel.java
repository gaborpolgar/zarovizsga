package hu.nive.ujratervezes.zarovizsga.kennel;

import hu.nive.ujratervezes.zarovizsga.kennel.Dog;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    private List<Dog> dogs = new ArrayList<>();

    void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        for (Dog dog : dogs) {
            dog.feed();
        }
    }

    public Dog findByName(String name) {
        for (Dog dog : dogs) {
            if (name.equals(dog.getName())) {
                return dog;
            }
        }
        throw new IllegalArgumentException("Cannot find dog with " + name + " in this kennel!");
    }

    public void playWith(String name, int hours) {
        findByName(name).play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness) {
        List<String> result = new ArrayList<>();
        for (Dog dog : dogs) {
            if (dog.getHappiness() > minHappiness) {
                result.add(dog.getName());
            }
        }
        return result;
    }

    public List<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }
}
