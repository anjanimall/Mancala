import java.awt.*;
import java.awt.geom.*;

/**
 * Mancala class creates and paints Mancala A and Mancala B
 * @author Setty, Mallampati, Elmoghany
 */
public class Mancala {

	private int number;
	private int x;
	private int y;
	private Color color;

	/**
	 * Creates a Mancala object
	 * @param num the number of pebbles
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param color the color 
	 */
	public Mancala(int num, int x, int y, Color color){
		this.number = num;
		this.x = x;
		this.y = y;
		this.color = color;
	}

	/**
	 * Paints mancala A and mancala B
	 * Initializes the location that the pebbles should be drawn
	 * @param g
	 */
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		RoundRectangle2D mancalaA = new RoundRectangle2D.Double(x, y, 100, 300, 60, 60);
		g2.setColor(color);
		g2.fill(mancalaA);

		int  distanceX = 30;
		int  distanceY = 120;

		for(int i = 0; i < this.number; i++){
			Ellipse2D pitBall = new Ellipse2D.Double(x + distanceX, y + distanceY, 10, 10);
			g2.setColor(Color.BLACK);
			g2.fill(pitBall);
			distanceX += 15;
			if (distanceX >= 70){
				distanceX = 30;
				distanceY += 15;
			}
		}
	}
}
