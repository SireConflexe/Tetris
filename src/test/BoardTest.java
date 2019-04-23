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
		int nbOfLinesDeleted = b.deletePossibleLines();
		
		for (char[] row : b.getBoardgame()) {
			for(char ch : row)
				assertEquals('0', ch);
		}
		assertEquals(1, nbOfLinesDeleted);
	}
	
	@Test
	public void should_deleteFourLines_when_full() {
		
		Board b = new Board(5, 24);
		for (int i = 0; i < 4; i++) {
			b.newForm("i1"); //Make a 4x1 bloc appears
			b.dropCurrentPiece();
		}
		b.newForm("i1"); //Make a 4x1 bloc appears to complete the previous 4x1 blocs
		b.moveCurrentPieceDown();
		b.rotateCurrentPiece();
		b.moveCurrentPieceRight();
		b.moveCurrentPieceRight(); //max to the right
		b.dropCurrentPiece();

		int nbOfLinesDeleted = b.deletePossibleLines();
		
		for (char[] row : b.getBoardgame()) {
			for(char ch : row)
				assertEquals('0', ch);
		}
		assertEquals(4, nbOfLinesDeleted);
	}


	//test remplissage (copie d'une empreinte d'une pi�ce dans l'aire de jeu) : Fonction flood de position avec un pivotX et pivotY donn�

	//test rotation avec un bloc courant 
	//test rotation qui fait d�border
	//test rotation qui fonctionne
	
	//test d�placement horizontal
	
	
	//test game over derniere ligne
	
	
}
