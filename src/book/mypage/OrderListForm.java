package book.mypage;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class OrderListForm extends JFrame implements ActionListener {
	private JLabel titleLabel;
	private JButton backButton;
	private DefaultTableModel model;
	private JTable table;
	private List<BookOrderDTO> list;
	
	public OrderListForm() {
		setLayout(null);
		
		//JLabel 생성
		titleLabel = new JLabel("주문 목록");
		titleLabel.setFont(new Font("중나좋체 Light",Font.BOLD,35));
		//titleLabel.setForeground(Color.BLUE);
		titleLabel.setBounds(300, 40, 460, 80);
		
		
		//JButton 생성
		backButton = new JButton("이전으로");
		backButton.setBounds(750,90,90,30);
		
		
		//목록생성
		Vector<String> totalVector = new Vector<String>();
		totalVector.addElement("주문날짜");
		totalVector.addElement("제목");
		totalVector.addElement("저자");
		totalVector.addElement("장르");
		totalVector.addElement("출판사");
		totalVector.addElement("금액");
		totalVector.addElement("수량");
		
		
		//모델생성
		model = new DefaultTableModel(totalVector, 0);

		
		//DB의 모든 레코드를 꺼내서 JList에 뿌리기
		BookOrderDAO bookOrderDAO = BookOrderDAO.getInstance();
		List<BookOrderDTO> allList = bookOrderDAO.getBookOrderList();
		
		for(BookOrderDTO bookOrderDTO : allList) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(bookOrderDTO.getOrderDate());
			vector.add(bookOrderDTO.getBookName());
			vector.add(bookOrderDTO.getWriter());
			vector.add(bookOrderDTO.getBookType());
			vector.add(bookOrderDTO.getBookName());
			vector.add(bookOrderDTO.getBookPrice());
			vector.add(bookOrderDTO.getBookNumber());
			
			model.addRow(vector);
		}
		
		//테이블생성
		table = new JTable (model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBackground(Color.WHITE);//스크롤색- 안먹음
		scroll.setBounds(100,150,780,480);//테이블사이즈
		
		
		
		//Container 생성
		Container con = this.getContentPane();
		con.add(titleLabel);
		con.add(backButton);
		con.add(scroll);
		
		
		con.setBackground(Color.WHITE);
		setBounds(200, 150, 1200, 800);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//event 처리
		backButton.addActionListener(this);
		
		
		
	} //OrderListForm()
	
//-----------------------------------------------------------------	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(90, 160, 900, 160);
		g.drawLine(90, 705, 900, 705);
		
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("logo.png");
	    g.drawImage(img,
					90, 70, 265, 140,       //화면 위치 - 고정되면 안됨
					0, 0, 1650, 768,        //이미지 위치
	                this);
		
	} //paint(Graphics g)

//-----------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton) {
			BookOrderDAO dao = new BookOrderDAO();
			//dao.inputFriend();
			new BookList();
			setVisible(false);
		}
		
	} //actionPerformed(ActionEvent e)
	
//	public static void main(String[] args) {
//		new OrderListForm();
//	}
	

}
