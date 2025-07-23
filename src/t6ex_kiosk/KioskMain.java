package t6ex_kiosk;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KioskMain {

	private JFrame frame;

	public static void main(String[] args) {
		new KioskMain();
	}

	public KioskMain() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("버거킹");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("BURGER KING");
		lblLogo.setForeground(Color.RED);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 28));
		lblLogo.setBounds(81, 26, 226, 48);
		frame.getContentPane().add(lblLogo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(KioskMain.class.getResource("/t7_WindowBuilder/images/burgerking/burgerking2.png")));
		lblNewLabel.setBounds(67, 72, 300, 467);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnMenuInput = new JButton("메뉴 등록 하기");
		btnMenuInput.setFont(new Font("굴림", Font.BOLD, 20));
		btnMenuInput.setBounds(427, 112, 220, 50);
		frame.getContentPane().add(btnMenuInput);
		
		JButton btnMenuOrder = new JButton("메뉴 주문 하기");
		btnMenuOrder.setFont(new Font("굴림", Font.BOLD, 20));
		btnMenuOrder.setBounds(427, 228, 220, 50);
		frame.getContentPane().add(btnMenuOrder);
		
		JButton btnOrderCheck = new JButton("주문 확인 하기");
		btnOrderCheck.setFont(new Font("굴림", Font.BOLD, 20));
		btnOrderCheck.setBounds(427, 335, 220, 50);
		frame.getContentPane().add(btnOrderCheck);
		
		JButton btnExit = new JButton("작 업 종 료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 20));
		btnExit.setBounds(427, 439, 220, 50);
		frame.getContentPane().add(btnExit);
		
		frame.setVisible(true);
		
//------------------------위쪽은 디자인 , 아래쪽은 메소드------------------------------------------------------

		// 메인메뉴 등록하기 마우스클릭시 수행
		btnMenuInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new KioskMenuInput();
			}
		});
		
		// 작업종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}
