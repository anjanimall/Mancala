
import java.awt.event.ActionEvent;

import javax.swing.*;

public class InitialBoard {
	public static void main(String[] args) {
		//MancalaModel model = new MancalaModel();
		final JFrame frame = new JFrame();
		Object[] optionsForStones = {"3", "4"};
		Object[] optionsForBoard = {"Dark Design", "Colorful Design", "Default Design"};
		int numOfStones = JOptionPane.showOptionDialog(frame, "How many stones?", 
				null, JOptionPane.YES_NO_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				optionsForStones, 
				null);
		BoardDS boardData = new BoardDS();
		if(numOfStones==0){
			boardData.setPits(3);
		}
		else
			boardData.setPits(4);
		
		int boardStyle = JOptionPane.showOptionDialog(frame, "Which design?",
				null, JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				optionsForBoard,
				null);
		DesignComponent dc;
		
		if(boardStyle == 0){
			dc = new DesignComponent(new DarkDesign());
			System.out.println("Dark Design");
		}
		else if(boardStyle == 1){
			dc = new DesignComponent(new ColorfulDesign());
		System.out.println("Colorful Design");
		}
		else{
			dc = new DesignComponent(new DefaultDesign());
			System.out.println("Default Design");
		}
		
		frame.add(dc);
		frame.setVisible(true);
		frame.pack();
	
	}
//	final JFrame parent = new JFrame();
//    String stones = JOptionPane.showInputDialog("what is the number of stones",null);
//    String style = JOptionPane.showInputDialog("Select ur style",null);
}