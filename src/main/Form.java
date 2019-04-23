package main;

public class Form {
	char [][] template;
	
	private int posX,posY;
	Form(char[][] template,int posX,int posY)
	{
		this.template = template;
		this.posX = posX;
		this.posY = posY;
	}
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	
	//For test purpose
	public char[][] getTemplate() {
		return template;
	}
}
