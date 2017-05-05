import java.awt.Color;

/**
 * Default Design option
 * @author Setty, Mallampati, Elmoghany
 */
public class DefaultDesign implements BoardDesign {
	
	/**
	 * Gets the background color for Default Design
	 * @return custom brown color
	 */
	public Color getBackgroundColor(){
		return new Color(139, 69, 19);
	}
	
	/**
	 * Gets the pit color for Default Design
	 * @return custom cream color
	 */
	public Color getPitColor(){
		return new Color(222, 184, 135);
	}
}