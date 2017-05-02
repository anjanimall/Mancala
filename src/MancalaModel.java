import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaModel {

	private ArrayList<ChangeListener> listeners;
	private BoardDS pastBoard;
	private BoardDS currentBoard;

	public MancalaModel(BoardDS board) {
		this.listeners = new ArrayList<>();
		currentBoard = board;
		
	}

	public void attach(ChangeListener l) {
		listeners.add(l);
	}
	
	public BoardDS getBoard(){
		return currentBoard;
	}

	public void setPreviousBoard() {
		// TODO: Make the current board equal to the last board in the arraylist
		// and remove that board.
		// TODO: Notify all listeners of the change
		InitialBoard.turn = !InitialBoard.turn;
		ArrayList<Integer> pits2 = new ArrayList<>();
		for(int i = 0; i<12; i++){
			pits2.add(pastBoard.getPits().get(i));
		}
		currentBoard = new BoardDS(pits2, pastBoard.getMancalaA(), pastBoard.getMancalaB());
		System.out.println(currentBoard.getPits());
		for(ChangeListener l: listeners){
			l.stateChanged(new ChangeEvent(this));
		}
	}

	public boolean update(int index, boolean playerA) {
		System.out.println(index);
		ArrayList<Integer> pits2 = new ArrayList<>();
		for(int i = 0; i<12; i++){
			pits2.add(currentBoard.getPits().get(i));
		}
		pastBoard = new BoardDS(pits2, currentBoard.getMancalaA(), currentBoard.getMancalaB());
		ArrayList<Integer> values = currentBoard.getPits();
		int currentVal = values.get(index);
		values.set(index, 0);
		index+=1;
		boolean first = true;
		boolean inMancala = false;
		for(int i = 1; i<=currentVal; i++){ //i num of stones
			if(playerA) {
				if(index<=11) {
					values.set(index, (values.get(index))+1);
					inMancala = false;
					index++;
				} else {
					currentBoard.setMancalaA((currentBoard.getMancalaA())+1);
					inMancala = true;
					index=0;
				}
			} else {
				if(first && index==6) {
					first = false;
					currentBoard.setMancalaB((currentBoard.getMancalaB())+1);
					inMancala = true;
				}
				else if((index==5 && i+1<=currentVal)) {
					first = false;
					values.set(index, (values.get(index))+1);
					currentBoard.setMancalaB((currentBoard.getMancalaB())+1);
					inMancala = true;
					i++;
					index = 6;
				}
				else if(index<=11) {
					values.set(index, (values.get(index))+1);
					inMancala = false;
					index++;
				} else {
					values.set(0, (values.get(0))+1);
					inMancala = false;
					index = 1;
				}
			}
		}
		
//		if(playerA){
//			if(index==0)
//				index = 11;
//			else if(index<=11 && index >=7)
//				index--;
//		}
//		else{
//				index--;
//		}
		
		for(ChangeListener l: listeners){
			l.stateChanged(new ChangeEvent(this));
		}
		// TODO: This is where the game logic is implemented
		// TODO: Move the currentBoard to the pastBoards and assign new
		// currentBoard based on game logic.
		// TODO: Notify the listeners of change
		return inMancala;
	}
	
}