package t2_AWT;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T06_AbsoluteLayout1 extends Frame implements WindowListener, ActionListener {
	
	public T06_AbsoluteLayout1() {
		designView();
	}
	private void designView() {
		setTitle("AWT 프레임(AbsoluteLayout)");
		setLayout(null);
		setBounds(1400, 200, 400, 350);  //좌표와 크기
		
		Button btn1 = new Button("btn1"); 
		Button btn2 = new Button("btn2"); 
		Button btn3 = new Button("btn3"); 
		Button btn4 = new Button("btn4"); 
		Button btnExit = new Button("Exit"); 
		
		btn1.setBounds(100, 100, 150, 30);
		btn2.setBounds(100, 140, 150, 30);
		btn3.setBounds(100, 180, 150, 30);
		btn4.setBounds(100, 220, 150, 30);
		btnExit.setBounds(100, 260, 150, 30);
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btnExit);
		
		addWindowListener(this);   
		btnExit.addActionListener(this);
		
		setVisible(true);
	}
		
// --------------------------- 위쪽은 사용자 인터페이스구현(UI), 아래쪽은 method(동작) 처리 -----------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Button btnText = (Button) e.getSource();
		System.exit(0);
	}
	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	
	public static void main(String[] args) {
		new T06_AbsoluteLayout1();
	}
}