package t4_windowBilder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class T01_images {

	private JFrame frame;

	public static void main(String[] args) {
		new T01_images();
	}

	public T01_images() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);     //화면 가운데 창 띄우기
		frame.setResizable(false);						// 사이즈 조정안되게..
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel pn1 = new JPanel();
		frame.getContentPane().add(pn1);
		pn1.setLayout(new BorderLayout(0, 0));
		
		frame.setVisible(true);
		
	//------------------------------------------------위쪽은 디자인, 아래쪽은 메소드----------------------------------------------------
	}

	
}
