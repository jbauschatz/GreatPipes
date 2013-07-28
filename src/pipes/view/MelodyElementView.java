package pipes.view;

import java.awt.Graphics;

import pipes.model.MelodyElement;

public interface MelodyElementView {
	public int getWidth();
	public int getX();
	public void setX(int x);
	public boolean contains(int x, int y);
	public boolean horizontallyContains(int x);
	public void draw(Graphics g);
	public MelodyElement getElement();
	public void setHighlight(boolean b);
}
