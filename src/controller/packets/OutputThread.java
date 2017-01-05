package controller.packets;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

import controller.actions.GameActions;
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

				if (socketAction == null) {
					try {
						socketAction = new SocketAction(new Socket(datas.getHost(), datas.getPort()));

						Thread inputThread = new Thread(new InputThread(socketAction, datas, this));
						inputThread.start();
						
					} catch (IOException e) {
						System.out.println("Impossible to initialize connection with the server");
					}
				}

				if (socketAction != null) {
					if (socketAction.isConnected()) {
						socketAction.send(cmd);
						System.out.println("Sent by client : " + cmd);
					} else {
						
						//If the connection to the server is lost : We reset the client
						GameActions.gameHasFinished(datas);
						socketAction = null;
						
					}
				}

			} catch (InterruptedException e) {

				socketAction = null;
				// this.closeThread = true;
			}

		}

	}
	public LinkedBlockingQueue getOutputQueue() {
		return outputQueue;
	}

	public void setOutputQueue(LinkedBlockingQueue outputQueue) {
		this.outputQueue = outputQueue;
	}

	public void closeSocketAction() {
		socketAction.closeConnections();
	}
	
	public boolean isConnected(){
		boolean r;
		if(socketAction != null)r=socketAction.isConnected();
		else r = false;
		return r;
	}

	
	
}
