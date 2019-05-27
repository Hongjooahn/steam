package steam;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SteamLogin extends JFrame {
	
	static String[] uFriend;// 로그인시 친구목록을 스트링배열로 저장
	static UserDTO1 userInfo;// 로그인시 userInfo에 정보 저장?
	JPanel loginPanel = new JPanel();
	JTextField idInput;
	JTextField pwInput;
	JLabel steamIcon;
	JLabel idText;
	JLabel pwText;
	JButton loginButton;
	JButton signButton;

	//생성자
	SteamLogin() {
		// 로그인프레임 사이즈설정과 로그인 패널 추가
		setTitle("Steam");
		setSize(400, 300);
		getContentPane().add(loginPanel);
		this.loginpanel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	//패널
	void loginpanel() {

		// 로그인패널 사이즈설정과 레이아웃설정
		loginPanel.setSize(400, 300);
		loginPanel.setLayout(null);
		loginPanel.setBackground(Color.DARK_GRAY);
		
		
		this.textfield();
		this.label();
		this.button();


		
	}
	//텍스트필드
	void textfield() {
		idInput = new JTextField();
		idInput.setBounds(173, 115, 150, 30);
		loginPanel.add(idInput);
		idInput.setColumns(10);
		
		pwInput = new JTextField();
		pwInput.setColumns(10);
		pwInput.setBounds(173, 157, 150, 30);
		loginPanel.add(pwInput);
	}
	//라벨
	void label() {
		//steam 로고
		steamIcon = new JLabel("");
		steamIcon.setIcon(new ImageIcon("steamIcon2.jpg"));
		steamIcon.setBounds(90, 20, 220, 80);
		loginPanel.add(steamIcon);

		//아이디 라벨
		idText = new JLabel("아이디");
		idText.setForeground(Color.WHITE);
		idText.setFont(new Font("굴림", Font.BOLD, 20));
		idText.setBounds(60, 121, 90, 20);
		loginPanel.add(idText);

		//비밀번호 라벨
		pwText = new JLabel("비밀번호");
		pwText.setForeground(Color.WHITE);
		pwText.setFont(new Font("굴림", Font.BOLD, 20));
		pwText.setBounds(60, 162, 90, 20);
		loginPanel.add(pwText);

	}
	//버튼
	void button() {
		//로그인버튼
		loginButton = new JButton("로그인");
		loginButton.setForeground(Color.WHITE);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idInput.getText().equals("") || pwInput.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "ID와 PW를 전부 입력 한 후 로그인 해주세요.");
				} else {
					UserDTO1 dto = new UserDTO1();
					UserDAO1 dao = new UserDAO1();
					dto = dao.select(idInput.getText());
					try {
						if (dto==null) {
							JOptionPane.showMessageDialog(null, "존재하지 않는 ID입니다.");
						} else {
							if (pwInput.getText().equals(dto.getPw())) {
								userInfo = dto;
								SteamMain main = new SteamMain();
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다");
							}
						}
					} catch (Exception e1) {
						System.out.println("로그인 실패");
						System.out.println(dto);
						e1.printStackTrace();
					} finally {
						idInput.setText("");
						pwInput.setText("");
					}
				}
			}
		});
		loginButton.setBackground(null);
		loginButton.setBorderPainted(false);
		loginButton.setFocusPainted(false);
		loginButton.setFont(new Font("굴림", Font.BOLD, 15));
		loginButton.setBounds(125, 200, 97, 30);
		loginPanel.add(loginButton);

		//패스워드 버튼
		signButton = new JButton("회원가입");
		signButton.setForeground(Color.WHITE);
		signButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SteamSign sign = new SteamSign();
			}
		});
		signButton.setBorderPainted(false);
		signButton.setBackground(null);
		signButton.setFocusPainted(false);
		signButton.setFont(new Font("굴림", Font.BOLD, 15));
		signButton.setBounds(226, 200, 97, 30);
		loginPanel.add(signButton);

		
	}
}
