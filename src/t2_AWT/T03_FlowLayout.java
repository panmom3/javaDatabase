package t2_AWT;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T03_FlowLayout extends Frame implements WindowListener, ActionListener {
	Label lblTitle;
	
	public T03_FlowLayout() {
		setLayout(new FlowLayout());
		setTitle("AWT 프레임(FlowLayout)");
		//setSize(300, 250);			// 프레임의 크기(폭, 높이) : 픽셀단위
		setBounds(1400, 200, 400, 350);  //좌표와 크기
		
		Label lblTitle = new Label("레이블 테스트");
		add(lblTitle);
		
		
//		btnAction.setLabel("Action");
		Button btn1 = new Button("btn1");
		Button btn2 = new Button("btn2");
		Button btn3 = new Button("btn3");
		Button btn4 = new Button("btn4");
		Button btnExit = new Button("Exit");
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btnExit);
		
		addWindowListener(this);   
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btnExit.addActionListener(this);
		
		setVisible(true);

// --------------------------- 위쪽은 사용자 인터페이스구현(UI), 아래쪽은 method(동작) 처리 -----------------------------------
	}
	
	public static void main(String[] args) {
		new T03_FlowLayout();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Button btnText = (Button) e.getSource();
		
		if(btnText.getLabel().equals("btn1")) {
			System.out.println("btn1~~~");
		}
		else if(btnText.getLabel().equals("btn2")) {
			System.out.println("btn2~~~");
		}
		else if(btnText.getLabel().equals("btn3")) {
			lblTitle.setText("btn3호출");
		}
		else if(btnText.getLabel().equals("btn4")) {
			lblTitle.setText("btn4호출");
		}
		else if(btnText.getLabel().equals("Exit")) {
			System.exit(0);
		}
		
		
	}
}