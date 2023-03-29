package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DbCon;

public class AccountDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public boolean checkLogin(String username, String password) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			con = DbCon.getConnection();
			if (con != null)
			{
				String sql = "select * from account where username=? and password=?";
				stm = con.prepareStatement(sql);
				stm.setString(1, username);
				stm.setString(2, password);
				
				rs = stm.executeQuery();
				if (rs.next()) {
					return true;
				}
			}
			
		} finally {
			// TODO: handle exception
		}
		return false;
	}

}
