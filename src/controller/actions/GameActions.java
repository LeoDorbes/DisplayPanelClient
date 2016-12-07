package controller.actions;

import java.util.Timer;

import model.Datas;

/**
 * GameActions contains all the controller methods related to receiving from the
 * network of the program. They are all declared as static, because they receive
 * their datas in parameters.
 * 
 * @author Léo Dorbes
 * @version 1.0 01 Dec, 2016.
 */
public class GameActions {

	/**
	 * This method is called when a new game has been started by the server, and
	 * we are getting notified for it.
	 * 
	 * @param cmd
	 *            Value of the command received by the server
	 */
	public static void gameHasStarted(Datas datas) {
		datas.setGameOn(true);
		datas.getMainFrame().updateContent();
	}

	public static void gameHasFinished(Datas datas) {
		datas.setGameOn(false);
		datas.getMainFrame().updateContent();
	}

	public static void gameIsOn(Datas datas) {
		int val = datas.getMainFrame().syncronizeWithServer();

		if (val == 0) { // YES :
			datas.getOt().getOutputQueue().add("get game");
			
		} else if (val == 1) { // NO :

			datas.getOt().closeSocketAction();
			
			System.out.println("Disconnected from server");
		} else { // Error :

		}
	}

	public static void loadCurrentGame(Datas datas, String cmd) {

		boolean error = false;
		int sportVal;
		int homeVal;
		int guestVal;
		String[] values;
		String s;
		values = cmd.split(Datas.separator);

		if (values.length == 4) {
			s = values[1];
			sportVal = datas.getSports().indexOf(s);
			if (sportVal != -1) {
				s = values[2];
				homeVal = datas.getCountries().indexOf(s);
				if (homeVal != -1) {
					s = values[3];
					guestVal = datas.getCountries().indexOf(s);
					if (guestVal != -1) {

						// Reaching here means the data is correct :

						datas.getMainFrame().setGameFromServer(sportVal, homeVal, guestVal);
						GameActions.gameHasStarted(datas);

					} else {
						System.out.println("Error : Guest team received from server not found");
						error = true;
					}
				} else {
					System.out.println("Error : Home team received from server not found");
					error = true;
				}
			} else {
				System.out.println("Error : Sports received from server not found");
				error = true;
			}
		} else {
			System.out.println("Error : Wrong game format from server");
			error = true;
		}

	}

}
