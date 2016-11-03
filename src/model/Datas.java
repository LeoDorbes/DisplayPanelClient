package model;

import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import controller.packets.InputThread;
import controller.packets.OutputThread;


public class Datas {
	
	//View 
	
	//View datas :
	private ArrayList<String> countries;
	private ArrayList<String> sports;
	private ArrayList<Integer> sportsActions;
	private ArrayList<String> sportsActionsNames;
	
	//Connexion datas :
	private OutputThread ot;
	private SocketAction socketAction;
	
	public Datas(){
		
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
	
}

