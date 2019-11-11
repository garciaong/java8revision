package design.pattern;

public class Builder {

	public static void main(String[] args) {
		CarBuilder builder = new CarBuilder().setEngine("1.5Turbo")
				.setModel("Proton x50").setSegment("B").setTransmission("7DCT");
		Car x50 = builder.build();
		System.out.println(String.format("Car model %s, Engine - %s, Transmission - %s,"
				+ " Segment - %s", x50.getModel(), x50.getEngine(), x50.getTransmission(),
				x50.getSegment()));
	}

	private static class CarBuilder {
		private String model;
		private String engine;
		private String transmission;
		private String segment;

		public CarBuilder setModel(String model) {
			this.model = model;
			return this;
		}

		public CarBuilder setEngine(String engine) {
			this.engine = engine;
			return this;
		}

		public CarBuilder setTransmission(String transmission) {
			this.transmission = transmission;
			return this;
		}

		public CarBuilder setSegment(String segment) {
			this.segment = segment;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}

	private static class Car {
		private String model;
		private String engine;
		private String transmission;
		private String segment;

		public Car(CarBuilder builder) {
			this.model = builder.model;
			this.engine = builder.engine;
			this.transmission = builder.transmission;
			this.segment = builder.segment;
		}

		public String getModel() {
			return model;
		}

		public String getEngine() {
			return engine;
		}

		public String getTransmission() {
			return transmission;
		}

		public String getSegment() {
			return segment;
		}
	}
}
