package steam;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SteamMainPanel2 extends JPanel{
	JLabel libraryLabel;
	JLabel categoryLabel;
	JLabel queueLabel;
	JLabel communityLabel;
	JLabel payLabel;
	JButton libraryButton;
	JButton hitButton;
	JButton lowPriceButton;
	JButton highPriceButton;
	JButton newButton;
	JButton themeSearchButton;
	JButton queueButton;
	JButton communityButton;
	JButton payButton;
	JButton infoButton;
	
	
	
	SteamMainPanel2(){
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setLocation(0, 159);
		setSize(260, 702);
		this.label();
		this.button();

		
		
		
	}
	void label() {
		libraryLabel = new JLabel("라이브러리");
		libraryLabel.setHorizontalAlignment(SwingConstants.LEFT);
		libraryLabel.setForeground(Color.WHITE);
		libraryLabel.setFont(new Font("굴림", Font.BOLD, 23));
		libraryLabel.setBounds(31, 50, 140, 42);
		add(libraryLabel);
		
		categoryLabel = new JLabel("카테고리 검색");
		categoryLabel.setHorizontalAlignment(SwingConstants.LEFT);
		categoryLabel.setForeground(Color.WHITE);
		categoryLabel.setFont(new Font("굴림", Font.BOLD, 23));
		categoryLabel.setBounds(31, 127, 166, 42);
		add(categoryLabel);
		
		queueLabel = new JLabel("맞춤 대기열");
		queueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		queueLabel.setForeground(Color.WHITE);
		queueLabel.setFont(new Font("굴림", Font.BOLD, 23));
		queueLabel.setBounds(31, 311, 155, 42);
		add(queueLabel);
		
		communityLabel = new JLabel("커뮤니티");
		communityLabel.setHorizontalAlignment(SwingConstants.LEFT);
		communityLabel.setForeground(Color.WHITE);
		communityLabel.setFont(new Font("굴림", Font.BOLD, 23));
		communityLabel.setBounds(31, 386, 118, 42);
		add(communityLabel);
		
		payLabel = new JLabel("결제");
		payLabel.setHorizontalAlignment(SwingConstants.LEFT);
		payLabel.setForeground(Color.WHITE);
		payLabel.setFont(new Font("굴림", Font.BOLD, 23));
		payLabel.setBounds(31, 460, 65, 42);
		add(payLabel);
	}
	void button() {
		libraryButton = new JButton("라이브러리");
		libraryButton.setBackground(null);
		libraryButton.setBorderPainted(false);
		libraryButton.setFocusPainted(false);
		libraryButton.setHorizontalAlignment(SwingConstants.LEFT);
		libraryButton.setForeground(Color.WHITE);
		libraryButton.setFont(new Font("굴림", Font.BOLD, 13));
		libraryButton.setBounds(45, 92, 105, 22);
		add(libraryButton);

		

		hitButton = new JButton("인기순");
		hitButton.setBackground(null);
		hitButton.setBorderPainted(false);
		hitButton.setFocusPainted(false);
		hitButton.setHorizontalAlignment(SwingConstants.LEFT);
		hitButton.setForeground(Color.WHITE);
		hitButton.setFont(new Font("굴림", Font.BOLD, 13));
		hitButton.setBounds(45, 169, 82, 22);
		add(hitButton);

		lowPriceButton = new JButton("낮은 가격");
		lowPriceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		lowPriceButton.setBackground(null);
		lowPriceButton.setBorderPainted(false);
		lowPriceButton.setFocusPainted(false);
		lowPriceButton.setHorizontalAlignment(SwingConstants.LEFT);
		lowPriceButton.setForeground(Color.WHITE);
		lowPriceButton.setFont(new Font("굴림", Font.BOLD, 13));
		lowPriceButton.setBounds(45, 191, 95, 22);
		add(lowPriceButton);

		highPriceButton = new JButton("높은 가격");
		highPriceButton.setBackground(null);
		highPriceButton.setBorderPainted(false);
		highPriceButton.setFocusPainted(false);
		highPriceButton.setHorizontalAlignment(SwingConstants.LEFT);
		highPriceButton.setForeground(Color.WHITE);
		highPriceButton.setFont(new Font("굴림", Font.BOLD, 13));
		highPriceButton.setBounds(45, 213, 95, 22);
		add(highPriceButton);

		newButton = new JButton("신규 출시");
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		newButton.setFocusPainted(false);
		newButton.setBackground(null);
		newButton.setBorderPainted(false);
		newButton.setHorizontalAlignment(SwingConstants.LEFT);
		newButton.setForeground(Color.WHITE);
		newButton.setFont(new Font("굴림", Font.BOLD, 13));
		newButton.setBounds(45, 235, 95, 22);
		add(newButton);

		themeSearchButton = new JButton("장르별 검색");
		themeSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		themeSearchButton.setFocusPainted(false);
		themeSearchButton.setBackground(null);
		themeSearchButton.setBorderPainted(false);
		themeSearchButton.setHorizontalAlignment(SwingConstants.LEFT);
		themeSearchButton.setForeground(Color.WHITE);
		themeSearchButton.setFont(new Font("굴림", Font.BOLD, 13));
		themeSearchButton.setBounds(45, 257, 110, 22);
		add(themeSearchButton);

		

		queueButton = new JButton("추천 목록");
		queueButton.setFocusPainted(false);
		queueButton.setBackground(null);
		queueButton.setBorderPainted(false);
		queueButton.setHorizontalAlignment(SwingConstants.LEFT);
		queueButton.setForeground(Color.WHITE);
		queueButton.setFont(new Font("굴림", Font.BOLD, 13));
		queueButton.setBounds(45, 353, 95, 22);
		add(queueButton);

		

		communityButton = new JButton("커뮤니티");
		communityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		communityButton.setBackground(null);
		communityButton.setBorderPainted(false);
		communityButton.setFocusPainted(false);
		communityButton.setHorizontalAlignment(SwingConstants.LEFT);
		communityButton.setForeground(Color.WHITE);
		communityButton.setFont(new Font("굴림", Font.BOLD, 13));
		communityButton.setBounds(45, 428, 95, 22);
		add(communityButton);
			
		

		payButton = new JButton("결제");
		payButton.setFocusPainted(false);
		payButton.setBackground(null);
		payButton.setBorderPainted(false);
		payButton.setHorizontalAlignment(SwingConstants.LEFT);
		payButton.setForeground(Color.WHITE);
		payButton.setFont(new Font("굴림", Font.BOLD, 13));
		payButton.setBounds(45, 502, 62, 22);
		add(payButton);

		infoButton = new JButton("회원정보/수정");
		infoButton.setFocusPainted(false);
		infoButton.setBackground(null);
		infoButton.setBorderPainted(false);
		infoButton.setHorizontalAlignment(SwingConstants.LEFT);
		infoButton.setForeground(Color.WHITE);
		infoButton.setFont(new Font("굴림", Font.BOLD, 13));
		infoButton.setBounds(45, 600, 126, 22);
		add(infoButton);
	}

}
