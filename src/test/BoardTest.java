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
	
	//General
	//test de taille du tableau lors de la creation
	//test rempli par des 0 lors de l'initialisation
	
	//test tous les templates sont composés de 4 blocs
	
	//test position d'une nouvelle piece est au milieu tout en haut
	
	//test remplissage (copie d'une empreinte d'une pièce dans l'aire de jeu) : Fonction flood de position avec un pivotX et pivotY donné
	
	//test collision avec le bas du tableau fonction isPieceFallen
	//test collision avec d'autres blocs fonction isPieceFallen
	
	//test suppression des lignes (une ligne)
	//test suppression des lignes (plusieurs lignes)
	
	//test rotation avec un bloc courant 
	//test rotation qui fait déborder
	//test rotation qui fonctionne
	
	//test déplacement horizontal
	
	
	//test game over derniere ligne
	
	
}
