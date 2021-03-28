package book.mypage;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MemberWithdrawalForm extends JFrame implements ActionListener {
	private JLabel titleLabel, questionLabel, inquiryLabel, callLabel, significantLabel, securityLabel, nameLabel, idLabel, pwdLabel;
	private JCheckBox agreeCheckBox;
	private JTextField idTextField, nameTextField, pwdTextField;
	private JButton backButton, checkButton;
	
	public MemberWithdrawalForm() {
		setLayout(null);
		
		//JLabel 생성
		titleLabel = new JLabel("회원 탈퇴");
		titleLabel.setFont(new Font("중나좋체 Light",Font.BOLD,35));
		//titleLabel.setForeground(Color.BLUE);
		titleLabel.setBounds(300, 40, 460, 80);
		
		questionLabel = new JLabel("회원님 bit199 서비스를 이용하시는데 불편함이 있으셨나요?");
		questionLabel.setFont(new Font("중나좋체 Light",Font.BOLD,14));
		//questionLabel.setForeground(Color.BLUE);
		questionLabel.setBounds(120, 110, 460, 125);
		
		inquiryLabel = new JLabel("이용 불편 및 각종 문의 사항은 고객센터로 문의 주시면 성심 성의껏 답변 드리겠습니다.");
		inquiryLabel.setFont(new Font("중나좋체 Light",Font.PLAIN,14));
		//inquiryLabel.setForeground(Color.BLUE);
		inquiryLabel.setBounds(120, 130, 760, 145);
		
		callLabel = new JLabel("- 자주 묻는 질문 / 1:1 온라인 문의 / 전화 문의: 010-3678-6435 (365일 오전 9시~오후6시)");
		callLabel.setFont(new Font("중나좋체 Light",Font.PLAIN,14));
		//callLabel.setForeground(Color.BLUE);
		callLabel.setBounds(120, 145, 600, 160);
		
		significantLabel = new JLabel("회원탈퇴 전, 유의사항을 확인해 주시기 바랍니다");
		significantLabel.setFont(new Font("중나좋체 Light",Font.BOLD,14));
		significantLabel.setForeground(Color.DARK_GRAY);
		significantLabel.setBounds(135, 190, 600, 215);
		
		securityLabel = new JLabel("보안을 위해 회원님의 이름과 계정 이메일 및 비밀번호를 확인 합니다");
		securityLabel.setFont(new Font("중나좋체 Light",Font.BOLD,14));
		securityLabel.setForeground(Color.DARK_GRAY);
		securityLabel.setBounds(120, 480, 600, 200);
		
		nameLabel = new JLabel("이름 :");
		nameLabel.setFont(new Font("중나좋체 Light",Font.PLAIN,14));
		nameLabel.setForeground(Color.DARK_GRAY);
		nameLabel.setBounds(120, 520, 600, 200);
		
		idLabel = new JLabel("아이디 :");
		idLabel.setFont(new Font("중나좋체 Light",Font.PLAIN,14));
		idLabel.setForeground(Color.DARK_GRAY);
		idLabel.setBounds(300, 520, 600, 200);
		
		pwdLabel = new JLabel("비밀번호 :");
		pwdLabel.setFont(new Font("중나좋체 Light",Font.PLAIN,14));
		pwdLabel.setForeground(Color.DARK_GRAY);
		pwdLabel.setBounds(490, 520, 600, 200);
		
		
		//JCheckBox 생성
		agreeCheckBox = new JCheckBox("상기 bit199 회원탈퇴 시 처리사항 안내를 확인하였음에 동의합니다.");
		agreeCheckBox.setForeground(Color.BLUE);
		agreeCheckBox.setBounds(130, 515, 600, 25);
		agreeCheckBox.setBackground(new Color(231, 200, 226));
		
		
		//JTextField 생성
		idTextField = new JTextField();
		idTextField.setBounds(158, 607, 120, 30);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(350, 607, 120, 30);
		
		pwdTextField = new JTextField();
		pwdTextField.setBounds(550, 607, 120, 30);
		
		
		//JButton 생성
		backButton = new JButton("이전으로");
		backButton.setBounds(750,90,90,30);
		
		checkButton = new JButton("본인확인");
		checkButton.setBounds(685, 607, 100, 30);
		
		
		
		
		
		//Container 생성
		Container con = this.getContentPane();
		con.add(titleLabel);
		con.add(backButton);
		con.add(questionLabel);
		con.add(inquiryLabel);
		con.add(callLabel);
		con.add(significantLabel);
		con.add(securityLabel);
		con.add(agreeCheckBox);
		con.add(nameLabel);
		con.add(idLabel);
		con.add(pwdLabel);
		con.add(idTextField);
		con.add(nameTextField);
		con.add(pwdTextField);
		con.add(checkButton);
		
		
		
		con.setBackground(Color.WHITE);
		setBounds(200, 150, 1200, 800);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		// event 처리
		backButton.addActionListener(this);
		
	} //MemberWithdrawalForm()

//-----------------------------------------------------------------
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(90, 160, 900, 160);
		g.drawLine(90, 705, 900, 705);
		g.drawLine(110, 300, 880, 300);
		g.drawLine(110, 580, 880, 580);
		g.drawLine(110, 300, 110, 580);
		g.drawLine(880, 300, 880, 580);
		g.drawLine(110, 530, 880, 530);
		
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("logo.png");
	    g.drawImage(img,
					90, 70, 265, 140,       //화면 위치 - 고정되면 안됨
					0, 0, 1650, 768,        //이미지 위치
	                this);
	    //Toolkit t2 = Toolkit.getDefaultToolkit();
	    Image img2 = t.getImage("significant.png");
	    g.drawImage(img2,
					120, 342, 870, 692,       //화면 위치 - 고정되면 안됨
					0, 0, 1680, 768,        //이미지 위치
	                this);
	    
		
	} //paint(Graphics g)
	
	
//-----------------------------------------------------------------	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton) {
			new MemberUpdateForm();
			setVisible(false);
		}
		
	} //actionPerformed(ActionEvent e)
	
	
//	public static void main(String[] args) {
//		new MemberWithdrawalForm();
//	}// main



}