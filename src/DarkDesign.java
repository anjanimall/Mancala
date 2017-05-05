import java.awt.Color;

/**
 * Dark Design option
 * @author Setty, Mallampati, Elmoghany
 */
public class DarkDesign implements BoardDesign {
	public Color getBackgroundColor(){
		return Color.BLACK;
	}
	
	public Color getPitColor(){
		return Color.GRAY;
	}
}