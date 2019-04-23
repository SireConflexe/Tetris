package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import main.Board;

public class BoardTest {
	
	@Test
	public void should_beAnArrayOf10x24_when_newBoard10x24() {
		int c = 10;
		int r = 24;
		
		Board b = new Board(c, r);
		assertEquals(b.getBoardgame().length, r);
		for (char[] row : b.getBoardgame()) {
			assertEquals(row.length, c);
		}
	}
	
	@Test
	public void should_beFilledBy0_when_newBoard() {
		int c = 10;
		int r = 24;
		
		Board b = new Board(c, r);

		for (char[] row : b.getBoardgame()) {
			for(char ch : row)
				assertEquals('0', ch);
		}
	}
	
	@Test
	public void should_beMiddle_when_newForm() {
		int c = 10;
		int r = 24;
		
		int columnExpected = (int) c/2;
		int rowExpected = 0;
		
		Board b = new Board(c, r);
		b.nextForm();
		assertEquals(rowExpected , b.getPivotX());
		assertEquals(columnExpected, b.getPivotY());
	}
	
	@Test
	public void should_beCollided_when_atTheBottom() {
		Board b = new Board(10, 24);
		b.newForm("o1"); //The square in the game = 2x2 blocs so it needs to move down 22 times to reach the bottom
		for (int i = 0; i < 22; i++) {
			b.moveCurrentPieceDown();
		}
		assertEquals(true, b.isCurrentPieceFallen());
	}
	
	@Test
	public void should_beCollided_when_hitOtherForm() {
		Board b = new Board(10, 24);
		b.newForm("i1"); //Make a 4x1 bloc appears
		for (int i = 0; i < 23; i++) { // move 23 times 
			b.moveCurrentPieceDown();
		}
		assertEquals(true, b.isCurrentPieceFallen());
		
		b.newForm("o1"); //Make a 2x2 bloc appears
		for (int i = 0; i < 21; i++) { // move 21 times (23-2)
			b.moveCurrentPieceDown();
		}
		assertEquals(true, b.isCurrentPieceFallen());
	}
	
	
	@Test
	public void should_beCollided_when_dropCurrentPiece() {
		Board b = new Board(10, 24);
		b.newForm("i1"); //Make a 4x1 bloc appears
		b.dropCurrentPiece();
		assertEquals(true, b.isCurrentPieceFallen());
	}
	
	
	@Test
	public void should_deleteOneLine_when_aLineIsFull() {
		
		Board b = new Board(4, 24);
		b.newForm("i1"); //Make a 4x1 bloc appears
		b.dropCurrentPiece();
		b.deletePossibleLines();
		
		for (char[] row : b.getBoardgame()) {
			for(char ch : row)
				assertEquals('0', ch);
		}
	}
	
	//General

	//test remplissage (copie d'une empreinte d'une pièce dans l'aire de jeu) : Fonction flood de position avec un pivotX et pivotY donné
	
	//test suppression des lignes (une ligne)
	//test suppression des lignes (plusieurs lignes)
	
	//test rotation avec un bloc courant 
	//test rotation qui fait déborder
	//test rotation qui fonctionne
	
	//test déplacement horizontal
	
	
	//test game over derniere ligne
	
	
}
