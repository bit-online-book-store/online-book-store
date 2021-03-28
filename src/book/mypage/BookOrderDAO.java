package book.mypage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookOrderDAO {
	private static BookOrderDAO instance;
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	
	public BookOrderDAO() {
		try {
			//driver loading
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} //BookOrderDAO()
	
	
	public static BookOrderDAO getInstance() {
		if(instance == null) {
			instance = new BookOrderDAO();
		}
		return instance;
	} //getInstance()
	
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} //getConnection()
	

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
		
	} //getSeq
	
	
	public void inputFriend() {
		//int su = 0;
		getConnection();
		String sql = "insert into orderlist values(?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "1");
			pstmt.setString(2, "987987");
			pstmt.setString(3, "987987");
			pstmt.setString(4, "987987");
			pstmt.setString(5, "987987");
			pstmt.setInt(6, 1);
			pstmt.setInt(7, 2);
			
			pstmt.executeUpdate();//실행
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//eturn su;
	}

	
	public List<BookOrderDTO> getBookOrderList() {
		List<BookOrderDTO> list = new ArrayList<BookOrderDTO>();
		
		//접속
		getConnection();
		String sql = "select * from orderlist order by bookname";
		
		try {
			//생성
			pstmt = conn.prepareStatement(sql);
			//실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookOrderDTO bookOrderDTO = new BookOrderDTO();
				
				bookOrderDTO.setOrderDate(rs.getString("orderdate"));
				bookOrderDTO.setBookName(rs.getString("bookname"));
				bookOrderDTO.setWriter(rs.getString("writer"));
				bookOrderDTO.setBookType(rs.getString("bookType"));
				bookOrderDTO.setPublisher(rs.getString("bookName"));
				bookOrderDTO.setBookPrice(rs.getInt("bookPrice"));
				bookOrderDTO.setBookNumber(rs.getInt("bookNumber"));
				
				list.add(bookOrderDTO);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //finally		
		
		return list;
		
	} //getBookOrderList()

}
