
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class InitialBoard {
	public static void main(String[] args) {
		//MancalaModel model = new MancalaModel();
		final JFrame frame = new JFrame();
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
		if(numOfStones==1){
			boardData.setPits(3);
			stones = 3;
			System.out.println("3");
		}
		else{
			boardData.setPits(4);
			stones =4;
			System.out.println("4");
		}
		int boardStyle = JOptionPane.showOptionDialog(frame, "Which design?",
				null, JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				optionsForBoard,
				null);
		DesignComponent dc;
		
		if(boardStyle == 0){
			dc = new DesignComponent(new DarkDesign(),stones);
			System.out.println("Dark Design");
		}
		else if(boardStyle == 1){
			dc = new DesignComponent(new ColorfulDesign(),stones);
		System.out.println("Colorful Design");
		}
		else{
			dc = new DesignComponent(new DefaultDesign(), stones);
			System.out.println("Default Design");
		}
	
		
		frame.setLayout(new BorderLayout());
		
		JButton undo = new JButton("Undo");
		frame.add(undo, BorderLayout.NORTH);
		frame.add(dc, BorderLayout.CENTER);
		
		frame.setVisible(true);
		frame.pack();
	
	}
//	final JFrame parent = new JFrame();
//    String stones = JOptionPane.showInputDialog("what is the number of stones",null);
//    String style = JOptionPane.showInputDialog("Select ur style",null);
}