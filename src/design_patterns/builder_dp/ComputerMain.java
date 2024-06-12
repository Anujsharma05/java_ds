package design_patterns.builder_dp;

import design_patterns.builder_dp.Computer.ComputerBuilder;

public class ComputerMain {
	public static void main(String args[]) {

		ComputerBuilder cb = new ComputerBuilder("1tb", "16gb").setBluetoothEnabled(false).setGraphicsCardEnabled(true);
		Computer computer = cb.build();

		System.out.println(computer);

	}
}
