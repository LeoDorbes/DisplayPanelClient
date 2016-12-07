package controller.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Datas;

public class FileLoader {

	private Datas datas;

	public FileLoader(Datas datas) {
		this.datas = datas;

	}

	public void loadCountries(String filePath) {
		File file = new File(filePath);
		try {

			Scanner scanner = new Scanner(file);
			int i = 0;
			String[] lineStrings;
			while (scanner.hasNextLine()) {
				i++;
				lineStrings = scanner.nextLine().split(";");

				if (lineStrings.length != 1) {
					System.out.println("Ligne " + i + " du fichier " + filePath + " non lisible");
				} else {
					datas.getCountries().add(lineStrings[0]);
				}
			}

		} catch (FileNotFoundException e) {

			System.err.println("Erreur : fichier de liste des pays inexistant!");

		}
	}

	public void loadSports(String filePath) {
		File file = new File(filePath);
		try {
			Scanner scanner = new Scanner(file);
			int i = 0;
			String[] lineStrings;
			while (scanner.hasNextLine()) {
				i++;
				lineStrings = scanner.nextLine().split(";");

				if (lineStrings.length < 3) {
					System.out.println("Ligne " + i + " du fichier " + filePath + " non lisible");
				} else {
					try {
						long timer = Long.parseLong(lineStrings[1]);
						int methodCount = Integer.parseInt(lineStrings[2]);
						if (lineStrings.length != methodCount + 3) {
							System.out.println("Ligne " + i + " du fichier " + filePath + " non lisible");
						} else {
							String[] s = new String[methodCount];
							for (int j = 0; j < methodCount; j++) {
								s[j] = lineStrings[j + 3];
							}
							datas.getSportsActionsNames().add(s);
							datas.getSports().add(lineStrings[0]);
							datas.getSportsActions().add(methodCount);
							datas.getSportsTimes().add(timer);
						}

					} catch (NumberFormatException e) {
						System.out.println("Ligne " + i + " du fichier ne respecte pas le bon format ");
					}
				}
			}
		} catch (FileNotFoundException e) {

			System.err.println("Erreur : fichier de liste des sports inexistant!");

		}
	}

	public void loadConfig(String filePath) {
		File file = new File(filePath);
		try {
			Scanner scanner = new Scanner(file);
			int i = 0;
			String[] lineStrings;

			// Loading the ip adress :
			lineStrings = scanner.nextLine().split(";");

			datas.setHost(lineStrings[0]);
			
			lineStrings = scanner.nextLine().split(";");
			try{
				datas.setPort(Integer.parseInt(lineStrings[0]));
			}catch(NumberFormatException e){
				System.out.println("Erreur : Le format du port est incorrect dans votre fichier de config!");
			}
			
			//System.out.println(datas.getInAddress());
			//System.out.println(datas.getPort());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Fichier de configuration chargé --- PORT : "+datas.getPort()+" --- IP : "+datas.getHost());
	}

}
