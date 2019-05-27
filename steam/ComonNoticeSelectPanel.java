package steam;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ComonNoticeSelectPanel extends JPanel{
	NoticeDTO1 dto;
	NoticeDAO1 dao = new NoticeDAO1();
	ArrayList<NoticeDTO1> noticeList;
	JButton[] buttons;
	JButton writeButton;
	JButton preButton;
	NoticeReadWrite contents;
	Random r1 = new Random(255);
	JLabel startLabel;
	JLabel titleT = new JLabel("제목");
	JLabel writerT = new JLabel("글쓴이");
	JLabel writeTime = new JLabel("작성시간");
	JLabel[] line;
	JLabel[] nNum;
	JLabel[] nId;
	JLabel[] nTime;

	
	ComonNoticeSelectPanel(){
		
	}
	ComonNoticeSelectPanel(String gname){
		
		noticeList = dao.select(gname);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		writeButton = new JButton("글쓰기");
		writeButton.setBackground(null);
		writeButton.setBorderPainted(false);
		writeButton.setFocusPainted(false);
		writeButton.setForeground(Color.WHITE);
		writeButton.setFont(new Font("굴림", Font.BOLD, 17));
		writeButton.setBounds(712, 70, 100, 23);
		writeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NoticeDTO1 dto = new NoticeDTO1();
				dto.setUid(SteamLogin.userInfo.getUid());//나중에 연결시 이걸로
				dto.setGname(gname);
				NoticeReadWrite name = new NoticeReadWrite(dto);
				
			}
		});
		add(writeButton);
		
		//이전페이지 button
		preButton = new JButton("이전 화면");
		preButton.setFont(new Font("굴림", Font.BOLD, 25));
		preButton.setForeground(Color.WHITE);
		preButton.setBounds(75, 60, 159, 38);
		preButton.setBorderPainted(false);
		preButton.setFocusPainted(false);
		preButton.setBackground(null);
		preButton.setHorizontalAlignment(SwingConstants.LEFT);
		preButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComonGroupSelectPanel name = new ComonGroupSelectPanel();
				SteamMain.sp.setViewportView(name);
			}
		});
		add(preButton);
		
		//서식
		titleT.setBounds(370, 115, 80, 30);
		titleT.setFont(new Font("굴림", Font.BOLD, 13));
		titleT.setForeground(new Color(112,112,112));
		add(titleT);
		writerT.setBounds(600, 115, 80, 30);
		writerT.setFont(new Font("굴림", Font.BOLD, 13));
		writerT.setForeground(new Color(112,112,112));
		add(writerT);
		writeTime.setBounds(712, 115, 80, 30);
		writeTime.setFont(new Font("굴림", Font.BOLD, 13));
		writeTime.setForeground(new Color(112,112,112));
		add(writeTime);
		
		
		
		startLabel = new JLabel("------------------------------");
		startLabel.setBounds(169, 135, 1000, 25);
		startLabel.setForeground(Color.WHITE);
		startLabel.setFont(new Font("굴림", Font.BOLD, 30));
		add(startLabel);
		
		if(noticeList.size()>0) {
			setPreferredSize(new Dimension(1001,300+(noticeList.size()*105)));//895
			buttons = new JButton[noticeList.size()];
			line = new JLabel[noticeList.size()];
			nNum = new JLabel[noticeList.size()];
			nId = new JLabel[noticeList.size()];
			nTime = new JLabel[noticeList.size()];
			int x = 250;
			int y = 150;
			for(int i=0;i<buttons.length;i++) {
				dto = noticeList.get(i);
				nTime[i] = new JLabel(dto.getTime());
				nTime[i].setFont(new Font("굴림", Font.BOLD, 15));
				nTime[i].setForeground(Color.WHITE);
				nTime[i].setBounds(x+460, y, 100, 30);
				add(nTime[i]);
				nId[i] = new JLabel(dto.getUid());
				nId[i].setFont(new Font("굴림", Font.BOLD, 20));
				nId[i].setForeground(Color.WHITE);
				nId[i].setHorizontalAlignment(SwingConstants.CENTER);
				nId[i].setBounds(x+350, y, 40, 30);
				add(nId[i]);
				nNum[i] = new JLabel((i+1)+"");
				nNum[i].setHorizontalAlignment(SwingConstants.RIGHT);
				nNum[i].setFont(new Font("굴림", Font.PLAIN, 15));
				nNum[i].setForeground(Color.WHITE);
				nNum[i].setBounds(x-85, y, 40, 30);
				add(nNum[i]);
				buttons[i] = new JButton(dto.getTitle());
				String conNum = ""+dto.getNum();
				buttons[i].setName(conNum);
				buttons[i].setBackground(null);
				buttons[i].setHorizontalAlignment(SwingConstants.LEFT);
				buttons[i].setBorderPainted(false);
				buttons[i].setFocusPainted(false);
				buttons[i].setForeground(Color.WHITE);
				buttons[i].setFont(new Font("굴림", Font.BOLD, 20));
				buttons[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b1 = (JButton)e.getSource();
						int cNum = Integer.parseInt(b1.getName());
						dto = dao.select(cNum);
						contents = new NoticeReadWrite(b1.getText(),dto.getNum(),dto.getGname());
						contents.setIdLabel.setText(dto.getUid());
						contents.titleText.setText(dto.getTitle());
						contents.contentsArea.setText(dto.getContents());
						contents.deleteButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(SteamLogin.userInfo.getUid().equals(dto.getUid())) {
									JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
									dao.delete(dto.getNum());
									contents.dispose();
									ComonNoticeSelectPanel p1 = new ComonNoticeSelectPanel(gname);
									SteamMain.sp.setViewportView(p1);
									//testpanel2에서 noticeread~호출. 호출 시 입력값을 받아서 그걸로 리페인트메소드써보기
								}
							}
						});
					}
				});
				buttons[i].setBounds(x+15, y, 300, 30);
				add(buttons[i]);
				line[i] = new JLabel("---------------------------------------------------------");
				line[i].setBounds(x-80, y+23, 1000, 25);
				line[i].setForeground(new Color(150,150,150));
				line[i].setFont(new Font("굴림", Font.PLAIN, 20));
				add(line[i]);
				y += 40; 
			}
		}
	}
}
