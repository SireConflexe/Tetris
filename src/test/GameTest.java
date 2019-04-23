package test;


import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;

//import static org.junit.Assert.assertThat;

import  org.junit.Assert;	
import org.junit.jupiter.api.Test;	

import main.Board;
import main.Game;




public class GameTest {

	
	

	static GraphicsConfiguration gc;
	
	
	@Test
	public void should_goRight_when_pressRightArrow() {
		
		Game g = new Game();
		
	//	assertEquals
	}
	
	@Test
	public void should_goLeft_when_pressLeftArrow() {
		
		Game g = new Game();
		
	//	assertEquals
	}
	
	@Test
	public void should_goDown_when_pressDownArrow() {
		
		Game g = new Game();
		
	//	assertEquals
	}
	
	@Test
	public void should_Drop_when_pressSpaceBar() {
		
		Game g = new Game();
		
	//	assertEquals
	}
	
	@Test
	public void should_gameOver_when_formAtLastLine() {
		
		Game g = new Game();
	
		for(int i =0;i<8;i++) {
			g.boardgame.dropCurrentPiece();
		}
		assertEquals(g.boardgame.isGameOver(),true);
		
	}
	
	@Test
	public void should_goDown_when_nothingHappens() {
		
		Game g = new Game();
		Board b = g.boardgame;

		
		for(int i=0;i<9999999;i++) {
			i*=i;
		}
		
		assertNotEquals(g.boardgame,b);
			
		
		
	}
	
	
	@Test
	public void should_displayGame_when_gameLaunching() {
		
		Game g = new Game();
		
		
		JFrame f = new JFrame(gc);
		f.setTitle("Tetris");
		f.setSize(500,700);
		f.setLocation(400, 200);
		
		
		assertEquals(g.frame,f);
	}
	
	@Test
	public void should_have100points_when_aLineIsOver() {
		Game g = new Game();
		assertEquals(100,g.getNbPoints(1));
	}
	
	@Test
	public void should_have900points_when_fiveLinesAreOver() {
		Game g = new Game();
		assertEquals(900,g.getNbPoints(5));
	}
		
		
		// BONUS : 2/4
		
		//si game lancé, affichage lancé (tester le jframe)
		
		// si keyboard pressé, drop the piece
		
		/* 
		 * 
		 * dans l'affichage, je me charges de rajouter le temps écoulé et le score ;-)
		 * 
		 * le changement de lvl se fait aussi, clairement
		 * 
		 * chercher affichage correct
		 */
		 
		
		
	
	
}
