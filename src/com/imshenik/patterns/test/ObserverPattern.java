package com.imshenik.patterns.test;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsoleObserver co = new ConsoleObserver();

		Meteostation station = new Meteostation();
		station.addObserver(co);
		station.addObserver(co);
		station.addObserver(co);

		for (int i = 0; i < 3; i++) {
			station.setMeasurements(i * 3, i * 33);
			try {
				Thread.sleep(1000);
				if (!station.observers.isEmpty()) {
					System.out.println(true);
					station.removeObserver(co);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

	class Meteostation implements Observed {

		int temperature;
		int pressure;

		public void setMeasurements(int t, int p) {
			temperature = t;
			pressure = p;
			notifyObservers();
		}

		List<Observer> observers = new ArrayList<>();

		@Override
		public void addObserver(Observer o) {
			observers.add(o);

		}

		@Override
		public void removeObserver(Observer o) {
			observers.remove(o);

		}

		public void removeObserver(int i) {
			observers.remove(i);

		}

		@Override
		public void notifyObservers() {
			for (Observer o : observers) {
				o.handleEvent(temperature, pressure);
			}
		}

	}

	interface Observed {
		void addObserver(Observer o);

		void removeObserver(Observer o);

		void notifyObservers();
	}

	interface Observer {
		void handleEvent(int temp, int presser);
	}

class ConsoleObserver implements Observer {

	@Override
	public void handleEvent(int temp, int presser) {
		System.out.println("Теперь температура = " + temp + ", и давление = " + presser + ".");
	}

}
