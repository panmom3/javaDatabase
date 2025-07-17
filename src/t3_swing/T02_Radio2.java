package t3_swing;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class T02_Radio2 extends JFrame {
	
	public T02_Radio2() {
		super("스윙연습(라디오버튼)");
		designView();
	}
	
	private void designView() { 
		setSize(400, 350);
		setLocationRelativeTo(null);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setResizable(false);	
		
		setLayout(new GridLayout(4,1));
		
		JPanel pn1 = new JPanel();
		JPanel pn2 = new JPanel();
		JPanel pn3 = new JPanel();
		JPanel pn4 = new JPanel();
		
		pn1.setBackground(Color.blue);
		pn2.setBackground(Color.yellow);
		pn3.setBackground(Color.cyan);
		pn4.setBackground(Color.green);
		
		JLabel lbl = new JLabel();
		lbl.setText("스윙연습하기");
		pn1.add(lbl);
		
		//체크박스
		JCheckBox chkHobby1 = new JCheckBox("등산");
		JCheckBox chkHobby2 = new JCheckBox("낚시");
		JCheckBox chkHobby3 = new JCheckBox("수영");
		JCheckBox chkHobby4 = new JCheckBox("바둑");
		JCheckBox chkHobby5 = new JCheckBox("기타");
		
		pn2.add(chkHobby1);
		pn2.add(chkHobby2);
		pn2.add(chkHobby3);
		pn2.add(chkHobby4);
		pn2.add(chkHobby5);
		
		//라디오버튼
		CheckboxGroup gender = new CheckboxGroup();
		Checkbox chkMale = new Checkbox("Male", gender, false);
		Checkbox chkFeMale = new Checkbox("FeMale", gender, true);
		
		pn3.add(chkMale);
		pn3.add(chkFeMale);
		
		JButton btnExit = new JButton("Exit");
		pn4.add(btnExit);
		
		add(pn1);
		add(pn2);
		add(pn3);
		add(pn4);
		
		setVisible(true);
		
	// --------------------------- 위쪽은 사용자 인터페이스구현(UI), 아래쪽은 method(동작) 처리 -----------------------------------
		
		//종료버튼 클릭시 수행
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new T02_Radio2();
	}
}
