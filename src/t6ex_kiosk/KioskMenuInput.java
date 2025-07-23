package t6ex_kiosk;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class KioskMenuInput {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public static void main(String[] args) {
		new KioskMenuInput();
	}

	public KioskMenuInput() {
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
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 58);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("버거킹 메뉴 등록 화면");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 22));
		lblNewLabel.setBounds(0, 0, 784, 58);
		pn1.add(lblNewLabel);
		
		JPanel pn1_1 = new JPanel();
		pn1_1.setLayout(null);
		pn1_1.setBounds(0, 56, 784, 448);
		frame.getContentPane().add(pn1_1);
		
		JLabel lbl = new JLabel("상품분류");
		lbl.setFont(new Font("굴림", Font.BOLD, 18));
		lbl.setBounds(23, 28, 108, 31);
		pn1_1.add(lbl);
		
		JLabel lbl_1 = new JLabel("상품명");
		lbl_1.setFont(new Font("굴림", Font.BOLD, 18));
		lbl_1.setBounds(23, 82, 108, 31);
		pn1_1.add(lbl_1);
		
		JLabel lbl_2 = new JLabel("간단설명");
		lbl_2.setFont(new Font("굴림", Font.BOLD, 18));
		lbl_2.setBounds(23, 134, 108, 31);
		pn1_1.add(lbl_2);
		
		JLabel lbl_2_1 = new JLabel("상세설명");
		lbl_2_1.setFont(new Font("굴림", Font.BOLD, 18));
		lbl_2_1.setBounds(23, 189, 108, 31);
		pn1_1.add(lbl_2_1);
		
		JLabel lblkcal = new JLabel("칼로리(kcal)");
		lblkcal.setFont(new Font("굴림", Font.BOLD, 18));
		lblkcal.setBounds(23, 273, 108, 31);
		pn1_1.add(lblkcal);
		
		JLabel lbl_4 = new JLabel("상품이미지");
		lbl_4.setFont(new Font("굴림", Font.BOLD, 18));
		lbl_4.setBounds(23, 391, 108, 31);
		pn1_1.add(lbl_4);
		
		JLabel lbl_5 = new JLabel("상품가격");
		lbl_5.setFont(new Font("굴림", Font.BOLD, 18));
		lbl_5.setBounds(23, 332, 108, 31);
		pn1_1.add(lbl_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("굴림", Font.PLAIN, 17));
		comboBox.setBounds(158, 34, 316, 31);
		pn1_1.add(comboBox);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 18));
		textField.setBounds(158, 82, 316, 31);
		pn1_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("굴림", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(158, 134, 316, 31);
		pn1_1.add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(158, 187, 316, 61);
		pn1_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		scrollPane.setViewportView(textArea);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("굴림", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(158, 273, 316, 31);
		pn1_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("굴림", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(158, 332, 316, 31);
		pn1_1.add(textField_3);
		
		JButton btnNewButton = new JButton("이미지등록");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 18));
		btnNewButton.setBounds(158, 391, 316, 31);
		pn1_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("상품 이미지가 표시됩니다.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(511, 174, 245, 245);
		pn1_1.add(lblNewLabel_1);
		
		JPanel pn1_2 = new JPanel();
		pn1_2.setLayout(null);
		pn1_2.setBounds(0, 503, 784, 58);
		frame.getContentPane().add(pn1_2);
		
		
		
		frame.setVisible(true);
		
//------------------------위쪽은 디자인 , 아래쪽은 메소드------------------------------------------------------

		// 메인메뉴 등록하기 마우스클릭시 수행
//		btnMenuInput.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				frame.dispose();
//				new KioskMenuInput();
//			}
//		});
		
		// 작업종료
//		btnExit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//			}
//		});
	
	}
}
