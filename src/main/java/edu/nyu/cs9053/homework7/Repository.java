package edu.nyu.cs9053.homework7;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Arrays;     //to use Arrays.copyOf(), not use any Java collection type.

public class Repository<T> {

    private final AtomicReference<T[]> array;

    public Repository(T[] array) {
        this.array = new AtomicReference<>(array);
    }

    public boolean add(T value) {
        if (array.get() == null) {
            T[] addedArray = Arrays.copyOf(array.get(), 1);
            addedArray[0] = value;
            array.set(addedArray);
        }
        else {
            for (T each: array.get()) {
                if (value == each) {
                    return false;
                }
            }
            T[] addedArray = Arrays.copyOf(array.get(), array.get().length + 1);
            addedArray[array.get().length] = value;
            array.set(addedArray);
        }
        return true;
    }

    public boolean contains(T value) {
        if (array.get() == null) {
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
        if (array.get() == null) {
            return false;
        }
        for (int i = 0; i < array.get().length; i++) {
            if (value == array.get()[i]) {
                T[] removedArray = Arrays.copyOf(array.get(), array.get().length - 1);
                for (int j = i; j < removedArray.length; j++) {
                    removedArray[j] = array.get()[j+1];
                }
                array.set(removedArray);
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
        return array.get().length;
    }

}
