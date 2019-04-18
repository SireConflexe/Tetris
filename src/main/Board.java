package main;

public class Board {

	private int columns, rows;
	private char boardgame[][];
	
	public Board(int c, int r) {
		
		this.columns=c;
		this.rows=r;
		this.boardgame= new char[r][c];
		
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
			System.out.print("|");
			for(int j=0;j<this.columns;j++) {
				if(this.boardgame[i][j]=='X'){
					System.out.print(" "+this.boardgame[i][j]+" ");
				}
				else {
					System.out.print("   ");
				}
				
			}
			System.out.println("|");
		}
	}
	
	
	public static void main(String[] args) {
		
		
		Board b = new Board(10,24);
		b.displayBoard();
		
		
	}
	
}
