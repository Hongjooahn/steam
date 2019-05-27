package steam;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AddFriend extends JFrame{
	JLabel l1 = new JLabel("아이디");
	JLabel l2 = new JLabel("닉네임");
	JLabel l3 = new JLabel("관심장르");
	JLabel l4 = new JLabel("보유게임");
	JTextField t1;
	JTextField t2;
	JTextField t3;
	JTextField t4;
	JButton add;
	JButton close;
	
	//텍스트필드로 uid검색
	//검색결과 있을때 친구 추가 가능
	//검색결과 없을 때 showmessagedialog띄우기
	//있을때 결과만 띄우기
	
	AddFriend(String uid){
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("친구 검색");
		setSize(400,300);
		getContentPane().setLayout(null);
		
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
		add = new JButton("친구추가");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDTO1 dto;
				UserDAO1 dao = new UserDAO1();
				
				dto = dao.select(t1.getText());
				if (dto != null) {
					boolean b = false;
					for(int i=0;i<SteamLogin.uFriend.length;i++) {
						if(SteamLogin.uFriend[i].equals(dto.getUid())) {
							b=true;
						}
					}
					if(b) {
						JOptionPane.showMessageDialog(null, "이미 친구입니다.");
					}else {
						SteamLogin.userInfo.setUfriend(SteamLogin.userInfo.getUfriend()+","+dto.getUid());
						SteamLogin.uFriend = SteamLogin.userInfo.getUfriend().split(","); 
						dao.update(SteamLogin.userInfo);
						JOptionPane.showMessageDialog(null, "친구추가에 성공했습니다.");
						SteamMainPanel4.friendList.setListData(SteamLogin.uFriend);
						dispose();
					}
				}
			}
		});
		add.setForeground(Color.WHITE);
		add.setFont(new Font("굴림", Font.BOLD, 12));
		add.setBounds(113, 202, 90, 30);
		add.setBackground(null);
		add.setBorderPainted(false);
		add.setFocusPainted(false);
		getContentPane().add(add);
		
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
}
