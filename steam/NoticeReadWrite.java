package steam;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NoticeReadWrite extends JFrame{
	JLabel titleLabel;
	JLabel contentsLabel;
	JLabel idLabel;
	JLabel setIdLabel;
	JButton canButton;
	JButton completeButton;
	JButton updateButton;
	JButton deleteButton;
	JTextField titleText;
	JTextArea contentsArea;
	NoticeDAO1 dao = new NoticeDAO1();
	String beforeTitle;
	String beforeContents;
	
	
	NoticeReadWrite(){}
	
	NoticeReadWrite(NoticeDTO1 dto){
		getContentPane().setBackground(Color.DARK_GRAY);
		setSize(400, 600);
		getContentPane().setLayout(null);
		
		
		form();

		setIdLabel.setText(dto.getUid());
		completeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = titleText.getText();
				String contents = contentsArea.getText();
				dto.setTitle(title);
				dto.setContents(contents);
				dao.insert(dto);
				JOptionPane.showMessageDialog(null, "작성이 완료되었습니다.");
				ComonNoticeSelectPanel p1 = new ComonNoticeSelectPanel(dto.getGname());
				SteamMain.sp.setViewportView(p1);
				dispose();
			}
		});
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	NoticeReadWrite(String title,int num,String gname){
		getContentPane().setBackground(Color.DARK_GRAY);
		setSize(400, 600);
		getContentPane().setLayout(null);
		
		form();
		// 글 읽기 상태일 때의 설정
		titleText.setEditable(false);
		contentsArea.setEditable(false);
		
		//업데이트 버튼 추가
		updateButton.setVisible(true);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "제목과 내용을 수정 한 후 확인 버튼을 눌러주세요");
				titleText.setEditable(true);
				contentsArea.setEditable(true);
				completeButton.setEnabled(true);
				updateButton.setEnabled(false);
				
			}
		});
		//삭제
		deleteButton = new JButton("삭제"); 
		deleteButton.setBackground(null);
		deleteButton.setFocusPainted(false);
		deleteButton.setBorderPainted(false);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(new Font("굴림",Font.BOLD,17));
		deleteButton.setBounds(15, 516, 71, 23);
		
		//완료버튼 이름 변경 후 기능 수정
		completeButton.setEnabled(false);
		completeButton.setText("확인");
		completeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(titleText.getText().equals("")|contentsArea.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "제목이나 내용이 빈칸입니다.");
				}else {
						NoticeDTO1 dto = new NoticeDTO1();
						String title = titleText.getText();
						String contents = contentsArea.getText();
						
						dto.setTitle(title);
						dto.setContents(contents);
						dto.setNum(num);
						
						dao.update(dto);
						JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.");
						ComonNoticeSelectPanel p1 = new ComonNoticeSelectPanel(gname);
						SteamMain.sp.setViewportView(p1);
						dispose();
				}
			}
		});
		
		add(deleteButton);
		
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	void form() {
		titleLabel = new JLabel("제목");
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("굴림", Font.BOLD, 17));
		titleLabel.setBounds(23, 33, 57, 26);
		getContentPane().add(titleLabel);
		
		titleText = new JTextField();
		titleText.setBounds(95, 34, 243, 23);
		getContentPane().add(titleText);
		titleText.setColumns(10);
		
		contentsLabel = new JLabel("내용");
		contentsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentsLabel.setForeground(Color.WHITE);
		contentsLabel.setFont(new Font("굴림", Font.BOLD, 17));
		contentsLabel.setBounds(160, 75, 57, 26);
		getContentPane().add(contentsLabel);
		
		contentsArea = new JTextArea();
		contentsArea.setBounds(44, 110, 294, 350);
		getContentPane().add(contentsArea);
		
		idLabel = new JLabel("작성자 :");
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idLabel.setForeground(Color.WHITE);
		idLabel.setBackground(Color.WHITE);
		idLabel.setFont(new Font("굴림", Font.BOLD, 17));
		idLabel.setBounds(103, 483, 86, 23);
		getContentPane().add(idLabel);
		
		setIdLabel = new JLabel("작성자");
		setIdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		setIdLabel.setForeground(Color.WHITE);
		setIdLabel.setFont(new Font("굴림", Font.BOLD, 17));
		setIdLabel.setBackground(Color.WHITE);
		setIdLabel.setBounds(201, 483, 137, 23);
		getContentPane().add(setIdLabel);
		
		canButton = new JButton("취소");
		canButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		canButton.setBackground(null);
		canButton.setBorderPainted(false);
		canButton.setFocusPainted(false);
		canButton.setForeground(Color.WHITE);
		canButton.setFont(new Font("굴림", Font.BOLD, 17));
		canButton.setBounds(277, 516, 71, 23);
		getContentPane().add(canButton);
		
		completeButton = new JButton("완료");
		completeButton.setBackground(null);
		completeButton.setBorderPainted(false);
		completeButton.setFocusPainted(false);
		completeButton.setForeground(Color.WHITE);
		completeButton.setFont(new Font("굴림", Font.BOLD, 17));
		completeButton.setBounds(189, 516, 71, 23);
		getContentPane().add(completeButton);
		
		
		updateButton = new JButton("수정");
		updateButton.setBackground(null);
		updateButton.setBorderPainted(false);
		updateButton.setFocusPainted(false);
		updateButton.setForeground(Color.WHITE);
		updateButton.setFont(new Font("굴림", Font.BOLD, 17));
		updateButton.setBounds(105, 516, 71, 23);
		getContentPane().add(updateButton);
		updateButton.setVisible(false);
		
		
	}
}
