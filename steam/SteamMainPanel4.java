package steam;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SteamMainPanel4 extends JPanel {
	ImageIcon icon;
	JToggleButton profileButton;
	JButton addFriend;
	static JList friendList;
	UserDTO1 dto;
	UserDAO1 dao= new UserDAO1();
	JScrollPane sp;
	boolean key=false;
	JLabel friendListLabel;

	SteamMainPanel4() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setBounds(1278, 159, 306, 702);
		setSize(306, 702);
		
		this.button();
		this.friendList();

	}
	void friendList() {
		dto = dao.select(SteamLogin.userInfo.getUid());
		SteamLogin.uFriend = dto.getUfriend().split(",");
		friendList = new JList();
		friendList.setListData(SteamLogin.uFriend);
		
		friendList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = friendList.getSelectedIndex();
				if(i !=-1) {
					dto = dao.select(SteamLogin.uFriend[i]);
					FriendInfo f = new FriendInfo();
					f.t1.setText(dto.getUid());
					f.t2.setText(dto.getUname());
					f.t3.setText(dto.getUgamelist());
					f.t4.setText(dto.getUtheme());
					f.deleteAction();
				}
				
				
			}
		});
				
		friendList.setFont(new Font("굴림", Font.BOLD, 30));
		friendList.setVisibleRowCount(10);

		sp = new JScrollPane(friendList);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBounds(25, 142, 243, 466);
		add(sp);
		
		friendListLabel = new JLabel("친구 목록");
		friendListLabel.setBackground(Color.GRAY);
		friendListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		friendListLabel.setFont(new Font("굴림", Font.BOLD, 20));
		sp.setColumnHeaderView(friendListLabel);
		sp.setVisible(false);
		
	}
	void button() {
		icon = new ImageIcon("profileIcon1.png");
		profileButton = new JToggleButton(icon);
		profileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(key) {
					sp.setVisible(false);
					key = false;
				}else {
					sp.setVisible(true);
					key = true;
				}
			}
		});
		profileButton.setBorderPainted(false);
		profileButton.setBackground(null);
		profileButton.setBounds(159, 618, 135, 59);
		add(profileButton);
		
		addFriend = new JButton("친구추가");
		addFriend.setForeground(Color.WHITE);
		addFriend.setBackground(null);
		addFriend.setFocusPainted(false);
		addFriend.setBorderPainted(false);
		addFriend.setFont(new Font("굴림", Font.BOLD, 15));
		addFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uid = JOptionPane.showInputDialog("ID를 입력해주세요");
				AddFriend f;
				dto=null;
				dto = dao.select(uid);
				if(dto==null) {
					JOptionPane.showMessageDialog(null, "찾으시는 아이디가 없습니다.");
				}else {
					if(dto.getUid().equals(SteamLogin.userInfo.getUid())) {
						JOptionPane.showMessageDialog(null, "본인입니다. 회원정보 보기를 눌러서 자신의 정보를 확인해주세요.");
					}else {
						f = new AddFriend(uid);
						f.t1.setText(dto.getUid());
						f.t2.setText(dto.getUname());
						f.t3.setText("개인정보");
						f.t4.setText(dto.getUtheme());
					}
				}
			}
		});
		addFriend.setBounds(12, 618, 135, 59);
		add(addFriend);
		

	}
}
