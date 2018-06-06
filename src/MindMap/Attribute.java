package MindMap;
import java.awt.*;
import javax.swing.*;
public class Attribute extends JPanel{
	JLabel text;
	JLabel x;
	JLabel y;
	JLabel h;
	JLabel w;
	JLabel color;
	JTextField field;
	
	Attribute(){
		setLayout(new GridLayout(6,1,10,0));
//		AttributePane ap = new AttributePane();
//		RightButton b = new RightButton();
		Text(); X(); Y(); H(); W(); Color();
		setVisible(true);
	}
	void Text(){
//		setLayout(new GridLayout(1,2));
		text = new JLabel("Text");
		text.setFont(new Font("a", Font.PLAIN, 20));
		field = new JTextField(7);
		add(text);add(field);
		setVisible(true);
	}
	void X(){
//		setLayout(new GridLayout(1,2));
		x = new JLabel("X");
		x.setFont(new Font("a", Font.PLAIN, 20));
		field = new JTextField(7);
		add(x);add(field);
		setVisible(true);
	}
	void Y(){
//		setLayout(new GridLayout(1,2));
		y = new JLabel("Y");
		y.setFont(new Font("a", Font.PLAIN, 20));
		field = new JTextField(7);
		add(y);add(field);
		setVisible(true);
	}
	void H(){
//		setLayout(new GridLayout(1,2));
		h = new JLabel("H");
		h.setFont(new Font("a", Font.PLAIN, 20));
		field = new JTextField(7);
		add(h);add(field);
		setVisible(true);
	}
	void W(){
//		setLayout(new GridLayout(1,2));
		w = new JLabel("W");
		w.setFont(new Font("a", Font.PLAIN, 20));
		field = new JTextField(7);
		add(w);add(field);
		setVisible(true);
	}
	void Color(){
//		setLayout(new GridLayout(1,2));
		color = new JLabel("Color");
		color.setFont(new Font("a", Font.PLAIN, 20));
		field = new JTextField(7);
		add(color);add(field);
		setVisible(true);
	}
	public static void main(String[] args){
		new Attribute();
	}
}
