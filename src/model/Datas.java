package model;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import controller.packets.InputThread;
import controller.packets.OutputThread;


public class Datas {
	
	//Connexion datas
	//@todo : To load from config file, later on.
	private InetAddress inAddress;
	private int port;
	private SocketAction socketAction;
	private OutputThread ot;
	
	//View datas :
	private ArrayList<String> countries;
	private ArrayList<String> sports;
	private ArrayList<Integer> sportsActions;
	private ArrayList<String[]> sportsActionsNames;

	
	public Datas(){
		//temporary :
		
		sportsActionsNames = new ArrayList<String[]>();
		countries = new ArrayList<String>();
		sports = new ArrayList<String>();
		sportsActions = new ArrayList<Integer>();	
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

	public InetAddress getInAddress() {
		return inAddress;
	}

	public void setInAddress(InetAddress inAddress) {
		this.inAddress = inAddress;
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
	
	
}

