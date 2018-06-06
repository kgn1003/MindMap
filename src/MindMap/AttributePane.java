package MindMap;
import java.awt.*;
import javax.swing.*;

public class AttributePane extends JPanel{
	AttributePane(){
//		setLayout(new BorderLayout());
		JLabel label = new JLabel("Attribute Pane");
		label.setFont(new Font("a", Font.PLAIN, 20));
		add(label,new FlowLayout(FlowLayout.CENTER));
		setVisible(true);
	}
	public static void main(String[] args){
		new AttributePane();
	}
}
