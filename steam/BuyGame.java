package steam;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BuyGame {
//	static String inputgname = "LOL";
//	static String inputuid = "2";
	String usergamelist;
	int[] saleP = {20,30,50,80};

	public BuyGame(String inputgname, String inputuid) {
		JFrame jf = new JFrame();
		jf.setSize(1920, 800);
		jf.getContentPane().setLayout(null);

		JPanel mainpanel = new JPanel();
		mainpanel.setBackground(Color.DARK_GRAY);
		mainpanel.setBounds(12, 10, 1880, 743);
		jf.getContentPane().add(mainpanel);
		mainpanel.setLayout(null);
		JPanel picturepanel = new JPanel();
		picturepanel.setBackground(Color.DARK_GRAY);

		picturepanel.setBounds(24, 77, 1844, 419);
		mainpanel.add(picturepanel);
		picturepanel.setLayout(new GridLayout(1, 0, 0, 0));

		ImageIcon[] ic = new ImageIcon[3];
		File[] f = new File[3];
		for (int i = 0; i < ic.length; i++) {
			f[i] = new File(inputgname + i + ".jpg");
			ic[i] = new ImageIcon(inputgname + i + ".jpg");
			if (!f[i].exists()) {
				f[i] = new File(inputgname + i + ".png");
				ic[i] = new ImageIcon(inputgname + i + ".png");
			}
			System.out.println(f[i]);

		}
		String[] str = new String[5];

		JPanel pnl1 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(ic[0].getImage(), 0, 0, d.width, d.height, null); // 컴포넌트 사이즈에 맞게
			}
		};
		picturepanel.add(pnl1);

		JPanel pnl2 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(ic[1].getImage(), 0, 0, d.width, d.height, null); // 컴포넌트 사이즈에 맞게
			}
		};
		picturepanel.add(pnl2);

		JPanel pnl3 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(ic[2].getImage(), 0, 0, d.width, d.height, null); // 컴포넌트 사이즈에 맞게
			}
		};
		picturepanel.add(pnl3);

		JLabel title = new JLabel("게임 이름");
		title.setForeground(Color.WHITE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(754, 10, 383, 57);
		title.setFont(new Font("굴림", Font.BOLD, 40));
		mainpanel.add(title);

		JPanel infopanel = new JPanel();
		infopanel.setForeground(new Color(255, 255, 255));
		infopanel.setBackground(Color.DARK_GRAY);
		infopanel.setBorder(new LineBorder(Color.WHITE));
		infopanel.setBounds(563, 506, 383, 225);

		Font font = new Font("굴림", Font.BOLD, 20);
		infopanel.setBorder(new TitledBorder(new LineBorder(Color.WHITE), "GameInfo", 2, 2, font, Color.WHITE));
		mainpanel.add(infopanel);
		infopanel.setLayout(null);

		JLabel lbl1 = new JLabel("게임 테마");
		lbl1.setBounds(25, 64, 119, 26);
		infopanel.add(lbl1);
		lbl1.setForeground(Color.WHITE);
		lbl1.setFont(new Font("굴림", Font.PLAIN, 26));

		JLabel lbl2 = new JLabel("게임 사양");
		lbl2.setBounds(25, 124, 119, 26);
		infopanel.add(lbl2);
		lbl2.setForeground(Color.WHITE);
		lbl2.setFont(new Font("굴림", Font.PLAIN, 26));

		JLabel lbl3 = new JLabel("게임 평점");
		lbl3.setBounds(25, 176, 119, 26);
		infopanel.add(lbl3);
		lbl3.setForeground(Color.WHITE);
		lbl3.setFont(new Font("굴림", Font.PLAIN, 26));

		JLabel grate = new JLabel("게임 평점");
		grate.setHorizontalAlignment(SwingConstants.CENTER);
		grate.setBounds(159, 176, 197, 26);
		infopanel.add(grate);
		grate.setForeground(Color.WHITE);
		grate.setFont(new Font("굴림", Font.PLAIN, 26));

		JLabel gspec = new JLabel("게임 사양");
		gspec.setHorizontalAlignment(SwingConstants.CENTER);
		gspec.setBounds(159, 124, 197, 26);
		infopanel.add(gspec);
		gspec.setForeground(Color.WHITE);
		gspec.setFont(new Font("굴림", Font.PLAIN, 26));

		JLabel gtheme = new JLabel("<html>게임1, 게임2, 게임3 <br> 게임4, 게임5</html>");
		gtheme.setHorizontalAlignment(SwingConstants.CENTER);
		gtheme.setBounds(156, 24, 200, 90);
		infopanel.add(gtheme);
		gtheme.setVerticalAlignment(SwingConstants.TOP);
		gtheme.setForeground(Color.WHITE);
		gtheme.setFont(new Font("굴림", Font.PLAIN, 24));

		JPanel buypanel = new JPanel();
		buypanel.setForeground(new Color(255, 255, 255));
		buypanel.setBackground(Color.DARK_GRAY);
		buypanel.setBorder(new LineBorder(Color.WHITE));
		buypanel.setBounds(972, 506, 383, 225);
		buypanel.setBorder(new TitledBorder(new LineBorder(Color.WHITE), "GameBuy", 2, 0, font, Color.WHITE));
		mainpanel.add(buypanel);
		buypanel.setLayout(null);

		JLabel lbl4 = new JLabel("내 지갑");
		lbl4.setBounds(56, 36, 117, 38);
		buypanel.add(lbl4);
		lbl4.setForeground(Color.WHITE);
		lbl4.setFont(new Font("굴림", Font.PLAIN, 26));

		JLabel lbl5 = new JLabel("게임 가격");
		lbl5.setBounds(39, 96, 134, 38);
		buypanel.add(lbl5);
		lbl5.setForeground(Color.WHITE);
		lbl5.setFont(new Font("굴림", Font.PLAIN, 26));

		JLabel usercash = new JLabel("10000");
		usercash.setHorizontalAlignment(SwingConstants.CENTER);
		usercash.setBounds(212, 41, 109, 29);
		buypanel.add(usercash);
		usercash.setForeground(Color.WHITE);
		usercash.setFont(new Font("굴림", Font.PLAIN, 26));

		JLabel gprice = new JLabel();
		gprice.setHorizontalAlignment(SwingConstants.CENTER);
		gprice.setBounds(212, 100, 117, 31);
		buypanel.add(gprice);
		gprice.setForeground(Color.WHITE);
		gprice.setFont(new Font("굴림", Font.PLAIN, 26));

		JButton editbtn = new JButton("결  제");
		editbtn.setBounds(27, 151, 152, 43);
		buypanel.add(editbtn);
		GameDAO gdao;
		UserDAO udao;
		try {
			gdao = new GameDAO();
			GameDTO gdto = gdao.selectgame(inputgname);

			title.setText(gdto.getGname());
			gtheme.setText(gdto.getGtheme());
			grate.setText(Integer.toString(gdto.getGrate()));
			gspec.setText(Integer.toString(gdto.getGspec()));
			for(int i =0;i<SteamMain.saleGame.length;i++) {
				if(SteamMain.saleGame[i].getGname().equals(gdto.getGname())) {
					gprice.setText((SteamMain.saleGame[i].getGprice()+""));
				}
			}
			if(gprice.getText().equals("")) {
				gprice.setText(Integer.toString(gdto.getGprice()));
			}

			udao = new UserDAO(); // 잔액 체크
			UserDTO udto = udao.select(inputuid);
			usergamelist = udto.getUgamelist();
			System.out.println(usergamelist);
			usercash.setText(Integer.toString(udto.getUcash()));

			JLabel warning = new JLabel("잔액부족 !");
			warning.setVisible(false);
			warning.setBounds(27, 195, 152, 29);
			buypanel.add(warning);
			warning.setHorizontalAlignment(SwingConstants.CENTER);
			warning.setForeground(Color.RED);
			warning.setFont(new Font("굴림", Font.PLAIN, 18));

			if (Integer.parseInt(gprice.getText()) > udto.getUcash()) { // 게임가격이 유저의 돈보다 비싸다면 에러메시지 출력
				editbtn.setEnabled(false);
			} 
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		editbtn.addActionListener(new ActionListener() { // 결제 버튼 액션 리스너 구매!!!!!!!!!!!!!!
			public void actionPerformed(ActionEvent e) {
				if (usergamelist.toLowerCase().contains(inputgname.toLowerCase())) { // 이미 게임을 가지고 있나요 ? + 소문자 통일로 if문
					JOptionPane.showMessageDialog(null, "이미 이 게임을 가지고 있습니다.");
				} else {
					try {
						UserDAO udao = new UserDAO();
						udao.updatecash(inputuid, Integer.parseInt(usercash.getText()),
								Integer.parseInt(gprice.getText()) * -1); // 유저 잔액 업데이트 시키기

						int minus = Integer.parseInt(usercash.getText()) - Integer.parseInt(gprice.getText());
						JOptionPane.showMessageDialog(null, title.getText() + " 구매하였습니다! \n 남은 잔액 : " + minus);

						if(!usergamelist.equals("")) {
							usergamelist = usergamelist + "," + inputgname;
						}
						else {
							usergamelist = usergamelist+ inputgname;
						}
						udao.updategame(usergamelist, inputuid);
						jf.dispose();
						SteamLibrary li = new SteamLibrary(); // 라이브러리
						jf.dispose();

					} catch (Exception e1) {
						e1.printStackTrace();
					} // catch
				} // else
			}// ActionEvent
		});

		editbtn.setForeground(new Color(135, 206, 250));
		editbtn.setBackground(Color.DARK_GRAY);
		editbtn.setFont(new Font("굴림", Font.PLAIN, 18));
		editbtn.setFocusPainted(false);

		JButton addcashbtn = new JButton("충전하러가기");
		addcashbtn.setBounds(192, 151, 152, 43);
		buypanel.add(addcashbtn);
		addcashbtn.addActionListener(new ActionListener() { // 충전하러가기
			public void actionPerformed(ActionEvent e) {

				AddUserCash addcash = new AddUserCash();
			}
		});
		addcashbtn.setForeground(new Color(250, 128, 114));
		addcashbtn.setBackground(Color.DARK_GRAY);
		addcashbtn.setFont(new Font("굴림", Font.PLAIN, 18));
		addcashbtn.setFocusPainted(false);

		jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
		jf.setVisible(true);
	}
}
