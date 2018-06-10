package MindMap;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;

public class Toolbar extends JPanel{
	JToolBar bar = new JToolBar();
	String[] itemTitle = { "���� �����", "����", "����", "�ٸ� �̸����� ����", "�ݱ�", "����", "����" };
	JButton[] barItem = new JButton[7];
	Toolbar(LeftPane item1,JMain item2,DrawPane item3,Attribute item4){
		setLayout(new FlowLayout(FlowLayout.LEFT));
//		this.setBackground(Color.GREEN);
		bar.setBorder(new EmptyBorder(new Insets(0,0,0,0)));
		MenuToolEvent listener = new MenuToolEvent(item1,item2,item3,item4);
		for (int i = 0; i < barItem.length; i++) {
			barItem[i] = new JButton(itemTitle[i]); // �޴������� ����
			barItem[i].addActionListener(listener); // �޴������ۿ� �׼� ������ ���.
			bar.add(barItem[i]);// �޴� �������� ��ũ�� �޴��� ����
		}
		add(bar, BorderLayout.NORTH);
		setVisible(true);
	}

}
