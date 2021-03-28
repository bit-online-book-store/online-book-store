package book.login;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;



public class MemberCreate extends JFrame implements ActionListener{
	private JLabel idL, pwdL, nameL, ageL, phoneL , addressL, mentL,emailL,pwdCheckL;
	private JTextField idT, pwdT, nameT, ageT, phoneT,addressT,emailT, pwdCheckT;
	private JButton idCheckBtn, inputBtn,cancelBtn, emailCheckBtn;

	//private JTextArea addressT;
	//JScrollPane scroll = new JScrollPane(addressT); //스크롤

	private JList<MemberDTO> list;
	//private DefaultListModel<MemberDTO> model;

	public MemberCreate() {

		//회원가입 창 ----------------------------------------------
		setLayout(null);

		Font font = new Font("중나좋체 MEDIUM",Font.BOLD,42);
		mentL=new JLabel("회원정보를 입력해주세요.");
		mentL.setFont(font);
		mentL.setBounds(30,10,500,100);

		idCheckBtn = new JButton("아이디중복검사");
		idCheckBtn.setBounds(285,120,121,25);

		inputBtn = new JButton(new ImageIcon("image/insertbtn.jpg"));
		inputBtn.setBounds(90,430,152,40);

		cancelBtn = new JButton(new ImageIcon("image/cancelbtn.jpg"));
		cancelBtn.setBounds(245,430,152,40);




		Font font2 = new Font("중나좋체 LIGHT",Font.BOLD,19);
		idL = new JLabel("아 이 디");
		idL.setFont(font2);
		idL.setBounds(80,120,70,25);
		idT = new JTextField();
		idT.setBounds(170,120,116,25);    


		pwdL = new JLabel("비밀번호");
		pwdL.setFont(font2);
		pwdL.setBounds(80,160,70,25);
		pwdT = new JTextField();
		pwdT.setBounds(170,160,237,25);
		Font font3 = new Font("중나좋체 LIGHT",Font.BOLD,13);
		pwdCheckL = new JLabel("비밀번호재확인");
		pwdCheckL.setFont(font3);
		pwdCheckL.setBounds(80,180,80,25);
		pwdCheckT = new JTextField();
		pwdCheckT.setBounds(170,180,237,25);

		nameL = new JLabel("이     름");
		nameL.setFont(font2);
		nameL.setBounds(80,200,70,25);
		nameT = new JTextField();
		nameT.setBounds(170,200,237,25);

		ageL = new JLabel("생년월일");
		ageL.setFont(font2);
		ageL.setBounds(80,240,70,25);
		ageT = new JTextField();
		ageT.setBounds(170,240,237,25);

		phoneL = new JLabel("휴 대 폰");
		phoneL.setFont(font2);
		phoneL.setBounds(80,280,70,25);
		phoneT = new JTextField();
		phoneT.setBounds(170,280,237,25);

		addressL = new JLabel("주     소");
		addressL.setFont(font2);
		addressL.setBounds(80,320,70,25);
		addressT = new JTextField(); //new JTextArea();
		addressT.setBounds(170,320,237,50);

		emailL = new JLabel("이 메 일");
		emailL.setFont(font2);
		emailL.setBounds(80,385,70,25);
		emailT = new JTextField(); //new JTextArea();
		emailT.setBounds(170,385,150,25);

		emailCheckBtn = new JButton("이메일인증");
		emailCheckBtn.setBounds(320,385,100,25);	


		//scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		Container con = getContentPane();

		con.add(idCheckBtn);
		con.add(mentL);
		con.add(idL);
		con.add(idT);
		con.add(pwdL);
		con.add(pwdT);
		con.add(nameL);
		con.add(nameT);
		con.add(ageL);
		con.add(ageT);
		con.add(phoneL);
		con.add(phoneT);
		con.add(addressL);
		con.add(addressT);
		con.add(inputBtn);
		con.add(cancelBtn);
		con.add(emailL);
		con.add(emailT);

		con.add(pwdCheckL);
		con.add(pwdCheckT);

		con.add(emailCheckBtn);

		setTitle("https://www.bit199.com/Member/FTMemAcc.aspx");
		setBounds(200, 150, 500, 750);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		con.setBackground(new Color(255, 240, 240));
		setResizable(false);

		//		inputBtn.setEnabled(false);
		//		idCheckBtn.setEnabled(true);
		//		
		//		if(idCheckBtn.isEnabled()==true) { 
		//		
		//		inputBtn.setEnabled(true);
		//		
		//		}


		//DB의 모든 레코드를 꺼내서 JList에 뿌리기
		//FriendDAO friendDAO = MemberDAO.getInstance();
		//List<MemberDTO>allList = MemberDAO.getFriendList();

		//for(MemberDTO memberDTO  :allList)	{
		//	model.addElement(memberDTO);
		//}	


		this.eventCreate();


	}//MemberCreate()









