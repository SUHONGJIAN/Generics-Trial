package edu.nyu.cs9053.homework7;

public class CattleArrayCreator implements ArrayCreator<Cattle> {

    @Override public Cattle[] create(int size) {
        return new Cattle[size];
    }

}
