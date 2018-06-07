package MindMap;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JPanel{
	JMenuBar bar = new JMenuBar();
	JMenuItem[] menuItem = new JMenuItem[7];
	String[] itemTitle = { "새로 만들기", "열기", "저장", "다른 이름으로 저장", "닫기", "적용", "변경" };

	Menu(LeftPane item1,JMain item2){
		JMenu title = new JMenu("Menu Bar");
		MenuToolEvent listener = new MenuToolEvent(item1,item2);
		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]); // 메뉴아이템 생성
			menuItem[i].addActionListener(listener); // 메뉴아이템에 액션 리스너 등록.
			title.add(menuItem[i]);// 메뉴 아이템을 스크린 메뉴에 삽입
			if (i == menuItem.length - 1)
				break;
			title.addSeparator();
		}
		bar.add(title); // 메뉴바에 스크린 메뉴 삽입.
	}
}
