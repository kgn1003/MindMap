package MindMap;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class MenuToolEvent extends MouseAdapter implements ActionListener {
	static int flag = 0;
	static String content = "";
	FileDialog mSave;
	FileDialog mOpen;
	LeftPane text;
	Attribute set;
	
	DrawPane draw;
	
	
	JMain mind;
	boolean dragging = false;
	boolean select = false;
	boolean enter = false;
	int x,y,index;
	
	
	MenuToolEvent(LeftPane item1, JMain item2,DrawPane item3,Attribute item4) {
		text = item1;
		mind = item2;
		draw = item3;
		set = item4;
		mSave = new FileDialog(mind, "����", FileDialog.SAVE);
		mOpen = new FileDialog(mind, "����", FileDialog.LOAD);
	}
	public void mousePressed(MouseEvent e) {

		x = e.getX();
		y = e.getY();

		for (int i = 0; i < draw.label.length; i++) {
			if (draw.label[i] == e.getSource()) {
				index = i;
				// select = true;
				break;
			}
		}
		if (draw.label[index] == e.getSource())
			select = true;
		else {
			select = false;
		}

		if (draw.getCursor() != Cursor.getDefaultCursor()) { // draw.getCursor()
			// If cursor is set for Test, allow dragging.
			dragging = true;
		}
		System.out.println(draw.getCursor());
	}
	public void mouseReleased(MouseEvent e) {
		dragging = false;
	}
	public void mouseClicked(MouseEvent e) {
		// int index = 0;

		for (int i = 0; i < draw.label.length; i++) {
			if (draw.label[i] == e.getSource()) {
				index = i;
				break;
			}
			System.out.println("Button >> "+draw.label[index].getText());
		}
	}
	int IndexOfLabel(int i){
		return i;
	}

	public void actionPerformed(ActionEvent e) {
//		int index;
		String data;
		
		String cmd = e.getActionCommand(); // ����ڰ� ������ �޴��������� ���ڿ� ����.
		System.out.println(cmd);
		switch (cmd) { // �޴� �������� ���� ����
		case "���� �����":
			text.data.setText(content);
			mind.setTitle("Mind Map");
			flag = 0;
			mind.setBounds(100, 100, 1000, 500);
			break;
		case "����":
			mOpen.setVisible(true);
			data = mOpen.getDirectory() + mOpen.getFile();
			System.out.println("load");
			try {
				String str = "";
				FileReader fr = new FileReader(data);
				BufferedReader br = new BufferedReader(fr);

				text.data.setText(""); // �ϴ� �ʱ�ȭ
				while ((str = br.readLine()) != null) { // str�� ���Ƶ� ������ null ��
														// �ƴϸ�..

					text.data.append(str); // str�� ������ �߰�
					text.data.append("\r\n"); // readline�� ������ ���ϴ� ������� �������ش�.
				}

				br.close();
				String Filename = mOpen.getFile();
				mind.setTitle(Filename);
				flag = 1;
			} catch (Exception e1) {
			}
			break;
		case "����":
			System.out.println("save");
			if (flag == 0) {
				mSave.setVisible(true);
				data = mSave.getDirectory() + mSave.getFile(); // ������ ���丮 ������
																// ���ϸ��� ��´�.
				try {
					FileWriter fw = new FileWriter(data + ".txt"); // txt���Ϸ�
																	// �����Ѵ�.
					BufferedWriter bw = new BufferedWriter(fw);

					String str = text.data.getText();
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) == '\n') {
							System.out.println("find");
							bw.newLine();
						} else
							bw.write(str.charAt(i)); // Textarea �� bw��ü�� �ִ� ������
														// �ִ´�.
					}

					bw.close();
					String Filename = mSave.getFile(); // ������ ������ �̸��� �ְ�..
					mind.setTitle(Filename + ".txt"); // ������ ���� ���ϸ����� �ٲ۴�..
				} catch (Exception e1) {

				}
				flag = 1;
			}

			else if (flag == 1) {
				data = mSave.getDirectory() + mSave.getFile(); // ������ ���丮 ������
																// ���ϸ��� ��´�.

				try {
					FileWriter fw = new FileWriter(data + ".txt"); // txt���Ϸ�
																	// �����Ѵ�.
					BufferedWriter bw = new BufferedWriter(fw);

					String str = text.data.getText();
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) == '\n') {
							System.out.println("find");
							bw.newLine();
						} else
							bw.write(str.charAt(i)); // Textarea �� bw��ü�� �ִ� ������
														// �ִ´�.
					}
					bw.close();
				} catch (Exception e2) {

				}

			}
			break;
		//
		case "�ٸ� �̸����� ����":
			mSave.setVisible(true);
			data = mSave.getDirectory() + mSave.getFile(); // ������ ���丮 ������ ���ϸ���
															// ��´�.
			try {
				FileWriter fw = new FileWriter(data + ".text"); // txt���Ϸ� �����Ѵ�.
				BufferedWriter bw = new BufferedWriter(fw);

				String str = text.data.getText();
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '\n') {
						System.out.println("find");
						bw.newLine();

					} else
						bw.write(str.charAt(i)); // Textarea �� bw��ü�� �ִ� ������ �ִ´�.
				}

				bw.close();
				String Filename = mSave.getFile(); // ������ ������ �̸��� �ְ�,
				mind.setTitle(Filename + ".txt"); // ������ ���� ���ϸ����� �ٲ۴�.
			} catch (Exception e1) {

			}
			break;
		case "�ݱ�":
			System.exit(0);
			break;
		case "����":
			// imgLabel.setVisible(true);
			break;
		case "����":
////			int index = 0;
//			for (int i = 0; i < draw.label.length; i++) {
//				if (draw.label[i] == e.getSource()) {
//					System.out.println(draw.label[i].getText());
//					index = i;
//					break;
//				}
//			}
			System.out.println(draw.label[index].getText());
//			draw.color[index] = set.statusColor.getText();
//			draw.label[index].setBackground(Color.decode(draw.color[index]));
//			System.out.println(draw.label[index].getText());
//			draw.label[index].setBackground(Color.decode(set.statusColor.getText()));
			break;
		}
	}

}
