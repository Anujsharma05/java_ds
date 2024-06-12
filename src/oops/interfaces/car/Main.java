package oops.interfaces.car;

public class Main {
	public static void main(String[] args) {
		Engine e = new PetrolEngine();
		MusicPlayer mp = new CdPlayer();
		Car maruti = new Car(e, mp);
		maruti.startEngine();

		Car tesla = new Car(new ElectricEngine(), new CdPlayer());
		tesla.startEngine();
	}
}
