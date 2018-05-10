import javax.swing.*;
import java.awt.*;
public class Quiz2 extends JFrame{
	Quiz2(){
		setTitle("BorderLayout Practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(5,7));
		add(new JButton("North"),BorderLayout.NORTH);
		add(new JButton("Center"),BorderLayout.CENTER);
		add(new JButton("West"),BorderLayout.WEST);
		add(new JButton("East"),BorderLayout.EAST);
		add(new JButton("South"),BorderLayout.SOUTH);
		
		setSize(400,200);
		setVisible(true);
	}
	public static void main(String[] args){
		new Quiz2();
	}
}