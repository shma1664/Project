package com.shma.chapter14.test;

import com.shma.chapter14.test.activeobject.ActiveObject;
import com.shma.chapter14.test.activeobject.Result;

public class MakerClientThread extends Thread {
    private final ActiveObject activeObject;
    private final char fillchar;
    public MakerClientThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
        this.fillchar = name.charAt(0);
    }
    public void run() {
        try {
            for (int i = 0; true; i++) {
                // û�д���ֵ�ĺ���
                Result result = activeObject.makeString(i, fillchar);
                Thread.sleep(10);
                String value = (String)result.getResultValue();
                System.out.println(Thread.currentThread().getName() + ": value = " + value);
            }
        } catch (InterruptedException e) {
        }
    }
}
