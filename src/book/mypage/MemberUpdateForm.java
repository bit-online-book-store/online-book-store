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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberUpdateForm extends JFrame implements ActionListener {
	
	private JPanel idPanel, namePanel, pwdPanel, phonePanel, addressPanel;
	private JLabel titleLabel, idLabel, nameLabel, pwdLabel, nowPwdLabel, newPwdLabel, againPwdLabel,  phoneLabel, addressLabel, withdrawalLabel;
	private JTextField idTextField, nameTextField, nowPwdTextField, newPwdTextField, againPwdTextField, phoneTextField, addressTextField;
	private JButton backButton, idButton, nameButton, pwdButton, phoneButton, addressButton, withdrawalButton;
			
	public MemberUpdateForm() {
		setLayout(null);
		
		//JPaenl 생성
		idPanel = new JPanel();
		idPanel.setBackground(new Color(247, 247, 247));
		idPanel.setBounds(100, 155, 150, 40);
		
		namePanel = new JPanel();
		namePanel.setBackground(new Color(247, 247, 247));
		namePanel.setBounds(100, 220, 150, 40);
		
		pwdPanel = new JPanel();
		pwdPanel.setBackground(new Color(247, 247, 247));
		pwdPanel.setBounds(100, 375, 150, 40);
		
		phonePanel = new JPanel();
		phonePanel.setBackground(new Color(247, 247, 247));
		phonePanel.setBounds(100, 520, 150, 40);
		
		addressPanel = new JPanel();
		addressPanel.setBackground(new Color(247, 247, 247));
		addressPanel.setBounds(100, 610, 150, 40);
		
		
		//JLabel 생성
		titleLabel = new JLabel("회원정보 수정");
		titleLabel.setFont(new Font("중나좋체 Light",Font.BOLD,35));
		titleLabel.setBounds(300, 40, 460, 80);
		
		idLabel = new JLabel("이메일");
		idLabel.setFont(new Font("중나좋체 Light",Font.BOLD,25));
		idPanel.add(idLabel);
		
		nameLabel = new JLabel("이름");
		nameLabel.setFont(new Font("중나좋체 Light",Font.BOLD,25));
		namePanel.add(nameLabel);
		
		pwdLabel = new JLabel("비밀번호");
		pwdLabel.setFont(new Font("중나좋체 Light",Font.BOLD,25));
		pwdPanel.add(pwdLabel);
		
		nowPwdLabel = new JLabel("현재 비밀번호");
		nowPwdLabel.setFont(new Font("중나좋체 Light",Font.PLAIN,13));
		nowPwdLabel.setBounds(346, 290, 100, 40);
		
		newPwdLabel = new JLabel("새 비밀번호");
		newPwdLabel.setFont(new Font("중나좋체 Light",Font.PLAIN,13));
		newPwdLabel.setBounds(346, 345, 100, 50);
		
		againPwdLabel = new JLabel("비밀번호 다시 입력");
		againPwdLabel.setFont(new Font("중나좋체 Light",Font.PLAIN,13));
		againPwdLabel.setBounds(346, 405, 100, 50);
		
		phoneLabel = new JLabel("휴대폰 번호");
		phoneLabel.setFont(new Font("중나좋체 Light",Font.BOLD,25));
		phonePanel.add(phoneLabel);
		
		addressLabel = new JLabel("주소");
		addressLabel.setFont(new Font("중나좋체 Light",Font.BOLD,25));
		addressPanel.add(addressLabel);
		
		withdrawalLabel = new JLabel("탈퇴를 원하시면 우측의 회원탈퇴 버튼을 눌러주세요");
		withdrawalLabel.setFont(new Font("중나좋체 Light",Font.PLAIN,13));
		withdrawalLabel.setBounds(480, 395, 500, 595);
		
		
		
		//JTextField 생성
		idTextField = new JTextField();
		idTextField.setBounds(340,159,255,30);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(340,221,255,30);
		
		nowPwdTextField = new JTextField();
		nowPwdTextField.setBounds(340,324,255,30);
		
		newPwdTextField = new JTextField();
		newPwdTextField.setBounds(340,383,255,30);
		
		againPwdTextField = new JTextField();
		againPwdTextField.setBounds(340,445,255,30);
		
		phoneTextField = new JTextField();
		phoneTextField.setBounds(340,527,255,30);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(340,612,255,30);
		
		
		//JButton 생성
		backButton = new JButton("이전으로");
		backButton.setBounds(750,90,90,30);
		
		idButton = new JButton("이메일 변경");
		idButton.setBounds(640,159,100,30);
		
		nameButton = new JButton("이름 변경");
		nameButton.setBounds(640,221,100,30);
		
		pwdButton = new JButton("비밀번호 변경");
		pwdButton.setBounds(640,445,100,30);
		
		phoneButton = new JButton("휴대폰 번호 변경");
		phoneButton.setBounds(640,527,120,30);
		
		addressButton = new JButton("주소 변경");
		addressButton.setBounds(640,612,100,30);
		
		withdrawalButton = new JButton("회원탈퇴");
		withdrawalButton.setBounds(750,678,90,30);
		
		
		Container con = this.getContentPane();
		con.add(titleLabel);
		con.add(backButton);
		//id
		con.add(idPanel);
		con.add(idTextField);
		con.add(idButton);
		//name
		con.add(namePanel);
		con.add(nameTextField);
		con.add(nameButton);
		//pwd
		con.add(pwdPanel);
		con.add(nowPwdLabel);
		con.add(nowPwdTextField);
		con.add(newPwdLabel);
		con.add(newPwdTextField);
		con.add(againPwdLabel);
		con.add(againPwdTextField);
		con.add(pwdButton);
		//phone
		con.add(phonePanel);
		con.add(phoneTextField);
		con.add(phoneButton);
		//address
		con.add(addressPanel);
		con.add(addressTextField);
		con.add(addressButton);
		//withdrawalLabel
		con.add(withdrawalLabel);
		con.add(withdrawalButton);
		

		con.setBackground(Color.WHITE);
		setBounds(200, 150, 1200, 800);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//event	처리
		backButton.addActionListener(this);
		withdrawalButton.addActionListener(this);
		
		
	} //MypageForm()
//-----------------------------------------------------------------	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(90, 160, 860, 160);
		g.drawLine(90, 705, 860, 705);
		g.drawLine(290, 160, 290, 704);
		
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
			new BookList();
			setVisible(false);
		} else if(e.getSource() == withdrawalButton) {
			new MemberWithdrawalForm();
			setVisible(false);
		}
		
		
	} //actionPerformed(ActionEvent e)
	
	
//	public static void main(String[] args) {
//		new MemberUpdateForm();
//	} //main

		
		
}