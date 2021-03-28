package book.mypage;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//import book.search.Novel;

public class BookList extends JFrame implements ActionListener{//도서목록
   private JLabel logoPic;
   private JComboBox<String> subjectComboBox; //말머리
   private JTextField searchT; //검색창
   private JButton searchBtn; //검색버튼
   private JButton mypageBtn, cartBtn, orderBtn;
   private JTabbedPane menu;//탭페인
   private JPanel totalP,nsP,poemP,humanP,novelP, essayP,artP;//메뉴탭
//   private MenuPane menup;
   
   
   
   public BookList() {//생성자
      setLayout(null);
//-------------------------------------------------------------------------
      //메뉴생성
      mypageBtn = new JButton("회원정보 수정");
      mypageBtn.setBounds(800,40,100,30);
      cartBtn = new JButton("장바구니");
      cartBtn.setBounds(910,40,100,30);
      orderBtn = new JButton("주문목록");
      orderBtn.setBounds(1020,40,100,30);
      
      
      
      
      //로고사진
      logoPic = new JLabel(new ImageIcon("logo.PNG"));
      logoPic.setBounds(17,12,300,175);
      
   
      //검색창
      String [] subject = {"제목","저자명","출판사"};
      subjectComboBox = new JComboBox<String>(subject);
      subjectComboBox.setFont(new Font("중나좋체 Light",Font.PLAIN,20));
      subjectComboBox.setBounds(375,100,85,30);
      searchT = new JTextField();
      searchT.setBounds(465,100,255,30);
      searchBtn = new JButton("검색");
      searchBtn.setBounds(725,100,85,30);
      searchBtn.setFont(new Font("중나좋체 Light",Font.PLAIN,20));
            
      
      //탭패널 생성 - 좌측 메뉴탭을 눌렀을때 생성되는 페이지창
      totalP = new JPanel();//전체
      totalP.setBackground(Color.WHITE);   
      
      nsP = new JPanel();//자연과학
      nsP.setBackground(Color.WHITE);
      
      poemP = new JPanel();//시
      poemP.setBackground(Color.WHITE);
      
      humanP = new JPanel();//인문학
      humanP.setBackground(Color.WHITE);
      
      novelP = new JPanel();//소설
      novelP.setBackground(Color.WHITE);
      
      essayP = new JPanel();//에세이
      essayP.setBackground(Color.WHITE);
      
      artP = new JPanel();//예술
      artP.setBackground(Color.WHITE);
      
      
      
      //메뉴탭 생성
      menu = new JTabbedPane(SwingConstants.LEFT);
      menu.setBounds(80,180,1000,550);
      menu.setFont(new Font("중나좋체 Light",Font.PLAIN,20));
//      menu.addTab("전체목록", new Total());
//      menu.addTab("자연과학", new NaturalScience());
//      menu.addTab("시", new Poem());
//      menu.addTab("인문학", new Humanities());
      //menu.addTab("소설", new Novel());
//      menu.addTab("에세이", new Eassay());
//      menu.addTab("예술", new Art());
            
      
      //컨테이너
      Container c = this.getContentPane();
      c.add(mypageBtn);
      c.add(cartBtn);
      c.add(orderBtn);
      c.add(subjectComboBox);
      c.add(searchT);
      c.add(searchBtn);
      c.add(logoPic);
      c.setBackground(Color.WHITE);
      c.add("LEFT",menu);
      
      setVisible(true);
      setTitle("도서목록");
      setBounds(50,50,1200,800);
      //setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      event();
      
   }//BookList() 

   //이벤트
   private void event() {
	   mypageBtn.addActionListener(this);
	   orderBtn.addActionListener(this);
      
   }

   @Override
   public void actionPerformed(ActionEvent e) {
	   if (e.getSource() == mypageBtn) {
		   new MemberUpdateForm();
		   setVisible(false);
		} else if (e.getSource() == orderBtn) {
			new OrderListForm();
			setVisible(false);
		}
      
   }
   
   
   public static void main(String[] args) {
      new BookList();
   }


}