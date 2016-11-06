package controller.packets;



import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

import model.Datas;
import model.SocketAction;

public class OutputThread implements Runnable {

	private boolean closeThread;
	private LinkedBlockingQueue<String> outputQueue;
	private Datas datas;
	private SocketAction socketAction;

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
				
				if(socketAction ==null){
					
					try {
						socketAction = new SocketAction(new Socket(datas.getInAddress(), datas.getPort()));
					} catch (IOException e) {
						System.out.println("test erreur");
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
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
