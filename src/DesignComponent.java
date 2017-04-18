import java.awt.Graphics;

import javax.swing.JComponent;

public class DesignComponent extends JComponent {

	private BoardDesign design;

	public DesignComponent(BoardDesign design) {
		this.design = design;
	}

	public void paintComponent(Graphics g) {
		// TODO: Paint component using the BoardDesign.
		// This is subject to change.
	}

}
