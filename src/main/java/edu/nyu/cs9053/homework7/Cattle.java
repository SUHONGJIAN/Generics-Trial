package edu.nyu.cs9053.homework7;

public class Cattle extends BarnyardAnimal implements Animal {

    public Cattle(String name) {
        super(name);
    }

    @Override public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cattle that = (Cattle) obj;
        return getName() == null ? that.getName() == null : getName().equals(that.getName());
    }

    @Override public int hashCode() {
        return getName() == null ? 0 : getName().hashCode();
    }

}
