package main;

public class Board {

	private char boardgame[][];
	private int columns, rows;
	
	public Board(int c, int r) {
		
		this.columns=c;
		this.rows=r;
	
		
		//test affichage
		for(int i=0; i<this.rows;i++) {
			for(int j=0;j<this.columns;j++) {
				if(j==5 && i== 4) {
					this.boardgame[i][j]='X';
				}
			}
		}
	}
	
	public void displayBoard() {
		
		for(int i=0; i<this.rows;i++) {
			System.out.println("|");
			for(int j=0;j<this.columns;j++) {
				System.out.print(" "+this.boardgame[i][j]+" ");
				
			}
			System.out.print("|");
		}
	}
	
	
	public static void main(String[] args) {
		
		
		Board b = new Board(10,24);
		b.displayBoard();
		
		
	}
	
}
