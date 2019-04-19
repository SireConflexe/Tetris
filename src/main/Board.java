package main;

public class Board {
	public enum caseState{EMPTY,FILLED};
	
	private int columns, rows;
	private char boardgame[][];
	private int pivotX,pivotY,originX,originY;
	private Forms forms;
	private String currentForm;
	private int SIZE = 4;
	
	private boolean flagMovableRotable;
	
	public Board(int c, int r) {
		
		this.columns=c;
		this.rows=r;
		this.boardgame= new char[r][c];
		this.pivotX = 0;
		this.pivotY = (int) c/2;
		this.originX = 0;
		this.originY = (int) c/2;
		
		this.forms = new Forms();
		
		
		
		//test affichage
		
		for(int i=0; i<this.rows;i++) {
			for(int j=0;j<this.columns;j++) {
				if(i== 4) {
					this.boardgame[i][j]='X';
				}
				else {
					this.boardgame[i][j]='0';
				}
			}
		}
	}
	
	public String displayBoard() {
		
		String display = new String();
		display+="    |_______T__E__T__R__I__S_______|\n";
		for(int i=0; i<this.rows;i++) {
			display+=("    |");
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
		display+="    |______________________________|\n";
		return display;
		
	}
	
	//moving form
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
	
	//check collision
	void flood(int i, int j, int px, int py, String formKey, boolean[][] visited)
	{
		//System.out.println(this.forms.allForms.get(formKey).template[px][py]);
	    //System.out.println(px < 0 || px >= this.SIZE || py < 0 || py >= this.SIZE || visited[px][py] || this.forms.allForms.get(formKey).template[px][py] == '0');
	    
	    if(px < 0 || px >= this.SIZE || py < 0 || py >= this.SIZE || visited[px][py] || this.forms.allForms.get(formKey).template[px][py] == '0')
	        return;
	 
	    visited[px][py] = true;
	    
	    if(i < 0 || i >= this.rows || j < 0 || j >= this.columns || boardgame[i][j] != '0')
	    {
	    	this.flagMovableRotable = false;
	        return;
	    }
	 
	    flood(i, j - 1, px, py - 1, formKey, visited);
	    flood(i + 1, j, px + 1, py, formKey, visited);
	    flood(i, j + 1, px, py + 1, formKey, visited);
	    flood(i - 1, j, px - 1, py, formKey, visited);
	}
	
	void floodFill(int i, int j, int px, int py, String formKey, char value)
	{
	    boolean [][] visited = new boolean[SIZE][SIZE];
	 
	    for(int l = 0; l < SIZE; ++l)
	        for(int m = 0; m < SIZE; ++m)
	            visited[l][m] = false;
	 
	    flood(i, j, px, py, formKey, value, visited);
	}
	
	boolean isCurrentPieceMovable(int i, int j)
	{
	    clearPiece(this.currentForm);

	    
	    boolean [][] visited = new boolean[SIZE][SIZE];
	 
	    for(int l = 0; l < SIZE; ++l)
	        for(int m = 0; m < SIZE; ++m)
	            visited[l][m] = false;
	    
	    int posFormX = this.forms.allForms.get(this.currentForm).getPosX();
	    int posFormY = this.forms.allForms.get(this.currentForm).getPosY();
	    this.flagMovableRotable = true;
	    
	    flood(i, j,posFormX, posFormY,  this.currentForm, visited);
	    drawForm(this.currentForm);
	    return this.flagMovableRotable;
	}
	boolean isCurrentPieceRotable()
	{
	    clearPiece(this.currentForm);
	 
	    boolean [][] visited = new boolean[SIZE][SIZE];
	 
	    for(int i = 0; i < SIZE; ++i)
	        for(int j = 0; j < SIZE; ++j)
	            visited[i][j] = false;
	    
	    
	    int posFormX = this.forms.allForms.get(this.currentForm).getPosX();
	    int posFormY = this.forms.allForms.get(this.currentForm).getPosY();
	    

	    int nextOrientation = Integer.parseInt(this.currentForm.substring(1)) +1;
	    String nextName = this.currentForm.substring(0,1) + String.valueOf(nextOrientation);
	    //System.out.println(nextName);
	    
	    this.flagMovableRotable = true;
	    if(this.forms.allForms.containsKey(nextName)) {
	    	flood(posFormX, posFormY, this.pivotX, this.pivotY, nextName, visited);
	    }
	    else {
	    	flood(posFormX, posFormY, this.pivotX, this.pivotY, this.currentForm.substring(0,1) + String.valueOf(1), visited);
	    }
	    drawForm(this.currentForm);
	    return this.flagMovableRotable;
	}
	

	void moveCurrentPieceDown()
	{
	    if(isCurrentPieceMovable(this.pivotX + 1, this.pivotY))
	    {
	    	System.out.println("ok");
	        clearPiece(this.currentForm);
	        this.pivotX++;
	        drawForm(this.currentForm); 
	    }
	}
	 
	void moveCurrentPieceLeft()
	{
	    if(isCurrentPieceMovable(this.pivotX, this.pivotY - 1))
	    {
	        clearPiece(this.currentForm);
	        this.pivotY--;
	        drawForm(this.currentForm); 
	    }
	}
	 
	void moveCurrentPieceRight()
	{
	    if(isCurrentPieceMovable(this.pivotX, this.pivotY + 1))
	    {
	    	 clearPiece(this.currentForm);
		     this.pivotY++;
		     drawForm(this.currentForm); 
	    }
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
	 
	    floodFill(this.pivotX, this.pivotY, x, y,  formKey, '0');
	}
	
	void newForm(String formKey)
	{
	    this.pivotX = this.originX;
	    this.pivotY = this.originY;
	    this.drawForm(formKey);
	    this.currentForm = formKey;
	}
	public void addForm(int pos_x, int pos_y) {
		
		this.boardgame[pos_x][pos_y]='X';
	}
	
	
	public Form nextForm() {
		
		return this.forms.randForm();
	}
	
	public static void main(String[] args) {
		
		
		Board b = new Board(10,24);
		
		b.newForm("o1");
		b.moveCurrentPieceDown();
		b.displayBoard();
		
		b.moveCurrentPieceDown();
		b.displayBoard();
		
		b.moveCurrentPieceDown();
		b.displayBoard();
		//System.out.println(b.isCurrentPieceMovable(b.pivotX+1, b.pivotY));
		//System.out.println(b.isCurrentPieceRotable());
		
		/*
		b.clearPiece("o1");
		b.pivotX++;
		b.drawForm("o1");
		b.displayBoard();
		
		b.clearPiece("o1");
		b.pivotX++;
		b.drawForm("o1");
		b.displayBoard();
        */
		
	}
	
}
