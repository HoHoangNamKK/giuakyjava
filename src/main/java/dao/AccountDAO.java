package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import connection.DbCon;
import model.Account;

public class AccountDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	public boolean checkLogin(String username, String password) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			con = DbCon.getConnection();
			if (con != null) {
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

	public List<Account> searchLastName(String searchValue) throws SQLException, NamingException, Exception {
		List<Account> listAccounts;
		listAccounts = new ArrayList<>();

		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			con = DbCon.getConnection();
			if (con != null) {
				String sql = "select * from account where lastname like ?";
				stm = con.prepareStatement(sql);
				stm.setString(1, "%" + searchValue + "%");
				rs = stm.executeQuery();
				while (rs.next()) {
					String username = rs.getString("username");
					String password = rs.getString("password");
					String lastname = rs.getString("lastname");
					boolean role = rs.getBoolean("isAdmin");
					Account dto = new Account(username, password, lastname, role);
					listAccounts.add(dto);

					// rut gon
					// listAccounts.add(new Account(username, password, lastname, role));

				}
				return listAccounts;
			}

		} finally {
			// TODO: handle exception
		}

		return null;
	}
	
	public boolean deleteRecord(String pk) throws SQLException, NamingException, Exception {
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = DbCon.getConnection();
			if (con != null) {
				String sql = "Delete from account where username=?";
				stm = con.prepareStatement(sql);
				stm.setString(1, pk);
				int row = stm.executeUpdate();
				if(row>0)
				{
					return true;
				}
			}

		} finally {
			// TODO: handle exception
		}
		return false;
	}
	
	public Account getAccountByUsername(String username) throws Exception{
		Account ac = new Account();
		
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			con = DbCon.getConnection();
			if (con != null) {
				String sql = "select * from account where username=?";
				stm = con.prepareStatement(sql);
				stm.setString(1, username);
				rs = stm.executeQuery();
				if (rs.next()) {
					ac.setUsername(rs.getString("username"));
					ac.setPassword(rs.getString("password"));
					ac.setLastname(rs.getString("lastname"));
					ac.setRole(rs.getBoolean("isAdmin"));
				}

				
			}

		} finally {
			// TODO: handle exception
		}
		
		return ac;
	}
	
	public boolean upodateRecord(String username, String password, String lastname, boolean role) throws SQLException, NamingException, Exception {
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = DbCon.getConnection();
			if (con != null) {
				String sql = "Update account set password=?, lastname=?, isAdmin=? where username=?";
				stm = con.prepareStatement(sql);
				stm.setString(1, password);
				stm.setString(2, lastname);
				stm.setBoolean(3, role);
				stm.setString(4, username);
				int row = stm.executeUpdate();
				if(row>0)
				{
					return true;
				}
			}

		} finally {
			// TODO: handle exception
		}
		
		
		return false;
	}
	
}
