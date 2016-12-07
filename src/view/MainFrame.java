package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Datas;

public class MainFrame extends JFrame {

	private LinkedBlockingQueue<String> commands;
	private Datas datas;
	private MainPanel mainPanel;

	public MainFrame(Datas datas, LinkedBlockingQueue<String> commands) {

		this.commands = commands;
		this.datas = datas;
		this.setSize(800, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Contrôle du panneau");
		this.setVisible(true);
		this.mainPanel = new MainPanel(datas);
		this.setContentPane(mainPanel);

	}

	public void setGameFromServer(int sportIndex, int homeIndex, int guestIndex) {

		try {
			mainPanel.getSportComboBox().setSelectedIndex(sportIndex);
			mainPanel.getHomeComboBox().setSelectedIndex(homeIndex);
			mainPanel.getGuestComboBox().setSelectedIndex(guestIndex);
		} catch (IllegalArgumentException e) {

			// Theorically : this can only happen if the datas and the view have
			// different values wich should NEVER happen
			System.out.println("Error : index sent to the view are wrong");
			System.out.println("The view and the datas are not syncronized");
		}

	}

	public int syncronizeWithServer() {

	return JOptionPane.showInternalOptionDialog(mainPanel, "Une partie est déjà en cours, voulez vous syncroniser l'affichage avec cette partie?",
			"Syncroniser?",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.INFORMATION_MESSAGE,
			null, null,null);
		
	}

	public void updateContent() {
		updateGuestComboBox();
		updateHomeComboBox();
		updateSportComboBox();
		updateConnectedStatus();
		gameOnDisplay();
	}

	public void updateSportComboBox() {

		int selected = mainPanel.getSportComboBox().getSelectedIndex();
		mainPanel.getSportComboBox().removeAllItems();
		for (String sport : datas.getSports()) {
			mainPanel.getSportComboBox().addItem(sport);
		}
		if (!(selected > mainPanel.getSportComboBox().getItemCount()) && selected != -1)
			mainPanel.getSportComboBox().setSelectedIndex(selected);
	}

	public void updateGuestComboBox() {
		int selected = mainPanel.getGuestComboBox().getSelectedIndex();
		mainPanel.getGuestComboBox().removeAllItems();
		for (String country : datas.getCountries()) {
			// if(mainPanel.getHomeComboBox().getSelectedItem() != country)
			mainPanel.getGuestComboBox().addItem(country);
		}
		if (!(selected > mainPanel.getGuestComboBox().getItemCount()) && selected != -1)
			mainPanel.getGuestComboBox().setSelectedIndex(selected);
	}

	public void updateHomeComboBox() {
		int selected = mainPanel.getHomeComboBox().getSelectedIndex();
		mainPanel.getHomeComboBox().removeAllItems();
		for (String country : datas.getCountries()) {
			// if(mainPanel.getGuestComboBox().getSelectedItem() != country)
			mainPanel.getHomeComboBox().addItem(country);
		}
		if (!(selected > mainPanel.getHomeComboBox().getItemCount()) && selected != -1)
			mainPanel.getHomeComboBox().setSelectedIndex(selected);
	}

	public void updateConnectedStatus(){
		if(datas.getOt().isConnected()){
			mainPanel.getLblConnection().setForeground(Color.GREEN);
			mainPanel.getLblConnection().setText("ON");
		}else{
			mainPanel.getLblConnection().setForeground(Color.RED);
			mainPanel.getLblConnection().setText("OFF");
		}
	}
	public void gameOnDisplay() {

		boolean status = !datas.isGameOn();
		if (status) {
			mainPanel.getBtnNewGame().setText("Nouvelle partie");

		} else {

			mainPanel.getBtnNewGame().setText("Fin de la partie");
		}
		mainPanel.getHomeComboBox().setEnabled(status);
		mainPanel.getGuestComboBox().setEnabled(status);
		mainPanel.getSportComboBox().setEnabled(status);

		mainPanel.getBtnGuestScore1().setEnabled(!status);
		mainPanel.getBtnGuestScore2().setEnabled(!status);
		mainPanel.getBtnGuestScore3().setEnabled(!status);
		mainPanel.getBtnHomeScore1().setEnabled(!status);
		mainPanel.getBtnHomeScore2().setEnabled(!status);
		mainPanel.getBtnHomeScore3().setEnabled(!status);
		mainPanel.getBtnPause().setEnabled(!status);
		mainPanel.getLblGuestName().setVisible(!status);
		mainPanel.getLblHomeName().setVisible(!status);

	}

	public void setListeners() {

		/*
		 * This part will set the listeners setting the application.
		 */

		mainPanel.getSportComboBox().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {

					int ind = mainPanel.getSportComboBox().getSelectedIndex();

					int buttonCount = datas.getSportsActions().get(ind);

					mainPanel.getBtnGuestScore1().setVisible(false);
					mainPanel.getBtnGuestScore2().setVisible(false);
					mainPanel.getBtnGuestScore3().setVisible(false);
					mainPanel.getBtnHomeScore1().setVisible(false);
					mainPanel.getBtnHomeScore2().setVisible(false);
					mainPanel.getBtnHomeScore3().setVisible(false);

					if (buttonCount > 0) {
						mainPanel.getBtnGuestScore1().setText(datas.getSportsActionsNames().get(ind)[0]);
						mainPanel.getBtnGuestScore1().setVisible(true);
						mainPanel.getBtnHomeScore1().setText(datas.getSportsActionsNames().get(ind)[0]);
						mainPanel.getBtnHomeScore1().setVisible(true);
					}
					if (buttonCount > 1) {
						mainPanel.getBtnGuestScore2().setText(datas.getSportsActionsNames().get(ind)[1]);
						mainPanel.getBtnGuestScore2().setVisible(true);
						mainPanel.getBtnHomeScore2().setText(datas.getSportsActionsNames().get(ind)[1]);
						mainPanel.getBtnHomeScore2().setVisible(true);
					}
					if (buttonCount > 2) {
						mainPanel.getBtnGuestScore3().setText(datas.getSportsActionsNames().get(ind)[2]);
						mainPanel.getBtnGuestScore3().setVisible(true);
						mainPanel.getBtnHomeScore3().setText(datas.getSportsActionsNames().get(ind)[2]);
						mainPanel.getBtnHomeScore3().setVisible(true);
					}

					// System.out.println("Sports");
				}

			}
		});

		mainPanel.getHomeComboBox().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("@TODO : Home team changed");
					int ind = mainPanel.getHomeComboBox().getSelectedIndex();
					mainPanel.getLblHomeName().setText(datas.getCountries().get(ind));
				}

			}
		});

		mainPanel.getGuestComboBox().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("@TODO : Guest team changed");
					int ind = mainPanel.getGuestComboBox().getSelectedIndex();
					mainPanel.getLblGuestName().setText(datas.getCountries().get(ind));
				}

			}
		});

		/*
		 * This part will set the listeners communicating with the server.
		 */

		mainPanel.getBtnGuestScore1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commands.add("Guest 1");
			}
		});

		mainPanel.getBtnGuestScore2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commands.add("Guest 2");
			}
		});

		mainPanel.getBtnGuestScore3().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commands.add("Guest 3");
			}
		});

		mainPanel.getBtnHomeScore1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commands.add("Home 1");
			}
		});

		mainPanel.getBtnHomeScore2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commands.add("Home 2");
			}
		});

		mainPanel.getBtnHomeScore3().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commands.add("Home 3");
			}
		});

		mainPanel.getBtnNewGame().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (datas.isGameOn()) {

					commands.add("Cancel Game");
				} else {

					int index=0;
					index = datas.getSports().indexOf(mainPanel.getSportComboBox().getSelectedItem().toString());
					long value;
					if(index != -1 ){
						String s = "New Game" + Datas.separator;
						s = s + mainPanel.getSportComboBox().getSelectedItem().toString() + Datas.separator;
						s = s + mainPanel.getHomeComboBox().getSelectedItem().toString() + Datas.separator;
						s = s + mainPanel.getGuestComboBox().getSelectedItem().toString() + Datas.separator;
						s = s + datas.getSportsTimes().get(index);
						commands.add(s);
					}else{
						System.out.println("Error : Time is not readable");
					}
				}
			}
		});

		mainPanel.getBtnPause().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commands.add("Pause Game");
			}
		});
	}
}
