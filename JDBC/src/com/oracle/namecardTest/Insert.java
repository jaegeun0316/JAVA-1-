package com.oracle.namecardTest;

import java.sql.*; //자바 sql라이브러리

public class Insert {

	public static void main(String[] args) {
	
		//미리 입력할 오라클 주소, 계정, 비밀번호를 변수로 저장
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
        String DB_USER = "scott";
        String DB_PASSWORD = "1234";
        //conn은 오라클 연결을 위한 객체
        Connection conn = null;
        //stmt는 sql문을 실행하기 위한 객체
        Statement stmt = null;
        //rs는 sql문 실행 후 결과값을 받아오는 객체
        //ResultSet rs = null;

        String query = "INSERT INTO NAMECARD VALUES (" + 
        		"    CARD_NO.nextval," + 
        		"    'LALA'," + 
        		"    '010-1234-5678'," + 
        		"    'LALA@NAVER.COM'," + 
        		"    'NAVER Com'" +
        		")";
        
        try {
        	//1. 오라클 드라이버 로딩   ( ojdbc6_g.jar )    		
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e ) { //클래스를 못찾았을때 (드라이버 없을때 )
            e.printStackTrace();
        }

        try { //DB 연결 부분은 try-catch 문으로 예외 발생시 처리
        	//2. DB 연결
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            //3. SQL 문 준비
            stmt = conn.createStatement();
            //4. SQL 쿼리 실행
            stmt.executeUpdate(query);
            
            conn.commit(); //영구저장

            System.out.println("입력완료!");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
               
                stmt.close();		//State문 닫기
                conn.close();
            } catch (SQLException e) {}
        }
    }

}
