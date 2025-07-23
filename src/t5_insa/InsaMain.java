package t5_insa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class InsaMain {

	private JFrame frame;

	public static void main(String[] args) {
		new InsaMain();
	}

	public InsaMain() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);    
		frame.setResizable(false);					
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 65);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("인사관리프로그램(v1.0)");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 784, 65);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 62, 784, 388);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblImage = new JLabel("New label");
		lblImage.setIcon(new ImageIcon(InsaMain.class.getResource("/t5_insa/images/pan.jpg")));
		lblImage.setBounds(0, 0, 784, 378);
		pn2.add(lblImage);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 447, 784, 90);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnInput = new JButton("사원등록");
		btnInput.setFont(new Font("굴림", Font.BOLD, 13));
		
		btnInput.setBounds(60, 23, 121, 44);
		pn3.add(btnInput);
		
		JButton btnSearch = new JButton("사원개별조회");
		btnSearch.setFont(new Font("굴림", Font.BOLD, 13));
		btnSearch.setBounds(241, 23, 121, 44);
		pn3.add(btnSearch);
		
		JButton btnList = new JButton("전체조회");
		btnList.setFont(new Font("굴림", Font.BOLD, 13));
		btnList.setBounds(419, 23, 121, 44);
		pn3.add(btnList);
		
		JButton btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 13));
		
		btnExit.setBounds(595, 23, 121, 44);
		pn3.add(btnExit);
		
		frame.setVisible(true);
	//-----------------------위쪽 디자인, 아래쪽 메소드-----------------------------------
		
		//전체조회 버튼을 마우스로 클릭시 수행
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new InsaList();
			}
		});
		
		// 사용등록 폼 호출
		btnInput.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new InsaInput();
			}
		});
		
		// 회원 개별 조회버튼을 마우스 클릭 실행
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("검색할 이름을 입력하세요");
				InsaDAO dao = new InsaDAO();
				InsaVO vo = dao.getNameSearch(name);
				
				if(vo.getName() == null) JOptionPane.showMessageDialog(frame, "검색할 회원이 없습니다");
				else {
					frame.dispose();
					new InsaSearch(vo);
				}
			}
		});
		
		//종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int ans = JOptionPane.showConfirmDialog(frame, "작업종료할까요??","작업종료", JOptionPane.YES_NO_OPTION);
//				if(ans == 0) System.exit(0);		
				System.exit(0);			
			}
		});
	}
}
