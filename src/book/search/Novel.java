//package book.search;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.util.List;
//import java.util.Vector;
//
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.JScrollPane;
//import javax.swing.JTabbedPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;
//
//public class Novel extends JPanel {//소설
//	private DefaultTableModel model;
//	private JTable table;
//	private List<BookDTO> list;
//	private JPanel novelP;
//
//	
//	public Novel(){
//		setLayout(new BorderLayout());
//				
//		novelP = new JPanel();
//		novelP.setLayout(null);
//		
//		//목록생성
//		Vector<String> nsV = new Vector<String>();
//		nsV.addElement("번호");
//		nsV.addElement("제목");
//		nsV.addElement("저자");
//		nsV.addElement("출판사");
//		nsV.addElement("가격");
//		
//		//모델생성
//		model = new DefaultTableModel(nsV,0);
//		
//		//DB레코드 JList에 넣기
//		BookDAO bookDAO = BookDAO.getInstance();
//		List<BookDTO> allList = bookDAO.genreList();
//			
//		
//		//테이블생성
//		table = new JTable (model);
//		JScrollPane scroll = new JScrollPane(table);
//		scroll.setBackground(Color.WHITE);//스크롤색- 안먹음
//		scroll.setBounds(10,10,880,525);//테이블사이즈
//		
//		//데이터
//		
//		//리스트생성
//		
//		novelP.add(scroll);
//		novelP.setBackground(Color.WHITE);//바탕색
//		add(novelP);
//		
//	}
//	
//
//}
