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
		f.loadCountries("countries.csv");
		f.loadSports("sports.csv");
		
		MainFrame p = new MainFrame(d);
		
		p.setListeners();
		p.updateContent();
		
	}
}