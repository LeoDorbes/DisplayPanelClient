package controller.kernel;

import java.util.concurrent.LinkedBlockingQueue;

import controller.data.DatabaseLoader;
import controller.data.FileLoader;
import controller.packets.InputThread;
import controller.packets.OutputThread;
import model.Datas;
import view.MainFrame;

/**
 * Main, handle the launching and initialization of the client.
 * 
 * @author Léo Dorbes
 * @version 1.0 01 Dec, 2016.
 */
public class Main {

	public static void main(String[] args) {
		
		Datas d = new Datas();
		FileLoader f = new FileLoader(d);
		
		DatabaseLoader dl = new DatabaseLoader(d);
		
		//@TODO : Changer le chargement par un chargement BDD
		
		dl.loadCountries();
		dl.loadSports();
		f.loadConfig("config.csv");
		
		OutputThread ot = new OutputThread(d);
		new Thread(ot).start();
		d.setOt(ot);
		
		
		MainFrame p = new MainFrame(d,ot.getOutputQueue());
		d.setMainFrame(p);
		
		p.setListeners();
		p.updateContent();
		
	}
}