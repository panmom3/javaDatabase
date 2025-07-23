package t5_insa;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;

	public class InsaSearch {
		private InsaDAO dao = new InsaDAO();
		private InsaVO vo = null;
		private int res = 0;
		
		private JFrame frame;
		private JTextField txtAge;
		private JTextField txtName;
		private final ButtonGroup buttonGroup = new ButtonGroup();
	
//		public static void main(String[] args) {
//			new InsaInput();
//		}
	
		public InsaSearch(InsaVO vo) {
			this.vo = vo;
			initialize();
		}
	
		private void initialize() {
			frame = new JFrame();
			frame.setTitle("회원검색");
			frame.setSize(800, 600);
			frame.setLocationRelativeTo(null);    
			frame.setResizable(false);					
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JPanel pn1 = new JPanel();
			pn1.setBounds(0, 0, 784, 72);
			frame.getContentPane().add(pn1);
			pn1.setLayout(null);
			
			JLabel lblTitle = new JLabel("회원가입폼");
			lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setBounds(0, 0, 784, 72);
			pn1.add(lblTitle);
			
			JPanel pn2 = new JPanel();
			pn2.setBounds(0, 71, 784, 372);
			frame.getContentPane().add(pn2);
			pn2.setLayout(null);
			
			JLabel lblAge = new JLabel("나이");
			lblAge.setHorizontalAlignment(SwingConstants.CENTER);
			lblAge.setFont(new Font("굴림", Font.BOLD, 20));
			lblAge.setBounds(26, 125, 105, 37);
			pn2.add(lblAge);
			
			JLabel lblName_1 = new JLabel("성명");
			lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblName_1.setFont(new Font("굴림", Font.BOLD, 20));
			lblName_1.setBounds(26, 44, 105, 37);
			pn2.add(lblName_1);
			
			JLabel lblGender = new JLabel("성별");
			lblGender.setHorizontalAlignment(SwingConstants.CENTER);
			lblGender.setFont(new Font("굴림", Font.BOLD, 20));
			lblGender.setBounds(26, 206, 105, 37);
			pn2.add(lblGender);
			
			JLabel lblIpial = new JLabel("입사일");
			lblIpial.setHorizontalAlignment(SwingConstants.CENTER);
			lblIpial.setFont(new Font("굴림", Font.BOLD, 20));
			lblIpial.setBounds(26, 287, 105, 37);
			pn2.add(lblIpial);
			
			txtAge = new JTextField();
			txtAge.setFont(new Font("굴림", Font.PLAIN, 15));
			txtAge.setHorizontalAlignment(SwingConstants.CENTER);
			txtAge.setBounds(191, 125, 271, 42);
			pn2.add(txtAge);
			txtAge.setColumns(10);
			
			txtName = new JTextField();
			txtName.setEditable(false);
			txtName.setFont(new Font("굴림", Font.PLAIN, 15));
			txtName.setHorizontalAlignment(SwingConstants.CENTER);
			txtName.setText("admin");
			txtName.setColumns(10);
			txtName.setBounds(191, 44, 271, 42);
			pn2.add(txtName);
			
			JRadioButton rdMale = new JRadioButton("남자");
			buttonGroup.add(rdMale);
			rdMale.setFont(new Font("굴림", Font.PLAIN, 18));
			rdMale.setBounds(191, 206, 78, 32);
			pn2.add(rdMale);
			
			JRadioButton rdFMale = new JRadioButton("여자");
			buttonGroup.add(rdFMale);
			rdFMale.setFont(new Font("굴림", Font.PLAIN, 18));
			rdFMale.setSelected(true);
			rdFMale.setBounds(279, 206, 88, 32);
			pn2.add(rdFMale);
			
			// 년/월/일 초기값 생성하기
			String[] yy = new String[25];
			String[] mm = new String[12];
			String[] dd = new String[31];
			
			int imsi = 2025;
			for (int i = 0; i < yy.length; i++) {
				yy[i] = imsi - i + "";
			}
			
			for (int i = 0; i < mm.length; i++) {
				mm[i] = (i + 1) + "";
			}
			
			for (int i = 0; i < dd.length; i++) {
				dd[i] = (i + 1) + "";
			}
			
			JComboBox cbYY = new JComboBox(yy);
			cbYY.setFont(new Font("굴림", Font.PLAIN, 18));
			cbYY.setBounds(191, 287, 100, 32);
			pn2.add(cbYY);
			
			JComboBox cbMM = new JComboBox(mm);
			cbMM.setFont(new Font("굴림", Font.PLAIN, 18));
			cbMM.setBounds(344, 287, 88, 32);
			pn2.add(cbMM);
			
			JComboBox cbDD = new JComboBox(dd);
			cbDD.setFont(new Font("굴림", Font.PLAIN, 18));
			cbDD.setBounds(485, 287, 88, 32);
			pn2.add(cbDD);
			
			JLabel lblYY = new JLabel("년");
			lblYY.setFont(new Font("굴림", Font.PLAIN, 20));
			lblYY.setBounds(303, 295, 29, 24);
			pn2.add(lblYY);
			
			JLabel lblMM = new JLabel("월");
			lblMM.setFont(new Font("굴림", Font.PLAIN, 20));
			lblMM.setBounds(444, 293, 29, 24);
			pn2.add(lblMM);
			
			JLabel lblDD = new JLabel("일");
			lblDD.setFont(new Font("굴림", Font.PLAIN, 20));
			lblDD.setBounds(585, 293, 29, 24);
			pn2.add(lblDD);
			
			JPanel pn3 = new JPanel();
			pn3.setBounds(0, 439, 784, 99);
			frame.getContentPane().add(pn3);
			pn3.setLayout(null);
			
			JButton btnUpdate = new JButton("수정하기");
			btnUpdate.setFont(new Font("굴림", Font.BOLD, 15));
			btnUpdate.setBounds(26, 20, 198, 57);
			pn3.add(btnUpdate);
			
			JButton btnDelete = new JButton("삭제하기");
			btnDelete.setFont(new Font("굴림", Font.BOLD, 15));
			btnDelete.setBounds(287, 20, 198, 57);
			pn3.add(btnDelete);
			
			JButton btnClose = new JButton("창닫기");
			btnClose.setFont(new Font("굴림", Font.BOLD, 15));
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnClose.setBounds(549, 20, 198, 57);
			pn3.add(btnClose);
			
			// vo에서 담겨서 넘어온 회원의 정보를 검색창에 뿌려줄수 있도록 처리한다.
			txtName.setText(vo.getName());
			txtAge.setText(vo.getAge() + "");
			if(vo.getGender().equals("남자")) rdMale.setSelected(true);
			if(vo.getGender().equals("여자")) rdFMale.setSelected(true);
			// 날짜형식의 자료를 '년/월/일'로 각각 뽑아서 콤보상자에 대입시켜준다.
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy-M-d");
			LocalDate date = LocalDate.parse(vo.getIpsail().substring(0, 10), dtf);
			String strDate = date.format(dtf);
			String[] ymds = strDate.split("-");
			cbYY.setSelectedItem(ymds[0]);
			cbMM.setSelectedItem(ymds[1]);
			cbDD.setSelectedItem(ymds[2]);
			
			
// -----------------------------------------------------------------------------
			frame.setVisible(true);
			
//-----------------------위쪽 디자인, 아래쪽 메소드-----------------------------------
			
			// 회원자료 삭제(마우스)
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name = txtName.getText();
					
					int ans = JOptionPane.showConfirmDialog(frame, "회원정보를 삭제하시겠습니까?","회원삭제창", JOptionPane.YES_NO_OPTION); // yes:0 no:1
					if(ans == 0) {  // yes:0 
						int res = dao.setInsaDelete(name);
						
						if(res !=0) {
							JOptionPane.showMessageDialog(frame, "회원정보가 삭제되었습니다.");
							frame.dispose();
							new InsaMain();
						} else {
							JOptionPane.showMessageDialog(frame, "회원자료 삭제 취소!!!.");
						}
					} 
				}
			});
			
			// 회원 수정버튼 마우스로 클릭시 수행
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					String age = txtAge.getText().trim();
					String gender = "";
					String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem();
					
					//유효성검사
					if(!Pattern.matches("^[0-9]+$", age)) {
						JOptionPane.showMessageDialog(frame, "나이는 숫자로 입력하세요");
						txtAge.requestFocus();
					}
					else {
						if(rdMale.isSelected()) gender = "남자";
						else gender = "여자";
						
						//회원명 중복처리 완료후 앞에서 기록한 내용을 vo에 담아서 DB에 저장한다.
						vo = new InsaVO();
						vo.setName(txtName.getText());
						vo.setAge(Integer.parseInt(age));
						vo.setGender(gender);
						vo.setIpsail(ipsail);
						
						res = dao.setInsaUpdate(vo);
						
						if(res !=0) {
							JOptionPane.showMessageDialog(frame, "회원정보가 수정되었습니다.");
							//frame.dispose();
							//new InsaMain();
						} else {
							JOptionPane.showMessageDialog(frame, "회원정보 수정실패.");
						}
					}
				}
			});
			
			// 종료버튼
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					new InsaMain();
				}
			});
		}
}
