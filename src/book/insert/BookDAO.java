package book.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
	private static BookDAO instance;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	//접속
	public BookDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//싱글톤 instance생성
	public static BookDAO getInstance() {
		if(instance == null) {
			instance = new BookDAO();
		}
		return instance;
	}
	//seq값 얻어오기
	public int getSeq() {
		int seq = 0;
		getConnection();
		String sql = "select seq.nextval from dual";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			rs.getInt(1);
			seq = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return seq;
	}
	//bookdata input
	public void inputBook(BookDTO bookDTO) {
		
		getConnection();
		String sql = "insert into bookTable values(?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookDTO.getSeq());
			pstmt.setString(2, bookDTO.getBookName());
			pstmt.setString(3, bookDTO.getWriter());
			pstmt.setString(4, bookDTO.getBookType());
			pstmt.setString(5, bookDTO.getPublisher());
			pstmt.setInt(6, bookDTO.getBookPrice());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally		
	}//inputBook
	
	

}
