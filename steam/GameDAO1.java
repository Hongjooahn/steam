package steam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GameDAO1 {
	private String url = "jdbc:mysql://localhost:3306/steam";
	private String user = "root";
	private String password = "1234";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	ArrayList<GameDTO1> selectAll() {
		ArrayList list = new ArrayList();
		GameDTO1 dto = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 ok");

			con = DriverManager.getConnection(url,user,password);
			System.out.println("2. DB 연결 ok");
			
			String sql = "select * from game";
			ps = con.prepareStatement(sql);
			System.out.println("3. SQL문 결정 ok");
			
			rs = ps.executeQuery();
			System.out.println("4. SQL문 전송 ok");
			
			while(rs.next()) {
				dto = new GameDTO1();
				String gname = rs.getString(1);
				String gtheme = rs.getString(2);
				int gprice = rs.getInt(3);
				int gspec = rs.getInt(4);
				int grate = rs.getInt(5);
				dto.setGname(gname);
				dto.setGtheme(gtheme);
				dto.setGprice(gprice);
				dto.setGspec(gspec);
				dto.setGrate(grate);
				
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
	GameDTO1 select(String inputName)  {
		GameDTO1 dto = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 ok");

			con = DriverManager.getConnection(url,user,password);
			System.out.println("2. DB 연결 ok");
			
			String sql = "select * from game where gname = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, inputName);
			System.out.println("3. SQL문 결정 ok");

			rs = ps.executeQuery();
			System.out.println("4. SQL문 전송 ok");

			if(rs.next()) {
				dto = new GameDTO1();
				String gname = rs.getString(1);
				String gtheme = rs.getString(2);
				int gprice = rs.getInt(3);
				int gspec = rs.getInt(4);
				int grate = rs.getInt(5);
				dto.setGname(gname);
				dto.setGtheme(gtheme);
				dto.setGprice(gprice);
				dto.setGspec(gspec);
				dto.setGrate(grate);
			}else {
				System.out.println("검색결과가 없습니다.");
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
	void insert(GameDTO1 dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 ok");
			
			con = DriverManager.getConnection(url,user,password);
			System.out.println("2. DB 연결 ok");
			
			String sql = "insert into game values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getGname());
			ps.setString(2, dto.getGtheme());
			ps.setInt(3, dto.getGprice());
			ps.setInt(4, dto.getGspec());
			ps.setInt(5, dto.getGrate());
			
			System.out.println("3. SQL문 결정 ok");
			
			ps.executeUpdate();
			System.out.println("4. SQL문 전송 ok");
		} catch (Exception e) {
			System.out.println("DB처리 중 에러 발생");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();				
			}catch(SQLException e) {
				System.out.println("자원 해제 중 에러 발생");
			}
		}
		
	}
//	void update(GameDto dto) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			System.out.println("1. 드라이버 설정 ok");
//			
//			con = DriverManager.getConnection(url,user,password);
//			System.out.println("2. DB 연결 ok");
//			
//			String sql = "update game set =?,contents=? where num=?";
//			ps = con.prepareStatement(sql);
//			ps.setString(1, dto.get());
//			ps.setString(2, dto.getContents());
//			System.out.println("3. SQL문 결정 ok");
//			
//			ps.executeUpdate();
//			System.out.println("4. SQL문 전송 ok");
//		} catch (Exception e) {
//			System.out.println("DB처리 중 에러 발생");
//			e.printStackTrace();
//		}finally {
//			try {
//				rs.close();
//				ps.close();
//				con.close();				
//			}catch(SQLException e) {
//				System.out.println("자원 해제 중 에러 발생");
//			}
//		}
//	}
//	void delete(int num) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			System.out.println("1. 드라이버 설정 ok");
//			
//			con = DriverManager.getConnection(url,user,password);
//			System.out.println("2. DB 연결 ok");
//			
//			String sql = "delete from notice where num = ?";
//			ps = con.prepareStatement(sql);
//			ps.setInt(1, num);
//			
//			System.out.println("3. SQL문 결정 ok");
//			
//			ps.executeUpdate();
//			System.out.println("4. SQL문 전송 ok");
//		} catch (Exception e) {
//			System.out.println("DB처리 중 에러 발생");
//			e.printStackTrace();
//		}finally {
//			try {
//				rs.close();
//				ps.close();
//				con.close();				
//			}catch(SQLException e) {
//				System.out.println("자원 해제 중 에러 발생");
//			}
//		}
//	}
}
