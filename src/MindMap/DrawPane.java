package MindMap;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.colorchooser.ColorChooserComponentFactory;


public class DrawPane extends JPanel{
	JLabel[] label = new JLabel[3];
	Rectangle[] rect = new Rectangle[3];
	String[] title = {"icon1","icon2","icon3"};
	String c ;
	String test;
	JColorChooser color;
	
//    public void paintComponent(Graphics g) {
////      super.paintComponent(g);
//      Graphics2D g2 = (Graphics2D)g;
////      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
////                          RenderingHints.VALUE_ANTIALIAS_ON);
////      for(int i = 0; i <)
//      
//      g2.setPaint(Color.blue);
//      g2.draw(rect);
//
//  }
//	public void draw(Graphics g){
//		super.paintComponent(g);
//        g.drawRect(100, 100, 200, 100);
//        g.setColor(Color.BLUE);
//	}
	DrawPane(RightPane item1,Attribute item2,CenterPane item3){
		setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.black, 3);
		DrawEvent drawing = new DrawEvent(item2,this);
		this.addMouseListener(drawing);
		
		this.addMouseMotionListener(drawing);
		for(int i = 0 ; i < label.length; i++){
			label[i] = new JLabel(title[i],JLabel.CENTER);

			label[i].setFont(new Font("Label", Font.BOLD, 15));
			label[i].setSize(60,30);
			label[i].setLocation(100 + (i*50), 100 + (i*50));		
			label[i].setBackground(Color.white);
			label[i].setForeground(Color.black);
			label[i].setOpaque(true);
			label[i].setBorder(border);
		}
		int r = label[0].getBackground().getRed();
		int g = label[0].getBackground().getGreen();
		int b = label[0].getBackground().getBlue();
		c = Integer.toHexString(r+g+b);
		System.out.println(c);
//		color = new JColorChooser(label[0].getBackground());
//		System.out.println(color.toString());
		for(int i = 0; i < label.length; i++){
//			this.addMouseListener(drawing);
//			this.addMouseMotionListener(drawing);
			label[i].addMouseMotionListener(drawing);
			label[i].addMouseListener(drawing);
//			label[i].setOpaque(true);
			add(label[i]);
		}

		setVisible(true);
//		DrawNode xxxx = new DrawNode(this);
	
	}
	
		
	
}
