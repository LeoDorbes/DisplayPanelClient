package controller.packets;

import java.util.concurrent.LinkedBlockingQueue;

import model.Datas;

public class OutputThread implements Runnable {

	private boolean closeThread;
	private LinkedBlockingQueue<String> outputQueue;
	private Datas datas;

	public OutputThread(Datas datas) {
		this.closeThread = false;
		this.datas = datas;
		this.outputQueue = new LinkedBlockingQueue<String>();
	}

	public void run() {
		String cmd;
		while (!closeThread) {
			try {
				cmd = outputQueue.take();
				System.out.println(cmd);
			} catch (InterruptedException e) {
				this.closeThread = true;
			}
		}

	}

	public LinkedBlockingQueue getOutputQueue() {
		return outputQueue;
	}

	public void setOutputQueue(LinkedBlockingQueue outputQueue) {
		this.outputQueue = outputQueue;
	}
}
