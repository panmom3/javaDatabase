package t2_AWT;

import java.awt.Frame;

@SuppressWarnings("serial")
public class T01_1 extends Frame {
	
	public T01_1() {
		setTitle("AWT 프레임");
		setSize(300, 250);			// 프레임의 크기(폭, 높이) : 픽셀단위
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new T01_1();
	}
}
