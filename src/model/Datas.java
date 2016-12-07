package model;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import view.MainFrame;
import view.MainPanel;
import controller.packets.InputThread;
import controller.packets.OutputThread;

public class Datas {
	
	public final static String separator = "%";

	// Main Frame & Panel :
	private MainFrame mainFrame;

	// Connexion datas
	// @todo : To load from config file, later on.
	private String host;
	private int port;
	private SocketAction socketAction;
	private OutputThread ot;

	// View datas :
	private ArrayList<String> countries;
	private ArrayList<String> sports;
	private ArrayList<Long> sportsTimes;
	private ArrayList<Integer> sportsActions;
	private ArrayList<String[]> sportsActionsNames;
	private boolean gameOn;

	public Datas() {

		// temporary :
		sportsActionsNames = new ArrayList<String[]>();
		countries = new ArrayList<String>();
		sports = new ArrayList<String>();
		sportsActions = new ArrayList<Integer>();
		sportsTimes = new ArrayList<Long>();
		gameOn = false;
	}

	public boolean isGameOn() {
		return gameOn;
	}

	public void setGameOn(boolean gameOn) {
		this.gameOn = gameOn;
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public ArrayList<String> getCountries() {
		return countries;
	}

	public void setCountries(ArrayList<String> countries) {
		this.countries = countries;
	}

	public ArrayList<String> getSports() {
		return sports;
	}

	public void setSports(ArrayList<String> sports) {
		this.sports = sports;
	}

	public ArrayList<Integer> getSportsActions() {
		return sportsActions;
	}

	public void setSportsActions(ArrayList<Integer> sportsActions) {
		this.sportsActions = sportsActions;
	}

	public ArrayList<String[]> getSportsActionsNames() {
		return sportsActionsNames;
	}

	public void setSportsActionsNames(ArrayList<String[]> sportsActionsNames) {
		this.sportsActionsNames = sportsActionsNames;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public SocketAction getSocketAction() {
		return socketAction;
	}

	public void setSocketAction(SocketAction socketAction) {
		this.socketAction = socketAction;
	}

	public OutputThread getOt() {
		return ot;
	}

	public void setOt(OutputThread ot) {
		this.ot = ot;
	}

	public ArrayList<Long> getSportsTimes() {
		return sportsTimes;
	}

	public void setSportsTimes(ArrayList<Long> sportsTimes) {
		this.sportsTimes = sportsTimes;
	}
	

}
