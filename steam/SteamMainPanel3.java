package steam;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class SteamMainPanel3 extends JPanel{
	JButton sale1;
	JButton sale2;
	JButton sale3;
	JButton sale4;
	JButton tGame1;
	JButton tGame2;
	JButton tGame3;
	JButton tGame4;
	JLabel label3;
	JLabel label4;
	
	
	SteamMainPanel3(){

		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(1019, 706));//실제 패널 사이즈 지정할때 수정할 값
		setLayout(null);
		this.button();
		this.label();
		this.toolbar();
		
		
	}
	void toolbar() {
		
	}
	void button() {
		
		sale1 = new JButton(SteamMain.saleGame[0].getGname());
		sale1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyGame name = new BuyGame(sale1.getText(),SteamLogin.userInfo.getUid());
			}
		});
		String str1 = sale1.getText()+"_icon.jpg";
		ImageIcon ic1 = new ImageIcon(str1);
		sale1.setIcon(ic1);
		sale1.setFocusPainted(false);
		sale1.setBorderPainted(false);
		sale1.setBackground(null);
		sale1.setBounds(52, 139, 190, 190);
		add(sale1);
		
		sale2 = new JButton(SteamMain.saleGame[1].getGname());
		String str2 = sale2.getText()+"_icon.jpg";
		ImageIcon ic2 = new ImageIcon(str2);
		sale2.setFocusPainted(false);
		sale2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyGame name = new BuyGame(sale2.getText(),SteamLogin.userInfo.getUid());
			}
		});
		sale2.setBorderPainted(false);
		sale2.setBackground(null);
		sale2.setIcon(ic2);
		sale2.setBounds(270, 139, 190, 190);
		add(sale2);
		
		sale3 = new JButton(SteamMain.saleGame[2].getGname());
		String str3 = sale3.getText()+"_icon.jpg";
		ImageIcon ic3 = new ImageIcon(str3);
		sale3.setFocusPainted(false);
		sale3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyGame name = new BuyGame(sale3.getText(),SteamLogin.userInfo.getUid());
			}
		});
		sale3.setBorderPainted(false);
		sale3.setBackground(null);
		sale3.setIcon(ic3);
		sale3.setBounds(488, 139, 190, 190);
		add(sale3);
		
		sale4 = new JButton(SteamMain.saleGame[3].getGname());
		String str4 = sale4.getText()+"_icon.jpg";
		ImageIcon ic4 = new ImageIcon(str4);
		sale4.setIcon(ic4);
		sale4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyGame name = new BuyGame(sale4.getText(),SteamLogin.userInfo.getUid());
			}
		});
		sale4.setFocusPainted(false);
		sale4.setBorderPainted(false);
		sale4.setBackground(null);
		sale4.setBounds(706, 139, 190, 190);
		add(sale4);
		
		Random r1 = new Random();
		tGame4 = new JButton(SteamMain.list.get(10).getGname());
		tGame4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyGame name = new BuyGame(tGame4.getText(),SteamLogin.userInfo.getUid());
			}
		});
		String str5 = tGame4.getText()+"_icon.jpg";
		ImageIcon ic5 = new ImageIcon(str5);
		tGame4.setIcon(ic5);
		tGame4.setBounds(706, 444, 200, 170);
		add(tGame4);
		
		tGame3 = new JButton(SteamMain.list.get(5).getGname());
		String str6 = tGame3.getText()+"_icon.jpg";
		ImageIcon ic6 = new ImageIcon(str6);
		tGame3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyGame name = new BuyGame(tGame3.getText(),SteamLogin.userInfo.getUid());
			}
		});
		tGame3.setIcon(ic6);
		tGame3.setBounds(488, 444, 200, 170);
		add(tGame3);
		
		tGame2 = new JButton(SteamMain.list.get(3).getGname());
		String str7 = tGame2.getText()+"_icon.jpg";
		ImageIcon ic7 = new ImageIcon(str7);
		tGame2.setIcon(ic7);
		tGame2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyGame name = new BuyGame(tGame2.getText(),SteamLogin.userInfo.getUid());
			}
		});
		tGame2.setBounds(270, 444, 200, 170);
		add(tGame2);
		
		tGame1 = new JButton(SteamMain.list.get(12).getGname());
		String str8 = tGame1.getText()+"_icon.jpg";
		ImageIcon ic8 = new ImageIcon(str8);
		tGame1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyGame name = new BuyGame(tGame1.getText(),SteamLogin.userInfo.getUid());
			}
		});
		tGame1.setIcon(ic8);
		tGame1.setBounds(52, 444, 200, 170);
		add(tGame1);
		
		tGame1.setFocusPainted(false);
		tGame1.setBorderPainted(false);
		tGame1.setBackground(null);
		tGame2.setFocusPainted(false);
		tGame2.setBorderPainted(false);
		tGame2.setBackground(null);
		tGame3.setFocusPainted(false);
		tGame3.setBorderPainted(false);
		tGame3.setBackground(null);
		tGame4.setFocusPainted(false);
		tGame4.setBorderPainted(false);
		tGame4.setBackground(null);
		
		
	}
	void label() {
		label3 = new JLabel("특별 할인!");
		label3.setBounds(52, 83, 120, 32);
		label3.setFont(new Font("굴림", Font.BOLD, 25));
		label3.setForeground(Color.WHITE);
		add(label3);
		
		
		label4 = new JLabel("추천 게임!");
		label4.setBounds(52, 388, 120, 32);
		label4.setForeground(Color.WHITE);
		label4.setFont(new Font("굴림", Font.BOLD, 25));
		add(label4);
	}
}
