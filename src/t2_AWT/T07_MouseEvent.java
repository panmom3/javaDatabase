package t2_AWT;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T07_MouseEvent extends Frame implements WindowListener, ActionListener, MouseListener {
	
	public T07_MouseEvent() {
		designView();
	}
	private void designView() {
		setTitle("AWT 프레임(MouseEvent)");
		setBounds(1400, 200, 400, 350);  //좌표와 크기
		
		
		
		addWindowListener(this);   
		addMouseListener(this);
		
		setVisible(true);
	}
		
// --------------------------- 위쪽은 사용자 인터페이스구현(UI), 아래쪽은 method(동작) 처리 -----------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
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
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 클릭시~~~~~");
	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("마우스 클릭 순간~~~~~");
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("마우스 클릭하고 놓는 순간~~~~~");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("마우스가 특정 객체안으로 들어가는 순간~~~~~");
	} 
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("마우스가 특정 객체안에서 밖으로 나가는 순간~~~~~");
	}
	
	public static void main(String[] args) {
		new T07_MouseEvent();
	}
}