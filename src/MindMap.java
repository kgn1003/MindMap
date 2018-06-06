import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;
import javax.swing.border.Border;

//class LeftPane extends JPanel {
//	JLabel label;
//	int xpos, ypos, count = 0;
//
//	LeftPane() {
//		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		JLabel la = new JLabel(" Mind Map Pane ");
//		// la.setAlignmentY(TOP_ALIGNMENT);
//		la.setAlignmentX(CENTER_ALIGNMENT);
//		Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
//		la.setFont(new Font("Arial", Font.ITALIC, 20));
//		la.setBorder(border);
//		la.setOpaque(true);
//
//		add(la);
//
////		ImageIcon icon = new ImageIcon("image/img.jpg");
//		label = new JLabel("Icon");
//		MyMouseListener listener = new MyMouseListener();
//		label.addMouseListener(listener);
//		label.addMouseMotionListener(listener);
//		label.setFont(new Font("Label",Font.BOLD,15));
//		label.setSize(20,20);
//		label.setBorder(border);
//		label.setLocation(100, 100);
//		add(label);
//		// setSize(300, 300);
//		setVisible(true);
//	}
//
//	// class MyMouseListener implements MouseListener {
//	//
//	// public void mousePressed(MouseEvent e) {
//	// System.out.println(1111);
//	// int x = e.getX();
//	// int y = e.getY();
//	// la.setLocation(x, y);
//	// xpos = x; ypos = y;
//	// System.out.println(2222);
//	// }
//	//
//	// public void mouseReleased(MouseEvent e) {
//	//
//	// }
//	//
//	// public void mouseClicked(MouseEvent e) {
//	// }
//	//
//	// public void mouseEntered(MouseEvent e) {
//	// }
//	//
//	// public void mouseExited(MouseEvent e) {
//	// }
//	// }
//	class MyMouseListener extends MouseAdapter {
//		int x, y;
//
//		public void mousePressed(MouseEvent e) {
//			x = e.getX();
//			y = e.getY();
//		}
//
//		public void mouseDragged(MouseEvent e) {
//			int distanceX = e.getX() - x;
//			int distanceY = e.getY() - y;
//			System.out.println(label.getX() + distanceX + "," + (label.getY() + distanceY));
//			label.setLocation(label.getX() + distanceX, label.getY() + distanceY);
//			xpos = label.getX() + distanceX;
//			ypos = label.getY() + distanceY;
//		}
//	}
//
//}

// class TextArea extends JPanel {
// JTextArea T = new JTextArea(7, 20);
//
// TextArea() {
// setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
// Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
// JLabel la = new JLabel(" Text Edit Pane ");
// JButton bt = new JButton(" 적용 ");
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
	FileDialog mSave = new FileDialog(this, "저장", FileDialog.SAVE);
	FileDialog mOpen = new FileDialog(this, "열기", FileDialog.LOAD);

	JSplitPane splitPane;
	JSplitPane splitPane2;
	JLabel imgLabel = new JLabel();

	JMenuBar bar = new JMenuBar();
	JMenuItem[] menuItem = new JMenuItem[7];
	String[] itemTitle = { "새로 만들기", "열기", "저장", "다른 이름으로 저장", "닫기", "적용", "변경" };

	JToolBar bar1 = new JToolBar();
	String[] itemTitle1 = { "새로 만들기", "열기", "저장", "다른 이름으로 저장", "닫기", "적용", "변경" };
	JButton[] barItem = new JButton[7];

	JTextArea T = new JTextArea(7, 20);
	JLabel[] label;
	JTextField statusX = new JTextField(10);
	JTextField statusY = new JTextField(10);
	JTextField statusH = new JTextField(10);
	JTextField statusW = new JTextField(10);
	JTextField textName = new JTextField(10);
	
	boolean dragging = false;
	final int PROX_DIST = 3;
	
	

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

		splitPane2.setContinuousLayout(true); // 연속적인 변화를 볼 수 있게 해준다.
		splitPane.setContinuousLayout(true);

		splitPane.setLeftComponent(new JScrollPane(ta));
		splitPane.setRightComponent(new JScrollPane(l));
		splitPane2.setLeftComponent(splitPane);
		splitPane2.setRightComponent(r);

