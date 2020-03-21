package com.allst.basic.thread;

/**
 * 同步代码块解决线程安全问题
 *
 * @author YiYa
 * @since 2020-03-21 下午 10:54
 */
public class Wind2 {

    public static void main(String[] args) {
        Winds2 w1 = new Winds2();
        Winds2 w2 = new Winds2();
        Winds2 w3 = new Winds2();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }

}

class Winds2 extends Thread {
    private static int ticket = 22;

    private static Object object = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
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
            }
        }
    }
}