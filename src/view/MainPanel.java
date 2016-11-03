package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;

import model.Datas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MainPanel extends JPanel {

	private Datas datas;

	private JLabel lblHome;
	private JLabel lblGuest;
	private JComboBox homeComboBox;
	private JComboBox guestComboBox;
	private JComboBox sportComboBox;
	private JLabel lblSport;
	private JButton btnNewGame;
	private JButton btnPause;
	private JButton btnHomeScore1;
	private JButton btnHomeScore2;
	private JButton btnHomeScore3;
	private JButton btnGuestScore1;
	private JButton btnGuestScore2;
	private JButton btnGuestScore3;

	public MainPanel(Datas datas) {
		this.datas = datas;
		this.setSize(800, 550);
		setLayout(null);

		lblHome = new JLabel("Domicile :");
		lblHome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHome.setBounds(88, 30, 115, 44);
		add(lblHome);

		lblGuest = new JLabel("Invit\u00E9 :");
		lblGuest.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGuest.setBounds(503, 28, 115, 44);
		add(lblGuest);

		homeComboBox = new JComboBox();
		homeComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		homeComboBox.setBounds(88, 69, 225, 35);
		add(homeComboBox);

		guestComboBox = new JComboBox();
		guestComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		guestComboBox.setBounds(503, 69, 225, 35);
		add(guestComboBox);

		sportComboBox = new JComboBox();
		sportComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		sportComboBox.setBounds(300, 169, 225, 35);
		add(sportComboBox);

		lblSport = new JLabel("Sport : ");
		lblSport.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSport.setBounds(300, 128, 115, 44);
		add(lblSport);

		btnNewGame = new JButton("Nouvelle Partie");
		btnNewGame.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewGame.setBounds(300, 215, 202, 44);
		add(btnNewGame);

		btnPause = new JButton("Pause");
		btnPause.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnPause.setBounds(300, 272, 202, 44);
		add(btnPause);

		btnHomeScore1 = new JButton("Score 1 +");
		btnHomeScore1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnHomeScore1.setBounds(118, 343, 172, 38);
		add(btnHomeScore1);

		btnHomeScore2 = new JButton("Score 2 +");
		btnHomeScore2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnHomeScore2.setBounds(118, 392, 172, 38);
		add(btnHomeScore2);

		btnHomeScore3 = new JButton("Score 3 +");
		btnHomeScore3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHomeScore3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnHomeScore3.setBounds(118, 441, 172, 38);
		add(btnHomeScore3);

		btnGuestScore1 = new JButton("Score 1 +");
		btnGuestScore1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnGuestScore1.setBounds(503, 343, 172, 38);
		add(btnGuestScore1);

		btnGuestScore2 = new JButton("Score 2 +");
		btnGuestScore2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnGuestScore2.setBounds(503, 392, 172, 38);
		add(btnGuestScore2);

		btnGuestScore3 = new JButton("Score 3 +");
		btnGuestScore3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnGuestScore3.setBounds(503, 441, 172, 38);
		add(btnGuestScore3);

	}
	
	public JComboBox getHomeComboBox() {
		return homeComboBox;
	}

	public void setHomeComboBox(JComboBox homeComboBox) {
		this.homeComboBox = homeComboBox;
	}

	public JComboBox getGuestComboBox() {
		return guestComboBox;
	}

	public void setGuestComboBox(JComboBox guestComboBox) {
		this.guestComboBox = guestComboBox;
	}

	public JComboBox getSportComboBox() {
		return sportComboBox;
	}

	public void setSportComboBox(JComboBox sportComboBox) {
		this.sportComboBox = sportComboBox;
	}

	public JButton getBtnNewGame() {
		return btnNewGame;
	}

	public void setBtnNewGame(JButton btnNewGame) {
		this.btnNewGame = btnNewGame;
	}

	public JButton getBtnPause() {
		return btnPause;
	}

	public void setBtnPause(JButton btnPause) {
		this.btnPause = btnPause;
	}

	public JButton getBtnHomeScore1() {
		return btnHomeScore1;
	}

	public void setBtnHomeScore1(JButton btnHomeScore1) {
		this.btnHomeScore1 = btnHomeScore1;
	}

	public JButton getBtnHomeScore2() {
		return btnHomeScore2;
	}

	public void setBtnHomeScore2(JButton btnHomeScore2) {
		this.btnHomeScore2 = btnHomeScore2;
	}

	public JButton getBtnHomeScore3() {
		return btnHomeScore3;
	}

	public void setBtnHomeScore3(JButton btnHomeScore3) {
		this.btnHomeScore3 = btnHomeScore3;
	}

	public JButton getBtnGuestScore1() {
		return btnGuestScore1;
	}

	public void setBtnGuestScore1(JButton btnGuestScore1) {
		this.btnGuestScore1 = btnGuestScore1;
	}

	public JButton getBtnGuestScore2() {
		return btnGuestScore2;
	}

	public void setBtnGuestScore2(JButton btnGuestScore2) {
		this.btnGuestScore2 = btnGuestScore2;
	}

	public JButton getBtnGuestScore3() {
		return btnGuestScore3;
	}

	public void setBtnGuestScore3(JButton btnGuestScore3) {
		this.btnGuestScore3 = btnGuestScore3;
	}
	
	

}
