package book.login;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;




public class MemberLogin extends JFrame implements ActionListener  {
	private JButton logInBtn, createBtn, findIdBtn, findPwdBtn;
	private JLabel logoL, idL, pwdL, imageL, mentL;
	private JTextField idT;

	
	private JPasswordField pwdT;
	private JRadioButton memberBtn, managerBtn;
	private MemberCreate memberCreate;
	public MemberLogin() {



		//로그인 창----------------------------------------------


		//버튼, 라벨
		setLayout(null);


		logInBtn = new JButton(new ImageIcon("image/loginbtn.jpg"));
		logInBtn.setBounds(180,490,360,50);

		Font font2 = new Font("중나좋체 LIGHT",Font.BOLD,20);
		createBtn = new JButton("회원가입");
		createBtn.setFont(font2);
		createBtn.setBounds(445,360,110,25);

		findIdBtn = new JButton(new ImageIcon("image/findid.jpg"));
		findIdBtn.setBounds(180,560,110,25);
		findPwdBtn = new JButton(new ImageIcon("image/findpwd.jpg"));
		findPwdBtn.setBounds(300,560,130,25);

		logoL=new JLabel(new ImageIcon("image/logo.png"));
		logoL.setBounds(20,50,670,250);
		imageL=new JLabel(new ImageIcon("image/books.jpg"));
		//books이미지출처: a href=httpskr.freepik.comphotosbookBook 사진은 freepik - kr.freepik.com가 제작함a
		imageL.setBounds(650,40,500,700);

		mentL = new JLabel("【온라인 서점 비트199】");
		Font font = new Font("중나좋체 MEDIUM",Font.BOLD,48);
		mentL.setFont(font);
		mentL.setBounds(140,290,500,45);



		memberBtn = new JRadioButton("회원", true);
		memberBtn.setFont(font2);
		memberBtn.setBounds(140, 360, 70, 25);
		//managerBtn.setBackground(new Color(200, 255, 200));
		managerBtn = new JRadioButton("관리자");
		managerBtn.setFont(font2);
		managerBtn.setBounds(210, 360, 90, 25);


		ButtonGroup buttonGroup  = new ButtonGroup();
		buttonGroup.add(memberBtn);
		buttonGroup.add(managerBtn);


		Font font3 = new Font("중나좋체 LIGHT",Font.BOLD,27);
		idL = new JLabel("아 이 디");
		idL.setFont(font3);
		idL.setBounds(180,405,150,25);

		idT = new JTextField();
		idT.setBounds(290,400,250,32);

		pwdL = new JLabel("비밀번호");
		pwdL.setFont(font3);
		pwdL.setBounds(180,455,150,25);
		pwdT = new JPasswordField();
		pwdT.setBounds(290,450,250,32);





		//컨테이너
		Container con = getContentPane();

		con.add(logoL);
		con.add(imageL);
		con.add(idL);
		con.add(idT);
		con.add(pwdL);
		con.add(pwdT);
		con.add(memberBtn);
		con.add(managerBtn);
		con.add(mentL);
		con.add(logInBtn);
		con.add(createBtn);
		con.add(findIdBtn);
		con.add(findPwdBtn);


		// 셋팅
		setTitle("http://www.bit199.com/Main/default.aspx");
		setBounds(200, 150, 1200, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		con.setBackground(new Color(255, 240, 240));
		setResizable(false);

		this.eventLogin();


	}//memberLogin()

	//이벤트
	public void eventLogin() {
		createBtn.addActionListener(this);
		//		editBtn.addActionListener(this);
		//		deleteBtn.addActionListener(this);
		//		removeBtn.addActionListener(this);
		//cancelBtn.addActionListener(this);

		logInBtn.addActionListener(this);

	}



	@Override
	public void actionPerformed(ActionEvent e) {





		if(e.getSource() == createBtn) {


			if(managerBtn.isSelected()) {
				// 관리자버튼으로는 회원가입을 할 수 없습니다.
				JOptionPane.showMessageDialog(this, "회원버튼을 누르세요.");
				return; }

			memberCreate = new MemberCreate();
		}

		else if(e.getSource() == logInBtn) {
			if(memberBtn.isSelected()) {
				//			 String id = idT.getText();
				//			 String pwd = pwdT.getText();

				memberLogin();





			}else {
				//				 String id = idT.getText();
				//				 String pwd = pwdT.getText(); 

				managerLogin();


			}
		}


	}


	private void memberLogin() {
		MemberDAO memberDAO = MemberDAO.getInstance();
		Boolean check = memberDAO.userLogin(idT.getText(), pwdT.getText());
		if(check == true) {
			// id == pwd . userService 객체 생성
			// new UserService();
			//  System.out.println("userLogin OK");


			Test_memberlogin test_memberlogin = new Test_memberlogin(); 	  

		}else {
			JOptionPane.showMessageDialog(this, "member - 아이디 혹은 비밀번호가 잘못 입력되었습니다");
		}
	}


	private void managerLogin() {
		MemberDAO memberDAO = MemberDAO.getInstance();
		Boolean check = memberDAO.managerLogin(idT.getText(), pwdT.getText());
		if(check == true) {
			// id == pwd . ManagerService 객체 생성
			// new ManagerService();
			//   System.out.println("managerLogin OK");

			Test_managerlogin test_managerlogin = new Test_managerlogin();



		}else {
			JOptionPane.showMessageDialog(this, "manager - 아이디 혹은 비밀번호가 잘못 입력되었습니다");
		}
	}






}


