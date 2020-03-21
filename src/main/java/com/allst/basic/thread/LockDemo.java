package com.allst.basic.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock
 * @author YiYa
 * @since 2020-03-22 上午 12:26
 */
public class LockDemo {

    public static void main(String[] args) {
        Windins w = new Windins();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("Windows1");
        t2.setName("Windows2");
        t3.setName("Windows3");

        t1.start();
        t2.start();
        t3.start();
    }

}

class Windins implements Runnable {

    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 买票， 票号: " + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}