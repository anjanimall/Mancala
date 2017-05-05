import java.awt.Color;

/**
 * Default Design option
 * @author Setty, Mallampati, Elmoghany
 */
public class DefaultDesign implements BoardDesign {
	public Color getBackgroundColor(){
		return new Color(139, 69, 19);
	}
	
	public Color getPitColor(){
		return new Color(222, 184, 135);
	}
}