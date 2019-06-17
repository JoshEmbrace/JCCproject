package com.jhtacybercampus.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jhtacybercampus.web.dao.FreeboardFileDao;
import com.jhtacybercampus.web.entity.FreeboardFile;

public class OracleFreeboardFileDao implements FreeboardFileDao{

	@Override
	public List<FreeboardFile> getListByNoticeId(int noticeId) throws ClassNotFoundException, SQLException {
		List<FreeboardFile> list = new ArrayList<>();

		String sql = "SELECT * FROM FREEBOARD_FILE WHERE FREEBOARD_ID  = ?  ";

		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, noticeId); 

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			FreeboardFile freeboardFile = new FreeboardFile(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getInt("notice_id")
					);

			list.add(freeboardFile);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}


	@Override
	public int insert(FreeboardFile freeboardFile) throws ClassNotFoundException, SQLException {
		int result = 0;

		String sql = "insert into FREEBOARD_FILE(id,name,FREEBOARD_ID)"+"values(freeboard_file_seq.nextval,?,?)";

		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");

		PreparedStatement st = con.prepareStatement(sql);//sql실행해주는 애, 미리셋팅
		st.setString(1, freeboardFile.getName());
		st.setInt(2, freeboardFile.getFreeboardId());
		result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

	@Override
	public int update(FreeboardFile freeboardFile) throws ClassNotFoundException, SQLException {
		int result = 0;

		String sql = "update FREEBOARD_FILE set name=?, freeboardId=? where id =?";

		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, freeboardFile.getName());
		st.setInt(2, freeboardFile.getFreeboardId());
		st.setInt(3, freeboardFile.getId());

		result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int result = 0;

		String sql = "delete FREEBOARD_FILE where id=?";

		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");

		PreparedStatement st = con.prepareStatement(sql);//sql실행해주는 애, 미리셋팅
		st.setInt(1, id);
		result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

}
