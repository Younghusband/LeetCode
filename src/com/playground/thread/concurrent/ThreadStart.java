package com.playground.thread.concurrent;

/**
 * @description
 * @author vermouth.Mac
 * @version 2018年2月27日 下午5:35:56
 */

public class ThreadStart {
	public static void main(String[] args) {
		Thread t1 = new ThreadA();
		Thread t2 = new ThreadB();
		Thread t3 = new ThreadC();
		t1.start();
		t2.start();
		t3.start();
	}
}

class ThreadA extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 4; i++) {
			try {
				Thread.sleep(95);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("A: ");
			for (int j = 15 * (i - 1) + 1; j < (15 * (i - 1) + 6); j++) {
				if (j != 15 * (i - 1) + 5)
					System.out.print(j + " ");
				else
					System.out.print(j);
			}
			System.out.println("");
		}
	}
}

class ThreadB extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 4; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("B: ");
			for (int j = 15 * (i - 1) + 6; j < 15 * (i - 1) + 11; j++) {
				if (j != 15 * (i - 1) + 10)
					System.out.print(j + " ");
				else
					System.out.print(j);
			}
			System.out.println("");
		}
	}
}

class ThreadC extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 4; i++) {
			try {
				Thread.sleep(105);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("C: ");
			for (int j = 15 * (i - 1) + 11; j < 15 * i + 1; j++) {
				if (j != 15 * i)
					System.out.print(j + " ");
				else
					System.out.print(j);
			}
			System.out.println("");
		}
	}
}
