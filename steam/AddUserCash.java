package steam;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddUserCash {
	private static JTextField safecodeinput;
	private static JTextField addcashtf;
	private static JLabel usercash;
	
	String inputid = SteamLogin.userInfo.getUid();
	
	public AddUserCash() {
	JFrame jf = new JFrame();
	jf.setSize(800, 600);
	jf.getContentPane().setLayout(null);

	JPanel panel = new JPanel();
	panel.setBackground(Color.DARK_GRAY);
	panel.setBounds(12, 10, 760, 541);
	jf.getContentPane().add(panel);
	panel.setLayout(null);

	JLabel title = new JLabel("내 지갑 충전");
	title.setForeground(Color.WHITE);
	title.setBounds(279, 42, 194, 29);
	title.setFont(new Font("굴림", Font.BOLD, 30));
	panel.add(title);

	JLabel lbl1 = new JLabel("충전금액(원)");
	lbl1.setHorizontalAlignment(SwingConstants.RIGHT);
	lbl1.setForeground(Color.WHITE);
	lbl1.setFont(new Font("굴림", Font.BOLD, 20));
	lbl1.setBounds(220, 147, 135, 29);
	panel.add(lbl1);

	JLabel lbl3 = new JLabel("우측 보안 코드 입력");
	lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
	lbl3.setForeground(Color.WHITE);
	lbl3.setFont(new Font("굴림", Font.BOLD, 20));
	lbl3.setBounds(146, 223, 209, 29);
	panel.add(lbl3);

	JLabel lbl5 = new JLabel("나의 현재 금액 : ");
	lbl5.setForeground(Color.WHITE);
	lbl5.setFont(new Font("굴림", Font.BOLD, 20));
	lbl5.setBounds(121, 409, 187, 37);
	panel.add(lbl5);

	ImageIcon icon = new ImageIcon("Hello.PNG");
	JPanel safepattern = new JPanel() {
		public void paintComponent(Graphics g) {
			Dimension d = getSize();
			g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null); // 컴포넌트 사이즈에 맞게
		}
	};
	safepattern.setBounds(379, 223, 209, 74);
	panel.add(safepattern);

	Random rc = new Random();
	JLabel safecode = new JLabel(Integer.toString(rc.nextInt(99999)));
	safepattern.add(safecode);
	safecode.setHorizontalAlignment(SwingConstants.CENTER);
	safecode.setFont(new Font("Segoe Print", Font.PLAIN, 32));

	addcashtf = new JTextField(); // 추가 될 돈
	addcashtf.setText("10000");
	addcashtf.setHorizontalAlignment(SwingConstants.CENTER);
	addcashtf.setFont(new Font("굴림", Font.BOLD, 16));
	addcashtf.setColumns(10);
	addcashtf.setBounds(379, 145, 135, 35);
	panel.add(addcashtf);

	safecodeinput = new JTextField();
	safecodeinput.setFont(new Font("굴림", Font.BOLD, 16));
	safecodeinput.setHorizontalAlignment(SwingConstants.CENTER);
	safecodeinput.setBounds(158, 262, 197, 35);
	panel.add(safecodeinput);
	safecodeinput.setColumns(10);

	UserDAO udao;
	try {
		udao = new UserDAO();
		UserDTO udto = udao.select(inputid);
		usercash = new JLabel();
		usercash.setText(Integer.toString(udto.getUcash()));
	} catch (Exception e1) {
		e1.printStackTrace();
	}

	JButton confirm = new JButton("충전 승인");
	confirm.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			int addcash = Integer.parseInt(addcashtf.getText()); // 추가 될 돈
			String safecodecheck = safecodeinput.getText(); // 보안코드체크

			if (!safecode.getText().equalsIgnoreCase((safecodecheck))) { // 같지 않으면 ?
				JOptionPane.showMessageDialog(null, "보안코드가 정확하지 않습니다");
				System.out.println(safecodecheck + "/" + safecode.getText());

			}

			else {
				try {
					UserDAO udao = new UserDAO();
					udao.updatecash(inputid, Integer.parseInt(usercash.getText()), addcash);
					JOptionPane.showMessageDialog(null, addcash + "원이 충전되었습니다");
					int sum = Integer.parseInt(usercash.getText()) + addcash;
//					usercash.setText(Integer.toString(sum));
					jf.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		}
	});
	confirm.setForeground(new Color(175, 238, 238));
	confirm.setBackground(Color.DARK_GRAY);
	confirm.setFont(new Font("굴림", Font.BOLD, 18));
	confirm.setBounds(378, 403, 135, 43);
	panel.add(confirm);

	usercash.setForeground(Color.WHITE);
	usercash.setFont(new Font("굴림", Font.BOLD, 20));
	usercash.setBounds(291, 409, 84, 37);
	panel.add(usercash);

	JButton cancel = new JButton("취소");
	cancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			jf.dispose();
		}
	});
	cancel.setForeground(new Color(255, 182, 193));
	cancel.setFont(new Font("굴림", Font.BOLD, 18));
	cancel.setBackground(Color.DARK_GRAY);
	cancel.setBounds(525, 403, 84, 43);
	panel.add(cancel);

	jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
	jf.setVisible(true);

}

}
