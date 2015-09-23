package com.shma.recursive;

/**
 * 汉诺塔
 * @author h p
 *
 */
public class HanoiTower {

	/**
	 * 移动汉诺塔
	 * @param topNum 移动的盘子层数
	 * @param from 起始塔座
	 * @param tmp 中间 塔座
	 * @param to 目标塔座
	 */
	public static void doTower(int topNum, String from, String tmp, String to) {
		if(topNum == 1) {
			System.out.println("盘子" + topNum + "从" + from + "移动到" + to + "盘座");
		} else {
			//移动topNum-1到中间盘子
			doTower(topNum - 1, from, to, tmp);
			//移动底座盘子到目标盘子
			System.out.println("盘子" + topNum + "从" + from + "移动到" + to + "盘座");
			//移动上层的盘子
			doTower(topNum - 1, tmp, from, to);
		}
	}
	
	public static void main(String[] args) {
		HanoiTower.doTower(3, "A", "B", "C");
	}
}
