package com.allst.basic.thread;

/**
 * 线程通信
 *
 * @author YiYa
 * @since 2020-03-22 上午 12:45
 */
public class ThreadCommmunication {

    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }

}

class Number implements Runnable {

    private int number = 17;

    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (this) { // this -> obj
                this.notify();      // this.notify(); -> obj.notify();
                // 多个线程(>2)时使用notifyAll()
                if (number <= 66) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 买票， 票号: " + number);
                    number++;

                    try {
                        this.wait();  // this.wait(); -> obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}