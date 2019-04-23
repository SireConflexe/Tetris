package test;


import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.GraphicsConfiguration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

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
	
		Board b = new Board(10, 24);
		b.newForm("o1"); //The square in the game = 2x2 blocs so it needs to move down 22 times to reach the bottom
		for (int i = 0; i < 22; i++) {
			b.moveCurrentPieceDown();
		}
		assertEquals(b.isGameOver(),true);
		
	}
	
	@Test
	public void should_goDown_when_nothingHappens() {
		
		Game g = new Game();
		Board b = g.boardgame;

		CountDownLatch lock = new CountDownLatch(1);
		
		try {
			lock.await(2000,TimeUnit.MILLISECONDS);

	//		assertNotEquals(g.boardgame,b);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}
	
	
	@Test
	public void should_displayGame_when_gameLaunching() {
		
		Game g = new Game();
		
		assertEquals(g.frame.isVisible(),true);
	}
	
	
	@Test
	public void should_display_when_gameRuning() {
		
		Game g = new Game();
		
		assertEquals(g.frame.isVisible(),true);
	}
		
		
		// BONUS : 2/4
		
		//si game lancé, affichage lancé (tester le jframe)
		
		/* 
		 * 
		 * dans l'affichage, je me charges de rajouter le temps écoulé et le score ;-)
		 * 
		 * le changement de lvl se fait aussi, clairement
		 * 
		 * chercher affichage correct
		 */
		 
		
		
	
	
}
