package controller.packets;

import java.io.IOException;

import controller.actions.GameActions;
import model.Datas;
import model.SocketAction;

public class InputThread implements Runnable {

	private OutputThread outputThread;
	private Datas datas;
	private SocketAction socketAction;

	public InputThread(SocketAction socketAction, Datas datas, OutputThread outputThread) {
		this.outputThread = outputThread;
		this.datas = datas;
		this.socketAction = socketAction;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		String s;
		String[] firstString;

		while (socketAction.isConnected()) {

			try {
				s = (String) socketAction.receive();
				System.out.println("recu : " + s);

				firstString = s.split(Datas.separator);

				switch (firstString[0].toLowerCase()) {
				case "current game":
					GameActions.loadCurrentGame(datas, s);
					break;
				case "game finished":
					GameActions.gameHasFinished(datas);
					break;
				case "game started":
					GameActions.gameHasStarted(datas);
					break;
				case "game canceled":
					GameActions.gameHasFinished(datas);
					break;
				case "game is on":
					GameActions.gameIsOn(datas);
					break;
				default:
					break;
				}
			} catch (ClassNotFoundException e) {
				System.out.println("Message recu non conforme!");
			} catch (IOException e) {
				socketAction.closeConnections();
				System.out.println("Déconnexion du client");
			}

			datas.getMainFrame().updateContent();
		}
		outputThread.getOutputQueue().add("clear");

		System.out.println("Fermeture de la connexion serveur!");

	}

}
