package MindMap;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawEvent extends MouseAdapter implements MouseListener {
	static int flag = 0;
	boolean dragging = false;
	boolean select = false;
	boolean enter = false;
	final int PROX_DIST = 3;
	RightPane right;
	DrawNode node;
	Attribute value;
	DrawPane draw;
	int x, y, h, w;
	int xpos, ypos, index;

	DrawEvent(/* DrawNode item1, */Attribute item2, DrawPane item3) {
		// node = item1;
		value = item2;
		draw = item3;
	}

	public void mousePressed(MouseEvent e) {

		x = e.getX();
		y = e.getY();
		int index = 0;
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
		}
		System.out.println("DRAW >> "+draw.label[index].getText());
		if(enter){
		value.statusX.setText(Integer.toString(draw.label[index].getX()));
		value.statusY.setText(Integer.toString(draw.label[index].getY()));
		value.statusH.setText(Integer.toString(draw.label[index].getHeight()));
		value.statusW.setText(Integer.toString(draw.label[index].getWidth()));
		value.statusColor.setText(draw.color[index]);
		value.statusText.setText(draw.label[index].getText());
		}
		else{
			value.statusX.setText("");
			value.statusY.setText("");
			value.statusH.setText("");
			value.statusW.setText("");
			value.statusColor.setText("");
			value.statusText.setText("");
		}

	}

	public void mouseEntered(MouseEvent e) {
		for (int i = 0; i < draw.label.length; i++) {
			if (draw.label[i] == e.getSource()) {
				index = i;
				break;
			}
		}
		if (draw.label[index] == e.getSource())
			enter = true;
		else {
			enter = false;
		}
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {

		for (int i = 0; i < draw.label.length; i++) {
			if (draw.label[i] == e.getSource()) {
				index = i;
				break;
			}
		}
		System.out.println("Select >>" + select);
		h = draw.label[index].getHeight();
		w = draw.label[index].getWidth();
		int distanceX = e.getX() - x;
		int distanceY = e.getY() - y;

		xpos = draw.label[index].getX() + distanceX;
		ypos = draw.label[index].getY() + distanceY;

		value.statusX.setText(Integer.toString(draw.label[index].getX()));
		value.statusY.setText(Integer.toString(draw.label[index].getY()));
		value.statusH.setText(Integer.toString(draw.label[index].getHeight()));
		value.statusW.setText(Integer.toString(draw.label[index].getWidth()));
		value.statusColor.setText(draw.color[index]);
		value.statusText.setText(draw.label[index].getText());

		System.out.println(dragging);
		if (select) {

			int type = draw.getCursor().getType();

			switch (type) {
			case Cursor.DEFAULT_CURSOR:
				draw.label[index].setLocation(draw.label[index].getX() + distanceX,
						draw.label[index].getY() + distanceY);
				break;
			case Cursor.N_RESIZE_CURSOR:
				if (e.getY() < 2) {
					draw.label[index].setBounds(draw.label[index].getX(), draw.label[index].getY() - 1,
							draw.label[index].getWidth(), draw.label[index].getHeight() + 1);
				} else {
					draw.label[index].setBounds(draw.label[index].getX(), draw.label[index].getY() + 1,
							draw.label[index].getWidth(), draw.label[index].getHeight() - 1);
				}
				break;
			case Cursor.NW_RESIZE_CURSOR:
				if (e.getY() < 2 && e.getX() < 2) {
					draw.label[index].setBounds(draw.label[index].getX() - 1, draw.label[index].getY() - 1,
							draw.label[index].getWidth() + 1, draw.label[index].getHeight() + 1);

				} else {
					draw.label[index].setBounds(draw.label[index].getX() + 1, draw.label[index].getY() + 1,
							draw.label[index].getWidth() - 1, draw.label[index].getHeight() - 1);
				}
				break;
			case Cursor.W_RESIZE_CURSOR:
				if (e.getX() < 3) {
					draw.label[index].setBounds(draw.label[index].getX() - 1, draw.label[index].getY(),
							draw.label[index].getWidth() + 1, draw.label[index].getHeight());
				} else {
					draw.label[index].setBounds(draw.label[index].getX() + 1, draw.label[index].getY(),
							draw.label[index].getWidth() - 1, draw.label[index].getHeight());
				}
				break;
			case Cursor.SW_RESIZE_CURSOR:
				if (e.getX() < 3 && e.getY() > draw.label[index].getHeight() - 3) {
					draw.label[index].setBounds(draw.label[index].getX() - 1, draw.label[index].getY(),
							draw.label[index].getWidth() + 1, draw.label[index].getHeight() + 1);
				} else {
					draw.label[index].setBounds(draw.label[index].getX() + 1, draw.label[index].getY(),
							draw.label[index].getWidth() - 1, draw.label[index].getHeight() - 1);
				}
				break;
			case Cursor.S_RESIZE_CURSOR:
				if (e.getY() > draw.label[index].getHeight() - 3) {
					draw.label[index].setBounds(draw.label[index].getX(), draw.label[index].getY(),
							draw.label[index].getWidth(), draw.label[index].getHeight() + 1);
				} else {
					draw.label[index].setBounds(draw.label[index].getX(), draw.label[index].getY(),
							draw.label[index].getWidth(), draw.label[index].getHeight() - 1);
				}
				break;
			case Cursor.SE_RESIZE_CURSOR:
				if (e.getX() > draw.label[index].getWidth() - 3 && e.getY() > draw.label[index].getHeight() - 3) {
					draw.label[index].setBounds(draw.label[index].getX(), draw.label[index].getY(),
							draw.label[index].getWidth() + 1, draw.label[index].getHeight() + 1);
				} else {
					draw.label[index].setBounds(draw.label[index].getX(), draw.label[index].getY(),
							draw.label[index].getWidth() - 1, draw.label[index].getHeight() - 1);
				}
				break;
			case Cursor.E_RESIZE_CURSOR:
				if (e.getX() > draw.label[index].getWidth() - 3) {
					draw.label[index].setBounds(draw.label[index].getX(), draw.label[index].getY(),
							draw.label[index].getWidth() + 1, draw.label[index].getHeight());
				} else {
					draw.label[index].setBounds(draw.label[index].getX(), draw.label[index].getY(),
							draw.label[index].getWidth() - 1, draw.label[index].getHeight());
				}
				break;
			case Cursor.NE_RESIZE_CURSOR:
				if (e.getX() > draw.label[index].getWidth() - 3 && e.getY() < 3) {
					draw.label[index].setBounds(draw.label[index].getX(), draw.label[index].getY() - 1,
							draw.label[index].getWidth() + 1, draw.label[index].getHeight() + 1);
				} else {
					draw.label[index].setBounds(draw.label[index].getX(), draw.label[index].getY() + 1,
							draw.label[index].getWidth() - 1, draw.label[index].getHeight() - 1);
				}
				break;
			default:
				System.out.println("unexpected type: " + type);
			}
			draw.repaint();
		}
	}

	public void mouseMoved(MouseEvent e) {

		int index = 0;
		for (int i = 0; i < draw.label.length; i++) {
			if (draw.label[i] == e.getSource()) {
				index = i;
				break;
			}
		}

		if (enter) {

			if (e.getX() < 4 && e.getY() < 4) {
				draw.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
			} else if (e.getX() != 0 && e.getY() < 3) {
				draw.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
			} else if (e.getX() > draw.label[index].getWidth() - 4 && e.getY() < 4) {
				draw.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
			} else if (e.getX() > draw.label[index].getWidth() - 3 && e.getY() > 3
					&& e.getY() < draw.label[index].getHeight() - 3) {
				draw.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
			} else if (e.getY() > draw.label[index].getHeight() - 4 && e.getX() > draw.label[index].getWidth() - 4) {
				draw.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
			} else if (e.getX() != 0 && e.getY() > draw.label[index].getHeight() - 3) {
				draw.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
			} else if (e.getX() < 4 && e.getY() > draw.label[index].getHeight() - 4) {
				draw.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
			} else if (e.getX() < 3 && e.getY() != 0) {
				draw.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
			} else
				draw.setCursor(Cursor.getDefaultCursor());
		}
		if (!enter)
			draw.setCursor(Cursor.getDefaultCursor());
	}
}
