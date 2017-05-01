import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;

public class MancalaTester {

	public static void main(String[] args) {
//		MancalaModel m = new MancalaModel();
//		MancalaFrame frame = new MancalaFrame(m);
//		m.attach(frame);
		
		BoardDS board = new BoardDS();
		board.setPits(3);
		board.setMancalaA(5);
		board.setMancalaB(7);
		MancalaModel model = new MancalaModel(board);
		//model.update(9);
		JFrame frame = new JFrame();
		//MancalaPanel panel = new MancalaPanel(model, new ColorfulDesign());
	DesignComponent bd = new DesignComponent(new ColorfulDesign(), board);
		frame.setLayout(new BorderLayout());
		frame.add(bd, BorderLayout.CENTER);
		//frame.setContentPane(panel);
		
		frame.setVisible(true);
		frame.pack();
		
//		Pit pit = new Pit(1,7,100,100, Color.BLUE);
//		pit.addMouseListener(new MouseListener(){
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				System.out.print(pit.containsPoint(e.getPoint()));
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//		frame.add(pit);
//		frame.setVisible(true);
//		frame.pack();
		
		
	}
}