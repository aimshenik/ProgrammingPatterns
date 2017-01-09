package com.imshenik.patterns.test;

public class DelegatePattern {

	public static void main(String[] args) {
		AnimalSeller s = new AnimalSeller();
		s.setAnimal(new Giraffe());
		s.testRoar();
		s.setAnimal(new Elefant());
		s.testRoar();

	}

}

interface Animal {
	public void roar();
}

class Elefant implements Animal {
	public void roar() {
		System.out.println("Я слон!");
	}
}

class Giraffe implements Animal {
	public void roar() {
		System.out.println("Я жираф!");
	}
}

class AnimalSeller {
	Animal a;

	public void setAnimal(Animal animal) {
		a = animal;
	}

	public void testRoar() {
		a.roar();
	}

}