import java.awt.*;
import java.awt.geom.*;
import javax.swing.JComponent;

/**
 * Pit class includes the design and creation of the pits
 * @author Setty, Mallampati, Elmoghany
 */
public class Pit extends JComponent {
	
	private int numOfStones;
	private int x;
	private int y;
	private Color color;
	private int pitNum;

	/**
	 * Creates a Pit object
	 * @param pitNum the number of the pit
	 * @param n the number of pebbles
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param color the color
	 */
	public Pit(int pitNum, int n, int x, int y, Color color){
		this.numOfStones = n;
		this.x = x;
		this.y = y;
		this.color = color;
		this.pitNum = pitNum;
	}
	
	/**
	 * Paints the pits and the pebbles that go into the pit
	 */
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Ellipse2D pitCircle = new Ellipse2D.Double(x, y, 100, 100);
		g2.setColor(color);
		g2.fill(pitCircle);
		int distanceX = 30;
		int distanceY = 40;
		for(int i = 0; i < numOfStones; i++){
			Ellipse2D pitBall = new Ellipse2D.Double(x+distanceX, y+distanceY, 10, 10);
			g2.setColor(Color.BLACK);
			g2.fill(pitBall);
			distanceX += 15;
			if (distanceX >= 70){
				distanceX = 30;
				distanceY += 15;
			}
		}
	}
	
	/**
	 * Gets the number of the pit
	 * @return the pitNum
	 */
	public int getIndex(){
		return pitNum;
	}
	
	/**
	 * Makes sure that the point selected is inside the pit
	 * @param p the point selected
	 * @return true, if the point selected is inside the pit/false, if otherwise
	 */
	public boolean containsPoint(Point p){
		double xVal = p.getX() - x - 50;
		double yVal = p.getY() - y - 50;
		double total = Math.pow(xVal, 2) + Math.pow(yVal, 2);
		return total <= 2500;
	}
}