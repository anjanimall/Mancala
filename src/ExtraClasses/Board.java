package ExtraClasses;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;

class Board extends JFrame {
	public Board() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D.Double outer = new Rectangle2D.Double(50, 50, 700, 300);
		g2.draw(outer);
		g2.setColor(Color.BLUE);
		g2.fillRect(50, 50, 700, 300);
		
		final int ovalWidth = 80;
		final int ovalHeight = 200;
		g2.drawOval(100, 100, ovalWidth, ovalHeight);
		g2.setColor(Color.RED);
		g2.fillOval(100, 100, 80, 200);
		
		g2.drawOval(620, 100, ovalWidth, ovalHeight);
		g2.setColor(Color.RED);
		g2.fillOval(620, 100, ovalWidth, ovalHeight);
		
		final int circleSize = 50;
		Color cyan = Color.CYAN;
		final int playerAY = 210;
		final int playerBY = 150;
		
		Ellipse2D.Double circleB1 = new Ellipse2D.Double(220, playerBY, circleSize, circleSize);
		g2.draw(circleB1);
		g2.setColor(cyan);
		g2.fill(circleB1);
		
		Ellipse2D.Double circleB2 = new Ellipse2D.Double(280, playerBY, circleSize, circleSize);
		g2.draw(circleB2);
		g2.setColor(cyan);
		g2.fill(circleB2);
		
		Ellipse2D.Double circleB3 = new Ellipse2D.Double(340, playerBY, circleSize, circleSize);
		g2.draw(circleB3);
		g2.setColor(cyan);
		g2.fill(circleB3);
		
		Ellipse2D.Double circleB4 = new Ellipse2D.Double(400, playerBY, circleSize, circleSize);
		g2.draw(circleB4);
		g2.setColor(cyan);
		g2.fill(circleB4);
		
		Ellipse2D.Double circleB5 = new Ellipse2D.Double(460, playerBY, circleSize, circleSize);
		g2.draw(circleB5);
		g2.setColor(cyan);
		g2.fill(circleB5);
		
		Ellipse2D.Double circleB6 = new Ellipse2D.Double(520, playerBY, circleSize, circleSize);
		g2.draw(circleB6);
		g2.setColor(cyan);
		g2.fill(circleB6);
		
		Ellipse2D.Double circleA1 = new Ellipse2D.Double(220, playerAY, circleSize, circleSize);
		g2.draw(circleA1);
		g2.setColor(cyan);
		g2.fill(circleA1);
		
		Ellipse2D.Double circleA2 = new Ellipse2D.Double(280, playerAY, circleSize, circleSize);
		g2.draw(circleA2);
		g2.setColor(cyan);
		g2.fill(circleA2);
		
		Ellipse2D.Double circleA3 = new Ellipse2D.Double(340, playerAY, circleSize, circleSize);
		g2.draw(circleA3);
		g2.setColor(cyan);
		g2.fill(circleA3);
		
		Ellipse2D.Double circleA4 = new Ellipse2D.Double(400, playerAY, circleSize, circleSize);
		g2.draw(circleA4);
		g2.setColor(cyan);
		g2.fill(circleA4);
		
		Ellipse2D.Double circleA5 = new Ellipse2D.Double(460, playerAY, circleSize, circleSize);
		g2.draw(circleA5);
		g2.setColor(cyan);
		g2.fill(circleA5);
		
		Ellipse2D.Double circleA6 = new Ellipse2D.Double(520, playerAY, circleSize, circleSize);
		g2.draw(circleA6);
		g2.setColor(cyan);
		g2.fill(circleA6);
	}

	public static void main(String[] args) {
		Board outline = new Board();
	}
}