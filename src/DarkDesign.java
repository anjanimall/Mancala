import java.awt.Color;

/**
 * Dark Design option
 * @author Setty, Mallampati, Elmoghany
 */
public class DarkDesign implements BoardDesign {
	
	/**
	 * Gets the background color for Dark Design
	 * @return Black
	 */
	public Color getBackgroundColor(){
		return Color.BLACK;
	}
	
	/**
	 * Gets the pit color for Dark Design
	 * @return Gray
	 */
	public Color getPitColor(){
		return Color.GRAY;
	}
}