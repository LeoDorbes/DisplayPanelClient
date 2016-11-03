package view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;

import model.Datas;

public class MainFrame extends JFrame {
	
	private Datas datas;
	private MainPanel mainPanel;

	public MainFrame(Datas datas) {
		
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
		
		//MainFrame me = this;
		
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
		
		
	
	}
}
