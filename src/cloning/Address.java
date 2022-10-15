package cloning;

public class Address {
    int plotno;
    String city;

    public Address(int plotno, String city) {
        this.plotno = plotno;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "plotno=" + plotno +
                ", city='" + city + '\'' +
                '}';
    }
}
