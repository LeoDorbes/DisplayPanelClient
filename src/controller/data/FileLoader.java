package controller.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
				}else{
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

				if (lineStrings.length != 2) {
					System.out.println("Ligne " + i + " du fichier " + filePath + " non lisible");
				} else{
					try{
						int methodCount = Integer.parseInt(lineStrings[1]);
						datas.getSports().add(lineStrings[0]);
						datas.getSportsActions().add(methodCount);
					}catch(NumberFormatException e){
						System.out.println("Ligne " + i + " du fichier ne respecte pas le bon format ");
					}
				}
			}
		} catch (FileNotFoundException e) {

			System.err.println("Erreur : fichier de liste des sports inexistant!");

		}
	}

	

}
