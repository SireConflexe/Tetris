package main;

public class Game {

	private Board boardgame;
	private Form currentForm;
	private int time_alive;
	
	
	public Game() {
		
		this.boardgame=new Board(10,24);
		this.time_alive=0;
		this.currentForm=this.boardgame.nextForm();
		
	}
	
	
	//called every second
	public void nextStep() {
		
		time_alive++;
		
		
		if(this.detectForm()) {
			
			this.fixForm();

			this.currentForm=this.boardgame.nextForm();
		}
		
		else {
			//en cran en bas
		}
		
		
		this.boardgame.displayBoard();
		
	}
	
	
	//Detect if current playable form will be in contact with a solid form at next step
	public boolean detectForm() {
		
		
		return false;
	}
	
	
	//fix current if solid form detected
	public void fixForm() {
		
		
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		Game superTetrisOfDoom = new Game();
		superTetrisOfDoom.nextStep();
	}
	
}
