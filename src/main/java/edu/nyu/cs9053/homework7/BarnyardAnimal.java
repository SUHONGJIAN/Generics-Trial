package edu.nyu.cs9053.homework7;

public abstract class BarnyardAnimal implements Animal {

    private final String name;

    protected BarnyardAnimal(String name) {
        this.name = name;
    }

    @Override public String getName() {
        return name;
    }

}
