package steam;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserEdit {
	private static JTextField input_spec;
	private static JTextField input_email;
	private static JTextField input_theme;
	private static JTextField input_uname;
	UserDAO1 dao = new UserDAO1();
	ArrayList list = dao.selectAll();
	String preUname;
	String nextUname;

// 이름, id, 사양, email, 보유금액, 관심장르

	public UserEdit() throws Exception {
		UserDAO udao;
		UserDTO udto;
		String userid = SteamLogin.userInfo.getUid(); // 유저아이디가 동일한게 없다면 null point 에러 남

		udao = new UserDAO();
		udto = udao.select(userid);

		JFrame jf = new JFrame();
		jf.setSize(800, 700);
		jf.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(12, 10, 760, 641);
		jf.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel title = new JLabel("회원정보 수정");
		title.setForeground(Color.WHITE);
		title.setBounds(267, 10, 224, 29);
		title.setFont(new Font("굴림", Font.BOLD, 30));
		panel.add(title);

		JLabel name = new JLabel("닉네임");
		name.setForeground(Color.WHITE);
		name.setFont(new Font("굴림", Font.BOLD, 22));
		name.setBounds(158, 84, 77, 29);
		panel.add(name);

		JLabel id = new JLabel("ID");
		id.setForeground(Color.WHITE);
		id.setFont(new Font("굴림", Font.BOLD, 22));
		id.setBounds(158, 144, 77, 29);
		panel.add(id);

		JLabel spec = new JLabel("컴퓨터 사양");

		spec.setForeground(Color.WHITE);
		spec.setFont(new Font("굴림", Font.BOLD, 22));
		spec.setBounds(158, 204, 134, 29);
		panel.add(spec);

		JLabel email = new JLabel("이메일");
		email.setForeground(Color.WHITE);
		email.setFont(new Font("굴림", Font.BOLD, 22));
		email.setBounds(158, 264, 77, 29);
		panel.add(email);

		JLabel theme = new JLabel("관심 장르");
		theme.setForeground(Color.WHITE);
		theme.setFont(new Font("굴림", Font.BOLD, 22));
		theme.setBounds(158, 324, 103, 29);
		panel.add(theme);

		JLabel cash = new JLabel("보유금");
		cash.setForeground(Color.WHITE);
		cash.setFont(new Font("굴림", Font.BOLD, 22));
		cash.setBounds(158, 384, 77, 29);
		panel.add(cash);

		JLabel input_ID = new JLabel(udto.getUid()); // 수정되는 라벨(ID)
		input_ID.setForeground(Color.WHITE);
		input_ID.setFont(new Font("굴림", Font.BOLD, 22));
		input_ID.setBounds(320, 144, 186, 29);

		panel.add(input_ID);

		JLabel input_cash = new JLabel(Integer.toString(udto.getUcash())); // 수정되는 라벨(보유금액)
		input_cash.setForeground(Color.WHITE);
		input_cash.setFont(new Font("굴림", Font.BOLD, 22));
		input_cash.setBounds(320, 384, 77, 29);
		panel.add(input_cash);

		input_uname = new JTextField();
		input_uname.setBackground(Color.LIGHT_GRAY);
		input_uname.setFont(new Font("굴림", Font.BOLD, 17));
		input_uname.setColumns(10);
		input_uname.setBounds(320, 84, 186, 35);
		preUname = udto.getUname();
		input_uname.setText(udto.getUname());
		panel.add(input_uname);

		input_spec = new JTextField();
		input_spec.setBackground(Color.LIGHT_GRAY);
		input_spec.setFont(new Font("굴림", Font.BOLD, 17));
		input_spec.setBounds(320, 204, 40, 35);
		panel.add(input_spec);
		input_spec.setText(Integer.toString(udto.getUspec()));
		input_spec.setColumns(10);

		input_email = new JTextField();
		input_email.setBackground(Color.LIGHT_GRAY);
		input_email.setFont(new Font("굴림", Font.BOLD, 17));
		input_email.setColumns(10);
		input_email.setBounds(320, 264, 361, 35);
		input_email.setText(udto.getUemail());
		panel.add(input_email);

		input_theme = new JTextField();
		input_theme.setBackground(Color.LIGHT_GRAY);
		input_theme.setFont(new Font("굴림", Font.BOLD, 17));
		input_theme.setColumns(10);
		input_theme.setBounds(320, 324, 361, 35);
		input_theme.setText(udto.getUtheme());
		panel.add(input_theme);

		JButton editbtn = new JButton("이대로 수정할래요");
		editbtn.setForeground(Color.WHITE);
		editbtn.setBackground(Color.DARK_GRAY);

		editbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDTO1 dto = null;
				boolean b = true;
				for (int i = 0; i < list.size(); i++) {
					dto = (UserDTO1) list.get(i);
					if (input_uname.getText().equals(preUname)) {
						b = true;
					}
				}
				if (b) { // 중복된
					UserDAO1 dao1;
					try {
						dao1 = new UserDAO1();
						UserDTO1 ddttoo = dao1.select1(input_uname.getText());
						if (ddttoo != null) {
							JOptionPane.showMessageDialog(null, "중복된 닉네임입니다.");
						} else {
							udto.setUname(input_uname.getText());
							udto.setUspec(Integer.parseInt(input_spec.getText())); // 일단은 정수형변수
							udto.setUemail((input_email.getText()));
							udto.setUtheme((input_theme.getText()));
							try {
								udao.update(udto, userid);
								JOptionPane.showMessageDialog(null, "User의 정보사항이 변경되었습니다.");
								jf.dispose();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					udto.setUname(input_uname.getText());
					udto.setUspec(Integer.parseInt(input_spec.getText())); // 일단은 정수형변수
					udto.setUemail((input_email.getText()));
					udto.setUtheme((input_theme.getText()));
					try {

						udao.update(udto, userid);
						JOptionPane.showMessageDialog(null, "User의 정보사항이 변경되었습니다.");
						jf.dispose();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}
		});

		editbtn.setFont(new Font("굴림", Font.BOLD, 18));
		editbtn.setBounds(158, 456, 202, 43);
		panel.add(editbtn);

		JButton outbtn = new JButton("회원탈퇴");
		outbtn.setForeground(new Color(255, 182, 193));
		outbtn.setBackground(Color.DARK_GRAY);
		outbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] yesorno = { "예", "아니오" };
				int select = JOptionPane.showOptionDialog(null, "정말 탈퇴하시겠습니까?", "회원탈퇴?",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, yesorno, yesorno[1]);
				if (select == 0) {
					try {
						udao.delete(userid);
					} catch (Exception e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "탈퇴가 완료됐습니다!");
					System.exit(0);

				} else {
					JOptionPane.showMessageDialog(null, "탈퇴를 취소했습니다!");
				}
			}
		});
		outbtn.setFont(new Font("굴림", Font.BOLD, 18));
		outbtn.setBounds(647, 598, 113, 43);
		panel.add(outbtn);

		jf.setVisible(true);

	}

}
