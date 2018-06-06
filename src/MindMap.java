import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

class LeftPane extends JPanel {
	JLabel label;
	int xpos, ypos, count = 0;

	LeftPane() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel la = new JLabel(" Mind Map Pane ");
		// la.setAlignmentY(TOP_ALIGNMENT);
		la.setAlignmentX(CENTER_ALIGNMENT);
		Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
		la.setFont(new Font("Arial", Font.ITALIC, 20));
		la.setBorder(border);
		la.setOpaque(true);

		add(la);

		ImageIcon icon = new ImageIcon("image/img.jpg");
		label = new JLabel(icon);
		MyMouseListener listener = new MyMouseListener();
		label.addMouseListener(listener);
		label.addMouseMotionListener(listener);
		label.setSize(icon.getIconWidth(), icon.getIconWidth());
		label.setLocation(100, 100);
		add(label);
		// setSize(300, 300);
		setVisible(true);
	}

	// class MyMouseListener implements MouseListener {
	//
	// public void mousePressed(MouseEvent e) {
	// System.out.println(1111);
	// int x = e.getX();
	// int y = e.getY();
	// la.setLocation(x, y);
	// xpos = x; ypos = y;
	// System.out.println(2222);
	// }
	//
	// public void mouseReleased(MouseEvent e) {
	//
	// }
	//
	// public void mouseClicked(MouseEvent e) {
	// }
	//
	// public void mouseEntered(MouseEvent e) {
	// }
	//
	// public void mouseExited(MouseEvent e) {
	// }
	// }
	class MyMouseListener extends MouseAdapter {
		int x, y;

		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
		}

		public void mouseDragged(MouseEvent e) {
			int distanceX = e.getX() - x;
			int distanceY = e.getY() - y;
			System.out.println(label.getX() + distanceX + "," + (label.getY() + distanceY));
			label.setLocation(label.getX() + distanceX, label.getY() + distanceY);
			xpos = label.getX() + distanceX;
			ypos = label.getY() + distanceY;
		}
	}

}

// class TextArea extends JPanel {
// JTextArea T = new JTextArea(7, 20);
//
// TextArea() {
// setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
// Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
// JLabel la = new JLabel(" Text Edit Pane ");
// JButton bt = new JButton(" ���� ");
//
// bt.setBackground(Color.red);
// bt.setForeground(Color.white);
// bt.setFont(new Font("A", Font.BOLD, 20));
//
// la.setAlignmentX(CENTER_ALIGNMENT);
// add(la);
// la.setFont(new Font("Arial", Font.ITALIC, 20));
// la.setForeground(Color.white);
// la.setBackground(Color.cyan);
// la.setBorder(border);
// la.setOpaque(true);
// setBackground(Color.cyan);
//
// T.setBackground(Color.cyan);
// T.setAlignmentX(CENTER_ALIGNMENT);
// add(T);
// add(bt, BorderLayout.SOUTH);
// bt.setAlignmentX(CENTER_ALIGNMENT);
//
// bt.getMouseMotionListeners();
// setSize(10, 500);
// setVisible(true);
// }
// }

public class MindMap extends JFrame implements ActionListener {
	static int flag = 0;
	static String content = "";
	FileDialog mSave = new FileDialog(this, "����", FileDialog.SAVE);
	FileDialog mOpen = new FileDialog(this, "����", FileDialog.LOAD);

	JSplitPane splitPane;
	JSplitPane splitPane2;
	JLabel imgLabel = new JLabel();

	JMenuBar bar = new JMenuBar();
	JMenuItem[] menuItem = new JMenuItem[7];
	String[] itemTitle = { "���� �����", "����", "����", "�ٸ� �̸����� ����", "�ݱ�", "����", "����" };

	JToolBar bar1 = new JToolBar();
	String[] itemTitle1 = { "���� �����", "����", "����", "�ٸ� �̸����� ����", "�ݱ�", "����", "����" };
	JButton[] barItem = new JButton[7];

	JTextArea T = new JTextArea(7, 20);

