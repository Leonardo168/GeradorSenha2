package gerador2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JToggleButton;

public class ColorToggleButton extends JToggleButton{

	String s;
	
	Color cor1 = Color.decode("#000000");
	Color cor2 = Color.decode("#33ff00");
	
	public ColorToggleButton(String str, boolean sel) {
		super(str, sel);
		s = str;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (this.isSelected()) {
			int w = getWidth();
			int h = getHeight();
			g.setColor(cor2);
			g.fillRect(0, 0, w, h);
			g.setColor(cor1);
			g.drawString(s, (w - g.getFontMetrics().stringWidth(s))/2 + 1, (h + g.getFontMetrics().getAscent())/2 - 1);
		}
	}
}
