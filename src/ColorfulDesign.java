import java.awt.Color;

/**
 * Colorful Design option
 * @author Setty, Mallampati, Elmoghany
 */
public class ColorfulDesign implements BoardDesign {
	
	/**
	 * Gets the background color for Colorful Design
	 * @return Blue
	 */
	public Color getBackgroundColor(){
		return Color.BLUE; 
	}
	
	/**
	 * Gets the pit color for Colorful Design
	 * @return Magenta
	 */
	public Color getPitColor() {
		return Color.MAGENTA;
	}
}