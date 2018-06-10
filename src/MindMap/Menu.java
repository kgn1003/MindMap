package MindMap;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JPanel{
	JMenuBar bar = new JMenuBar();
	JMenuItem[] menuItem = new JMenuItem[7];
	String[] itemTitle = { "���� �����", "����", "����", "�ٸ� �̸����� ����", "�ݱ�", "����", "����" };

	Menu(LeftPane item1,JMain item2,DrawPane item3,Attribute item4){
		JMenu title = new JMenu("Menu Bar");
		MenuToolEvent listener = new MenuToolEvent(item1,item2,item3,item4);
		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]); // �޴������� ����
			menuItem[i].addActionListener(listener); // �޴������ۿ� �׼� ������ ���.
			title.add(menuItem[i]);// �޴� �������� ��ũ�� �޴��� ����
			if (i == menuItem.length - 1)
				break;
			title.addSeparator();
		}
		bar.add(title); // �޴��ٿ� ��ũ�� �޴� ����.
	}
}
