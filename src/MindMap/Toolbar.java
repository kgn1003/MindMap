package MindMap;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Toolbar extends JPanel{
	JToolBar bar = new JToolBar();
	String[] itemTitle = { "���� �����", "����", "����", "�ٸ� �̸����� ����", "�ݱ�", "����", "����" };
	JButton[] barItem = new JButton[7];
	Toolbar(){
		for (int i = 0; i < barItem.length; i++) {
			barItem[i] = new JButton(itemTitle[i]); // �޴������� ����
			// barItem[i].addActionListener(listener); // �޴������ۿ� �׼� ������ ���.
//			barItem[i].addActionListener(this);
			bar.add(barItem[i]);// �޴� �������� ��ũ�� �޴��� ����
		}
		add(bar, BorderLayout.NORTH);
		setVisible(true);
	}
	public static void main(String[] args){
		new Toolbar();
	}
}
