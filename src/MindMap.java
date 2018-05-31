
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

class LeftPane extends JPanel {
	JLabel la = new JLabel("Hello");
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
		// setLayout(null);
		// addMouseListener(new MyMouseListener());
		// la.setSize(50, 20);
		// la.setLocation(30, 30);
		// add(la);
		// setVisible(true);
		// setLayout(null);

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

class TextArea extends JPanel {
	JTextArea ta = new JTextArea(7, 20);

	TextArea() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
		JLabel la = new JLabel(" Text Edit Pane ");
		JButton bt = new JButton(" 적용 ");

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

		ta.setBackground(Color.cyan);
		ta.setAlignmentX(CENTER_ALIGNMENT);
		add(ta);
		add(bt, BorderLayout.SOUTH);
		bt.setAlignmentX(CENTER_ALIGNMENT);

		bt.getMouseMotionListeners();
		setSize(10, 500);
		setVisible(true);
	}
}

public class MindMap extends JFrame {
	JSplitPane splitPane;
	JSplitPane splitPane2;
	JLabel imgLabel = new JLabel();

	MindMap() {
		setTitle("Mind Map");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		crateTool();

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

		splitPane2.setContinuousLayout(true); // 연속적인 변화를 볼 수 있게 해준다.
		splitPane.setContinuousLayout(true);

		splitPane.setLeftComponent(new JScrollPane(ta));
		splitPane.setRightComponent(new JScrollPane(l));
		splitPane2.setLeftComponent(splitPane);
		splitPane2.setRightComponent(r);
		// r.setSize(min);
		splitPane2.getRightComponent().setPreferredSize(min);
		// splitPane2.getRightComponent().setMaximumSize(min);
		splitPane.setDividerSize(5);
		// splitPane2.setDividerLocation((int) splitPane2.getSize().getWidth() /
		// 2);
		splitPane2.setDividerLocation(0.8);
		splitPane2.setDividerSize(5);
	}

	void createMenu() {
		JMenuBar bar = new JMenuBar();
		JMenuItem[] menuItem = new JMenuItem[7];
		String[] itemTitle = { "새로 만들기", "열기", "저장", "다른 이름으로 저장", "닫기", "적용", "변경" };

		JMenu title = new JMenu("Menu Bar");
		MenuActionListener listener = new MenuActionListener();
		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]); // 메뉴아이템 생성
			menuItem[i].addActionListener(listener); // 메뉴아이템에 액션 리스너 등록.
			title.add(menuItem[i]);// 메뉴 아이템을 스크린 메뉴에 삽입
			if (i == menuItem.length - 1)
				break;
			title.addSeparator();
		}
		bar.add(title); // 메뉴바에 스크린 메뉴 삽입.
		setJMenuBar(bar); // 메뉴바를 프레임에 부착.

	}

	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand(); // 사용자가 선택한 메뉴아이템의 문자열 리턴.
			switch (cmd) { // 메뉴 아이템의 종류 구분
			case "새로 만들기":
				if (imgLabel.getIcon() != null)
					return; // 이미 로딩 되이있으면 리턴.
				imgLabel.setIcon(new ImageIcon("image/Oz.jpg"));
				break;
			case "열기":
				imgLabel.setVisible(false);
				break;
			case "저장":
				imgLabel.setVisible(true);
				break;
			case "다른 이름으로 저장":
				imgLabel.setVisible(true);
				break;
			case "닫기":
				System.exit(0);
				break;
			case "적용":
				imgLabel.setVisible(true);
				break;
			case "변경":
				imgLabel.setVisible(true);
				break;
			}
		}
	}

	void crateTool() {
		JToolBar bar = new JToolBar();
		String[] itemTitle = { "새로 만들기", "열기", "저장", "다른 이름으로 저장", "닫기", "적용", "변경" };
		JButton[] barItem = new JButton[7];
		ToolActionListener listener = new ToolActionListener();
		for (int i = 0; i < barItem.length; i++) {
			barItem[i] = new JButton(itemTitle[i]); // 메뉴아이템 생성
			barItem[i].addActionListener(listener); // 메뉴아이템에 액션 리스너 등록.
			bar.add(barItem[i]);// 메뉴 아이템을 스크린 메뉴에 삽입
		}
		add(bar, BorderLayout.NORTH);
	}

	class ToolActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand(); // 사용자가 선택한 메뉴아이템의 문자열 리턴.
			switch (cmd) { // 메뉴 아이템의 종류 구분
			case "새로 만들기":
				if (imgLabel.getIcon() != null)
					return; // 이미 로딩 되이있으면 리턴.
				imgLabel.setIcon(new ImageIcon("image/Oz.jpg"));
				break;
			case "열기":
				imgLabel.setVisible(false);
				break;
			case "저장":
				imgLabel.setVisible(true);
				break;
			case "다른 이름으로 저장":
				imgLabel.setVisible(true);
				break;
			case "닫기":
				System.exit(0);
				break;
			case "적용":
				imgLabel.setVisible(true);
				break;
			case "변경":
				imgLabel.setVisible(true);
				break;
			}
		}
	}

	class RightPane extends JPanel {
		RightPane() {
			// setLayout(new FlowLayout(FlowLayout.CENTER));
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			Border border = BorderFactory.createLineBorder(Color.BLUE, 1);

			// setAlignmentX(CENTER_ALIGNMENT);
			JLabel la = new JLabel(" Attribute Pane ");
			la.setAlignmentX(CENTER_ALIGNMENT);
			la.setFont(new Font("Arial", Font.ITALIC, 20));
			la.setBorder(border);
			la.setOpaque(true);
			add(la);

			JButton bt = new JButton(" 변경 ");
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
//			field();
			 add(status,BorderLayout.EAST);
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
