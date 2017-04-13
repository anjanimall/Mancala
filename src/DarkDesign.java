import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class DarkDesign implements BoardDesign {

	@Override
	public void draw(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Rectangle2D box = new Rectangle2D.Double(0, 0, 1060, 400);
		g.setColor(Color.BLACK);
		g.fill(box);
		RoundRectangle2D mancalaA = new RoundRectangle2D.Double(25, 50, 100, 300, 60, 60);
		g.setColor(Color.GRAY);
		g.fill(mancalaA);
		for (int i = 0; i < 6; i++) {
			g.fill(new Ellipse2D.Double(155 + (130 * i), 50, 100, 125));
			g.fill(new Ellipse2D.Double(155 + (130 * i), 225, 100, 125));
		}
		RoundRectangle2D mancalaB = new RoundRectangle2D.Double(935, 50, 100, 300, 60 ,60);
		g.fill(mancalaB);
		
	}

}
