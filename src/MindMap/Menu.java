package MindMap;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JPanel{
	JMenuBar bar = new JMenuBar();
	JMenuItem[] menuItem = new JMenuItem[7];
	String[] itemTitle = { "���� �����", "����", "����", "�ٸ� �̸����� ����", "�ݱ�", "����", "����" };
	
	Menu(){
		JMenu title = new JMenu("Menu Bar");
		// MenuActionListener listener = new MenuActionListener();
		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]); // �޴������� ����
			// menuItem[i].addActionListener(listener); // �޴������ۿ� �׼� ������ ���.
//			menuItem[i].addActionListener(this);
			title.add(menuItem[i]);// �޴� �������� ��ũ�� �޴��� ����
			if (i == menuItem.length - 1)
				break;
			title.addSeparator();
		}
		bar.add(title); // �޴��ٿ� ��ũ�� �޴� ����.
//		setJMenuBar(bar); // �޴��ٸ� �����ӿ� ����.
	}
	public static void main(String[] args){
		new Menu();
	}
}
