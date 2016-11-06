package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JFrame;

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
	
	public void updateContent(){
		updateGuestComboBox();
		updateHomeComboBox();
		mainPanel.getSportComboBox().removeAllItems();
		for (String sport : datas.getSports()) {
			mainPanel.getSportComboBox().addItem(sport);
		}
		
	}
	
	public void updateGuestComboBox(){
		mainPanel.getGuestComboBox().removeAllItems();
		for (String country : datas.getCountries()) {
			//if(mainPanel.getHomeComboBox().getSelectedItem() != country)
			mainPanel.getGuestComboBox().addItem(country);
		}
	}
	
	public void updateHomeComboBox(){
		mainPanel.getHomeComboBox().removeAllItems();
		for (String country : datas.getCountries()) {
			//if(mainPanel.getGuestComboBox().getSelectedItem() != country)
			mainPanel.getHomeComboBox().addItem(country);
		}
	}
	
	public void setListeners(){
		
		/*
		 * This part will set the listeners setting the application.
		 */
		
		mainPanel.getSportComboBox().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange() == ItemEvent.SELECTED) {
					
					int ind = mainPanel.getSportComboBox().getSelectedIndex();
					
					int buttonCount = datas.getSportsActions().get(ind);
					
					mainPanel.getBtnGuestScore1().setVisible(false);
					mainPanel.getBtnGuestScore2().setVisible(false);
					mainPanel.getBtnGuestScore3().setVisible(false);
					mainPanel.getBtnHomeScore1().setVisible(false);
					mainPanel.getBtnHomeScore2().setVisible(false);
					mainPanel.getBtnHomeScore3().setVisible(false);
					
					if(buttonCount > 0 ){
						mainPanel.getBtnGuestScore1().setText(datas.getSportsActionsNames().get(ind)[0]);
						mainPanel.getBtnGuestScore1().setVisible(true);
						mainPanel.getBtnHomeScore1().setText(datas.getSportsActionsNames().get(ind)[0]);
						mainPanel.getBtnHomeScore1().setVisible(true);
					}
					if(buttonCount>1){
						mainPanel.getBtnGuestScore2().setText(datas.getSportsActionsNames().get(ind)[1]);
						mainPanel.getBtnGuestScore2().setVisible(true);
						mainPanel.getBtnHomeScore2().setText(datas.getSportsActionsNames().get(ind)[1]);
						mainPanel.getBtnHomeScore2().setVisible(true);
					}
					if(buttonCount>2){
						mainPanel.getBtnGuestScore3().setText(datas.getSportsActionsNames().get(ind)[2]);
						mainPanel.getBtnGuestScore3().setVisible(true);
						mainPanel.getBtnHomeScore3().setText(datas.getSportsActionsNames().get(ind)[2]);
						mainPanel.getBtnHomeScore3().setVisible(true);
					}
					
					//System.out.println("Sports");
                }
				
			}
		});
		
		mainPanel.getHomeComboBox().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("Home");
                }
				
			}
		});
		
		mainPanel.getGuestComboBox().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("Guest");
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
				commands.add("New Game");
			}
		});
		
		mainPanel.getBtnPause().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commands.add("Pause Game");
			}
		});
	}
}
