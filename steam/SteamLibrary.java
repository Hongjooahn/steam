package steam;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SteamLibrary extends JPanel {

	String labels[];
	String changedugamelist = null;
	String selectedgname;
	JList jlist;

	public SteamLibrary() {
		String userid = SteamLogin.userInfo.getUid(); // 임의로 정한 유저 ID

		setBackground(Color.DARK_GRAY);
		setLayout(null);


		JPanel list_panel = new JPanel();
		list_panel.setBackground(Color.DARK_GRAY);
		list_panel.setBounds(12, 8, 300, 670);
		list_panel.setLayout(null);
		add(list_panel);

		try {
			UserDAO udao = new UserDAO();
			UserDTO udto = udao.select(userid);

			GameDAO gdao = new GameDAO();

			String countlist = udto.getUgamelist();
			labels = countlist.split(",");

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		JPanel gameexplane_panel = new JPanel();
		gameexplane_panel.setBackground(Color.GRAY);
		gameexplane_panel.setBounds(324, 10, 675, 670);

		add(list_panel);
		add(gameexplane_panel);
		gameexplane_panel.setLayout(null);

		JLabel lb = new JLabel("게임 이름");
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		lb.setFont(new Font("굴림", Font.PLAIN, 30));
		lb.setBounds(201, 20, 272, 88);
		gameexplane_panel.add(lb);

		JLabel lb1 = new JLabel("테마");
		lb1.setFont(new Font("굴림", Font.PLAIN, 30));
		lb1.setHorizontalAlignment(SwingConstants.CENTER);
		lb1.setBounds(65, 133, 272, 88);
		gameexplane_panel.add(lb1);

		JLabel lb2 = new JLabel("가격");
		lb2.setFont(new Font("굴림", Font.PLAIN, 30));
		lb2.setHorizontalAlignment(SwingConstants.CENTER);
		lb2.setBounds(65, 243, 272, 88);
		gameexplane_panel.add(lb2);

		JLabel lb3 = new JLabel("사양");
		lb3.setFont(new Font("굴림", Font.PLAIN, 30));
		lb3.setHorizontalAlignment(SwingConstants.CENTER);
		lb3.setBounds(65, 353, 272, 88);
		gameexplane_panel.add(lb3);

		JLabel lb4 = new JLabel("평점");
		lb4.setFont(new Font("굴림", Font.PLAIN, 30));
		lb4.setHorizontalAlignment(SwingConstants.CENTER);
		lb4.setBounds(65, 463, 272, 88);
		gameexplane_panel.add(lb4);

		JLabel gtheme = new JLabel();
		gtheme.setFont(new Font("굴림", Font.PLAIN, 30));
		gtheme.setHorizontalAlignment(SwingConstants.CENTER);
		gtheme.setBounds(359, 133, 272, 88);
		gameexplane_panel.add(gtheme);

		JLabel gprice = new JLabel("");
		gprice.setFont(new Font("굴림", Font.PLAIN, 30));
		gprice.setHorizontalAlignment(SwingConstants.CENTER);
		gprice.setBounds(359, 243, 272, 88);
		gameexplane_panel.add(gprice);

		JLabel gspec = new JLabel("");
		gspec.setFont(new Font("굴림", Font.PLAIN, 30));
		gspec.setHorizontalAlignment(SwingConstants.CENTER);
		gspec.setBounds(359, 353, 272, 88);
		gameexplane_panel.add(gspec);

		JLabel grate = new JLabel("");
		grate.setFont(new Font("굴림", Font.PLAIN, 30));
		grate.setHorizontalAlignment(SwingConstants.CENTER);
		grate.setBounds(359, 463, 272, 88);
		gameexplane_panel.add(grate);

		jlist = new JList(labels);
		jlist.setBackground(Color.LIGHT_GRAY);

		jlist.setFont(new Font("굴림", Font.PLAIN, 22));
		jlist.setVisibleRowCount(26);
		JScrollPane scrollPane1 = new JScrollPane(jlist);
		scrollPane1.setBounds(3, 5, 297, 702);
		list_panel.add(scrollPane1);
		ListSelectionListener listSelectionListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				boolean adjust = listSelectionEvent.getValueIsAdjusting();

				if (!adjust) {
					JList list = (JList) listSelectionEvent.getSource();
					int selections[] = list.getSelectedIndices();
					Object selectionValues[] = list.getSelectedValues();
					for (int i = 0, n = selections.length; i < n; i++) {
						System.out.print(selections[i] + "/" + selectionValues[i] + " "); // 번호 / 값 출력
						try {
							String gamename = selectionValues[i].toString();
							GameDAO gdao = new GameDAO();
							GameDTO gdto = gdao.selectgame(gamename);
							lb.setText(gdto.getGname());
							gtheme.setText(gdto.getGtheme());
							gprice.setText(Integer.toString(gdto.getGprice()));
							gspec.setText(Integer.toString(gdto.getGspec()));
							grate.setText(Integer.toString(gdto.getGrate()));

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					System.out.println();
				}
			}
		};
		jlist.addListSelectionListener(listSelectionListener);

		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				JList theList = (JList) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 2) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						Object o = theList.getModel().getElementAt(index);
						System.out.println("Double-clicked on: " + o.toString()); // 더블클릭
																					// *****************************************
					}
				}
			}
		};

		JButton btnNewButton = new JButton("목록에서 제거");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);

		btnNewButton.addActionListener(new ActionListener() { // 목록에서 제거 버튼
			public void actionPerformed(ActionEvent arg0) { // gnamelist => 게임 한개가 제거된 목록이 들어갈 배열
				String[] gnamelist = new String[labels.length - 1]; // 한개가 제거될테니까 한칸 줄임
				int j = 0;

				for (int i = 0; i < labels.length; i++) {
					if (!lb.getText().equalsIgnoreCase(labels[i])) { // 같지않으면
						gnamelist[j] = labels[i]; // 대입해줌
						j++;
					}
				}

				changedugamelist = ""; //
				for (int i = 0; i < gnamelist.length - 1; i++) {
					changedugamelist = changedugamelist + gnamelist[i] + ","; //
				}
				if (gnamelist.length - 1 != -1) {
					changedugamelist = changedugamelist + gnamelist[gnamelist.length - 1]; // 제거한 게임을 제외한 목록을 String에
																							// 넣어줌
				} else {
					changedugamelist = "";
				}
				try {
					UserDAO udao = new UserDAO();
					udao.updategame(changedugamelist, userid); // DB업데이트 changedugamelist => gnamelist 배열을 단일 String화

					jlist.setListData(gnamelist); // JList 업데이트
					labels = new String[gnamelist.length];
					for (int i = 0; i < gnamelist.length; i++) {
						labels[i] = gnamelist[i];
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 18));
		btnNewButton.setBounds(410, 600, 163, 55);
		gameexplane_panel.add(btnNewButton);


	}

}
