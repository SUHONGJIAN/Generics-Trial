package edu.nyu.cs9053.homework7;

public class Barn<T extends Animal> extends Repository<T> {

    public Barn(T[] array) {
        super(array);
    }

}
