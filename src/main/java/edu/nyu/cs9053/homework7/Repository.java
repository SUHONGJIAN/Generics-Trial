package edu.nyu.cs9053.homework7;

import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;

public class Repository<T> {

    private static final int DEFAULT_ARRAY_SIZE = 5;

    private final AtomicReference<T[]> array;

    private final ArrayCreator<T> arrayCreator;

    private final int initialSize;

    private int trueSize;

    public Repository(ArrayCreator<T> arrayCreator) {
        this(arrayCreator, DEFAULT_ARRAY_SIZE);
    }

    public Repository(ArrayCreator<T> arrayCreator, int initialSize) {
        this.arrayCreator = arrayCreator;
        this.array = new AtomicReference<>(resize(initialSize));
        this.initialSize = initialSize;
        trueSize = 0;
    }

    private T[] resize(int size) {
        return arrayCreator.create(size);
    }

    public boolean add(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Argument cannot be null!");
        }
        if (contains(value)) {
            return false;
        }
        if (this.trueSize == array.get().length) {
            T[] doubleArray = resize(trueSize + initialSize);
            for (int i = 0; i < array.get().length; i++) {
                doubleArray[i] = array.get()[i];
            }
            array.set(doubleArray);
        }
        this.array.get()[trueSize] = value;
        trueSize++;
        return true;
    }

    public boolean contains(T value) {
        if (value == null || array.get() == null) {
            return false;
        }
        for (T each: array.get()) {
            if (value == each) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(T value) {
        if (value == null || array.get() == null) {
            return false;
        }
        for (int i = 0; i < array.get().length; i++) {
            if (value == array.get()[i]) {
                for (int j = i; j < (array.get().length - 1); j++) {
                    array.get()[j] = array.get()[j+1];
                }
                array.get()[array.get().length] = null;
                trueSize--;
                return true;
            }
        }
        return false;
    }

    public T get(int index) {
        if (array.get() == null) {
            throw new NullPointerException("Error: There is nothing in this repository!");
        }
        if (index >= array.get().length) {
            throw new IllegalArgumentException("Error: The index does not exist!");
        }
        return array.get()[index];
    }

    public int size() {
        if (array.get() == null) {
            return 0;
        }
        return trueSize;
    }

}
