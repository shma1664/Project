package com.shma.chapter14.test;

import com.shma.chapter14.test.activeobject.ActiveObject;
import com.shma.chapter14.test.activeobject.ActiveObjectFactory;

public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakerClientThread("Alice", activeObject).start();
        new MakerClientThread("Bobby", activeObject).start();
        new DisplayClientThread("Chris", activeObject).start();
    }
}
