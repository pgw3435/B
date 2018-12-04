
import javax.swing.*;
import java.awt.*;

class NorthPanel extends JPanel {

	NorthPanel() {
		setBackground(Color.RED);
		setOpaque(false); // 백그라운드 색상 적용(불투명)
		setLayout(new FlowLayout());

		add(new JButton("예약"));
		add(new JButton("예약 취소"));
		add(new JButton("대기인원"));
		add(new JButton("추첨"));
		add(new JButton("종료"));
	}
}

class Panel1 extends JPanel {
	
	Panel1() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints[] gbc = new GridBagConstraints[5];
		JTextArea[] bt = new JTextArea[3];
		bt[0] = new JTextArea("나이");
		bt[1] = new JTextArea("이름");
		bt[2] = new JTextArea("놀이기구");
		JTextField[] textField = new JTextField[3];
		for (int i = 0; i < 3; i++) 
			textField[i] = new JTextField(15);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				gbc[i] = new GridBagConstraints();
				gbc[i].gridx = i;
				gbc[i].gridx = j;
				add(bt[i] , gbc[i]);
				gbc[i].gridx = ++j;
				add(textField[i], gbc[i]);
			}
		}
	}
}

class MultiPanelFrame extends JFrame {

	ImageIcon icon;
	JScrollPane scrollPane;
	
	public MultiPanelFrame() {

		super("광주금호프렌드랜드");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		icon = new ImageIcon("C:\\자바학습\\B\\untitled.png");
		
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		background.add(new NorthPanel(), BorderLayout.NORTH);
		background.add(new Panel1(), BorderLayout.CENTER);
		
		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);

		setSize(700, 320);
		setVisible(true);
	}
}

public class G {
	public static void main(String[] args) {
		new MultiPanelFrame();
	}
}
