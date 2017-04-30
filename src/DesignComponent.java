import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;

public class DesignComponent extends JComponent {

	private BoardDesign design;

	public DesignComponent(BoardDesign design) {
		this.design = design;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Rectangle2D box = new Rectangle2D.Double(0, 0, 960, 400);
		g2.setColor(design.getBackgroundColor());
		g2.fill(box);
		RoundRectangle2D mancalaA = new RoundRectangle2D.Double(25, 50, 100, 300, 60, 60);
		g2.setColor(design.getPitColor());
		g2.fill(mancalaA);
		for (int i = 0; i < 6; i++) {
			Pit pit = new Pit(i, 3, 155 + (110 * i), 50, design.getPitColor());
			pit.paintComponent(g);
			Pit pit2 = new Pit(i+6, 3, 155 + (110 * i), 225, design.getPitColor());
			pit2.paintComponent(g);
		}
		RoundRectangle2D mancalaB = new RoundRectangle2D.Double(830, 50, 100, 300, 60, 60);
		g2.setColor(design.getPitColor());
		g2.fill(mancalaB);
	}

}
