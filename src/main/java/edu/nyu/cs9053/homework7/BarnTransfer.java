package edu.nyu.cs9053.homework7;

public class BarnTransfer {

    public void transfer(Barn<? extends Animal> from, Barn<? super Animal> to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        for (int i = 0; i < from.size(); i++) {
            if(from.get(i) != null) {
                to.add(from.get(i));
            }
        }
    }

//    public static void main(String[] args) {       //For test
//        ArrayCreator<Cattle> ac = new CattleArrayCreator();
//        ArrayCreator<Animal> ac2 = new AnimalArrayCreator();
//        Cattle c1 = new Cattle("su");
//        Cattle c2 = new Cattle("zhou");
//        Cattle c3 = new Cattle("liu");
//        Cattle c4 = new Cattle("wang");
//        BarnTransfer test = new BarnTransfer();
//        Barn<Cattle> from = new Barn<>(ac);
//        from.add(c1);
//        from.add(c2);
//        from.add(c3);
//
//        Barn<Animal> to = new Barn<>(ac2);
//        to.add(c4);
//
//        System.out.println(from.size());
//        System.out.println(to.size());
//        test.transfer(from, to);
//        System.out.println(from.size());
//        System.out.println(to.size());
//    }

}
