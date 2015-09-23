package com.shma.recursive;

/**
 * ��ŵ��
 * @author h p
 *
 */
public class HanoiTower {

	/**
	 * �ƶ���ŵ��
	 * @param topNum �ƶ������Ӳ���
	 * @param from ��ʼ����
	 * @param tmp �м� ����
	 * @param to Ŀ������
	 */
	public static void doTower(int topNum, String from, String tmp, String to) {
		if(topNum == 1) {
			System.out.println("����" + topNum + "��" + from + "�ƶ���" + to + "����");
		} else {
			//�ƶ�topNum-1���м�����
			doTower(topNum - 1, from, to, tmp);
			//�ƶ��������ӵ�Ŀ������
			System.out.println("����" + topNum + "��" + from + "�ƶ���" + to + "����");
			//�ƶ��ϲ������
			doTower(topNum - 1, tmp, from, to);
		}
	}
	
	public static void main(String[] args) {
		HanoiTower.doTower(3, "A", "B", "C");
	}
}
