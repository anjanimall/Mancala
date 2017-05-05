import java.awt.Color;

/**
 * Colorful Design option
 * @author Setty, Mallampati, Elmoghany
 */
public class ColorfulDesign implements BoardDesign {
	public Color getBackgroundColor(){
		return Color.BLUE; 
	}
	
	public Color getPitColor() {
		return Color.MAGENTA;
	}
}