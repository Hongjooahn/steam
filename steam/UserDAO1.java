package steam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class UserDAO1 {
	private String url = "jdbc:mysql://localhost:3306/steam";
	private String user = "root";
	private String password = "1234";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	ArrayList selectAll() {
		ArrayList list = new ArrayList();
		UserDTO1 dto = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 ok");

			con = DriverManager.getConnection(url,user,password);
			System.out.println("2. DB 연결 ok");
			
			String sql = "select * from user";
			ps = con.prepareStatement(sql);
			System.out.println("3. SQL문 결정 ok");
			
			rs = ps.executeQuery();
			System.out.println("4. SQL문 전송 ok");
			
			while(rs.next()) {
				dto = new UserDTO1();
				String uname = rs.getString(1);
				String uid = rs.getString(2);
				String pw = rs.getString(3);
				int uspec = rs.getInt(4);
				String uemail = rs.getString(5);
				int ucash = rs.getInt(6);
				String utheme = rs.getString(7);
				String ugamelist = rs.getString(8);
				String ufriend = rs.getString(9);
				dto.setUname(uname);
				dto.setUid(uid);
				dto.setPw(pw);
				dto.setUspec(uspec);
				dto.setUemail(uemail);
				dto.setUcash(ucash);
				dto.setUtheme(utheme);
				dto.setUgamelist(ugamelist);
				dto.setUfriend(ufriend);
				
				list.add(dto);
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
	UserDTO1 select(String inputId)  {
		UserDTO1 dto = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 ok");

			con = DriverManager.getConnection(url,user,password);
			System.out.println("2. DB 연결 ok");
			
			String sql = "select * from user where uid = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, inputId);
			System.out.println("3. SQL문 결정 ok");

			rs = ps.executeQuery();
			System.out.println("4. SQL문 전송 ok");

			if(rs.next()) {
				dto = new UserDTO1();
				String uname = rs.getString(1);
				String uid = rs.getString(2);
				String pw = rs.getString(3);
				int uspec = rs.getInt(4);
				String uemail = rs.getString(5);
				int ucash = rs.getInt(6);
				String utheme = rs.getString(7);
				String ugamelist = rs.getString(8);
				String ufriend = rs.getString(9);
				dto.setUname(uname);
				dto.setUid(uid);
				dto.setPw(pw);
				dto.setUspec(uspec);
				dto.setUemail(uemail);
				dto.setUcash(ucash);
				dto.setUtheme(utheme);
				dto.setUgamelist(ugamelist);
				dto.setUfriend(ufriend);
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
	UserDTO1 select1(String inputId)  {
		UserDTO1 dto = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 ok");

			con = DriverManager.getConnection(url,user,password);
			System.out.println("2. DB 연결 ok");
			
			String sql = "select * from user where uname = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, inputId);
			System.out.println("3. SQL문 결정 ok");

			rs = ps.executeQuery();
			System.out.println("4. SQL문 전송 ok");

			if(rs.next()) {
				dto = new UserDTO1();
				String uname = rs.getString(1);
				String uid = rs.getString(2);
				String pw = rs.getString(3);
				int uspec = rs.getInt(4);
				String uemail = rs.getString(5);
				int ucash = rs.getInt(6);
				String utheme = rs.getString(7);
				String ugamelist = rs.getString(8);
				String ufriend = rs.getString(9);
				dto.setUname(uname);
				dto.setUid(uid);
				dto.setPw(pw);
				dto.setUspec(uspec);
				dto.setUemail(uemail);
				dto.setUcash(ucash);
				dto.setUtheme(utheme);
				dto.setUgamelist(ugamelist);
				dto.setUfriend(ufriend);
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
	void insert(UserDTO1 dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 ok");
			
			con = DriverManager.getConnection(url,user,password);
			System.out.println("2. DB 연결 ok");
			
			String sql = "insert into user values(?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getUname());
			ps.setString(2, dto.getUid());
			ps.setString(3, dto.getPw());
			ps.setInt(4, dto.getUspec());
			ps.setString(5, dto.getUemail());
			ps.setInt(6, dto.getUcash());
			ps.setString(7, dto.getUtheme());
			ps.setString(8, dto.getUgamelist());
			ps.setString(9, dto.getUfriend());
			
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
	void update(UserDTO1 dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 ok");
			
			con = DriverManager.getConnection(url,user,password);
			System.out.println("2. DB 연결 ok");
			
			String sql = "update user set pw=?,uspec=?,uemail=?,utheme=?,ufriend=? where uid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPw());
			ps.setInt(2, dto.getUspec());
			ps.setString(3, dto.getUemail());
			ps.setString(4, dto.getUtheme());
			ps.setString(5, dto.getUfriend());
			ps.setString(6, dto.getUid());
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
	void delete(String uid) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 ok");
			
			con = DriverManager.getConnection(url,user,password);
			System.out.println("2. DB 연결 ok");
			
			String sql = "delete from user where uid = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, uid);
			
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
