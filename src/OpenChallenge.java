import javax.swing.*;
import java.awt.*;
class NorthPanel extends JPanel{
	NorthPanel(){
		
		//JPanel p = new JPanel();
		setBackground(Color.gray);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(new JButton("Open"));
		add(new JButton("Read"));
		add(new JButton("Close"));
	}
}
class CenterPanel extends JPanel{
	CenterPanel(){
		//JPanel p = new JPanel();
		setLayout(null);
		JLabel l = new JLabel("Java");
		l.setLocation(200, 100);
		l.setSize(100, 20);
		add(l);
	}
}
public class OpenChallenge extends JFrame{
	OpenChallenge(){
		setTitle("Open Challenge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		NorthPanel north = new NorthPanel();
		add(north,BorderLayout.NORTH);
		CenterPanel center = new CenterPanel();
		contentPane.add(center,BorderLayout.CENTER);

		setSize(400,200);
		setVisible(true);
	}
	public static void main(String[] args){
		new OpenChallenge();
	}
}
