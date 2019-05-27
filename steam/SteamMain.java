package steam;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.SoftBevelBorder;

import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class SteamMain extends JFrame {
	SteamMainPanel1 mainPanel1;
	SteamMainPanel2 mainPanel2;
	SteamMainPanel3 mainPanel3;
	SteamMainPanel4 mainPanel4;
	static GameDTO1[] saleGame = new GameDTO1[4];
	static ArrayList<GameDTO1> list;
	static JScrollPane sp;

	SteamMain() {
		setBackground(Color.DARK_GRAY);
		// mainFrame 설정
		setTitle("steam");
		setSize(1600, 900);
		getContentPane().setLayout(null);

		// 세일목록 생성
		GameDAO1 dao = new GameDAO1();
		list = null;
		list = dao.selectAll();
		Random r = new Random();
		int index = 0;
		int i = 0;
		boolean b;
		while (true) {
			b=false;
			index = r.nextInt(list.size());
			if (i == 0) {
				saleGame[i] = (GameDTO1) list.get(index);
				i++;
			} else if (i == 4) {
				break;
			} else if (1 <= i && i < 4) {
				saleGame[i] = (GameDTO1) list.get(index);
				for (int j = i; j >=0; j--) {
					for(int k=i;k>=0;k--) {
						if(j!=k) {
							System.out.println(j);
							System.out.println(k);
							System.out.println("-----------------------");
							if (saleGame[j].getGname().equals(saleGame[k].getGname())) {
								b = true;
							}
						}
					}
				}
				if (b) {
				} else {
					i++;
				}
			}
		}
		saleGame[0].setGprice(saleGame[0].getGprice() / 10 * 8);
		saleGame[1].setGprice(saleGame[1].getGprice() / 3);
		saleGame[2].setGprice(saleGame[2].getGprice() / 2);
		saleGame[3].setGprice(saleGame[3].getGprice() / 5);

		// panel1(가로)
		mainPanel1 = new SteamMainPanel1();
		getContentPane().add(mainPanel1);

		// panel1의 버튼액션
		this.panelAction1();

		// panel2(세로)
		mainPanel2 = new SteamMainPanel2();
		getContentPane().add(mainPanel2);

		// panel2의 버튼액션
		this.panelAction2();

		// panel3(목록)
		mainPanel3 = new SteamMainPanel3();

		// panel3의 스크롤페인(버튼클릭시마다 바뀜)
		sp = new JScrollPane();
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setViewportView(mainPanel3);
		sp.setBounds(259, 157, 1019, 706);

		getContentPane().add(sp);

		// 커뮤니티 일 때

		// panel4(프로필)
		mainPanel4 = new SteamMainPanel4();
		getContentPane().add(mainPanel4);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	void panelAction1() {
		mainPanel1.comonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				sp.setVisible(false);
//				sp.setEnabled(false);
//				sp.setViewportView(null);
//				ComonScroll comonSp = new ComonScroll();
//				comonSp.sp.setBounds(311, 251, 913, 566); //옛날설정
//				comonSp.sp.setBounds(259, 157, 1019, 706);
//				getContentPane().add(comonSp.sp);
				sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				sp.setViewportView(new ComonGroupSelectPanel());

			}
		});
		mainPanel1.titleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
				sp.setViewportView(mainPanel3);
			}
		});

		mainPanel1.libraryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SteamLibrary l1 = new SteamLibrary();
				sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
				l1.setPreferredSize(new Dimension(1001, 706));
				sp.setViewportView(l1);
			}
		});

		mainPanel1.storeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				SteamShop s1 = new SteamShop(0, "");
				sp.setViewportView(s1);
			}
		});
		mainPanel1.infoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserEdit ue = new UserEdit();
				} catch (Exception e1) {
					System.out.println("userinfo불러오는중 오류");
				}
			}
		});

	}

	void panelAction2() {
		mainPanel2.hitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SteamShop s1 = new SteamShop(3, "");
				sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				sp.setViewportView(s1);
			}
		});
		mainPanel2.lowPriceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SteamShop s1 = new SteamShop(1, "");
				sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				sp.setViewportView(s1);
			}
		});
		mainPanel2.highPriceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SteamShop s1 = new SteamShop(2, "");
				sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				sp.setViewportView(s1);
			}
		});
		mainPanel2.newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SteamShop s1 = new SteamShop(5, "a");
				sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				sp.setViewportView(s1);
			}
		});
		mainPanel2.hitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SteamShop s1 = new SteamShop(0, "");
				sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				sp.setViewportView(s1);
			}
		});
		mainPanel2.themeSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IfSearchClicked name = new IfSearchClicked();
				SteamShop s1 = new SteamShop(4, name.yesorno[name.select]);
				sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				sp.setViewportView(s1);
			}
		});
		mainPanel2.communityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				sp.setViewportView(new ComonGroupSelectPanel());
			}
		});
		mainPanel2.payButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUserCash name = new AddUserCash();
			}
		});
		mainPanel2.infoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserEdit ue = new UserEdit();
				} catch (Exception e1) {
					System.out.println("userinfo불러오는중 오류");
				}
			}
		});
		mainPanel2.libraryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SteamLibrary li = new SteamLibrary();
				sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				sp.setViewportView(li);
				
			}
		});
	}

}
