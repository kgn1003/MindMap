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
	RightPane right;
	Attribute value;
	DrawPane draw;
	int x, y, h, w;
	int xpos, ypos, index;
	
	DrawEvent(Attribute item2,DrawPane item3) {
//		right = item1;
		value = item2;
		draw = item3;
	}

	public void mousePressed(MouseEvent e) {

		x = e.getX();
		y = e.getY();
		// int index = 0;
		// for (int i = 0; i < label.length; i++) {
		// if (label[i] == e.getSource()) {
		// index = i;
		// break;
		// }
		// }
		// if (label[index].getCursor() != Cursor.getDefaultCursor()) {
		// // If cursor is set for Test, allow dragging.
		// dragging = true;
		// }
	}

	public void mouseReleased(MouseEvent e) {
		// dragging = false;
	}

	public void mouseClicked(MouseEvent e) {
//		int index = 0;

		for (int i = 0; i < draw.label.length; i++) {
			if (draw.label[i] == e.getSource()) {
				index = i;
				break;
			}
			System.out.println(index);
		}
		System.out.println("¾¾ºñ¤¿¤©");
		System.out.println(index);
		value.statusX.setText(Integer.toString(draw.label[index].getX()));
		value.statusY.setText(Integer.toString(draw.label[index].getY()));
		value.statusH.setText(Integer.toString(draw.label[index].getHeight()));
		value.statusW.setText(Integer.toString(draw.label[index].getWidth()));
		value.statusText.setText(draw.label[index].getText());
		System.out.println("Á¶±î");
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {

//		int index = 0;
		System.out.println(">>>>>>>>>>>>>>>>>>"+index);
		for (int i = 0; i < draw.label.length; i++) {
			if (draw.label[i] == e.getSource()) {
				index = i;
				break;
			}
			System.out.println(index);
		}
		System.out.println("????????????????????"+index);
		h = draw.label[index].getHeight();
		w = draw.label[index].getWidth();
		int distanceX = e.getX() - x;
		int distanceY = e.getY() - y;
		System.out.println(draw.label[index].getX() + distanceX + "," + (draw.label[index].getY() + distanceY));
		draw.label[index].setLocation(draw.label[index].getX() + distanceX, draw.label[index].getY() + distanceY);
		xpos = draw.label[index].getX() + distanceX;
		ypos = draw.label[index].getY() + distanceY;

		value.statusX.setText(Integer.toString(draw.label[index].getX()));
		value.statusY.setText(Integer.toString(draw.label[index].getY()));
		value.statusH.setText(Integer.toString(draw.label[index].getHeight()));
		value.statusW.setText(Integer.toString(draw.label[index].getWidth()));
		value.statusText.setText(draw.label[index].getText());

		// if (dragging) {
		// Point p = e.getPoint();
		//
		// int type = label[index].getCursor().getType();
		// distanceX = e.getX() - x;
		// distanceY = e.getY() - y;
		// switch (type) {
		// case Cursor.N_RESIZE_CURSOR:
		// int height = label[index].getHeight() - distanceY;
		// label[index].setBounds(label[index].getX(), label[index].getY() +
		// distanceY, label[index].getWidth(),
		// height);
		// break;
		// case Cursor.NW_RESIZE_CURSOR:
		// int width = label[index].getWidth() - distanceX;
		// height = label[index].getHeight() - distanceY;
		// label[index].setBounds(label[index].getX() + distanceX,
		// label[index].getY() + distanceY, width, height);
		// break;
		// case Cursor.W_RESIZE_CURSOR:
		// width = label[index].getWidth() - distanceX;
		// label[index].setBounds(label[index].getX() + distanceX,
		// label[index].getY(), width,
		// label[index].getHeight());
		// break;
		// case Cursor.SW_RESIZE_CURSOR:
		// width = label[index].getWidth() - distanceX;
		// height = distanceY;
		// label[index].setBounds(label[index].getX() + distanceX,
		// label[index].getY(), width, height);
		// break;
		// case Cursor.S_RESIZE_CURSOR:
		// height = distanceY;
		// label[index].setBounds(label[index].getX(), label[index].getY(),
		// label[index].getWidth(), height);
		// break;
		// case Cursor.SE_RESIZE_CURSOR:
		// width = distanceX;
		// height = distanceY;
		// label[index].setBounds(label[index].getX(), label[index].getY(),
		// width, height);
		// break;
		// case Cursor.E_RESIZE_CURSOR:
		// width = distanceX;
		// label[index].setBounds(label[index].getX(), label[index].getY(),
		// width, label[index].getHeight());
		// break;
		// case Cursor.NE_RESIZE_CURSOR:
		// width = distanceX;
		// height = label[index].getHeight() - distanceY;
		// label[index].setBounds(label[index].getX(), label[index].getY() +
		// distanceY, width, height);
		// break;
		// default:
		// System.out.println("unexpected type: " + type);
		// }
		// label[index].repaint();
		// }
		// }

	}

	public void mouseMoved(MouseEvent e) {
//		Point p = e.getPoint();
//		int index = 0;
//		for (int i = 0; i < label.length; i++) {
//			if (label[i] == e.getSource()) {
//				index = i;
//				break;
//			}
//		}
//		if (label == e.getSource()) {
//			if (label[index].getCursor() != Cursor.getDefaultCursor()) {
//				// If cursor is not over rect reset it to the default.
//				label[index].setCursor(Cursor.getDefaultCursor());
//			}
//			return;
//		}
//		int outcode = getOutcode(p, e);
//
//		switch (outcode) {
//		case Rectangle.OUT_TOP:
//			if (Math.abs(p.y - label[index].getY()) < PROX_DIST) {
//				label[index].setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
//			}
//			break;
//		case Rectangle.OUT_TOP + Rectangle.OUT_LEFT:
//			if (Math.abs(p.y - label[index].getY()) < PROX_DIST && Math.abs(p.x - label[index].getX()) < PROX_DIST) {
//				label[index].setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
//			}
//			break;
//		case Rectangle.OUT_LEFT:
//			if (Math.abs(p.x - label[index].getX()) < PROX_DIST) {
//				label[index].setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
//			}
//			break;
//		case Rectangle.OUT_LEFT + Rectangle.OUT_BOTTOM:
//			if (Math.abs(p.x - label[index].getX()) < PROX_DIST
//					&& Math.abs(p.y - (label[index].getY() + label[index].getHeight())) < PROX_DIST) {
//				label[index].setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
//			}
//			break;
//		case Rectangle.OUT_BOTTOM:
//			if (Math.abs(p.y - (label[index].getY() + label[index].getHeight())) < PROX_DIST) {
//				label[index].setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
//			}
//			break;
//		case Rectangle.OUT_BOTTOM + Rectangle.OUT_RIGHT:
//			if (Math.abs(p.x - (label[index].getX() + label[index].getWidth())) < PROX_DIST
//					&& Math.abs(p.y - (label[index].getY() + label[index].getHeight())) < PROX_DIST) {
//				label[index].setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
//			}
//			break;
//		case Rectangle.OUT_RIGHT:
//			if (Math.abs(p.x - (label[index].getX() + label[index].getWidth())) < PROX_DIST) {
//				label[index].setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
//			}
//			break;
//		case Rectangle.OUT_RIGHT + Rectangle.OUT_TOP:
//			if (Math.abs(p.x - (label[index].getX() + label[index].getWidth())) < PROX_DIST
//					&& Math.abs(p.y - label[index].getY()) < PROX_DIST) {
//				label[index].setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
//			}
//			break;
//		default: // center
//			label[index].setCursor(Cursor.getDefaultCursor());
//		}
	}

//	private boolean isOverRect(Point p, MouseEvent e) {
//		int index = 0;
//		for (int i = 0; i < label.length; i++) {
//			if (label[i] == e.getSource()) {
//				index = i;
//				break;
//			}
//		}
//		Rectangle r = (Rectangle) label[index].bounds().clone();
//		r.grow(PROX_DIST, PROX_DIST);
//		return r.contains(p);
//	}
//
//	private int getOutcode(Point p, MouseEvent e) {
//		int index = 0;
//		for (int i = 0; i < label.length; i++) {
//			if (label[i] == e.getSource()) {
//				index = i;
//				break;
//			}
//		}
//		Rectangle r = (Rectangle) label[index].bounds().clone();
//		r.grow(-PROX_DIST, -PROX_DIST);
//		return r.outcode(p.x, p.y);
//	}
}
