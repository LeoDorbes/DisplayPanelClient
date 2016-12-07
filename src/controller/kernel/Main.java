package controller.kernel;

import java.util.concurrent.LinkedBlockingQueue;

import controller.data.FileLoader;
import controller.packets.InputThread;
import controller.packets.OutputThread;
import model.Datas;
import view.MainFrame;

public class Main {

	public static void main(String[] args) {
		
		Datas d = new Datas();
		FileLoader f = new FileLoader(d);
		
		//@TODO : Changer le chargement par un chargement BDD
		f.loadCountries("countries.csv");
		f.loadSports("sports.csv");
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