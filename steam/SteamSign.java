package steam;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SteamSign extends JFrame{
	JPanel panel = new JPanel();
	JTextField idInput;
	JTextField pwInput;
	JTextField unameInput;
	JTextField emailInput;
	String theme1 = "어드벤쳐";
	String theme2 = "RPG";
	String theme3 = "액션";
	String theme4 = "fps";
	String theme5 = "전략";
	JLabel signLabel;
	JLabel idLabel;
	JLabel pwLabel;
	JLabel nameLabel;
	JLabel emailLabel;
	JLabel themeLabel2;
	JLabel themeLabel1;
	JLabel themeLabel3;
	JButton signButton;
	JButton checkButton;
	JComboBox themeBox1;
	JComboBox themeBox2;
	JComboBox themeBox3;
	
	SteamSign() {
		
		
		setTitle("회원가입");
		setSize(400,600);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		
		this.textfield();
		this.combobox();
		this.label();
		this.button();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	void textfield(){
		idInput = new JTextField();
		idInput.setBounds(129, 93, 170, 27);
		panel.add(idInput);
		idInput.setColumns(10);
		
		pwInput = new JTextField();
		pwInput.setColumns(10);
		pwInput.setBounds(129, 132, 170, 27);
		panel.add(pwInput);
		
		unameInput = new JTextField();
		unameInput.setColumns(10);
		unameInput.setBounds(129, 167, 170, 27);
		panel.add(unameInput);
		
		emailInput = new JTextField();
		emailInput.setColumns(10);
		emailInput.setBounds(129, 202, 170, 27);
		panel.add(emailInput);
	}
	void label() {
		signLabel = new JLabel("회원가입");
		signLabel.setForeground(Color.WHITE);
		signLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signLabel.setFont(new Font("굴림", Font.BOLD, 25));
		signLabel.setBounds(125, 20, 130, 50);
		panel.add(signLabel);
		
		idLabel = new JLabel("아이디");
		idLabel.setForeground(Color.WHITE);
		idLabel.setFont(new Font("굴림", Font.BOLD, 18));
		idLabel.setBounds(30, 90, 80, 31);
		panel.add(idLabel);
		
		pwLabel = new JLabel("비밀번호");
		pwLabel.setForeground(Color.WHITE);
		pwLabel.setFont(new Font("굴림", Font.BOLD, 18));
		pwLabel.setBounds(30, 130, 80, 31);
		panel.add(pwLabel);
		
		nameLabel = new JLabel("닉네임");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("굴림", Font.BOLD, 18));
		nameLabel.setBounds(30, 165, 80, 31);
		panel.add(nameLabel);
		
		emailLabel = new JLabel("이메일");
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("굴림", Font.BOLD, 18));
		emailLabel.setBounds(30, 200, 80, 31);
		panel.add(emailLabel);
		
		themeLabel2 = new JLabel("장르1");
		themeLabel2.setForeground(Color.WHITE);
		themeLabel2.setFont(new Font("굴림", Font.BOLD, 18));
		themeLabel2.setBounds(30, 283, 67, 23);
		panel.add(themeLabel2);
		
		themeLabel1 = new JLabel("장르2");
		themeLabel1.setForeground(Color.WHITE);
		themeLabel1.setFont(new Font("굴림", Font.BOLD, 18));
		themeLabel1.setBounds(30, 248, 67, 23);
		panel.add(themeLabel1);
		
		themeLabel3 = new JLabel("장르2");
		themeLabel3.setForeground(Color.WHITE);
		themeLabel3.setFont(new Font("굴림", Font.BOLD, 18));
		themeLabel3.setBounds(30, 320, 67, 23);
		panel.add(themeLabel3);
	}
	void button() {
		signButton = new JButton("회원가입");
		signButton.setEnabled(false);
		signButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String uid = idInput.getText();
					String pw = pwInput.getText();
					if(5<=uid.length()&&uid.length()<20) {
						if(6<=pw.length()&&pw.length()<20) {
							UserDAO1 dao = new UserDAO1();
							UserDTO1 dto = dao.select(uid);
							if(dto==null) {
								dto = new UserDTO1();
								String[] themeInfo = {"Adventure","RPG","Action","FPS","Simulation"};
								String uname = unameInput.getText();
								String uemail = emailInput.getText();
								String utheme1 = themeInfo[themeBox1.getSelectedIndex()];
								String utheme2 = themeInfo[themeBox2.getSelectedIndex()];
								String utheme3 = themeInfo[themeBox3.getSelectedIndex()];
								dto.setUid(uid);
								dto.setPw(pw);
								dto.setUname(uname);
								dto.setUemail(uemail);
								dto.setUtheme(utheme1+","+utheme2+","+utheme3);
								dto.setUfriend("");
								dto.setUgamelist("");
								dao.insert(dto);
								JOptionPane.showMessageDialog(null, "회원가입이 성공했습니다.");
								dispose();
							}else {
								JOptionPane.showMessageDialog(null, "이미 가입된 아이디입니다.");
							}
						}else {
							JOptionPane.showMessageDialog(null, "비밀번호는 6글자 이상, 20글자 미만이어야 합니다.");
						}
					}else {
						JOptionPane.showMessageDialog(null, "아이디는 5글자 이상, 20글자 미만이어야 합니다.");
					}
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, "회원가입에 실패했습니다.");
					System.out.println("회원가입 오류");
				}finally {
					idInput.setText("");
					pwInput.setText("");
					unameInput.setText("");
					emailInput.setText("");
				}
			}
		});
		signButton.setForeground(Color.WHITE);
		signButton.setBackground(null);
		signButton.setFocusPainted(false);
		signButton.setBorderPainted(false);
		signButton.setFont(new Font("굴림", Font.BOLD, 15));
		signButton.setBounds(228, 457, 97, 31);
		panel.add(signButton);
		checkButton = new JButton("중복");
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idInput.getText().equals("")) {
					}else {
						String uid = idInput.getText();
						if(5<=uid.length()&&uid.length()<20) {
							UserDAO1 dao = new UserDAO1();
							UserDTO1 dto =dao.select(uid);
							if(dto==null){
								JOptionPane.showMessageDialog(null, "사용할 수 있는 아이디입니다.");
								signButton.setEnabled(true);
							}else {
								JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.");
							}
						
						}else {
							JOptionPane.showMessageDialog(null, "아이디는 5글자 이상, 20글자 미만이어야 합니다.");
						}
					}
			}
		});
		checkButton.setForeground(Color.WHITE);
		checkButton.setFocusPainted(false);
		checkButton.setBorderPainted(false);
		checkButton.setBackground(null);
		checkButton.setFont(new Font("굴림", Font.BOLD,15));
		checkButton.setBounds(300, 96, 70, 23);
		panel.add(checkButton);
	}
	void combobox() {
		themeBox1 = new JComboBox();
		themeBox1.setBounds(129, 246, 170, 27);
		panel.add(themeBox1);
		themeBox1.addItem("선택");
		themeBox1.addItem(theme1);
		themeBox1.addItem(theme2);
		themeBox1.addItem(theme3);
		themeBox1.addItem(theme4);
		themeBox1.addItem(theme5);
		
		themeBox2 = new JComboBox();
		themeBox2.setBounds(129, 283, 170, 27);
		panel.add(themeBox2);
		themeBox2.addItem("선택");
		themeBox2.addItem(theme1);
		themeBox2.addItem(theme2);
		themeBox2.addItem(theme3);
		themeBox2.addItem(theme4);
		themeBox2.addItem(theme5);
		
		themeBox3 = new JComboBox();
		themeBox3.setBounds(129, 320, 170, 27);
		panel.add(themeBox3);
		themeBox3.addItem("선택");
		themeBox3.addItem(theme1);
		themeBox3.addItem(theme2);
		themeBox3.addItem(theme3);
		themeBox3.addItem(theme4);
		themeBox3.addItem(theme5);
	}
}
