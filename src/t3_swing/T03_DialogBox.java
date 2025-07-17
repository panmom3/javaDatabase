package t3_swing;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class T03_DialogBox extends JFrame {
	
	public T03_DialogBox() {
		super("스윙연습(라디오버튼)");
		designView();
	}
	
	private void designView() { 
		setSize(400, 350);
		setLocationRelativeTo(null);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setResizable(false);	
		
		setLayout(new GridLayout(2,1));
		
		JPanel pn1 = new JPanel();
		JPanel pn2 = new JPanel();
		
		pn1.setBackground(Color.gray);
		pn2.setBackground(Color.orange);

		JButton btn1 = new JButton("경고");
		JButton btn2 = new JButton("입력");
		JButton btn3 = new JButton("종료");
		JButton btn4 = new JButton("종료(예/아니오)");
		JButton btn5 = new JButton("종료(예/아니오/취소)");
		
		pn1.add(btn1);
		pn1.add(btn2);
		pn1.add(btn3);
		pn1.add(btn4);
		pn1.add(btn5);
		
		JLabel lblMessage = new JLabel("메세지가 출력됩니다.");
		pn2.add(lblMessage);
		
		add(pn1);
		add(pn2);
		
		setVisible(true);
		
	// --------------------------- 위쪽은 사용자 인터페이스구현(UI), 아래쪽은 method(동작) 처리 -----------------------------------
		
		//경고메세지 출력처리
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText("경고버튼을 누르셨습니다");
				//JOptionPane.showMessageDialog(null, lblMessage.getText());
				JOptionPane.showMessageDialog(null, lblMessage.getText(), "경고메세지", JOptionPane.WARNING_MESSAGE);
			}
		});
		//입력 출력처리
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText("입력버튼을 누르셨습니다");
				String name = JOptionPane.showInputDialog(null, "성명을 입력하세요", "입력창", JOptionPane.DEFAULT_OPTION);
				if(name != null) lblMessage.setText("성명 : " +name);
			}
		});
		
		//종료버튼 클릭시 수행
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// 예/아니오 출력처리
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText("예/아니오 버튼을 누르셨습니다");
				int ans = JOptionPane.showConfirmDialog(null, "작업을 계속 하시겠습니까?", "작업 종료창", JOptionPane.YES_NO_OPTION); // 0:yes 1:no 
				if(ans == 0) {
					JOptionPane.showMessageDialog(null, "작업을 계속 진행합니다.");
				}
				else {
					JOptionPane.showMessageDialog(null, "작업을 마칩니다.");
					System.exit(0);
				}
			}
		});
		// 예/아니오/취소 출력처리
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText("예/아니오/취소 버튼을 누르셨습니다");
				int ans = JOptionPane.showConfirmDialog(null, "작업을 계속 하시겠습니까?", "작업 종료창", JOptionPane.YES_NO_CANCEL_OPTION);  // 0 1 2
				if(ans == 0) {
					JOptionPane.showMessageDialog(null, "작업을 계속 진행합니다.");
				}
				else if(ans == 1){
					JOptionPane.showMessageDialog(null, "작업을 마칩니다.");
					System.exit(0);
				}
				else {
					JOptionPane.showMessageDialog(null, "작업을 취소합니다.");
					System.exit(0);
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new T03_DialogBox();
	}
}
