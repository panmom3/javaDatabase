package t4_WindowBuilder;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.sound.midi.MetaMessage;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class T06_File {

	private JFrame frame;


	public static void main(String[] args) {
		new T06_File();
	}

	public T06_File() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);     //화면 가운데 창 띄우기
		frame.setResizable(false);						// 사이즈 조정안되게..
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblImage = new JLabel("이곳에 이미지가 출력됩니다");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(0, 90, 772, 312);
		frame.getContentPane().add(lblImage);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setBounds(0, 412, 772, 78);
		frame.getContentPane().add(txtArea);
		
		JButton btnImage = new JButton("이미지 선택");
		
		btnImage.setBounds(12, 10, 247, 40);
		frame.getContentPane().add(btnImage);
		
		frame.setVisible(true);
		
		//이미지 선택버튼을 클릭하면 수행(btnImage상자에 그림파일을 출력시켜준다.)
		btnImage.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png");
				chooser.setFileFilter(filter);
				
				int res = chooser.showOpenDialog(null);
				
				if(res != chooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(frame, "파일을 선택해 주세요", "경고",JOptionPane.WARNING_MESSAGE);
				} else {
					String filePath = chooser.getSelectedFile().getPath();
					String fileName = chooser.getSelectedFile().getName();
					
					//lblImage.setIcon(new ImageIcon(filePath));
					btnImage.setIcon(new ImageIcon(filePath));
					
					String fileInfo = "경로명과 파일명 : " + filePath + " , \n파일명 :  " + fileName;
					txtArea.setText(filePath);
					
				}
			}
		});
	}
}
