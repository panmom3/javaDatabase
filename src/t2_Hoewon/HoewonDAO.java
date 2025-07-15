package t2_Hoewon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HoewonDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/springgroup";
	private String user = "atom";
	private String password = "1234";
	
	private String sql = "";
	
	public HoewonDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패~~~");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동 실패~~");
		}
	}
	
	// connection객체 닫기
	public void connClose() {
		try {
			if(conn != null) conn.close();
		} catch (Exception e) {}
	}

	// 개별 회원 조회
	public HoewonVO getNameSearch(String name) {
		HoewonVO vo = new HoewonVO();
		
		try {
			stmt = conn.createStatement();   //검색 Statement
			//String sql = "select * from hoewon where name = '홍길동'";
			String sql = "select * from hoewon where name ='"+name+"'";
			ResultSet rs = stmt.executeQuery(sql);     //레코드 담아가기ResultSet
			
			if(rs.next()) {    //자료가 있으면
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
			}
			else vo = null;
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		}	
		return vo;
	}

	//회원 가입처리(insert)
	public void setHoewonInput(String name) {
		try {
			stmt = conn.createStatement();   //검색 Statement
			String sql = "insert into hoewon (name) values ('"+name+"')";
			stmt.executeUpdate(sql);     //레코드 담아가기ResultSet
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		}	
	}
	//회원 자료 삭제처리
	public int setHoewonDelete(String name) {
		int res = 0;
		
		try {
			stmt = conn.createStatement();   //검색 Statement
			String sql = "delete from hoewon where name = '"+name+"'";
			res = stmt.executeUpdate(sql);     //레코드 담아가기ResultSet
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		}	
		
		return res;
	}
}
