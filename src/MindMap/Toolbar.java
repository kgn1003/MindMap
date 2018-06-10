package MindMap;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;

public class Toolbar extends JPanel{
	JToolBar bar = new JToolBar();
	String[] itemTitle = { "새로 만들기", "열기", "저장", "다른 이름으로 저장", "닫기", "적용", "변경" };
	JButton[] barItem = new JButton[7];
	Toolbar(LeftPane item1,JMain item2,DrawPane item3,Attribute item4){
		setLayout(new FlowLayout(FlowLayout.LEFT));
//		this.setBackground(Color.GREEN);
		bar.setBorder(new EmptyBorder(new Insets(0,0,0,0)));
		MenuToolEvent listener = new MenuToolEvent(item1,item2,item3,item4);
		for (int i = 0; i < barItem.length; i++) {
			barItem[i] = new JButton(itemTitle[i]); // 메뉴아이템 생성
			barItem[i].addActionListener(listener); // 메뉴아이템에 액션 리스너 등록.
			bar.add(barItem[i]);// 메뉴 아이템을 스크린 메뉴에 삽입
		}
		add(bar, BorderLayout.NORTH);
		setVisible(true);
	}

}
