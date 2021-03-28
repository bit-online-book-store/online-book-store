package book.search;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import project.BookDAO;
//import project.BookDTO;

public class Total extends JPanel{// 누르면 데이터베이스 내 전체 목록 가져오기
	private DefaultTableModel model;
	private JTable table;
	//private List<BookDTO> list;
	private JPanel totalP;

	public Total() {
		
		setLayout(new BorderLayout());
		
		totalP = new JPanel();
		totalP.setLayout(null);
		
		//목록생성
		Vector<String> totalV = new Vector<String>();
		totalV.addElement("번호");
		totalV.addElement("제목");
		totalV.addElement("저자");
		totalV.addElement("장르");
		totalV.addElement("출판사");
		totalV.addElement("가격");
		
		
		//모델생성
		model = new DefaultTableModel(totalV,0);
		
		//DB의 모든 레코드를 꺼내서 JList에 뿌리기
//		BookDAO bookDAO = BookDAO.getInstance(); //싱글톤부름
//		List<BookDTO> allList = bookDAO.selectTotal();
//		
//		for(BookDTO bookDTO : allList) {
//			Vector<Object> v = new Vector<Object>();
//			v.add(bookDTO.getSeq());
//			v.add(bookDTO.getBookName());
//			v.add(bookDTO.getWriter());
//			v.add(bookDTO.getBookType());
//			v.add(bookDTO.getPublisher());
//			v.add(bookDTO.getBookPrice());
//			
//			model.addRow(v);
//		}
		
		
		
		
		
		
		//테이블생성
		table = new JTable (model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBackground(Color.WHITE);//스크롤색- 안먹음
		scroll.setBounds(10,10,880,525);//테이블사이즈
		
		//데이터
		
		//리스트생성
		
		totalP.add(scroll);
		totalP.setBackground(Color.WHITE);//바탕색
		add(totalP);
		
	}
}
