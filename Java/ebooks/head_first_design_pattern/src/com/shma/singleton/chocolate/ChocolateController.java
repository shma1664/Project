package com.shma.singleton.chocolate;

public class ChocolateController {

	public static void main(String[] args) {
		ChocolateBoiler boiler = ChocolateBoiler.getInstance();
		
		//װ��ԭ��
		boiler.fill();
		//���
		boiler.boil();
		//�ų�
		boiler.drain();
		
		// will return the existing instance
		ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();
	}
}
