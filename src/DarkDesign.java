import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class DarkDesign implements BoardDesign {

	public Color getBackgroundColor(){
		return Color.BLACK;
	}
	
	public Color getPitColor(){
		return Color.GRAY;
	}

}