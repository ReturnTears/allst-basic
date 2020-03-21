package com.allst.basic.thread;

/**
 * 同步代码块解决线程安全问题
 *
 * @author YiYa
 * @since 2020-03-21 下午 10:54
 */
public class Wind {

    public static void main(String[] args) {
        Winds w = new Winds();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

}

class Winds implements Runnable {
    private int ticket = 22;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 买票， 票号: " + ticket);
                    ticket--;
                }
            }
        }
    }
}