import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Pit extends JComponent {
	
	private int n;
	private int x;
	private int y;
	private Color color;
	private int pitNum;

	public Pit(int pitNum, int n, int x, int y, Color color){
		this.n = n;
		this.x = x;
		this.y = y;
		this.color = color;
		this.pitNum = pitNum;
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Ellipse2D pitCircle = new Ellipse2D.Double(x, y, 100, 100);
		g2.setColor(color);
		g2.fill(pitCircle);
		int  distanceX=30;
		int  distanceY=40;
		for(int i = 0; i<n; i++){
			Ellipse2D pitBall = new Ellipse2D.Double(x+distanceX,y+distanceY,10,10);
			g2.setColor(Color.BLACK);
			g2.fill(pitBall);
			distanceX +=15;
			if (distanceX>=70){
				distanceX=30;
				distanceY+=15;
			}
		}
	}
	
	public int getIndex(){
		return pitNum;
	}
	
	public boolean containsPoint(Point p){
		double xVal = p.getX() - x - 50;
		double yVal = p.getY() - y - 50;
		double total = Math.pow(xVal, 2) + Math.pow(yVal, 2);
		return total <= 2500;
	}
	
	public int getN(){
		return n;
	}
	
	public Color getColor(){
		return color;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getPitNum(){
		return pitNum;
	}
	
	
	
}