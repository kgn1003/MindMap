package MindMap;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JPanel{
	JMenuBar bar = new JMenuBar();
	JMenuItem[] menuItem = new JMenuItem[7];
	String[] itemTitle = { "새로 만들기", "열기", "저장", "다른 이름으로 저장", "닫기", "적용", "변경" };
	
	Menu(){
		JMenu title = new JMenu("Menu Bar");
		// MenuActionListener listener = new MenuActionListener();
		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]); // 메뉴아이템 생성
			// menuItem[i].addActionListener(listener); // 메뉴아이템에 액션 리스너 등록.
//			menuItem[i].addActionListener(this);
			title.add(menuItem[i]);// 메뉴 아이템을 스크린 메뉴에 삽입
			if (i == menuItem.length - 1)
				break;
			title.addSeparator();
		}
		bar.add(title); // 메뉴바에 스크린 메뉴 삽입.
//		setJMenuBar(bar); // 메뉴바를 프레임에 부착.
	}
	public static void main(String[] args){
		new Menu();
	}
}
