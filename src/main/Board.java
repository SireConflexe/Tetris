package main;

public class Board {
	public enum caseState{EMPTY,FILLED};
	
	private int columns, rows;
	private char boardgame[][];
	private int pivotX,pivotY;
	private Forms forms;
	
	private int SIZE = 4;
	
	public Board(int c, int r) {
		
		this.columns=c;
		this.rows=r;
		this.boardgame= new char[r][c];
		this.pivotX = (int) c/2;
		this.pivotY = 0;
		
		this.forms = new Forms();
		
		//test affichage
		
		for(int i=0; i<this.rows;i++) {
			for(int j=0;j<this.columns;j++) {
				if(j==5 && i== 4) {
					this.boardgame[i][j]='X';
				}
			}
		}
	}
	
	public String displayBoard() {
		
		String display = new String();
		display+="|_______T__E__T__R__I__S_______|\n";
		for(int i=0; i<this.rows;i++) {
			display+=("|");
			for(int j=0;j<this.columns;j++) {
				if(this.boardgame[i][j]=='X'){
					display+="  "+this.boardgame[i][j]+"  ";
				}
				else {
					display+="       ";
				}
				
			}
			display+="|\n";
		}
		display+="|______________________________|\n";
		return display;
		
	}
	
	void flood(int i, int j, int px, int py,String formKey, char value, boolean[][] visited)
	{
	    if(px < 0 || px >= this.SIZE || py < 0 || py >= this.SIZE || visited[px][py] || this.forms.allForms.get(formKey).template[px][py] == '0')
	        return;
	 
	    visited[px][py] = true;
	    this.boardgame[i][j] = value;
	 
	    flood(i, j - 1, px, py - 1, formKey, value, visited);
	    flood(i + 1, j, px + 1, py, formKey, value, visited);
	    flood(i, j + 1, px, py + 1, formKey, value, visited);
	    flood(i - 1, j, px - 1, py, formKey, value, visited);
	}
	
	void floodFill(int i, int j, int px, int py, String formKey, char value)
	{
	    boolean [][] visited = new boolean[SIZE][SIZE];
	 
	    for(int l = 0; l < SIZE; ++l)
	        for(int m = 0; m < SIZE; ++m)
	            visited[l][m] = false;
	 
	    flood(i, j, px, py, formKey, value, visited);
	}
	
	void drawForm(String formKey){
		
		int x = this.forms.allForms.get(formKey).getPosX();
		int y = this.forms.allForms.get(formKey).getPosY();
		floodFill(this.pivotX, this.pivotY,x, y, formKey, 'X');
	}
	void clearPiece(String formKey)
	{
		int x = this.forms.allForms.get(formKey).getPosX();
		int y = this.forms.allForms.get(formKey).getPosY();
	 
	    floodFill(this.pivotX, this.pivotY, x, y,  formKey, ' ');
	}
	public void addForm(int pos_x, int pos_y) {
		
		this.boardgame[pos_x][pos_y]='X';
	}
	
	
	public Form nextForm() {
		
		return this.forms.randForm();
	}
	
	public static void main(String[] args) {
		
		
		Board b = new Board(10,24);
		
		b.pivotY = 4;
		b.drawForm("o1");
		b.displayBoard();
		
		b.clearPiece("o1");
		b.pivotX++;
		b.drawForm("o1");
		b.displayBoard();
		
		b.clearPiece("o1");
		b.pivotX++;
		b.drawForm("o1");
		b.displayBoard();
		
		
	}
	
}
