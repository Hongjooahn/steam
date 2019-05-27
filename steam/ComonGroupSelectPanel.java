package steam;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ComonGroupSelectPanel extends JPanel{
	JTable table;
	JButton[] buttons;
	GameDAO1 dao = new GameDAO1();
	GameDTO1 dto;
	ArrayList gameList;
	JLabel comLabel;
	JLabel Down;
	JLabel up;
	JLabel sero;
	Random r1 = new Random(255);
	
	
	ComonGroupSelectPanel(){
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		//라벨, 게시판 구분선/////////////////////////////////
		comLabel = new JLabel("그룹 선택");
		comLabel.setFont(new Font("굴림", Font.BOLD, 25));
		comLabel.setBounds(90, 60, 109, 38);
		comLabel.setForeground(Color.WHITE);
		add(comLabel);
		
		Down = new JLabel("-------------------------");
		Down.setForeground(Color.WHITE);
		Down.setFont(new Font("굴림", Font.BOLD, 30));
		
		up = new JLabel("-------------------------");
		up.setForeground(Color.WHITE);
		up.setFont(new Font("굴림", Font.BOLD, 30));
		///////////////////////////////////////////////
		
		
		gameList = dao.selectAll();
		
		
		
		int x = 250;
		int y = 150;
		buttons = new JButton[gameList.size()];
		setPreferredSize(new Dimension(1001,200+(gameList.size()*75)));//895
		for(int i=0;i<gameList.size();i++) {
			if(i==0) {
				up.setBounds(x-12, y-30, 1000, 30);
				add(up);
			}
			dto = (GameDTO1)gameList.get(i);
			buttons[i] = new JButton(dto.getGname());
			buttons[i].setBackground(new Color(100,100,100));
			buttons[i].setFont(new Font("굴림", Font.BOLD, 25));
			buttons[i].setForeground(new Color(100+r1.nextInt(125),100+r1.nextInt(125),100+r1.nextInt(125)));
			buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton b1 = (JButton)e.getSource();
					ComonNoticeSelectPanel panel2 = new ComonNoticeSelectPanel(b1.getActionCommand());//gettext()=getactioncommand()
					SteamMain.sp.setViewportView(panel2);
				}
			});
			buttons[i].setBounds(x, y, 500, 75);
			y+= 80;
			add(buttons[i]);
			if(i==gameList.size()-1) {
				Down.setBounds(x-12, y, 1000, 30);
				add(Down);
			}
		}
		
		
		
		
	}
}
