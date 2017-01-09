package com.imshenik.patterns.test;

public class FacadePattern {

	public static void main(String[] args) {
		Computer comp = new Computer();
		comp.copy();
	}
}

class Computer {
	Power p = new Power();
	DVDRom dvd = new DVDRom();
	HDD HDD = new HDD();

	void copy() {
		p.on();
		dvd.load();
		HDD.copyFromDVD(dvd);
	}
}

class Power {
	void on() {
		System.out.println("Включаем ПК");
	}

	void off() {
		System.out.println("Выключаем ПК");
	}
}

class DVDRom {
	private boolean data = false;

	public boolean hasData() {
		return data;
	}

	void load() {
		data = true;
	}

	void unload() {
		data = false;
	}

}

class HDD {

	void copyFromDVD(DVDRom dvd) {
		if (dvd.hasData()) {
			System.out.println("Копируем данные");
		} else {
			System.out.println("Вставьте диск");
		}

	}

}