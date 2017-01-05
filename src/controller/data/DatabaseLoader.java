package controller.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import model.Datas;

public class DatabaseLoader {

	private Datas datas;

	public DatabaseLoader(Datas datas) {
		this.datas = datas;

	}

	public void loadCountries() {

		DBAction.DBConnexion();
		String req = ("SELECT * FROM countries;");

		try {
			DBAction.setRes(DBAction.getStm().executeQuery(req));
		} catch (SQLException ex) {
			System.out.println("UserDAO SQL Error : " + ex.getErrorCode());
			System.out.println(ex.getMessage());
		}
		try {
			while (DBAction.getRes().next()) {

				// int id = DBAction.getRes().getInt(1);
				String name = DBAction.getRes().getString(2);
				datas.getCountries().add(name);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		DBAction.DBClose();
		System.out.println("Pays chargés depuis la BDD");

	}

	public void loadSports() {

		DBAction.DBConnexion();
		String req = ("SELECT * FROM sports;");

		try {
			DBAction.setRes(DBAction.getStm().executeQuery(req));
		} catch (SQLException ex) {
			System.out.println("UserDAO SQL Error : " + ex.getErrorCode());
			System.out.println(ex.getMessage());
		}
		try {
			while (DBAction.getRes().next()) {

				// int id = DBAction.getRes().getInt(1);
				String name = DBAction.getRes().getString(2);
				int actionCount = DBAction.getRes().getInt(3);
				long timer = DBAction.getRes().getLong(4);
				datas.getSports().add(name);
				datas.getSportsActions().add(actionCount);
				datas.getSportsTimes().add(timer);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		req = ("SELECT * FROM sport_actions;");

		int id = 0;
		ArrayList<String> as = new ArrayList<String>();
		try {
			DBAction.setRes(DBAction.getStm().executeQuery(req));
		} catch (SQLException ex) {
			System.out.println("UserDAO SQL Error : " + ex.getErrorCode());
			System.out.println(ex.getMessage());
		}
		try {
			String name="";
			while (DBAction.getRes().next()) {

				// int id = DBAction.getRes().getInt(1);
				int sportId = DBAction.getRes().getInt(2);
				name = DBAction.getRes().getString(3);
				if (id == 0) {
					id = sportId;
					as.add(name);
				} else if (id == sportId) {
					as.add(name);
				} else {

					String[] sTab = new String[as.size()];
					int i = 0;
					for (String string : as) {
						sTab[i] = string;
						i++;
					}
					
					datas.getSportsActionsNames().add(sTab);
					id = sportId;
					as.clear();
					as.add(name);
				}

			}
			String[] sTab = new String[as.size()];
			int i = 0;
			for (String string : as) {
				sTab[i] = string;
				i++;
			}
			System.out.println(sTab[0]);
			
			datas.getSportsActionsNames().add(sTab);
			as.clear();
			as.add(name);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		
		DBAction.DBClose();
		System.out.println("Sports chargés depuis la BDD");
	}
}
