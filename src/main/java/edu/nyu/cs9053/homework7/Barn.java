package edu.nyu.cs9053.homework7;

public class Barn<T extends Animal> extends Repository<T> {

    public Barn(ArrayCreator<T> arrayCreator) {
        super(arrayCreator);
    }

    public Barn(ArrayCreator<T> arrayCreator, int initialSize) {
        super(arrayCreator, initialSize);
    }

}
