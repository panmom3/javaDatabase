package t2_AWT;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T10_Adapter extends Frame {
	public T10_Adapter() {
		super("어뎁터를 활용한 예");
		designView();
	}
	
	private void designView() {
		//setTitle("어뎁터를 활용한 예");
		setBounds(1400, 200, 400, 350);  //좌표와 크기
		
		Button btnExit = new Button("Exit");
		add(btnExit);

		setVisible(true);
		
	// --------------------------- 위쪽은 사용자 인터페이스구현(UI), 아래쪽은 method(동작) 처리 -----------------------------------
		
		// 종료버튼 클릭시 수행
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//윈도우의 종료버튼(x)을 클릭해서 작업종료
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new T10_Adapter();
	}
}
