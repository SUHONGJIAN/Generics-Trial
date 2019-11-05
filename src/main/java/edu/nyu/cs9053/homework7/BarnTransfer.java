package edu.nyu.cs9053.homework7;

public class BarnTransfer<T> {

    public void transfer(Barn<? extends T> from, Barn<? super T> to) {
        for (int i = 0; i < from.size(); i++) {
                to.add((T) from.get(i));
        }
    }

}
