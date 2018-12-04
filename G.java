
import javax.swing.*;
import java.awt.*;

class NorthPanel extends JPanel {

	NorthPanel() {
		setBackground(Color.RED);
		setOpaque(false); // ��׶��� ���� ����(������)
		setLayout(new FlowLayout());

		add(new JButton("����"));
		add(new JButton("���� ���"));
		add(new JButton("����ο�"));
		add(new JButton("��÷"));
		add(new JButton("����"));
	}
}

class Panel1 extends JPanel {
	
	Panel1() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints[] gbc = new GridBagConstraints[5];
		JTextArea[] bt = new JTextArea[3];
		bt[0] = new JTextArea("����");
		bt[1] = new JTextArea("�̸�");
		bt[2] = new JTextArea("���̱ⱸ");
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

		super("���ֱ�ȣ�����巣��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		icon = new ImageIcon("C:\\�ڹ��н�\\B\\untitled.png");
		
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
