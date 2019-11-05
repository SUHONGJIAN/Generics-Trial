package edu.nyu.cs9053.homework7;

public class AnimalArrayCreator implements ArrayCreator<Animal> {

    @Override public Animal[] create(int size) {
        return new Animal[size];
    }

}
