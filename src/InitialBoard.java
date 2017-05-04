import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * @author Setty, Mallampati, Elmoghany
 *
 */
public class InitialBoard {
	
	static boolean turn = true;
	
	public static void main(String[] args) {
		final JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(960, 450));
		
		Object[] optionsForStones = {"4", "3"};
		Object[] optionsForBoard = {"Dark Design", "Colorful Design", "Default Design"};
		int numOfStones = JOptionPane.showOptionDialog(frame, "How many stones?", 
				null, JOptionPane.YES_NO_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				optionsForStones, 
				null);
		
		int stones;
		BoardDS boardData = new BoardDS();
		if(numOfStones == 1){
			boardData.setPits(3);
			stones = 3;
			System.out.println("3");
		} else {
			boardData.setPits(4);
			stones = 4;
			System.out.println("4");
		}
		
		int boardStyle = JOptionPane.showOptionDialog(frame, "Which design?",
				null, JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				optionsForBoard,
				null);
		BoardDesign design;
		
		if(boardStyle == 0){
			design  = new DarkDesign();
			System.out.println("Dark Design");
		} else if(boardStyle == 1) {
			design = new ColorfulDesign();
		System.out.println("Colorful Design");
		} else {
			design = new DefaultDesign();
			System.out.println("Default Design");
		}
		
		MancalaModel model = new MancalaModel(boardData);
		MancalaPanel panel = new MancalaPanel(model, design);
		model.attach(panel);
		
		panel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				for(Pit p: panel.getDesignComponent().getPits()){
					if(p.containsPoint(e.getPoint())) {
						int index = p.getIndex();
						if((turn && index > 5 && index < 12) || !turn && index < 6) {
							boolean inMancala = model.update(index, turn);
							if(!inMancala)
								turn = !turn;
							System.out.println(turn);
						}
					}
				}
			}
		});
		
		frame.setLayout(new BorderLayout());
		
		JButton undo = new JButton("Undo");
		undo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int count = 0;
				model.setPreviousBoard();
				
			}
		});
		
		frame.add(undo, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		
		frame.setVisible(true);
		frame.pack();
	}
}