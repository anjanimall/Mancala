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
		
		JFrame frame = new JFrame();
		DesignComponent bd = new DesignComponent(new ColorfulDesign());
		frame.add(bd);
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
