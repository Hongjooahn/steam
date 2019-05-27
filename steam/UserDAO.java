package steam;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class UserDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String url;
	String user;
	String passwd;

	// 멤버

	
	
	public UserDAO() throws Exception {
		Class.forName("com.mysql.jdbc.Driver"); // 도메인 네임 거꾸로 , 파일을 읽어오는 것 이기 때문에 .. 에러처리가 필수

		url = "jdbc:mysql://localhost:3306/steam";
		user = "root";
		passwd = "1234";
		con = DriverManager.getConnection(url, user, passwd);

	}

	public void insert(UserDTO dto) throws Exception { // C- 생성

		String sql = "insert into user values(?,?,?,?,?,default,?)"; // 따옴표 없이

		ps = con.prepareStatement(sql);
		ps.setString(1, dto.getUname());
		ps.setString(2, dto.getUid());
		ps.setString(3, dto.getPw());
		ps.setInt(4, dto.getUspec());
		ps.setString(5, dto.getUemail());
		ps.setString(6, dto.getUtheme());

		ps.executeUpdate();
	}

	public ArrayList selectlib(UserDTO dto) throws Exception { // 라이브러리
		ArrayList list = new ArrayList();
		String sql = "select ugamelist from user where id = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, dto.getUid());
		rs = ps.executeQuery();

		return list;

	}

	public UserDTO select(String inputId) {
		UserDTO udto = null;
		try {

			String sql = "select * from user where uid = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, inputId);
			rs = ps.executeQuery();

			if (rs.next()) {
				udto = new UserDTO();
				// 이름, id, 사양, email, 보유금액, 관심장르
				udto.setUname(rs.getString(1));
				udto.setUid(rs.getString(2));
				udto.setUspec(rs.getInt(4));
				udto.setUemail(rs.getString(5));
				udto.setUcash(rs.getInt(6));
				udto.setUtheme(rs.getString(7));
				udto.setUgamelist(rs.getString(8));
//				dto.setId(rs.getString(1));
//				dto.setTitle(rs.getString(2));
//				dto.setContent(rs.getString(3));
//				dto.setEtc(rs.getString(4));

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return udto;
	}

	
	public void update(UserDTO udto, String change) throws Exception { // 회원정보수정
		String sql = "update user set uname=?,uspec=?,uemail=?,utheme=? where uid=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, udto.getUname());
		ps.setInt(2, udto.getUspec());
		ps.setString(3, udto.getUemail());
		ps.setString(4, udto.getUtheme());
		ps.setString(5, change);

		ps.executeUpdate();

	}

	public void updategame(String ugamelist, String uid) throws Exception { // 유저 게임구매, 게임제거, 환불
		String sql = "update user set ugamelist=? where uid =?";
		ps = con.prepareStatement(sql);
		ps.setString(1, ugamelist);
		ps.setString(2, uid);

		ps.executeUpdate();

	}

	public void updatecash(String userid, int cash , int addcash) throws Exception { // 유저 환불 , 게임구매시
		String sql = "update user set ucash = ? where uid=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, cash+addcash);  // 여기서 계산하는것이 현명할것인가 ?
		ps.setString(2, userid);

		ps.executeUpdate();
		
		
	}

	public void delete(String del) throws Exception { // 유저 삭제
		String sql = "delete from user where uid = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, del);

		ps.executeUpdate();

	}
}
