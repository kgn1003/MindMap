package MindMap;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class MenuToolEvent implements ActionListener {
	static int flag = 0;
	static String content = "";
	FileDialog mSave;
	FileDialog mOpen;
	LeftPane text;
	
	
	Attribute set;
	
	
	JMain mind;

	MenuToolEvent(LeftPane item1, JMain item2) {
		text = item1;
		mind = item2;
//		set = item3;
		mSave = new FileDialog(mind, "저장", FileDialog.SAVE);
		mOpen = new FileDialog(mind, "열기", FileDialog.LOAD);
	}

	public void actionPerformed(ActionEvent e) {

		String data;
		String cmd = e.getActionCommand(); // 사용자가 선택한 메뉴아이템의 문자열 리턴.
		System.out.println(cmd);
		switch (cmd) { // 메뉴 아이템의 종류 구분
		case "새로 만들기":
			text.data.setText(content);
			mind.setTitle("Mind Map");
			flag = 0;
			mind.setBounds(100, 100, 1000, 500);
			break;
		case "열기":
			mOpen.setVisible(true);
			data = mOpen.getDirectory() + mOpen.getFile();
			System.out.println("load");
			try {
				String str = "";
				FileReader fr = new FileReader(data);
				BufferedReader br = new BufferedReader(fr);

				text.data.setText(""); // 일단 초기화
				while ((str = br.readLine()) != null) { // str에 남아둔 내용이 null 이
														// 아니면..

					text.data.append(str); // str의 내용을 추가
					text.data.append("\r\n"); // readline은 개행을 못하니 개행까지 직접해준다.
				}

				br.close();
				String Filename = mOpen.getFile();
				mind.setTitle(Filename);
				flag = 1;
			} catch (Exception e1) {
			}
			break;
		case "저장":
			System.out.println("save");
			if (flag == 0) {
				mSave.setVisible(true);
				data = mSave.getDirectory() + mSave.getFile(); // 파일의 디렉토리 정보와
																// 파일명을 얻는다.
				try {
					FileWriter fw = new FileWriter(data + ".txt"); // txt파일로
																	// 저장한다.
					BufferedWriter bw = new BufferedWriter(fw);

					String str = text.data.getText();
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) == '\n') {
							System.out.println("find");
							bw.newLine();
						} else
							bw.write(str.charAt(i)); // Textarea 에 bw객체에 있는 내용을
														// 넣는다.
					}

					bw.close();
					String Filename = mSave.getFile(); // 저장할 파일의 이름을 넣고..
					mind.setTitle(Filename + ".txt"); // 프레임 명을 파일명으로 바꾼다..
				} catch (Exception e1) {

				}
				flag = 1;
			}

			else if (flag == 1) {
				data = mSave.getDirectory() + mSave.getFile(); // 파일의 디렉토리 정보와
																// 파일명을 얻는다.

				try {
					FileWriter fw = new FileWriter(data + ".txt"); // txt파일로
																	// 저장한다.
					BufferedWriter bw = new BufferedWriter(fw);

					String str = text.data.getText();
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) == '\n') {
							System.out.println("find");
							bw.newLine();
						} else
							bw.write(str.charAt(i)); // Textarea 에 bw객체에 있는 내용을
														// 넣는다.
					}
					bw.close();
				} catch (Exception e2) {

				}

			}
			break;
		//
		case "다른 이름으로 저장":
			mSave.setVisible(true);
			data = mSave.getDirectory() + mSave.getFile(); // 파일의 디렉토리 정보와 파일명을
															// 얻는다.
			try {
				FileWriter fw = new FileWriter(data + ".text"); // txt파일로 저장한다.
				BufferedWriter bw = new BufferedWriter(fw);

				String str = text.data.getText();
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '\n') {
						System.out.println("find");
						bw.newLine();

					} else
						bw.write(str.charAt(i)); // Textarea 에 bw객체에 있는 내용을 넣는다.
				}

				bw.close();
				String Filename = mSave.getFile(); // 저장할 파일의 이름을 넣고,
				mind.setTitle(Filename + ".txt"); // 프레임 명을 파일명으로 바꾼다.
			} catch (Exception e1) {

			}
			break;
		case "닫기":
			System.exit(0);
			break;
		case "적용":
			// imgLabel.setVisible(true);
			break;
		case "변경":
//			set.statusText.setText(set.statusText.getText());
//			set.statusX.setText(set.statusX.getText());
//			set.statusX.getText();
//			set.statusY.setText(set.statusY.getText());
//			set.statusH.setText(set.statusH.getText());
//			set.statusW.setText(set.statusW.getText());
//			set.statusColor.setText(set.statusColor.getText());
			break;
		}
	}

}
