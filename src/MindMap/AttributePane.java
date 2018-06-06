package MindMap;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class AttributePane extends JPanel{
	AttributePane(){
		setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel label = new JLabel("Attribute Pane");
		label.setFont(new Font("a", Font.PLAIN, 30));
		label.setForeground(Color.white);
		this.setOpaque(false);
		add(label,new FlowLayout(FlowLayout.CENTER));
		setVisible(true);
	}
	public static void main(String[] args){
		new AttributePane();
	}
}