	MindMap() {
		setTitle("Mind Map");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		crateTool();
		// testText();
		setBounds(100, 100, 1000, 500);
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

		TextArea ta = new TextArea();
		LeftPane l = new LeftPane();
		RightPane r = new RightPane();

		addMouseListener(l.new MyMouseListener());

		add(splitPane2, "Center");

		setVisible(true);

		Dimension min = new Dimension(50, 50);

		splitPane2.setContinuousLayout(true); // �������� ��ȭ�� �� �� �ְ� ���ش�.
		splitPane.setContinuousLayout(true);

		splitPane.setLeftComponent(new JScrollPane(ta));
		splitPane.setRightComponent(new JScrollPane(l));
		splitPane2.setLeftComponent(splitPane);
		splitPane2.setRightComponent(r);

		splitPane2.getRightComponent().setPreferredSize(min);

		splitPane.setDividerSize(5);
		splitPane2.setDividerLocation(0.8);
		splitPane2.setDividerSize(5);
	}

	void createMenu() {
		// JMenuBar bar = new JMenuBar();
		// JMenuItem[] menuItem = new JMenuItem[7];
		// String[] itemTitle = { "���� �����", "����", "����", "�ٸ� �̸����� ����", "�ݱ�",
		// "����", "����" };

		JMenu title = new JMenu("Menu Bar");
		// MenuActionListener listener = new MenuActionListener();
		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]); // �޴������� ����
			// menuItem[i].addActionListener(listener); // �޴������ۿ� �׼� ������ ���.
			menuItem[i].addActionListener(this);
			title.add(menuItem[i]);// �޴� �������� ��ũ�� �޴��� ����
			if (i == menuItem.length - 1)
				break;
			title.addSeparator();
		}
		bar.add(title); // �޴��ٿ� ��ũ�� �޴� ����.
		setJMenuBar(bar); // �޴��ٸ� �����ӿ� ����.

	}

	// class MenuActionListener implements ActionListener {
	// public void actionPerformed(ActionEvent e) {
	// String cmd = e.getActionCommand(); // ����ڰ� ������ �޴��������� ���ڿ� ����.
	// switch (cmd) { // �޴� �������� ���� ����
	// case "���� �����":
	// if (imgLabel.getIcon() != null)
	// return; // �̹� �ε� ���������� ����.
	// imgLabel.setIcon(new ImageIcon("image/Oz.jpg"));
	// break;
	// case "����":
	// imgLabel.setVisible(false);
	// break;
	// case "����":
	//
	// break;
	// case "�ٸ� �̸����� ����":
	// imgLabel.setVisible(true);
	// break;
	// case "�ݱ�":
	// System.exit(0);
	// break;
	// case "����":
	// imgLabel.setVisible(true);
	// break;
	// case "����":
	// imgLabel.setVisible(true);
	// break;
	// }
	//
	// }
	// }
	// void testText(){
	// name = new JTextArea();
	// add(name);
	// }
	void crateTool() {
		// JToolBar bar = new JToolBar();
		// String[] itemTitle = { "���� �����", "����", "����", "�ٸ� �̸����� ����", "�ݱ�",
		// "����", "����" };
		// JButton[] barItem = new JButton[7];
		// ToolActionListener listener = new ToolActionListener();
		for (int i = 0; i < barItem.length; i++) {
			barItem[i] = new JButton(itemTitle1[i]); // �޴������� ����
			// barItem[i].addActionListener(listener); // �޴������ۿ� �׼� ������ ���.
			barItem[i].addActionListener(this);
			bar1.add(barItem[i]);// �޴� �������� ��ũ�� �޴��� ����
		}
		add(bar1, BorderLayout.NORTH);
	}

	// class ToolActionListener implements ActionListener {
	// public void actionPerformed(ActionEvent e) {
	// String cmd = e.getActionCommand(); // ����ڰ� ������ �޴��������� ���ڿ� ����.
	// switch (cmd) { // �޴� �������� ���� ����
	// case "���� �����":
	// if (imgLabel.getIcon() != null)
	// return; // �̹� �ε� ���������� ����.
	// imgLabel.setIcon(new ImageIcon("image/Oz.jpg"));
	// break;
	// case "����":
	// imgLabel.setVisible(false);
	// break;
	// case "����":
	// imgLabel.setVisible(true);
	// break;
	// case "�ٸ� �̸����� ����":
	// imgLabel.setVisible(true);
	// break;
	// case "�ݱ�":
	// System.exit(0);
	// break;
	// case "����":
	// imgLabel.setVisible(true);
	// break;
	// case "����":
	// imgLabel.setVisible(true);
	// break;
	// }
	// }
	// }
	public void actionPerformed(ActionEvent e) {

		String data;
		String cmd = e.getActionCommand(); // ����ڰ� ������ �޴��������� ���ڿ� ����.
		switch (cmd) { // �޴� �������� ���� ����
		case "���� �����":
			T.setText(content);
            setTitle("�޸���");
            flag = 0;
            setBounds(100, 100, 1000, 500);
			break;
		case "����":
			mOpen.setVisible(true);
			data = mOpen.getDirectory() + mOpen.getFile();
			try {
				String str = "";
				FileReader fr = new FileReader(data);
				BufferedReader br = new BufferedReader(fr);

				T.setText(""); // �ϴ� �ʱ�ȭ
				while ((str = br.readLine()) != null) { // str�� ���Ƶ� ������ null ��
														// �ƴϸ�..

					T.append(str); // str�� ������ �߰�
					T.append("\r\n"); // readline�� ������ ���ϴ� ������� �������ش�.
				}

				br.close();
				String Filename = mOpen.getFile();
				setTitle(Filename);
				flag = 1;
			} catch (Exception e1) {
			}
			break;
		case "����":
			if (flag == 0) {
				mSave.setVisible(true);
				data = mSave.getDirectory() + mSave.getFile(); // ������ ���丮 ������
																// ���ϸ��� ��´�.
				try {
					FileWriter fw = new FileWriter(data + ".txt"); // txt���Ϸ�
																	// �����Ѵ�.
					BufferedWriter bw = new BufferedWriter(fw);

					String str = T.getText();
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) == '\n') {
							System.out.println("find");
							bw.newLine();
						} else
							bw.write(str.charAt(i)); // Textarea �� bw��ü�� �ִ� ������
														// �ִ´�.
					}

					bw.close();
					String Filename = mSave.getFile(); // ������ ������ �̸��� �ְ�..
					setTitle(Filename + ".txt"); // ������ ���� ���ϸ����� �ٲ۴�..
				} catch (Exception e1) {

				}
				flag = 1;
			}

			else if (flag == 1) {
				data = mSave.getDirectory() + mSave.getFile(); // ������ ���丮 ������
																// ���ϸ��� ��´�.

				try {
					FileWriter fw = new FileWriter(data + ".txt"); // txt���Ϸ�
																	// �����Ѵ�.
					BufferedWriter bw = new BufferedWriter(fw);

					String str = T.getText();
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) == '\n') {
							System.out.println("find");
							bw.newLine();
						} else
							bw.write(str.charAt(i)); // Textarea �� bw��ü�� �ִ� ������
														// �ִ´�.
					}
					bw.close();
				} catch (Exception e2) {

				}

			}

			break;
		case "�ٸ� �̸����� ����":
			mSave.setVisible(true);
			data = mSave.getDirectory() + mSave.getFile(); // ������ ���丮 ������ ���ϸ���
															// ��´�.
			try {
				FileWriter fw = new FileWriter(data + ".text"); // txt���Ϸ� �����Ѵ�.
				BufferedWriter bw = new BufferedWriter(fw);

				String str = T.getText();
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '\n') {
						System.out.println("find");
						bw.newLine();

					} else
						bw.write(str.charAt(i)); // Textarea �� bw��ü�� �ִ� ������ �ִ´�.
				}

				bw.close();
				String Filename = mSave.getFile(); // ������ ������ �̸��� �ְ�,
				setTitle(Filename + ".txt"); // ������ ���� ���ϸ����� �ٲ۴�.
			} catch (Exception e1) {

			}
			break;
		case "�ݱ�":
			System.exit(0);
			break;
		case "����":
			imgLabel.setVisible(true);
			break;
		case "����":
			imgLabel.setVisible(true);
			break;
		}

	}

	class TextArea extends JPanel {

		TextArea() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
			JLabel la = new JLabel(" Text Edit Pane ");
			JButton bt = new JButton(" ���� ");

			bt.setBackground(Color.red);
			bt.setForeground(Color.white);
			bt.setFont(new Font("A", Font.BOLD, 20));

			la.setAlignmentX(CENTER_ALIGNMENT);
			add(la);
			la.setFont(new Font("Arial", Font.ITALIC, 20));
			la.setForeground(Color.white);
			la.setBackground(Color.cyan);
			la.setBorder(border);
			la.setOpaque(true);
			setBackground(Color.cyan);

			T.setToolTipText("\\t �� ���ؼ� ������ �ּ���.");
			T.setBackground(Color.cyan);
			T.setAlignmentX(CENTER_ALIGNMENT);
			add(T);
			add(bt, BorderLayout.SOUTH);
			bt.setAlignmentX(CENTER_ALIGNMENT);

			bt.getMouseMotionListeners();
			setSize(10, 500);
			setVisible(true);
		}
	}

	class RightPane extends JPanel {
		RightPane() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			Border border = BorderFactory.createLineBorder(Color.BLUE, 1);

			JLabel la = new JLabel(" Attribute Pane ");
			la.setAlignmentX(CENTER_ALIGNMENT);
			la.setFont(new Font("Arial", Font.ITALIC, 20));
			la.setBorder(border);
			la.setOpaque(true);
			add(la);

			JButton bt = new JButton(" ���� ");
			bt.setBackground(Color.red);
			bt.setForeground(Color.white);
			bt.setFont(new Font("A", Font.BOLD, 20));
			bt.setAlignmentX(CENTER_ALIGNMENT);
			bt.getMouseMotionListeners();

			Text t = new Text();
			X x = new X();
			Y y = new Y();
			H h = new H();
			W w = new W();
			add(t);
			add(x);
			add(y);
			add(h);
			add(w);
			add(bt, BorderLayout.SOUTH);

			setVisible(true);
		}
	}

	class Text extends JPanel {
		Text() {
			setLayout(new FlowLayout(FlowLayout.CENTER));
			JLabel text = new JLabel("Text : ");
			text.setFont(new Font("a", Font.PLAIN, 20));
			JTextField status = new JTextField(10);
			add(text);
			add(status);
			setVisible(true);
		}
	}

	class X extends JPanel {
		JTextField status = new JTextField(10);

		X() {
			setLayout(new FlowLayout(FlowLayout.CENTER));
			JLabel xPos = new JLabel("X : ");
			xPos.setFont(new Font("a", Font.PLAIN, 20));
			// JTextField status = new JTextField(10);
			add(xPos, FlowLayout.LEFT);
			// field();
			add(status, BorderLayout.EAST);
			setVisible(true);
		}

	}

	class Y extends JPanel {
		Y() {
			// setLayout(new GridLayout(1,2,5,10));
			setLayout(new FlowLayout(FlowLayout.CENTER));
			JLabel yPos = new JLabel("Y : ");
			yPos.setFont(new Font("a", Font.PLAIN, 20));
			JTextField status = new JTextField(10);
			add(yPos);
			add(status);
			setVisible(true);
		}
	}

	class H extends JPanel {
		H() {
			setLayout(new FlowLayout(FlowLayout.CENTER));
			JLabel height = new JLabel("H : ");
			height.setFont(new Font("a", Font.PLAIN, 20));
			JTextField status = new JTextField(10);
			add(height, FlowLayout.LEFT);
			add(status, BorderLayout.EAST);
			setVisible(true);
		}
	}

	class W extends JPanel {
		W() {
			setLayout(new FlowLayout(FlowLayout.CENTER));
			JLabel width = new JLabel("W : ");
			width.setFont(new Font("a", Font.PLAIN, 20));
			JTextField status = new JTextField(10);
			add(width, FlowLayout.LEFT);
			add(status, BorderLayout.EAST);
			setVisible(true);
		}

	}

	public static void main(String[] args) {
		new MindMap();
	}
}
