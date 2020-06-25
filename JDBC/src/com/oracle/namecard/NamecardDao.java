package com.oracle.namecard;

import java.sql.*;
import java.util.ArrayList;

public class NamecardDao {
    static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";  
    static final String USER = "scott";
    static final String PASSWORD = "1234";
    
    // 1.����Ŭ DB ����̹� �ε� ������
    public NamecardDao() {
        try { 
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    // 2.DB ���� �޼ҵ�
    private Connection getConnection() throws SQLException {
    	
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    		//���� ResultSet �� �ΰ��� �ƴϸ� ����, ���� Statement ����, ���������� Ŀ�ؼ� ����
    private void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // �Է� �޼ҵ�
    public void insert(Namecard card) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "INSERT INTO namecard VALUES (CARD_NO.NEXTVAL, ?, ?, ?, ?)";

        try {
        	// DB ����
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, card.getName());
            pstmt.setString(2, card.getMobile());
            pstmt.setString(3, card.getEmail());
            pstmt.setString(4, card.getCompany());
            pstmt.executeUpdate();
            con.commit(); //������ ����
            System.out.println("�Է¿Ϸ�!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(sql);
        } finally {
            close(null, pstmt, con);
        }
    }
    
    //��ȣ no �� ����    
    public void delete(int no) {
    	Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "DELETE FROM namecard WHERE no = ?";

        try {
        	// DB ����
            con = getConnection();
            pstmt = con.prepareStatement(sql); //sql�غ�
            pstmt.setInt(1, no);
            pstmt.executeUpdate(); //sql����
            con.commit(); //������ ����
            System.out.println("�����Ϸ�!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(sql);
        } finally {
            close(null, pstmt, con);
        }
    }
    
    //��ȣ no �� �˻�
    public Namecard selectOne(int no) {
    	Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Namecard card = null; //Namecard Ŭ���� ��ü
        
        String sql = "SELECT * FROM namecard WHERE NO = ?";

        try {
        	// DB ����
            con = getConnection();
            pstmt = con.prepareStatement(sql); //sql�غ�
            pstmt.setInt(1, no);
            //pstmt.executeUpdate(); //��� ���� ���� ���
            rs = pstmt.executeQuery(); //sql���� (����� ���� ��)
            
            if(rs.next()) {
            	card = new Namecard();
            	card.setNo(rs.getInt("NO"));
            	card.setName(rs.getString("NAME"));
            	card.setMobile(rs.getString("MOBILE"));
            	card.setEmail(rs.getString("EMAIL"));
            	card.setCompany(rs.getString("COMPANY"));
            	return card;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(sql);
        } finally {
            close(rs, pstmt, con);
        }
        return null; // ���� �����߻��� ���ϵ�
    }
    
    //�̸����� ã��
    public ArrayList<Namecard> selectByKeyword(String keyword) {       
        ArrayList<Namecard> matched = new ArrayList<Namecard>();
        
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Namecard card = null; //Namecard Ŭ���� ��ü
        
        String sql = "SELECT * FROM namecard WHERE NAME = ?";

        try {
        	// DB ����
            con = getConnection();
            pstmt = con.prepareStatement(sql); //sql�غ�
            pstmt.setString(1, keyword);
            //pstmt.executeUpdate(); //��� ���� ���� ���
            rs = pstmt.executeQuery(); //sql���� (����� ���� ��)
            
            while(rs.next()) {
            	card = new Namecard();
            	card.setNo(rs.getInt("NO"));
            	card.setName(rs.getString("NAME"));
            	card.setMobile(rs.getString("MOBILE"));
            	card.setEmail(rs.getString("EMAIL"));
            	card.setCompany(rs.getString("COMPANY"));

            	matched.add(card);
            }
            return matched;
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(sql);
        } finally {
            close(rs, pstmt, con);
        }
        return null; // ���� �����߻��� ���ϵ�  
    }
    
    //Namecard�� ��� ��/���� �������� ��ȣ������ 
    public ArrayList<Namecard> selectAll() {
        ArrayList<Namecard> all = new ArrayList<Namecard>();
       
        	Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            Namecard card = null; //Namecard Ŭ���� ��ü
            
            String sql = "SELECT * FROM namecard ORDER BY 1";

            try {
            	// DB ����
                con = getConnection();
                pstmt = con.prepareStatement(sql); //sql�غ�
                //pstmt.executeUpdate(); //��� ���� ���� ���
                rs = pstmt.executeQuery(); //sql���� (����� ���� ��)
                
                while(rs.next()) {
                	card = new Namecard();
                	card.setNo(rs.getInt("NO"));
                	card.setName(rs.getString("NAME"));
                	card.setMobile(rs.getString("MOBILE"));
                	card.setEmail(rs.getString("EMAIL"));
                	card.setCompany(rs.getString("COMPANY"));
                	//return card;
                	all.add(card);
                }
                return all;
                
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(sql);
            } finally {
                close(rs, pstmt, con);
            }
            return null; // ���� �����߻��� ���ϵ�
    }        
    
    //�����ϱ�
    public void update(Namecard card) {
    	 Connection con = null;
         PreparedStatement pstmt = null;
         
         String sql = "UPDATE namecard SET NAME = ?, MOBILE = ?, EMAIL = ?, COMPANY = ? WHERE NO = ?";

         try {
         	// DB ����
             con = getConnection();
             pstmt = con.prepareStatement(sql);
             pstmt.setString(1, card.getName());
             pstmt.setString(2, card.getMobile());
             pstmt.setString(3, card.getEmail());
             pstmt.setString(4, card.getCompany());
             pstmt.setInt(5, card.getNo());
             pstmt.executeUpdate();
             con.commit(); //������ ����
             System.out.println("�����Ϸ�!");
         } catch (SQLException e) {
             e.printStackTrace();
             System.out.println(sql);
         } finally {
             close(null, pstmt, con);
         }
    }

}
