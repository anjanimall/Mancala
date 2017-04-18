
public class MancalaTester {

	public static void main(String[] args) {
		MancalaModel m = new MancalaModel();
		MancalaFrame frame = new MancalaFrame(m);
		m.attach(frame);
	}
}
