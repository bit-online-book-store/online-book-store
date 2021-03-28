package book.insert;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ManagerMain extends JFrame implements ActionListener{
	private JLabel bookNameL, writerL, bookTypeL, publisherL, bookPriceL, backL;
	private JTextField bookNameT, writerT, bookTypeT, publisherT, bookPriceT;
	private JButton insertBtn, cancelBtn;
	

	private Font font = new Font("중나좋체 MEDIUM", Font.BOLD, 20);

	
	public ManagerMain() {
		setLayout(null);
		//제목
		bookNameL = new JLabel("제 목 : ");
		bookNameL.setBounds(100,120,110,30);
		bookNameL.setFont(font);
		bookNameT = new JTextField("",15);
		bookNameT.setBounds(180, 120, 130, 30);
		bookNameT.setFont(font);
		//저자
		writerL = new JLabel("저 자 : ");
		writerL.setBounds(100, 200, 110, 30);
		writerL.setFont(font);
		writerT = new JTextField("",15);
		writerT.setBounds(180, 200, 130, 30);
		writerT.setFont(font);
		//장르
		bookTypeL = new JLabel("장 르 : ");
		bookTypeL.setBounds(100, 280, 110, 30);
		bookTypeL.setFont(font);
		bookTypeT = new JTextField("",15);
		bookTypeT.setBounds(180, 280, 130, 30);
		bookTypeT.setFont(font);
		//출판사
		publisherL = new JLabel("출판사 : ");
		publisherL.setBounds(100, 360, 130, 30);
		publisherL.setFont(font);
		publisherT = new JTextField("",15);
		publisherT.setBounds(180, 360, 130, 30);
		publisherT.setFont(font);
		//가격
		bookPriceL = new JLabel("가 격 : ");
		bookPriceL.setBounds(100, 440, 130, 30);
		bookPriceL.setFont(font);
		bookPriceT = new JTextField("",15);
		bookPriceT.setBounds(180, 440, 130, 30);
		bookPriceT.setFont(font);
		//back
		ImageIcon icon = new ImageIcon("image/book.jpg");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(900, 720, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		backL = new JLabel(new ImageIcon(changeImg));
		backL.setBounds(0, 0, 1500, 720);
						
		//btn 생성
		insertBtn = new JButton("등록");
		insertBtn.setBounds(120,550, 80, 40);
		insertBtn.setFont(font);
		cancelBtn = new JButton("취소");
		cancelBtn.setBounds(220,550, 80, 40);
		cancelBtn.setFont(font);
		
		
		Container c = this.getContentPane();
	    c.add(backL);
		c.add(bookNameL);
		c.add(bookNameT);
		c.add(writerL);
		c.add(writerT);
		c.add(bookTypeL);
		c.add(bookTypeT);
		c.add(publisherL);
		c.add(publisherT);
		c.add(bookPriceL);
		c.add(bookPriceT);
		c.add(insertBtn);
		c.add(cancelBtn);
		
		c.setBackground(Color.WHITE);
		setBounds(200, 150, 1200, 800);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//이벤트
		insertBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}//생성자
	//bookdata input
	private void inputBook() {
		Scanner scan = new Scanner(System.in);
		//data
		String bookName = bookNameT.getText();
		String writer = writerT.getText();
		String bookType = bookTypeT.getText();
		String publisher = publisherT.getText();
		int bookPrice = Integer.parseInt(bookPriceT.getText());
		
		BookDAO bookDAO = BookDAO.getInstance();
		
		int seq = bookDAO.getSeq();
		
		BookDTO bookDTO = new BookDTO();
		bookDTO.setSeq(seq);
		bookDTO.setBookName(bookName);
		bookDTO.setWriter(writer);
		bookDTO.setBookType(bookType);
		bookDTO.setPublisher(publisher);
		bookDTO.setBookPrice(bookPrice);
		
		bookDAO.inputBook(bookDTO);
		
		remove();
	}//insert
	//remove
	public void remove() {
		bookNameT.setText("");
		writerT.setText("");
		bookTypeT.setText("");
		publisherT.setText("");
		bookPriceT.setText("");
		
	}//remove
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==insertBtn) {
			inputBook();
		}else if(e.getSource()== cancelBtn) {
			return;
		}
		
	}
	public static void main(String[] args) {
		new ManagerMain();

	}

}
