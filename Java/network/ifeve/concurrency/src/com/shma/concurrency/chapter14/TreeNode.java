package com.shma.concurrency.chapter14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ����ʵ��
 * �����߳�1����parent.addChild(child)����ΪaddChild()��ͬ���ģ������߳�1���parent��������Բ��������̷߳��ʸö���
 * Ȼ���߳�2����child.setParent(parent)����ΪsetParent()��ͬ���ģ������߳�2���child��������Բ��������̷߳��ʸö���
 * ����child��parent����������ͬ���߳���ס�ˡ��������߳�1���Ե���child.setParentOnly()��������������child�������ڱ��߳�2��ס�ģ����Ըõ��ûᱻ������
 * �߳�2Ҳ���Ե���parent.addChildOnly()����������parent�������ڱ��߳�1��ס�������߳�2Ҳ�����ڸ÷����������������̶߳����������ȴ��Ż�ȡ����һ���߳������е�����
 * @author admin
 *
 */
public class TreeNode {

	private TreeNode parentNode;
	
	private List<TreeNode> childrenNodes = new ArrayList<TreeNode>();
	
	public synchronized void addChild(TreeNode node) {
		if(!this.childrenNodes.contains(node)) {
			this.childrenNodes.add(node);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			node.setParentOnly(this);
		}
	}
	
	public synchronized void addChildOnly(TreeNode node) {
		if(!this.childrenNodes.contains(node)) {
			this.childrenNodes.add(node);
		}
	}
	
	public synchronized void setParent(TreeNode node) {
		this.parentNode = node;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parentNode.addChildOnly(this);
	}
	
	public synchronized void setParentOnly(TreeNode node) {
		this.parentNode = node;
	}
	
	public static void main(String[] args) {
		final TreeNode node = new TreeNode();
		final TreeNode parentNode = new TreeNode();
		
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				parentNode.addChild(node);
				
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				node.setParent(parentNode);
			}
		});
		
		thread1.start();
		thread2.start();
	}
	
}
