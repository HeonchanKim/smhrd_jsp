package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.VO.memberVO;

//CRUD
//Create Read Update Delete
public class memberDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	//DB ���� 
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			
			conn = DriverManager.getConnection(url,dbid,dbpw);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//����� ��ü ��ȯ
	public void close() {
		try {
			if(rs != null) {
				rs.close(); 				
			}
			if(psmt != null) {
				psmt.close();				
			}
			if(conn != null) {
				conn.close();				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<memberVO> selectAll() {
		ArrayList<memberVO> al = new ArrayList<memberVO>();
		
		try {
			connect();
			
			String sql = "select email, tel, address from message_member";
			
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()){
				String getEmail = rs.getString(1);
				String getTel = rs.getString(2);
				String getAddress = rs.getString(3);
				
				memberVO vo = new memberVO(getEmail,getTel,getAddress);
				al.add(vo);
			}//end of while
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return al;
	} // end of selectAll()
	
	public int delete(String email) {
		int cnt = 0;
		
		try {
			connect();
			
			//Ư�� �̸��� ������ �ִ� �� ����
			String sql = "delete from message_member where email = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			
			cnt = psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}// end of delte()
	
	//LoginCon -> login()
	public memberVO login(String email, String pw) {
		memberVO vo = null;
		
		 try {
	         connect();
	         
	         String sql = "select * from message_member where email = ?";
	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, email);
	         
	         rs = psmt.executeQuery();
	      
	         if(rs.next()){
	            
	            String getemail = rs.getString(1);
	            String getpw = rs.getString(2);
	            String tel = rs.getString(3);
	            String address = rs.getString(4);
	            String date = rs.getString(5);
	         
	            System.out.println(getemail + "\t" + getpw + "\t" + tel + "\t" + address + "\t" + date);
	            
	            if(pw.equals(getpw)) {
	               vo = new memberVO(email, tel, address);
	            }
	         }
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
			 close();
	      }
	      return vo;

	}// end of login()
	
	//JoinCon -> join()
	public int join(String email, String pw, String tel, String address) {
		int cnt = 0;
		
		try {
			connect();
			
			String sql = "insert into message_member values(?,?,?,?,sysdate)";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, pw);
			psmt.setString(3, tel);
			psmt.setString(4, address);
			
			//4. SQL����
			cnt = psmt.executeUpdate();
			
			//5. ���� �� ó��
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}// end of join()
	
	//UpdateCon -> update()
	public int update(String email, String pw, String tel, String address) {
		int cnt = 0;
		
		try {
			connect();
			
			String sql = "update message_member set pw = ?, tel = ?, address = ? where email = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);
			psmt.setString(2, tel);
			psmt.setString(3, address);
			psmt.setString(4, email);
			
			cnt = psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}// end of update()
} // end of class