package t1_database.t3_Hoewon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HoewonDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/springgroup";
	private String user = "atom";
	private String password = "1234";
	
	private HoewonVO vo = null;
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
	
	// stmt객체 닫기
	public void stmtClose() {
		if(stmt != null)
		try {
			 stmt.close();
		} catch (SQLException e) {}
	}
	// rs객체 닫기
	public void rsClose() {
		if(rs != null)
			try {
				rs.close();
				stmtClose();
			} catch (SQLException e) {}
	}

	// 개별 회원 조회
	public HoewonVO getNameSearch(int idx) {
		vo = new HoewonVO();
		try {
			stmt = conn.createStatement();   //검색 Statement
			//String sql = "select * from hoewon where name = '홍길동'";
			String sql = "select * from hoewon where idx ="+idx;
			rs = stmt.executeQuery(sql);     //레코드 담아가기ResultSet
			
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
		}	finally {
			rsClose();
		}
		return vo;
	}

	//회원 가입처리(insert)
	public int setHoewonInput(HoewonVO vo) {
		int res = 0;
		try {
			stmt = conn.createStatement();   //검색 Statement
			sql = "insert into hoewon values (default,'"+vo.getName()+"',"+vo.getAge()+",'"+vo.getGender()+"','"+vo.getAddress()+"')";
			res = stmt.executeUpdate(sql);     //레코드 담아가기ResultSet
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		}	finally {
			stmtClose();
		}
		return res;
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
		}	finally {
			stmtClose();
		}
		return res;
	}
	//회원 전체 리스트
	public ArrayList<HoewonVO> getHoewonList() {
		ArrayList<HoewonVO> vos = new ArrayList<HoewonVO>();
		try {
			stmt = conn.createStatement(); 
			sql = "select * from hoewon order by name";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				vo = new HoewonVO();       //vo 객체생성
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		}	finally {
			rsClose();
		}
		return vos;
	}
	// 회원정보 수정처리
	public int setHoewonUpdate(int idx, int choice, String content) {
		int res = 0;
		try {
			stmt = conn.createStatement();
			if(choice == 1) {
				sql = "update hoewon set name = '"+content+"' where idx = " + idx;
			}
			else if(choice == 2) {
				sql = "update hoewon set age = '"+Integer.parseInt(content)+"' where idx = " + idx;
			}
			else if(choice == 3) {
				sql = "update hoewon set gender = '"+content+"' where idx = " + idx;
			}
			else if(choice == 4) {
				sql = "update hoewon set address = '"+content+"' where idx = " + idx;
			}
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		}	finally {
			stmtClose();
		}
		return res;
	}

	


}
