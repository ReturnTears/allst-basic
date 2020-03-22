package com.allst.basic.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author YiYa
 * @since 2020-03-22 下午 10:52
 */
public class ThreadCallable {

    public static void main(String[] args) {
        CallThread thread = new CallThread();
        FutureTask<Integer> task = new FutureTask<Integer>(thread);
        Thread t = new Thread(task);
        t.start();
        try {
            Integer o = task.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

class CallThread implements Callable {

    @Override
    public Object call() throws Exception {
        int num = 0;
        for (int i = 0; i < 22; i++) {
            num += i;
        }
        return num;
    }
}