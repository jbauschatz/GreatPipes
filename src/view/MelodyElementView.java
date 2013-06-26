package view;

import java.awt.Graphics;

import model.MelodyElement;

public interface MelodyElementView {
	public int getWidth();
	public void setX(int x);
	public boolean contains(int x, int y);
	public void draw(Graphics g);
	public MelodyElement getElement();
	public void setHighlight(boolean b);
}
