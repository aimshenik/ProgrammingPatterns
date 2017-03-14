package com.imshenik.patterns.test;

public class AbstractFactoryPattern {

	public static void main(String[] args) {
		AbstractFactory factory = selectProductioneer("Microsoft");
		
		Mouse mouse = factory.createMouse();
		Keyboard keyboard = factory.createKeyboard();
		Dynamics dinamics = factory.createDynamics();
		
		mouse.leftClick();
		mouse.rightClick();
		
		keyboard.pressEnter();
		
		dinamics.play(true);
	}
	//этот метод позволит удобнее получить ту или иную фаюрику, достаточно будет
	//только поменять значение аргумента
	public static AbstractFactory selectProductioneer(String company) {
		if (company.equals("Apple")) {
			return new AppleFactory();
		} else if (company.equals("Microsoft")) {
			return new MicrosoftFactory();
		} else {
			return new AppleFactory();
		}
	}

}
//суть в том, что абстрактная фабрика создаёт не 1, а не сколько конечных "изделий"
//создаём три интерфейса
interface Mouse {
	void leftClick();

	void rightClick();
}

interface Keyboard {
	void pressEnter();
}

interface Dynamics {
	void play(boolean b);
}
//реализуем в виде классов
class MicrosoftMouse implements Mouse {
	public void leftClick() {
		System.out.println("на мышке Microsoft нажали ЛКМ");
	}

	public void rightClick() {
		System.out.println("на мышке Microsoft нажали ПКМ");
	}
}

class MicrosoftKeyboard implements Keyboard {
	public void pressEnter() {
		System.out.println("на клавиатуре Microsoft нажали ENTER");
	}
}

class MicrosoftDynamics implements Dynamics {
	public void play(boolean b) {
		if (b) {
			System.out.println("Включаем колонки Microsoft");
		} else {
			System.out.println("Выключаем колонки Microsoft");
		}
	}
}
//реализуем в виде классов второй раз
class AppleMouse implements Mouse {
	public void leftClick() {
		System.out.println("на мышке Apple нажали ЛКМ");
	}

	public void rightClick() {
		System.out.println("на мышке Apple нажали ПКМ");
	}
}

class AppleKeyboard implements Keyboard {
	public void pressEnter() {
		System.out.println("на клавиатуре Apple нажали ENTER");
	}
}

class AppleDynamics implements Dynamics {
	public void play(boolean b) {
		if (b) {
			System.out.println("Включаем колонки Apple");
		} else {
			System.out.println("Выключаем колонки Apple");
		}
	}
}


//создаём фабрику, у которой есть 3 метода для получения каждого из "продуктов"
interface AbstractFactory {
	
	Mouse createMouse();
	Keyboard createKeyboard();
	Dynamics createDynamics();
}
//создаем фабрику, производящую Аpple
class AppleFactory implements AbstractFactory {
	public Mouse createMouse() {
		return new AppleMouse();
	}

	public Keyboard createKeyboard() {
		return new AppleKeyboard();
	}

	public Dynamics createDynamics() {
		return new AppleDynamics();
	}

}
//создаем фабрику, производящую Microsoft
class MicrosoftFactory implements AbstractFactory {
	public Mouse createMouse() {
		return new MicrosoftMouse();
	}

	public Keyboard createKeyboard() {
		return new MicrosoftKeyboard();
	}

	public Dynamics createDynamics() {
		return new MicrosoftDynamics();
	}

}
