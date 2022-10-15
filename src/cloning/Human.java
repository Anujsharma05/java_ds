package cloning;

public class Human implements Cloneable{
    int age;
    String name;
    Address address;
    int[] arr;

    public Human(int age, String name, Address address) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.arr =  new int[]{1,3,4,6,7};
    }

//    public Human(Human other) {
//        this.age = other.age;
//        this.name = other.name;
//    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    //    shallow copy
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }


    //deep copy
    @Override
    public Human clone() throws CloneNotSupportedException {
        Human doppelganger = (Human) super.clone();

        doppelganger.arr = new int[doppelganger.arr.length];

        for(int i=0; i<doppelganger.arr.length; i++) {
            doppelganger.arr[i] = this.arr[i];
        }

        return doppelganger;
    }
}
