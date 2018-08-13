package org.shopmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.shopmall.dto.ShushuDTO;

public class ShuShuDAO
{
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "SHOP_ADMIN";
	private static final String PW = "1111";
	
	// db 접속
	public Connection getConnection()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(URL, USER, PW);
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// 회원등록
	public boolean insertShushuAdd(ShushuDTO shudto)
	{
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int result;
		
		if (conn != null && shudto != null)
		{
			String sql = "insert into shushu values (?, ?, ?, ?)";
			
			try
			{
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, shudto.getId());
				pstmt.setString(2, shudto.getName());
				pstmt.setDate(3, shudto.getDob());
				pstmt.setString(4, shudto.getEmail());
				
				result = pstmt.executeUpdate();
				
				if (result == 0)
				{
					return false;
				}
				else
				{
					return true;
				}
				
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (pstmt != null)
				{
					try
					{
						pstmt.close();
					} catch (SQLException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try
				{
					conn.close();
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}
	
	public ShushuDTO[] selectShushuList()
	{
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		if (conn != null)
		{
			String sql = "select id, name, dob, email from shushu";
			
			try
			{
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				ArrayList<ShushuDTO> list = new ArrayList<>();
				while (rs.next())
				{
					ShushuDTO shudto = new ShushuDTO();
					shudto.setId(rs.getString(1));
					shudto.setName(rs.getString(2));
					shudto.setDob(rs.getDate(3));
					shudto.setEmail(rs.getString(4));
					
					list.add(shudto);
				}
				return list.toArray(new ShushuDTO[0]);
				
				
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (rs != null)
				{
					try
					{
						rs.close();
					} catch (SQLException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (pstmt != null)
				{
					try
					{
						pstmt.close();
					} catch (SQLException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try
				{
					conn.close();
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
}
