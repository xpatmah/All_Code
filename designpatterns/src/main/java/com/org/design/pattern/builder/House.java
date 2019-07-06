package com.org.design.pattern.builder;

public class House {

	private boolean basement;
	
	public boolean getBasement() {
		return basement;
	}

	public boolean getRoom() {
		return room;
	}

	public boolean getAppartment() {
		return appartment;
	}

	public boolean getVila() {
		return vila;
	}

	private boolean room;
	
	private boolean appartment;
	
	private boolean vila;
	
	public House(HouseBuilder houseBuilder) {
		// TODO Auto-generated constructor stub
		this.appartment = houseBuilder.appartment;
		this.basement = houseBuilder.basement;
		this.room = houseBuilder.room;
		this.vila = houseBuilder.vila;
	}

	public static class HouseBuilder{
		
		private boolean basement;
		
		private boolean room;
		
		private boolean appartment;
		
		private boolean vila;
		
		
		public House build() {
			return new House(this);
		}
		
		public HouseBuilder buildBaseMent(boolean basement) {
			this.basement = basement;
			return this;
		}
		
		public HouseBuilder buildRoom(boolean room) {
			this.room = room;
			return this;
		}
		
		public HouseBuilder buildAppartment(boolean appartment) {
			this.appartment = appartment;
			return this;
		}
		
		public HouseBuilder buildVila(boolean vila) {
			this.vila = vila;
			return this;
		}
		
	}
	
}
