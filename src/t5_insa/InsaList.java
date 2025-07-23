package t5_insa;

import java.awt.EventQueue;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

@SuppressWarnings({ "rawtypes", "unused", "unchecked"})
public class InsaList {

	private JFrame frame;
	private JTable table;
	private Vector title, vData;
	private DefaultTableModel dtm;
	
	InsaDAO dao = new InsaDAO();
	private JTextField txtCondition;

//	public static void main(String[] args) {
//		new InsaList();
//	}

	public InsaList() {
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
		pn1.setBounds(0, 0, 784, 55);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JButton btnClose = new JButton("종료");
		btnClose.setFont(new Font("굴림", Font.PLAIN, 15));
		btnClose.setBounds(671, 10, 85, 35);
		pn1.add(btnClose);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 56, 784, 440);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JButton btnNewButton = new JButton("종료");
		pn1.add(btnNewButton);
		
		JButton btnList = new JButton("전체검색");
		btnList.setFont(new Font("굴림", Font.PLAIN, 15));
		btnList.setBounds(560, 10, 99, 35);
		pn1.add(btnList);
		
		JComboBox cbCondition = new JComboBox();
		cbCondition.setFont(new Font("굴림", Font.PLAIN, 15));
		cbCondition.setModel(new DefaultComboBoxModel(new String[] {"성명", "나이", "성별", "입사일"}));
		cbCondition.setBounds(23, 13, 148, 29);
		pn1.add(cbCondition);
		
		txtCondition = new JTextField();
		txtCondition.setBounds(183, 14, 116, 31);
		pn1.add(txtCondition);
		txtCondition.setColumns(10);
		
		JButton btnCondition = new JButton("조건검색");
		btnCondition.setBounds(316, 16, 97, 23);
		pn1.add(btnCondition);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(12, 10, 760, 420);
//		pn2.add(scrollPane);
		
//		table_1 = new JTable();
//		scrollPane.setViewportView(table_1);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 495, 784, 66);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnIpisalAsc = new JButton("입사일오름차순");
		btnIpisalAsc.setFont(new Font("굴림", Font.PLAIN, 12));
		btnIpisalAsc.setBounds(502, 21, 133, 35);
		pn3.add(btnIpisalAsc);
		
		JButton btnIpisalDesc = new JButton("입사일내림차순");
		btnIpisalDesc.setFont(new Font("굴림", Font.PLAIN, 12));
		btnIpisalDesc.setBounds(639, 21, 133, 35);
		pn3.add(btnIpisalDesc);
		
	// ------- 아래쪽으로 JTable 설계하기 -------
			// JTable제작시는 '제목(필드명)'과 '데이터'를 설계하여 Vector 객체타입으로 준비한다.
			
			// 1. '제목'을 Vector에 저장
			title = new Vector();
			title.add("번호");
			title.add("성명");
			title.add("나이");
			title.add("성별");
			title.add("입사일");
			
			// 2. '데이터'를 Vector로 준비... 데이터를 db에서 가져온다
			vData = dao.getInsaList("","");  // idx내림차순으로 가져옴
			
			// 3. DB에서 가져온 자료(Data)와 타이틀(title)을 DefaultTableModel객체 생성시 할당한다.
			dtm = new DefaultTableModel(vData, title); // (데이터, 타이틀)
			
			// 4. DefaultTableModel로 담긴 벡터타입의 '데이터/타이틀을 JTable객체 생성시에 담아준다.
			table = new JTable(dtm);
			
			// 5. 자료가 담긴 JTable을 JScrollPane객체 생성시에  담아준다.
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(25, 10, 732, 420);
			pn2.add(scrollPane);
			
			// 6. 출력결과를 화면에 표시한다.
			frame.setVisible(true);
		
		//-----------------------위쪽 디자인, 아래쪽 메소드-----------------------------------
		
			// 조건검색버튼을 마우스로 클릭시 수행
			btnCondition.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String condition = cbCondition.getSelectedItem().toString();
					String textCondition = txtCondition.getText();
					
					if(textCondition.trim().equals("")) {
						JOptionPane.showMessageDialog(frame, "검색할 내용을 입력하세요.");
						txtCondition.requestFocus();
						return;
					}
					if(condition.equals("성명")) vData = dao.getConditionSearch("name", textCondition);
					else if(condition.equals("나이")) {
						if(!Pattern.matches("^[0-9]+$", textCondition)) {
							JOptionPane.showMessageDialog(frame, "나이는 숫자로 입력하세요");
							txtCondition.requestFocus();
						}
						else vData = dao.getConditionSearch("age", textCondition);
					}
					else if(condition.equals("성별")) vData = dao.getConditionSearch("gender", textCondition);
					else if(condition.equals("입사일")) {
						vData = dao.getConditionSearch("ipsail", textCondition);
					}
					dtm.setDataVector(vData, title);
				}
			});
			// 전체검색 버튼을 마우스 클릭시 수행
			btnList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vData = dao.getInsaList("","");
					dtm.setDataVector(vData, title);
				}
			});

			// 입사일 내림차순 정렬버튼 마우스 클릭시 수행
			btnIpisalDesc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vData = dao.getInsaList("ipsail","desc");
					dtm.setDataVector(vData, title);
				}
			});
		
			// 입사일 오름차순 정렬버튼 마우스 클릭시 수행
			btnIpisalAsc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vData = dao.getInsaList("ipsail","asc");
					dtm.setDataVector(vData, title);
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
