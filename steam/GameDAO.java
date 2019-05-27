package steam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GameDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String url;
	String user;
	String passwd;

	// 멤버

	public GameDAO() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		url = "jdbc:mysql://localhost:3306/steam";
		user = "root";
		passwd = "1234";
		con = DriverManager.getConnection(url, user, passwd);

	}

	public void insert(GameDTO gdto) throws Exception { // 게임생성(개발자)

		String sql = "insert into game values(?,?,?,?,?)"; // 따옴표 없이

		ps = con.prepareStatement(sql);
		ps.setString(1, gdto.getGname());
		ps.setString(2, gdto.getGtheme());
		ps.setInt(3, gdto.getGprice());
		ps.setInt(4, gdto.getGspec());
		ps.setInt(5, gdto.getGrate());

		ps.executeUpdate();
	}

	public GameDTO selectgame(String gname) throws Exception {
		GameDTO gdto = new GameDTO();
		String sql = "select * from game where gname = ?";

		ps = con.prepareStatement(sql);
		ps.setString(1, gname);
		rs = ps.executeQuery();

		while (rs.next()) {
			gdto.setGname(rs.getString(1));
			gdto.setGtheme(rs.getString(2));
			gdto.setGprice(rs.getInt(3));
			gdto.setGspec(rs.getInt(4));
			gdto.setGrate(rs.getInt(5));

		}
		return gdto;

	}

	public ArrayList showshop(int menuselect, String search) throws Exception { // 스팀 상점
		GameDTO gdto = null;
		ArrayList list = new ArrayList();
		String sql = "";
		if (menuselect == 0) {
			sql = "select * from game"; // 전체출력 ( default)
			ps = con.prepareStatement(sql);
		} else if (menuselect == 1) {
			sql = "select * from game order by gprice asc"; // 낮은가격순
			ps = con.prepareStatement(sql);
		} else if (menuselect == 2) {
			sql = "select * from game order by gprice desc"; // 높은가격순
			ps = con.prepareStatement(sql);
		} else if (menuselect == 3) {
			sql = "select * from game order by grate desc"; // 평점 높은순
			ps = con.prepareStatement(sql);
		} else if (menuselect == 4) {
			sql = "select* from game where gtheme like '%"+search+"%'";// || gtheme like '%4%'"; // 게임 테마(contains)
			ps = con.prepareStatement(sql);
		} else if (menuselect == 5) {
			sql = "select* from game where gname like '%"+search+"%'"; // 직접검색
			ps = con.prepareStatement(sql);
		}
		rs = ps.executeQuery();

		while (rs.next()) {
			gdto = new GameDTO();
			gdto.setGname(rs.getString(1));
			gdto.setGtheme(rs.getString(2));
			gdto.setGprice(rs.getInt(3));
			gdto.setGspec(rs.getInt(4));
			gdto.setGrate(rs.getInt(5));
			list.add(gdto);
		}
		return list;
	}

	public void update(GameDTO gdto, String changegame) throws Exception { // 게임체인지(개발자)
		String sql = "update game set gname=?,gtheme=?,gprice=?,gspec=? where gname = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, gdto.getGname());
		ps.setString(2, gdto.getGtheme());
		ps.setInt(3, gdto.getGprice());
		ps.setInt(4, gdto.getGspec());
		ps.setString(5, changegame);

		ps.executeUpdate();

	}

	public void updaterate(GameDTO gdto, int rate) throws Exception { // 평점 갱신
		String sql = "update game set grate =? where gname =?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, rate);
		ps.setString(2, gdto.getGname());

		ps.executeUpdate();
	}

	public void delete(String del) throws Exception { // 게임삭제 (개발자)
		String sql = "delete from game where gname = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, del);

		ps.executeUpdate();

	}
}
