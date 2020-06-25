package com.oracle.test;

import java.sql.*; //자바 sql라이브러리

public class GetEmp {

	public static void main(String[] args) {
		//(oracle) jdbc:oracle:thin:@localhost:1521:xe
		//(mySQL) jdbc:mysql://localhost:3306/db이름
		//미리 입력할 오라클 주소, 계정, 비밀번호를 변수로 저장
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
        String DB_USER = "scott";
        String DB_PASSWORD = "1234";
        //conn은 오라클 연결을 위한 객체
        Connection conn = null;
        //stmt는 sql문을 실행하기 위한 객체
        Statement stmt = null;
        //rs는 sql문 실행 후 결과값을 받아오는 객체
        ResultSet rs = null;

        String query = "SELECT * FROM emp";
        String query2 = "SELECT * FROM emp WHERE empno = 7369";
        
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
            //4. SQL 쿼리 실행하고 결과 받기
            rs = stmt.executeQuery(query2);

            while (rs.next()) { // 테이블의 한 행씩 실행
                String empno = rs.getString("EMPNO");  // 첫번째 열
                String ename = rs.getString("ENAME");
                String job = rs.getString(3);
                String mgr = rs.getString(4);
                String hiredate = rs.getString(5);
                String sal = rs.getString(6);
                String comm = rs.getString(7);
                String depno = rs.getString(8);

                System.out.println(empno + " : " + ename + " : " + job + " : " + mgr + " : " + hiredate + " : " + sal + " : " + comm + " : " + depno); 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close(); 		//ResultSet (쿼리 결과) 닫기
                stmt.close();		//State문 닫기
                conn.close();
            } catch (SQLException e) {}
        }
    }

}
