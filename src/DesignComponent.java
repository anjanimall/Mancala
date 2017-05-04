import java.awt.*;
import java.util.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

/**
 * 
 * @author Setty, Mallampati, Elmoghany
 * 
 */
public class DesignComponent extends JComponent {
	
	private BoardDesign design;
	private BoardDS board;
	private ArrayList<Pit> pits;

	/**
	 * 
	 * @param design
	 * @param boardDS
	 */
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

	/**
	 * 
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Rectangle2D box = new Rectangle2D.Double(0, 0, 960, 400);
		g2.setColor(design.getBackgroundColor());
		g2.fill(box);
		Mancala mancalaA = new Mancala(board.getMancalaB(), 25, 50, design.getPitColor());
		mancalaA.paintComponent(g);
		for(Pit pit: pits){
			pit.paintComponent(g);
		}
		Mancala mancalaB = new Mancala(board.getMancalaA(), 830, 50, design.getPitColor());
		mancalaB.paintComponent(g);
		
		Color white = Color.WHITE;
		Font pitFont = new Font("Serif", Font.BOLD, 12);
		for(int i = 0; i < 6; i++) {
			g2.setColor(white);
			g2.setFont(pitFont);
			g2.drawString("B"+ (6-i), 195 + (110 * i), 40);
			g2.drawString("A"+ (i+1), 195 + (110 * i), 345);
		}
		Font boardFont = new Font("Serif", Font.PLAIN, 18);
		g2.setColor(white);
		g2.setFont(boardFont);
		g2.drawString("<-- Player B", 430, 20);
		g2.drawString("Player A -->", 430, 370);
		g2.drawString("Mancala B", 36, 40);
		g2.drawString("Mancala A", 840, 40);
		if(InitialBoard.turn){
			g2.drawString("Player A's Turn", 430, 190);
		} else {
			g2.drawString("Player B's Turn", 430, 190);
		}
		g2.setFont(new Font("Serif", Font.BOLD, 80));
		if(MancalaModel.winner == Winners.draw) {
			g2.drawString("Player A & Player B Tied!", 100, 200);
		} else if(MancalaModel.winner == Winners.winnerA) {
			g2.drawString("Player A Won!", 200, 200);
		} else if(MancalaModel.winner == Winners.winnerB) {
			g2.drawString("Player B Won!", 200, 200);
		}
		
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Pit> getPits(){
		return pits;
	}

}