import java.awt.*;
import javax.swing.JPanel;
import javax.swing.event.*;

/**
 * MancalaPanel gets the design selected and paints the board accordingly
 * @author Setty, Mallampati, Elmoghany
 */
public class MancalaPanel extends JPanel implements ChangeListener {

	private static final long serialVersionUID = 1L;
	private MancalaModel model;
	private BoardDesign design;
	private BoardDS board;
	private DesignComponent dc;
	
	/**
	 * Creates a MancalaPanel object
	 * @param m the MancalaModel
	 * @param d the BoardDesign
	 */
	public MancalaPanel(MancalaModel m, BoardDesign d) {
		model = m;
		design = d;
		board = model.getBoard();
		dc = new DesignComponent(design, board);
	}
	
	/**
	 * Paints the board according to the design selected
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		dc = new DesignComponent(design, board);
		dc.paintComponent(g);
	}
	
	/**
	 * Gets the DesignComponent selected by the user
	 * @return the DesignComponent dc
	 */
	public DesignComponent getDesignComponent(){
		return dc;
	}

	/**
	 * Repaints the board
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		board = model.getBoard();
		System.out.println("State changed");
		repaint();
	}
}