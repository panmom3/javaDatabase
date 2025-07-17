package t2_AWT;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T02_1 extends Frame implements WindowListener {
	
	public T02_1() {
		setTitle("AWT 프레임");
		//setSize(300, 250);			// 프레임의 크기(폭, 높이) : 픽셀단위
		setBounds(300, 200, 400, 350);  //좌표와 크기
		
		setVisible(true);
		
		addWindowListener(this);   
	}
	public static void main(String[] args) {
		new T02_1();
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
}