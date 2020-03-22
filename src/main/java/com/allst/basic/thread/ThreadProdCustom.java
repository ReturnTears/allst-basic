package com.allst.basic.thread;

/**
 * 生产者消费者问题
 * 涉及到技术分析:
 * 是否多线程？ 生产者、消费者
 * 是否共享数据？ 店员或产品
 * 是否解决线程的安全问题？ 同步机制，三种方式
 * 是否涉及线程通信？ 是
 *
 * @author YiYa
 * @since 2020-03-22 下午 06:14
 */
public class ThreadProdCustom {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者 : ");

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者 : ");

        p1.start();
        c1.start();

    }

}

class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "~开始生产产品......");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.prod();
        }
    }
}

class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "~开始消费产品......");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.cons();
        }
    }
}

class Clerk {

    private int num = 0;

    public synchronized void prod() {
        if (num < 20) {
            num++;
            System.out.println(Thread.currentThread().getName() + "开始生产第 " + num + "个产品~~~~");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void cons() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "开始消费第 " + num + "个产品~~~~");
            num--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}