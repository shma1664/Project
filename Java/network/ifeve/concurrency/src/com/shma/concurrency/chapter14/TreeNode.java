package com.shma.concurrency.chapter14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 死锁实现
 * 首先线程1调用parent.addChild(child)。因为addChild()是同步的，所以线程1会对parent对象加锁以不让其它线程访问该对象。
 * 然后线程2调用child.setParent(parent)。因为setParent()是同步的，所以线程2会对child对象加锁以不让其它线程访问该对象。
 * 现在child和parent对象被两个不同的线程锁住了。接下来线程1尝试调用child.setParentOnly()方法，但是由于child对象现在被线程2锁住的，所以该调用会被阻塞。
 * 线程2也尝试调用parent.addChildOnly()，但是由于parent对象现在被线程1锁住，导致线程2也阻塞在该方法处。现在两个线程都被阻塞并等待着获取另外一个线程所持有的锁。
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
