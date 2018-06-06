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
		setLayout(new GridLayout(6,1,0,15));
		Text(); X(); Y(); H(); W(); Color();
		this.setBackground(Color.cyan);
		setVisible(true);
	}
	void Text(){
		text = new JLabel("Text");
		text.setFont(new Font("a", Font.PLAIN, 30));
		field = new JTextField();
		field.setBackground(Color.LIGHT_GRAY);
		add(text);add(field);
		setVisible(true);
	}
	void X(){
		x = new JLabel("X");
		x.setFont(new Font("a", Font.PLAIN, 30));
		field = new JTextField(7);
		add(x);add(field);
		setVisible(true);
	}
	void Y(){
		y = new JLabel("Y");
		y.setFont(new Font("a", Font.PLAIN, 30));
		field = new JTextField(7);
		add(y);add(field);
		setVisible(true);
	}
	void H(){
		h = new JLabel("H");
		h.setFont(new Font("a", Font.PLAIN, 30));
		field = new JTextField(7);
		add(h);add(field);
		setVisible(true);
	}
	void W(){
		w = new JLabel("W");
		w.setFont(new Font("a", Font.PLAIN, 30));
		field = new JTextField(7);
		add(w);add(field);
		setVisible(true);
	}
	void Color(){
		color = new JLabel("Color");
		color.setFont(new Font("a", Font.PLAIN, 30));
		field = new JTextField(7);
		add(color);add(field);
		setVisible(true);
	}
	public static void main(String[] args){
		new Attribute();
	}
}
