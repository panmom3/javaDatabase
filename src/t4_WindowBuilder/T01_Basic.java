package t4_WindowBuilder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class T01_Basic {

	private JFrame frame;
	private JTextField txtAge;
	private JPasswordField txtPwd;
	private JTextField txtMid;
	private JTextField txtName;

	public static void main(String[] args) {
		new T01_Basic();
	}

	public T01_Basic() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		//frame.setBounds(100, 100, 800, 600);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);     //화면 가운데 창 띄우기
		frame.setResizable(false);						// 사이즈 조정안되게..
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("작업종료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 20));
		btnExit.setBounds(534, 454, 200, 40);
		frame.getContentPane().add(btnExit);
		
		JButton btnNewButton_2 = new JButton("다시입력");
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton_2.setBounds(300, 454, 200, 40);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnInput = new JButton("회원가입");
		btnInput.setFont(new Font("굴림", Font.PLAIN, 20));
		btnInput.setBounds(61, 456, 200, 40);
		frame.getContentPane().add(btnInput);
		
		JLabel lblNewLabel = new JLabel("나이");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(56, 216, 205, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("성명");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(56, 149, 205, 46);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("아이디");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_2.setBounds(58, 25, 205, 46);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("비밀번호");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(58, 81, 205, 46);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		txtAge = new JTextField();
		txtAge.setText("0");
		txtAge.setHorizontalAlignment(SwingConstants.LEFT);
		txtAge.setBounds(319, 216, 415, 51);
		frame.getContentPane().add(txtAge);
		txtAge.setColumns(10);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(319, 82, 414, 50);
		frame.getContentPane().add(txtPwd);
		
		txtMid = new JTextField();
		txtMid.setHorizontalAlignment(SwingConstants.LEFT);
		txtMid.setColumns(10);
		txtMid.setBounds(319, 20, 415, 51);
		frame.getContentPane().add(txtMid);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.LEFT);
		txtName.setColumns(10);
		txtName.setBounds(319, 149, 415, 51);
		frame.getContentPane().add(txtName);
		
		JLabel lblNewLabel_3 = new JLabel("자기소개");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_3.setBounds(58, 290, 205, 46);
		frame.getContentPane().add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(319, 289, 415, 109);
		frame.getContentPane().add(scrollPane);
		
		JTextArea txtaContent = new JTextArea();
		scrollPane.setViewportView(txtaContent);
		
		frame.setVisible(true);
		
//------------------------------------------------위쪽은 디자인, 아래쪽은 메소드----------------------------------------------------

		// 종료버튼 클릭시 수행
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {    //키보드로 종료
				System.exit(0);
			}
		});
		
		// 회원가입버튼 클릭시 수행
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mid = txtMid.getText();
				String pwd = txtPwd.getText();
				String name = txtName.getName();
				int age = Integer.parseInt(txtAge.getText());
				String content = txtaContent.getText();
				
				if(mid.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디은 필수 입력입니다." , "회원가입창", JOptionPane.WARNING_MESSAGE);
					txtMid.requestFocus();
				} else if(pwd.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호은 필수 입력입니다." , "회원가입창", JOptionPane.WARNING_MESSAGE);
					txtPwd.requestFocus();
				} else if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명은 필수 입력입니다." , "회원가입창", JOptionPane.WARNING_MESSAGE);
					txtName.requestFocus();
				} else {
					JOptionPane.showMessageDialog(null, "회원에 가입합니다." , "회원가입", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		
	}
	
}