//		splitPane2.getRightComponent().setPreferredSize(min);

		splitPane.setDividerSize(5);
		splitPane2.setDividerLocation(0.8);
		splitPane2.setDividerSize(5);
	}

	void createMenu() {
		// JMenuBar bar = new JMenuBar();
		// JMenuItem[] menuItem = new JMenuItem[7];
		// String[] itemTitle = { "새로 만들기", "열기", "저장", "다른 이름으로 저장", "닫기",
		// "적용", "변경" };

		JMenu title = new JMenu("Menu Bar");
		// MenuActionListener listener = new MenuActionListener();
		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]); // 메뉴아이템 생성
			// menuItem[i].addActionListener(listener); // 메뉴아이템에 액션 리스너 등록.
			menuItem[i].addActionListener(this);
			title.add(menuItem[i]);// 메뉴 아이템을 스크린 메뉴에 삽입
			if (i == menuItem.length - 1)
				break;
			title.addSeparator();
		}
		bar.add(title); // 메뉴바에 스크린 메뉴 삽입.
		setJMenuBar(bar); // 메뉴바를 프레임에 부착.

	}

	void crateTool() {
		// JToolBar bar = new JToolBar();
		// String[] itemTitle = { "새로 만들기", "열기", "저장", "다른 이름으로 저장", "닫기",
		// "적용", "변경" };
		// JButton[] barItem = new JButton[7];
		// ToolActionListener listener = new ToolActionListener();
		for (int i = 0; i < barItem.length; i++) {
			barItem[i] = new JButton(itemTitle1[i]); // 메뉴아이템 생성
			// barItem[i].addActionListener(listener); // 메뉴아이템에 액션 리스너 등록.
			barItem[i].addActionListener(this);
			bar1.add(barItem[i]);// 메뉴 아이템을 스크린 메뉴에 삽입
		}
		add(bar1, BorderLayout.NORTH);
	}

	class LeftPane extends JPanel {

		int xpos, ypos;

		LeftPane() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			JLabel la = new JLabel(" Mind Map Pane ");
			la.setAlignmentX(CENTER_ALIGNMENT);
			Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
			la.setFont(new Font("Arial", Font.ITALIC, 20));
			la.setBorder(border);
			la.setOpaque(true);

			add(la);
			label = new JLabel[3];
			label[0] = new JLabel("Icon 1");
			label[1] = new JLabel("Icon 2");
			label[2] = new JLabel("Icon 3");

			MyMouseListener listener = new MyMouseListener();
			
			for (int i = 0; i < label.length; i++) {
				label[i].addMouseMotionListener(listener);
				label[i].addMouseListener(listener);
				label[i].setFont(new Font("Label", Font.BOLD, 15));
				label[i].setSize(20, 20);
				label[i].setBorder(border);
				label[i].setLocation(100 + (i*30), 100 + (i*30));
				add(label[i],null);
			}
			setVisible(true);
		}

		class MyMouseListener extends MouseAdapter implements MouseListener {
			
			int x, y, h, w;

			public void mousePressed(MouseEvent e) {
				
				x = e.getX();
				y = e.getY();
				int index = 0;
				for (int i = 0; i < label.length; i++) {
					if (label[i] == e.getSource()) {
						index = i;
						break;
					}
				}
				 if(label[index].getCursor() != Cursor.getDefaultCursor()) {
			            // If cursor is set for Test, allow dragging.
			            dragging = true;
			        }
			}
				

			public void mouseReleased(MouseEvent e) {
				dragging = false;
			}

			public void mouseClicked(MouseEvent e) {
				int index = 0;
				for (int i = 0; i < label.length; i++) {
					if (label[i] == e.getSource()) {
						index = i;
						break;
					}
				}
				statusX.setText(Integer.toString(label[index].getX()));
				statusY.setText(Integer.toString(label[index].getY()));
				statusH.setText(Integer.toString(label[index].getHeight()));
				statusW.setText(Integer.toString(label[index].getWidth()));
				textName.setText(label[index].getText());
				
			
			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseDragged(MouseEvent e) {

				int index = 0;
				for (int i = 0; i < label.length; i++) {
					if (label[i] == e.getSource()) {
						index = i;
						break;
					}
				}
				h = label[index].getHeight();
				w = label[index].getWidth();
				int distanceX = e.getX() - x;
				int distanceY = e.getY() - y;
				System.out.println(label[index].getX() + distanceX + "," + (label[index].getY() + distanceY));
				label[index].setLocation(label[index].getX() + distanceX, label[index].getY() + distanceY);
				xpos = label[index].getX() + distanceX;
				ypos = label[index].getY() + distanceY;

				textName.setText(label[index].getText());
				statusX.setText(Integer.toString(xpos));
				statusY.setText(Integer.toString(ypos));
				statusH.setText(Integer.toString(h));
				statusW.setText(Integer.toString(w));
				
				if(dragging) {
		            Point p = e.getPoint();
		            
		            int type = label[index].getCursor().getType();
		            distanceX = e.getX() - x;
					distanceY = e.getY() - y;
		            switch(type) {
		                case Cursor.N_RESIZE_CURSOR:
		                    int height = label[index].getHeight() - distanceY;
		                     label[index].setBounds(label[index].getX(), label[index].getY()+distanceY, label[index].getWidth(), height);
		                    break;
		                case Cursor.NW_RESIZE_CURSOR:
		                    int width = label[index].getWidth() - distanceX;
		                    height = label[index].getHeight() - distanceY;
		                    label[index].setBounds(label[index].getX()+distanceX, label[index].getY()+distanceY, width, height);
		                    break;
		                case Cursor.W_RESIZE_CURSOR:
		                    width = label[index].getWidth() - distanceX;
		                    label[index].setBounds(label[index].getX()+distanceX, label[index].getY(), width, label[index].getHeight());
		                    break;
		                case Cursor.SW_RESIZE_CURSOR:
		                    width = label[index].getWidth() - distanceX;
		                    height = distanceY;
		                    label[index].setBounds(label[index].getX()+distanceX, label[index].getY(), width, height);
		                    break;
		                case Cursor.S_RESIZE_CURSOR:
		                    height = distanceY;
		                    label[index].setBounds(label[index].getX(), label[index].getY(), label[index].getWidth(), height);
		                    break;
		                case Cursor.SE_RESIZE_CURSOR:
		                    width = distanceX;
		                    height = distanceY;
		                    label[index].setBounds(label[index].getX(), label[index].getY(), width, height);
		                    break;
		                case Cursor.E_RESIZE_CURSOR:
		                    width = distanceX;
		                    label[index].setBounds(label[index].getX(), label[index].getY(), width, label[index].getHeight());
		                    break;
		                case Cursor.NE_RESIZE_CURSOR:
		                    width = distanceX;
		                    height = label[index].getHeight() - distanceY;
		                    label[index].setBounds(label[index].getX(), label[index].getY()+distanceY, width, height);
		                    break;
		                default:
		                    System.out.println("unexpected type: " + type);
		            }
		            label[index].repaint();
		        }
			}
		}
		public void mouseMoved(MouseEvent e) {
	        Point p = e.getPoint();
	        int index = 0;
			for (int i = 0; i < label.length; i++) {
				if (label[i] == e.getSource()) {
					index = i;
					break;
				}
			}
	        if(label == e.getSource()) {
	            if(label[index].getCursor() != Cursor.getDefaultCursor()) {
	                // If cursor is not over rect reset it to the default.
	            	label[index].setCursor(Cursor.getDefaultCursor());
	            }
	            return;
	        }
	        int outcode = getOutcode(p,e);
	        
	        switch(outcode) {
	            case Rectangle.OUT_TOP:
	                if(Math.abs(p.y - label[index].getY()) < PROX_DIST) {
	                    label[index].setCursor(Cursor.getPredefinedCursor(
	                                        Cursor.N_RESIZE_CURSOR));
	                }
	                break;
	            case Rectangle.OUT_TOP + Rectangle.OUT_LEFT:
	                if(Math.abs(p.y - label[index].getY()) < PROX_DIST &&
	                   Math.abs(p.x - label[index].getX()) < PROX_DIST) {
	                    label[index].setCursor(Cursor.getPredefinedCursor(
	                                        Cursor.NW_RESIZE_CURSOR));
	                }
	                break;
	            case Rectangle.OUT_LEFT:
	                if(Math.abs(p.x - label[index].getX()) < PROX_DIST) {
	                    label[index].setCursor(Cursor.getPredefinedCursor(
	                                        Cursor.W_RESIZE_CURSOR));
	                }
	                break;
	            case Rectangle.OUT_LEFT + Rectangle.OUT_BOTTOM:
	                if(Math.abs(p.x - label[index].getX()) < PROX_DIST &&
	                   Math.abs(p.y - (label[index].getY()+label[index].getHeight())) < PROX_DIST) {
	                    label[index].setCursor(Cursor.getPredefinedCursor(
	                                        Cursor.SW_RESIZE_CURSOR));
	                }
	                break;
	            case Rectangle.OUT_BOTTOM:
	                if(Math.abs(p.y - (label[index].getY()+label[index].getHeight())) < PROX_DIST) {
	                    label[index].setCursor(Cursor.getPredefinedCursor(
	                                        Cursor.S_RESIZE_CURSOR));
	                }
	                break;
	            case Rectangle.OUT_BOTTOM + Rectangle.OUT_RIGHT:
	                if(Math.abs(p.x - (label[index].getX()+label[index].getWidth())) < PROX_DIST &&
	                   Math.abs(p.y - (label[index].getY()+label[index].getHeight())) < PROX_DIST) {
	                    label[index].setCursor(Cursor.getPredefinedCursor(
	                                        Cursor.SE_RESIZE_CURSOR));
	                }
	                break;
	            case Rectangle.OUT_RIGHT:
	                if(Math.abs(p.x - (label[index].getX()+label[index].getWidth())) < PROX_DIST) {
	                    label[index].setCursor(Cursor.getPredefinedCursor(
	                                        Cursor.E_RESIZE_CURSOR));
	                }
	                break;
	            case Rectangle.OUT_RIGHT + Rectangle.OUT_TOP:
	                if(Math.abs(p.x - (label[index].getX()+label[index].getWidth())) < PROX_DIST &&
	                   Math.abs(p.y - label[index].getY()) < PROX_DIST) {
	                    label[index].setCursor(Cursor.getPredefinedCursor(
	                                        Cursor.NE_RESIZE_CURSOR));
	                }
	                break;
	            default:    // center
	                label[index].setCursor(Cursor.getDefaultCursor());
	        }
		}
		private boolean isOverRect(Point p, MouseEvent e) {
			int index = 0;
			for (int i = 0; i < label.length; i++) {
				if (label[i] == e.getSource()) {
					index = i;
					break;
				}
			}
	        Rectangle r = (Rectangle)label[index].bounds().clone();
	        r.grow(PROX_DIST, PROX_DIST);
	        return r.contains(p);
	    }
		private int getOutcode(Point p, MouseEvent e) {
			int index = 0;
			for (int i = 0; i < label.length; i++) {
				if (label[i] == e.getSource()) {
					index = i;
					break;
				}
			}
	        Rectangle r = (Rectangle)label[index].bounds().clone();
	        r.grow(-PROX_DIST, -PROX_DIST);
	        return r.outcode(p.x, p.y);        
	    }

	}
	

	public void actionPerformed(ActionEvent e) {

		String data;
		String cmd = e.getActionCommand(); // 사용자가 선택한 메뉴아이템의 문자열 리턴.
		switch (cmd) { // 메뉴 아이템의 종류 구분
		case "새로 만들기":
			T.setText(content);
			setTitle("Mind Map");
			flag = 0;
			setBounds(100, 100, 1000, 500);
			break;
		case "열기":
			mOpen.setVisible(true);
			data = mOpen.getDirectory() + mOpen.getFile();
			try {
				String str = "";
				FileReader fr = new FileReader(data);
				BufferedReader br = new BufferedReader(fr);

				T.setText(""); // 일단 초기화
				while ((str = br.readLine()) != null) { // str에 남아둔 내용이 null 이
														// 아니면..

					T.append(str); // str의 내용을 추가
					T.append("\r\n"); // readline은 개행을 못하니 개행까지 직접해준다.
				}

				br.close();
				String Filename = mOpen.getFile();
				setTitle(Filename);
				flag = 1;
			} catch (Exception e1) {
			}
			break;
		case "저장":
			if (flag == 0) {
				mSave.setVisible(true);
				data = mSave.getDirectory() + mSave.getFile(); // 파일의 디렉토리 정보와
																// 파일명을 얻는다.
				try {
					FileWriter fw = new FileWriter(data + ".txt"); // txt파일로
																	// 저장한다.
					BufferedWriter bw = new BufferedWriter(fw);

					String str = T.getText();
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) == '\n') {
							System.out.println("find");
							bw.newLine();
						} else
							bw.write(str.charAt(i)); // Textarea 에 bw객체에 있는 내용을
														// 넣는다.
					}

					bw.close();
					String Filename = mSave.getFile(); // 저장할 파일의 이름을 넣고..
					setTitle(Filename + ".txt"); // 프레임 명을 파일명으로 바꾼다..
				} catch (Exception e1) {

				}
				flag = 1;
			}

			else if (flag == 1) {
				data = mSave.getDirectory() + mSave.getFile(); // 파일의 디렉토리 정보와
																// 파일명을 얻는다.

				try {
					FileWriter fw = new FileWriter(data + ".txt"); // txt파일로
																	// 저장한다.
					BufferedWriter bw = new BufferedWriter(fw);

					String str = T.getText();
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) == '\n') {
							System.out.println("find");
							bw.newLine();
						} else
							bw.write(str.charAt(i)); // Textarea 에 bw객체에 있는 내용을
														// 넣는다.
					}
					bw.close();
				} catch (Exception e2) {

				}

			}

			break;
		case "다른 이름으로 저장":
			mSave.setVisible(true);
			data = mSave.getDirectory() + mSave.getFile(); // 파일의 디렉토리 정보와 파일명을
															// 얻는다.
			try {
				FileWriter fw = new FileWriter(data + ".text"); // txt파일로 저장한다.
				BufferedWriter bw = new BufferedWriter(fw);

				String str = T.getText();
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '\n') {
						System.out.println("find");
						bw.newLine();

					} else
						bw.write(str.charAt(i)); // Textarea 에 bw객체에 있는 내용을 넣는다.
				}

				bw.close();
				String Filename = mSave.getFile(); // 저장할 파일의 이름을 넣고,
				setTitle(Filename + ".txt"); // 프레임 명을 파일명으로 바꾼다.
			} catch (Exception e1) {

			}
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

	class TextArea extends JPanel {

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

			T.setToolTipText("\\t 를 통해서 구분을 주세요.");
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
			add(la, BorderLayout.NORTH);

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
			Colors c = new Colors();
			add(t);
			add(x);
			add(y);
			add(h);
			add(w);
			add(c);
			// Test t = new Test();
			// add(t);
			add(bt, BorderLayout.SOUTH);

			setVisible(true);
		}
	}


	class Text extends JPanel {
		Text() {
			// setLayout(new FlowLayout(FlowLayout.CENTER));
			JLabel text = new JLabel("Text : ");
			text.setFont(new Font("a", Font.PLAIN, 20));
			textName.setForeground(Color.red);
			textName.setBackground(Color.LIGHT_GRAY);
			// textName = new JTextField(10);
			add(text);
			add(textName);
			setVisible(true);
		}
	}

	class X extends JPanel {
		// JTextField status = new JTextField(10);

		X() {
			setLayout(new FlowLayout(FlowLayout.CENTER));
			JLabel xPos = new JLabel("X : ");
			xPos.setFont(new Font("a", Font.PLAIN, 20));
			// statusX.setText(Integer.toString(label[].getX()));
			// LeftPane pos = new LeftPane();
			// JTextField status = new JTextField(10);
			add(xPos);
			// field();
			add(statusX);
			setVisible(true);
		}

	}

	class Y extends JPanel {
		Y() {
			// String pos = Integer.toString(label.getX());
			// setLayout(new GridLayout(1,2,5,10));
			// setLayout(new FlowLayout(FlowLayout.CENTER));
			JLabel yPos = new JLabel("Y : ");
			yPos.setFont(new Font("a", Font.PLAIN, 20));
			// statusY.setText(Integer.toString(label.getY()));
			// JTextField statusY = new JTextField(10);
			add(yPos);
			add(statusY);
			setVisible(true);
		}
	}

	class H extends JPanel {
		H() {
			// setLayout(new FlowLayout(FlowLayout.CENTER));
			JLabel height = new JLabel("H : ");
			height.setFont(new Font("a", Font.PLAIN, 20));
			add(height);
			add(statusH);
			setVisible(true);
		}
	}

	class W extends JPanel {
		W() {
			// setLayout(new FlowLayout(FlowLayout.CENTER));
			JLabel width = new JLabel("W : ");
			width.setFont(new Font("a", Font.PLAIN, 20));
			add(width);
			add(statusW);
			setVisible(true);
		}

	}

	class Colors extends JPanel {
		Colors() {
			// setLayout(new GridLayout(1,2));
			JLabel color = new JLabel("Color : ");
			color.setFont(new Font("a", Font.PLAIN, 20));
			JTextField status = new JTextField(10);
			add(color);
			add(status);
			setVisible(true);
		}
	}

	public static void main(String[] args) {
		new MindMap();
	}
}
