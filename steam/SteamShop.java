package steam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SteamShop extends JPanel {
	int count;
	int y = 200; // 검색창을 위해 비워두는 여백이 200
	String search = "";
	boolean b = false;
	int sale;
	int index;
	int[] saleP = {20,30,50,80};

	public SteamShop(int menuselect, String search) { // 정렬을 어떤것으로 어떻게 정렬 할 것인지 ?
		this.search = search;
		setBackground(Color.DARK_GRAY);
		setLayout(null);

		JPanel searchpnl = new JPanel(null);
		searchpnl.setBounds(20, 20, 960, 160);
		Font font = new Font("굴림", Font.BOLD, 20);
		searchpnl.setBorder(new TitledBorder(new LineBorder(Color.WHITE), "GameSearch", 1, 2, font, Color.WHITE));
		searchpnl.setBackground(Color.DARK_GRAY);
		add(searchpnl);

		JTextField gnamesearchtf = new JTextField();
		gnamesearchtf.setFont(new Font("굴림", Font.PLAIN, 24));
		gnamesearchtf.setBounds(50, 65, 740, 50);
		searchpnl.add(gnamesearchtf);

		JButton searchsubmit = new JButton("검색!");
		searchsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SteamShop s = new SteamShop(5, gnamesearchtf.getText());
			}
		});

		searchsubmit.setFont(new Font("굴림", Font.PLAIN, 18));
		searchsubmit.setBackground(Color.WHITE);
		searchsubmit.setBounds(810, 65, 100, 50);
		searchpnl.add(searchsubmit);

		// 게임 리스트 시작

		GameDAO gdao;
		try {
			gdao = new GameDAO();
			ArrayList glist = gdao.showshop(menuselect, search); // -> 게임의 전체목록을 불러온다.. 지금 이 코드를 if문으로 나눠서 연산
			// menuselect == 1:메인메뉴 2:낮은가격순 3:높은가격순 4:테마일치 5:이름일치
			JPanel[] gamepanels = new JPanel[glist.size()];
			JPanel[] imagepanel = new JPanel[glist.size()];
			JLabel[] gnametext = new JLabel[glist.size()];
			JLabel[] gpricetext = new JLabel[glist.size()];
			JLabel[] imglbl = new JLabel[glist.size()];

			for (int i = 0; i < glist.size(); i++) { // 반복문 시작
				GameDTO gdto = (GameDTO) glist.get(i);

				// 게임 패널 설정 안에 게임 이름이나 가격등을 넣을것
				gamepanels[i] = new JPanel();
				gamepanels[i].setBounds(20, y, 960, 200);
				gamepanels[i].setBackground(new Color(100, 100, 100)); // 게임 패널 안에 색상
				gamepanels[i].setLayout(null);
				gamepanels[i].setBorder(new LineBorder(new Color(0, 0, 30), 2, false)); // 테두리 설정

				ImageIcon[] ic = new ImageIcon[glist.size()];
				File[] f = new File[glist.size()];

				f[i] = new File(gdto.getGname() + "_icon.jpg");
				ic[i] = new ImageIcon(gdto.getGname() + "_icon.jpg");

				if (!f[i].exists()) {
					f[i] = new File(gdto.getGname() + "_icon.png");
					ic[i] = new ImageIcon(gdto.getGname() + "_icon.png");
				}
				System.out.println(ic.length);
				System.out.println(glist.size());
				System.out.println(f[i]);

				// 이미지 패널 설정
				imagepanel[i] = new JPanel(new BorderLayout()) {
					public void paintComponent(Graphics g) {
//						Dimension d = getSize();
//						System.out.println(d);
//						if(f[i].exists()) {
//						g.drawImage(ic[0].getImage(), 0, 0, d.width, d.height, null); // case1 - 컴포넌트 사이즈에 맞게
//						}
					}
				};
				imglbl[i] = new JLabel(ic[i]); // case2 - 이미지를 미리 사이즈를 맞추어서 삽입.
				imagepanel[i].add(imglbl[i]); // case2

				imagepanel[i].setBackground(Color.white);
				imagepanel[i].setBorder(new LineBorder(new Color(40, 40, 40), 1, false)); // 테두리 설정
				imagepanel[i].setBounds(5, 5, 190, 190);

				// 텍스트 설정
				gnametext[i] = new JLabel(gdto.getGname());
				gnametext[i].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						JLabel la = (JLabel) e.getSource();
						String indextest = la.getText();
						BuyGame bg = new BuyGame(indextest,SteamLogin.userInfo.getUid());

					}
				});
				// gnametext[i].setVerticalAlignment(SwingConstants.TOP); // 위쪽부터 붙여쓰기
				gnametext[i].setBounds(220, 5, 600, 190);
				gnametext[i].setHorizontalAlignment(SwingConstants.LEFT);
				gnametext[i].setFont(new Font("굴림", Font.PLAIN, 40));
				gnametext[i].setForeground(Color.BLACK);
				for (int j = 0; j < SteamMain.saleGame.length; j++) {
					if (gdto.getGname().equals(SteamMain.saleGame[j].getGname())) {
						b = true;
						index = j;
					}
					if (b) {
						gpricetext[i] = new JLabel(saleP[index]+"% 특별 할인! -> "+SteamMain.saleGame[index].getGprice() + "\\");
					}
				}
				if (b) {
					b = false;
				} else {
					gpricetext[i] = new JLabel(gdto.getGprice() + "\\");
				}
				gpricetext[i].setBounds(630, 5,	300, 190);
				gpricetext[i].setHorizontalAlignment(SwingConstants.RIGHT);
				gpricetext[i].setFont(new Font("굴림", Font.PLAIN, 20));
				gpricetext[i].setForeground(Color.BLACK);

				// 사이즈 및 인덱스 증가
				y = y + 210;
				count++;
				// 이미지 넣고 add
				add(gamepanels[i]); // 메인패널에 게임패널 삽입
				gamepanels[i].add(imagepanel[i]); // 게임패널에 이미지 삽입
				gamepanels[i].add(gnametext[i]); // 게임패널에 정보 삽입
				gamepanels[i].add(gpricetext[i]); // 게임패널에 정보 삽입

			} // for ~~~~~~~

		} catch (Exception e) {
			e.printStackTrace();
		}
//		JScrollPane sp = new JScrollPane();
		setPreferredSize(new Dimension(1001, 200 + (count * 210))); // 가변크기 ( 가로스크롤 / 검색창 여백 + ( 게임 개수 *
																	// 세로길이+여백))
		SteamMain.sp.setViewportView(this);

		setVisible(true);
	}

}
