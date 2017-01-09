package com.imshenik.patterns.test;

import java.util.Date;

public class FactoryPattern {

	public static void main(String[] args) {
		WatchFactory factory = createMeWatch("444ome"); //���������� ��������� ��� ��� ���� �����
		Watch w = factory.createWatch(); // ������ ������� ������� ��� ����
		w.getTime(); // ������� �� ��� ����� =)

	}

	public static WatchFactory createMeWatch(String watchName) {
		if (watchName.equals("Digital")) {
			return new DigitalWatchFactory();
		} else if (watchName.equals("Rome")) {
			return new RomeWatchFactory();
		} else {
			System.out.println("����� ���� ����� �� ����������, ��� ��� �������� ��� ��������");
			return new DigitalWatchFactory();
		}
	}

}
//interface product
interface Watch {
	void getTime();
}
//concrete product
class DigitalWatch implements Watch {
	
	public void getTime() {
		System.out.println(new Date());
	}
}
//concrete product
class RomeWatch implements Watch {

	public void getTime() {
		System.out.println("X-XV");
	}
}
//interface creator
interface WatchFactory {
	Watch createWatch();
}
//concrete creator
class DigitalWatchFactory implements WatchFactory {

	public Watch createWatch() {
		return new DigitalWatch();
	}

}
//concrete creator
class RomeWatchFactory implements WatchFactory {

	public Watch createWatch() {
		return new RomeWatch();
	}

}
