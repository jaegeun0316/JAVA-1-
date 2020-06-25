package com.oracle.namecardTest;

import java.sql.*; //�ڹ� sql���̺귯��

public class Insert {

	public static void main(String[] args) {
	
		//�̸� �Է��� ����Ŭ �ּ�, ����, ��й�ȣ�� ������ ����
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
        String DB_USER = "scott";
        String DB_PASSWORD = "1234";
        //conn�� ����Ŭ ������ ���� ��ü
        Connection conn = null;
        //stmt�� sql���� �����ϱ� ���� ��ü
        Statement stmt = null;
        //rs�� sql�� ���� �� ������� �޾ƿ��� ��ü
        //ResultSet rs = null;

        String query = "INSERT INTO NAMECARD VALUES (" + 
        		"    CARD_NO.nextval," + 
        		"    'LALA'," + 
        		"    '010-1234-5678'," + 
        		"    'LALA@NAVER.COM'," + 
        		"    'NAVER Com'" +
        		")";
        
        try {
        	//1. ����Ŭ ����̹� �ε�   ( ojdbc6_g.jar )    		
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e ) { //Ŭ������ ��ã������ (����̹� ������ )
            e.printStackTrace();
        }

        try { //DB ���� �κ��� try-catch ������ ���� �߻��� ó��
        	//2. DB ����
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            //3. SQL �� �غ�
            stmt = conn.createStatement();
            //4. SQL ���� ����
            stmt.executeUpdate(query);
            
            conn.commit(); //��������

            System.out.println("�Է¿Ϸ�!");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
               
                stmt.close();		//State�� �ݱ�
                conn.close();
            } catch (SQLException e) {}
        }
    }

}