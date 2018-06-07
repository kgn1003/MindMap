package MindMap;
import java.awt.*;
import javax.swing.*;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;

public class Attribute extends JPanel{
	
	
	JTextField statusText, statusX,statusY,statusH,statusW,statusColor;
	
	Attribute(){
		setLayout(new GridLayout(6,1,0,15));
		Text(); X(); Y(); H(); W(); Color();
		this.setBackground(Color.cyan);
		setVisible(true);
	}
	void Text(){
		JLabel text = new JLabel("Text");
		text.setFont(new Font("a", Font.PLAIN, 30));
		statusText = new JTextField();
		statusText.setForeground(Color.red);
		statusText.setFont(new Font("s",Font.BOLD,20));
		statusText.setBackground(Color.LIGHT_GRAY);
		add(text);add(statusText);
		setVisible(true);
	}
	void X(){
		JLabel x = new JLabel("X");
		x.setFont(new Font("a", Font.PLAIN, 30));
		statusX = new JTextField(7);
		add(x);add(statusX);
		setVisible(true);
	}
	void Y(){
		JLabel y = new JLabel("Y");
		y.setFont(new Font("a", Font.PLAIN, 30));
		statusY = new JTextField(7);
		add(y);add(statusY);
		setVisible(true);
	}
	void H(){
		JLabel h = new JLabel("H");
		h.setFont(new Font("a", Font.PLAIN, 30));
		statusH = new JTextField(7);
		add(h);add(statusH);
		setVisible(true);
	}
	void W(){
		JLabel w = new JLabel("W");
		w.setFont(new Font("a", Font.PLAIN, 30));
		statusW = new JTextField(7);
		add(w);add(statusW);
		setVisible(true);
	}
	void Color(){
		JLabel color = new JLabel("Color");
		color.setFont(new Font("a", Font.PLAIN, 30));
		statusColor = new JTextField(7);
		add(color);add(statusColor);
		setVisible(true);
	}
	public static void main(String[] args){
		new Attribute();
	}
}
