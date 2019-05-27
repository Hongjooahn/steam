package steam;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FriendInfo extends JFrame{
	JLabel l1 = new JLabel("아이디");
	JLabel l2 = new JLabel("닉네임");
	JLabel l3 = new JLabel("관심장르");
	JLabel l4 = new JLabel("보유게임");
	JTextField t1;
	JTextField t2;
	JTextField t3;
	JTextField t4;
	JButton delete;
	JButton close;
	FriendInfo(){
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		setSize(400, 300);
		
		label();
		textfield();
		button();
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	void label() {
		l1.setFont(new Font("굴림", Font.BOLD, 12));
		l1.setForeground(Color.WHITE);
		l1.setLocation(78, 29);
		l1.setSize(70, 30);
		getContentPane().add(l1);
		l2.setFont(new Font("굴림", Font.BOLD, 12));
		l2.setForeground(Color.WHITE);
		l2.setLocation(78, 69);
		l2.setSize(70, 30);
		getContentPane().add(l2);
		l3.setFont(new Font("굴림", Font.BOLD, 12));
		l3.setForeground(Color.WHITE);
		l3.setLocation(78, 149);
		l3.setSize(70, 30);
		getContentPane().add(l3);
		l4.setFont(new Font("굴림", Font.BOLD, 12));
		l4.setForeground(Color.WHITE);
		l4.setLocation(78, 109);
		l4.setSize(70, 30);
		getContentPane().add(l4);
	}
	void textfield() {
		t1 = new JTextField();
		t1.setBounds(178, 29, 129, 30);
		t1.setEditable(false);
		getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(178, 69, 129, 30);
		t2.setEditable(false);
		getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(178, 109, 129, 30);
		t3.setEditable(false);
		getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setEditable(false);
		t4.setBounds(178, 149, 129, 30);
		getContentPane().add(t4);
	}
	void button() {
		delete = new JButton("친구삭제");
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("굴림", Font.BOLD, 12));
		delete.setBounds(113, 202, 90, 30);
		delete.setBackground(null);
		delete.setBorderPainted(false);
		delete.setFocusPainted(false);
		getContentPane().add(delete);
		
		close = new JButton("닫기");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		close.setForeground(Color.WHITE);
		close.setFont(new Font("굴림", Font.BOLD, 12));
		close.setBounds(217, 202, 90, 30);
		close.setFocusPainted(false);
		close.setBorderPainted(false);
		close.setBackground(null);
		getContentPane().add(close);
	}
	void deleteAction() {
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = "";
				if(t1.getText().equals("")) {
				}else {
					UserDAO1 dao = new UserDAO1();
					UserDTO1 dto = SteamLogin.userInfo;
					for(int i=0;i<SteamLogin.uFriend.length;i++) {
						if(t1.getText().equals(SteamLogin.uFriend[i])) {
						}else {
							if(i!=SteamLogin.uFriend.length-1) {
								result += SteamLogin.uFriend[i]+",";
							}else {
								result += SteamLogin.uFriend[i];
							}
						}
					}
					dto.setUfriend(result);
					dao.update(dto);
					SteamLogin.userInfo = dto;
					SteamLogin.uFriend = SteamLogin.userInfo.getUfriend().split(",");
					SteamMainPanel4.friendList.setListData(SteamLogin.uFriend);
					JOptionPane.showMessageDialog(null, "친구삭제가 완료되었습니다.");
					dispose();
				}
			}
		});
	}
}
