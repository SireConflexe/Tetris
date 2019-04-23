package test;


import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.GraphicsConfiguration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import  org.junit.Assert;	
import org.junit.jupiter.api.Test;	

import main.Board;
import main.Game;




public class GameTest {


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
	public void should_have100points_when_aLineIsOver() {
		Game g = new Game();
		assertEquals(100,g.getNbPoints(1));
	}
	
	@Test
	public void should_have900points_when_fiveLinesAreOver() {
		Game g = new Game();
		assertEquals(900,g.getNbPoints(5));
	}
		
	
}
