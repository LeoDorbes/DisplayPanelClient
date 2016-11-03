package controller.packets;

import java.util.concurrent.LinkedBlockingQueue;

public class OutputThread implements Runnable{

	LinkedBlockingQueue outputQueue;
	
	public OutputThread(){
		this.outputQueue = new LinkedBlockingQueue();
	}
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public LinkedBlockingQueue getOutputQueue() {
		return outputQueue;
	}
	public void setOutputQueue(LinkedBlockingQueue outputQueue) {
		this.outputQueue = outputQueue;
	}
}
