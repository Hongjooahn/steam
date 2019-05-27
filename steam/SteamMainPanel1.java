package steam;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SteamMainPanel1 extends JPanel {
	JButton titleButton;
	JButton storeButton;
	JButton libraryButton;
	JButton comonButton;
	JButton infoButton;

	SteamMainPanel1() {
		setBackground(Color.DARK_GRAY);
		setLocation(0, 0);
		setLayout(null);
		setSize(1584, 159);

		this.button();

	}

	void button() {
		titleButton = new JButton("Steam");
		titleButton.setBorderPainted(false);
		titleButton.setFocusPainted(false);
		titleButton.setBackground(null);
		titleButton.setForeground(Color.WHITE);
		titleButton.setFont(new Font("굴림", Font.BOLD, 35));
		titleButton.setHorizontalAlignment(SwingConstants.CENTER);
		titleButton.setBounds(275, 52, 149, 42);
		add(titleButton);

		storeButton = new JButton("상점");
		storeButton.setBackground(null);
		storeButton.setBorderPainted(false);
		storeButton.setFocusPainted(false);
		storeButton.setFont(new Font("굴림", Font.BOLD, 20));
		storeButton.setForeground(Color.WHITE);
		storeButton.setIcon(null);
		storeButton.setBounds(505, 63, 97, 33);
		add(storeButton);

		libraryButton = new JButton("라이브러리");
		libraryButton.setBackground(null);
		libraryButton.setBorderPainted(false);
		libraryButton.setFocusPainted(false);
		libraryButton.setForeground(Color.WHITE);
		libraryButton.setFont(new Font("굴림", Font.BOLD, 20));
		libraryButton.setBounds(623, 63, 156, 33);
		add(libraryButton);

		comonButton = new JButton("커뮤니티");
		comonButton.setBackground(null);
		comonButton.setBorderPainted(false);
		comonButton.setFocusPainted(false);
		comonButton.setForeground(Color.WHITE);
		comonButton.setFont(new Font("굴림", Font.BOLD, 20));
		comonButton.setBounds(799, 63, 119, 33);
		add(comonButton);

		infoButton = new JButton("회원정보/수정");
		infoButton.setBackground(null);
		infoButton.setBorderPainted(false);
		infoButton.setFocusPainted(false);
		infoButton.setForeground(Color.WHITE);
		infoButton.setFont(new Font("굴림", Font.BOLD, 20));
		infoButton.setBounds(1020, 61, 177, 33);
		add(infoButton);

	}

}
