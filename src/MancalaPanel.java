import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaPanel extends JPanel implements ChangeListener {

	private static final long serialVersionUID = 1L;
	private MancalaModel model;
	private BoardDesign design;
	private BoardDS board;
	private DesignComponent dc;

	// TODO: Right now the program will not wait for the user to select
	// BoardDesign or numStones. It will just go through all the steps, and
	// probably throw some null error.
	// We should figure out how to fix this
	public MancalaPanel(MancalaModel m, BoardDesign d) {
		
		model = m;
		design = d;
		board = model.getBoard();
		dc = new DesignComponent(design, board);

		// TODO: User needs to select the BoardDesign to use.

		// TODO: Initialize the instance variables and get data from model

		// TODO: Paint the BoardDesign by using a DesignComponent.

		// TODO: Add a JTextArea prompting to enter the number of stones: either
		// 3 or 4. Add a JTextField for the user to enter the number.
		// Alternatively, add two button either 3 or 4. Update the mancalaStones
		// accordingly. Set the the buttons/textfield to not visible.

		// TODO: Paint the stones according to the mancalaStones data. This
		// could change.

		// TODO: Add a button for undo function

		// TODO: Create a MouseListener for the button. It should call the
		// setPrevious() method in the MancalaModel.
		// The user can undo a maximum of three times, and cannot undo more than
		// one step back.

		// TODO: When user clicks a pit, need to get index and call update
		// method of MancalaModel. Need to figure out how to know which pit is
		// clicked.
		// If design changes this is subject to change.

		// TODO: Add a button that will complete the turn when clicked.

	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		dc = new DesignComponent(design, board);
		dc.paintComponent(g);
		
		
	}
	
	public DesignComponent getDesignComponent(){
		return dc;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO: Get the new data and assign it to mancalaStones

		// TODO: Need to repaint the board with new data
		
		board = model.getBoard();
		System.out.println("State changed");
		repaint();

	}

}