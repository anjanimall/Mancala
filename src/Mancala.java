import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;

public class Mancala {
		private int n;
		private int x;
		private int y;
		private Color color;

		public Mancala(int n, int x, int y, Color color){
			this.n = n;
			this.x = x;
			this.y = y;
			this.color = color;
		}
		
		public void paintComponent(Graphics g){
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			RoundRectangle2D mancalaA = new RoundRectangle2D.Double(x, y, 100, 300, 60, 60);
			g2.setColor(color);
			g2.fill(mancalaA);
			int  distanceX=30;
			int  distanceY=120;
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
		
		public void setStones(int n) {
			this.n = n;
		}
 }
