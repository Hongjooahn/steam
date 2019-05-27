package steam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class NoticeDAO1 {

	private String url = "jdbc:mysql://localhost:3306/steam";
	private String user = "root";
	private String password = "1234";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	ArrayList selectAll() {
		ArrayList list = new ArrayList();
		NoticeDTO1 dto = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 ok");

			con = DriverManager.getConnection(url,user,password);
			System.out.println("2. DB 연결 ok");
			
			String sql = "select * from notice";
			ps = con.prepareStatement(sql);
			System.out.println("3. SQL문 결정 ok");
			
			rs = ps.executeQuery();
			System.out.println("4. SQL문 전송 ok");
			
			while(rs.next()) {
				dto = new NoticeDTO1();
				String title = rs.getString(1);
				String contents = rs.getString(2);
				String time = rs.getString(3);
				int num = rs.getInt(4);
				String gname = rs.getString(5);
				String uid = rs.getString(6);
				dto.setTitle(title);
				dto.setContents(contents);
				dto.setTime(time);
				dto.setNum(num);
				dto.setGname(gname);
				dto.setUid(uid);
				
				list.add(dto);
			} 
			if(dto==null) {
				JOptionPane.showMessageDialog(null, "찾으시는 정보가 없습니다.");
			}
		} catch (Exception e) {
			System.out.println("DB처리 중 에러 발생");
			System.out.println(e.getMessage());
		}finally {
			//에러 발생 여부와 상관없이 무조건 실행시켜야 하는 코드.
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("자원 해제 중 에러 발생");
			}
		}
		
		return list;
	}
	ArrayList<NoticeDTO1> select(String gname)  {
		ArrayList<NoticeDTO1> list = new ArrayList<NoticeDTO1>();
		NoticeDTO1 dto = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 ok");

			con = DriverManager.getConnection(url,user,password);
			System.out.println("2. DB 연결 ok");
			
			String sql = "select * from notice where gname = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, gname);
			System.out.println("3. SQL문 결정 ok");

			rs = ps.executeQuery();
			System.out.println("4. SQL문 전송 ok");
			
			while(rs.next()) {
				dto = new NoticeDTO1();
				String title = rs.getString(1);
				String contents = rs.getString(2);
				String time = rs.getString(3);
				int num = rs.getInt(4);
				String gname1 = rs.getString(5);
				String uid = rs.getString(6);
				dto.setTitle(title);
				dto.setContents(contents);
				dto.setTime(time);
				dto.setNum(num);
				dto.setGname(gname1);
				dto.setUid(uid);
				
				list.add(dto);
			}
			if(dto == null) {
				JOptionPane.showMessageDialog(null, "찾으시는 정보가 없습니다.");
			}
		} catch (Exception e) {
			System.out.println("DB처리 중 에러 발생");
			System.out.println(e.getMessage());
		}finally {
			//에러 발생 여부와 상관없이 무조건 실행시켜야 하는 코드.
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("자원 해제 중 에러 발생");
			}
		}
		return list;
		
		
	}
	NoticeDTO1 select(int num)  {
		NoticeDTO1 dto = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 ok");

			con = DriverManager.getConnection(url,user,password);
			System.out.println("2. DB 연결 ok");
			
			String sql = "select * from notice where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			System.out.println("3. SQL문 결정 ok");

			rs = ps.executeQuery();
			System.out.println("4. SQL문 전송 ok");
			
			while(rs.next()) {
				dto = new NoticeDTO1();
				String title = rs.getString(1);
				String contents = rs.getString(2);
				String time = rs.getString(3);
				String gname1 = rs.getString(5);
				String uid = rs.getString(6);
				dto.setTitle(title);
				dto.setContents(contents);
				dto.setTime(time);
				dto.setNum(num);
				dto.setGname(gname1);
				dto.setUid(uid);
			}
			if(dto == null) {
				JOptionPane.showMessageDialog(null, "찾으시는 정보가 없습니다.");
			}
		} catch (Exception e) {
			System.out.println("DB처리 중 에러 발생");
			System.out.println(e.getMessage());
		}finally {
			//에러 발생 여부와 상관없이 무조건 실행시켜야 하는 코드.
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("자원 해제 중 에러 발생");
			}
		}
		return dto;
		
		
	}
	void insert(NoticeDTO1 dto) {
		Calendar cal = Calendar.getInstance();
		String today;
		String str = (cal.get(Calendar.YEAR)+"").substring(2);
		today = str+"."+(cal.get(Calendar.MONTH)+1)+"."
				+cal.get(Calendar.DATE);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 ok");
			
			con = DriverManager.getConnection(url,user,password);
			System.out.println("2. DB 연결 ok");
			
			String sql = "insert into notice values(?,?,?,default,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getContents());
			ps.setString(3, today);
			ps.setString(4, dto.getGname());
			ps.setString(5, dto.getUid());
			
			System.out.println("3. SQL문 결정 ok");
			
			ps.executeUpdate();
			System.out.println("4. SQL문 전송 ok");
		} catch (Exception e) {
			System.out.println("DB처리 중 에러 발생");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();				
			}catch(SQLException e) {
				System.out.println("자원 해제 중 에러 발생");
			}
		}
		
	}
	void update(NoticeDTO1 dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 ok");
			
			con = DriverManager.getConnection(url,user,password);
			System.out.println("2. DB 연결 ok");
			
			String sql = "update notice set title=?,contents=? where num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getContents());
			ps.setInt(3, dto.getNum());
			System.out.println("3. SQL문 결정 ok");
			
			ps.executeUpdate();
			System.out.println("4. SQL문 전송 ok");
		} catch (Exception e) {
			System.out.println("DB처리 중 에러 발생");
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();				
			}catch(SQLException e) {
				System.out.println("자원 해제 중 에러 발생");
			}
		}
	}
	void delete(int num) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 ok");
			
			con = DriverManager.getConnection(url,user,password);
			System.out.println("2. DB 연결 ok");
			
			String sql = "delete from notice where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			
			System.out.println("3. SQL문 결정 ok");
			
			ps.executeUpdate();
			System.out.println("4. SQL문 전송 ok");
		} catch (Exception e) {
			System.out.println("DB처리 중 에러 발생");
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();				
			}catch(SQLException e) {
				System.out.println("자원 해제 중 에러 발생");
			}
		}
	}
}