	public void eventCreate() {
		inputBtn.addActionListener(this);
		//		editBtn.addActionListener(this);
		//		deleteBtn.addActionListener(this);
		//		removeBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		idCheckBtn.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inputBtn) {

			if(pwdT.getText().equals(pwdCheckT.getText())){// 비밀번호 일치 여부 확인

			}else {
				JOptionPane.showMessageDialog(this, "비밀번호 불일치");
				return;
			}



			// idCheck();
			MemberDAO memberDAO = MemberDAO.getInstance();

			boolean check = memberDAO.idCheck(idT.getText());

			if(check == false) {
				// 아이디 중복 X


				inputBtn.setEnabled(true);

			}else {
				// 아이디 중복
				JOptionPane.showMessageDialog(this, "중복된 아이디가 있습니다. 다시 입력하세요");

				inputBtn.setEnabled(false);
				return;
			}	 








			//		    //  String idT = idT.getText();
			//		      if(idT.length()==0) {// 회원아이디최소글자열
			//			        
			//		  
			//		     JOptionPane.showMessageDialog(this, "4자이상 입력");	 
			//			 return;





			inputMember();





		}else if(e.getSource() == cancelBtn) {

			//System.exit(0);//이거누르면 창이 다꺼진다
			setVisible(false);
			//		}else if(e.getSource() == deleteBtn) {
			//			
		}




		if(e.getSource() == idCheckBtn) {
			//idCheck();


			MemberDAO memberDAO = MemberDAO.getInstance();

			boolean check = memberDAO.idCheck(idT.getText());

			if(check == false) {
				// 아이디 중복 X
				JOptionPane.showMessageDialog(this, "아이디를 사용하셔도 됩니다.");

				inputBtn.setEnabled(true);

			}else {
				// 아이디 중복
				JOptionPane.showMessageDialog(this, "중복된 아이디가 있습니다. 다시 입력하세요");

				inputBtn.setEnabled(false);
				return;
			}

		}
	}	


	//private void idCheck() {


	//	}






	// private boolean inputMember()
	private void inputMember() {
		//데이터
		String id = idT.getText();
		String pwd = pwdT.getText();

		String pwdCheck = pwdCheckT.getText(); 

		String name = nameT.getText();
		String age = ageT.getText();
		String phone = phoneT.getText();
		String address = addressT.getText();
		String email = emailT.getText();









		MemberDTO memberDTO = new MemberDTO();

		memberDTO.setPosition(0);
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		memberDTO.setName(name);
		memberDTO.setAge(age);
		memberDTO.setPhone(phone);
		memberDTO.setAddress(address);
		memberDTO.setEmail(email);

		// private boolean inputMember()	이었을시 	
		// if(true) return 
		MemberDAO memberDAO = MemberDAO.getInstance();






		if(id.length()>=4) {// 회원아이디최소글자열
		}else {
			JOptionPane.showMessageDialog(this, "아이디 4자리 이상 입력");	 
			return;

		}
		if(pwd.length()>=8) {// 회원비밀번호최소글자열
		}else {   
			JOptionPane.showMessageDialog(this, "비밀번호 8자리 이상 입력");	 
			return;
		}
		if(name.length()>=2) {// 회원이름최소글자열
		}else {
			JOptionPane.showMessageDialog(this, "이름을 정확히 입력하시오");	 
			return;
		}
		if(age.length()==6) {// 회원생년월일최소글자열
		}else {   
			JOptionPane.showMessageDialog(this, "생년월일을 정확히 입력하시오[예]851205");	 
			return;
		}
		if(phone.length()>=11) {// 회원핸드폰번호최소글자열
		}else {   
			JOptionPane.showMessageDialog(this, "휴대폰번호를 정확히 입력하시오[예]01012345678");	 
			return;	
		}
		if(address.length()>=10) {// 회원주소최소글자열
		}else {   
			JOptionPane.showMessageDialog(this, "주소를 정확히 입력하시오");	 
			return;
		}if(email.length()>=10) {// 회원이메일최소글자열
		}else {   
			JOptionPane.showMessageDialog(this, "이메일을 정확히 입력해야 가입가능");	 
			return;
		}



		//dao에게 Beans 전달
		Boolean check = memberDAO.add(memberDTO);





		if(check = true) {
			// 저장 성공 //TODO : 저장성공 멘트 뜨게하기
			//remove();
			JOptionPane.showMessageDialog(this, "가입완료.");
			setVisible(false);

		}else {
			// 저장 실패
		}
	}

	//	public void remove() {
	//		// 회원가입 성공 시 텍스트 리셋하기
	//		idT.setText("");
	//		pwdT.setText("");
	//		pwdCheckT.setText("");
	//		nameT.setText("");
	//		ageT.setText("");
	//		phoneT.setText("");
	//		addressT.setText("");
	//		emailT.setText("");


}//inputMember()

