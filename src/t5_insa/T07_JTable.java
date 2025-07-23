package t5_insa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

@SuppressWarnings({ "rawtypes", "unused", "unchecked"})
public class T07_JTable {

	private JFrame frame;
	private JTable table;
	private Vector title, vData;
	private DefaultTableModel dtm;
	
	InsaDAO dao = new InsaDAO();

	public static void main(String[] args) {
		new T07_JTable();
	}

	public T07_JTable() {
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
		pn1.setBounds(0, 0, 784, 53);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("JTable 연습");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 331, 33);
		pn1.add(lblTitle);
		
		JButton btnExit = new JButton("종료");
		btnExit.setBounds(657, 7, 98, 38);
		pn1.add(btnExit);
		
		JButton btnPrint = new JButton("선택셀의값 출력");
		btnPrint.setBounds(505, 7, 140, 38);
		pn1.add(btnPrint);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 53, 784, 455);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		//JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBounds(25, 10, 732, 435);
		//pn2.add(scrollPane);
		
		//table = new JTable();
		//scrollPane.setViewportView(table);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 508, 784, 53);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JLabel lblMsg = new JLabel("New label");
		lblMsg.setFont(new Font("굴림", Font.PLAIN, 18));
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setBounds(12, 0, 760, 43);
		pn3.add(lblMsg);
		
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
		vData = dao.getInsaList("","");
		
		// 3. DB에서 가져온 자료(Data)와 타이틀(title)을 DefaultTableModel객체 생성시 할당한다.
		dtm = new DefaultTableModel(vData, title); // (데이터, 타이틀)
		
		// 4. DefaultTableModel로 담긴 벡터타입의 '데이터/타이틀을 JTable객체 생성시에 담아준다.
		table = new JTable(dtm);
		
		// 5. 자료가 담긴 JTable을 JScrollPane객체 생성시에  담아준다.
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(25, 10, 732, 435);
		pn2.add(scrollPane);
		
		// 6. 출력결과를 화면에 표시한다.
		frame.setVisible(true);
		
	//-----------------------위쪽 디자인, 아래쪽 메소드-----------------------------------
		
		// 테이블(JTable)에서 셀의 자료를 선택하면 해당 레코드(행)의 정보를 출력하기
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				System.out.println("선택된 행의 정보 : " + row);
				if(row != -1) {  //음수행이 아닐때
					InsaVO vo = dao.getNameSearch(table.getValueAt(row, 1).toString()); //이름검색해서 vo에 담기
					
					String temp = "성명: "+vo.getName()+", 나이: "+vo.getAge()+", 성별: "+vo.getGender()+", 입사일: "+vo.getIpsail().substring(0,10); 
					
					lblMsg.setText(temp);
				}
			}
		});
		
		//종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int ans = JOptionPane.showConfirmDialog(frame, "작업종료할까요??","작업종료", JOptionPane.YES_NO_OPTION);
				//if(ans == 0) System.exit(0);		
				System.exit(0);			
			}
		});
	}
}
