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
	//���� ����� �������� ������� �������� �� ��� ���� �������, ���������� �����
	//������ �������� �������� ���������
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
//���� � ���, ��� ����������� ������� ������ �� 1, � �� ������� �������� "�������"
//������ ��� ����������
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
//��������� � ���� �������
class MicrosoftMouse implements Mouse {
	public void leftClick() {
		System.out.println("�� ����� Microsoft ������ ���");
	}

	public void rightClick() {
		System.out.println("�� ����� Microsoft ������ ���");
	}
}

class MicrosoftKeyboard implements Keyboard {
	public void pressEnter() {
		System.out.println("�� ���������� Microsoft ������ ENTER");
	}
}

class MicrosoftDynamics implements Dynamics {
	public void play(boolean b) {
		if (b) {
			System.out.println("�������� ������� Microsoft");
		} else {
			System.out.println("��������� ������� Microsoft");
		}
	}
}
//��������� � ���� ������� ������ ���
class AppleMouse implements Mouse {
	public void leftClick() {
		System.out.println("�� ����� Apple ������ ���");
	}

	public void rightClick() {
		System.out.println("�� ����� Apple ������ ���");
	}
}

class AppleKeyboard implements Keyboard {
	public void pressEnter() {
		System.out.println("�� ���������� Apple ������ ENTER");
	}
}

class AppleDynamics implements Dynamics {
	public void play(boolean b) {
		if (b) {
			System.out.println("�������� ������� Apple");
		} else {
			System.out.println("��������� ������� Apple");
		}
	}
}


//������ �������, � ������� ���� 3 ������ ��� ��������� ������� �� "���������"
interface AbstractFactory {
	
	Mouse createMouse();
	Keyboard createKeyboard();
	Dynamics createDynamics();
}
//������� �������, ������������ �pple
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
//������� �������, ������������ Microsoft
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
