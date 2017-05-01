import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class DesignComponent extends JComponent {

	private BoardDesign design;
	private BoardDS board;
	private ArrayList<Pit> pits;

	public DesignComponent(BoardDesign design, BoardDS boardDS) {
		this.design = design;
		this.board = boardDS;
		pits = new ArrayList<>();
		ArrayList<Integer> pitStones = board.getPits();
		for (int i = 0; i < 6; i++) {
			Pit pit = new Pit(5-i, pitStones.get(5-i), 155 + (110 * i), 50, design.getPitColor());
			pits.add(pit);
			Pit pit2 = new Pit(6+i, pitStones.get(i+6), 155 + (110 * i), 225, design.getPitColor());
			pits.add(pit2);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Rectangle2D box = new Rectangle2D.Double(0, 0, 960, 400);
		g2.setColor(design.getBackgroundColor());
		g2.fill(box);
		Mancala mancalaA = new Mancala(board.getMancalaA(), 25, 50, design.getPitColor());
		mancalaA.paintComponent(g);
		for(Pit pit: pits){
			pit.paintComponent(g);
		}
		Mancala mancalaB = new Mancala(board.getMancalaB(), 830, 50, design.getPitColor());
		mancalaB.paintComponent(g);
	}
	
	public ArrayList<Pit> getPits(){
		return pits;
	}

}