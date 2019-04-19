package test;


//import static org.junit.Assert.assertThat;

import  org.junit.Assert;	
import org.junit.jupiter.api.Test;

import main.Board;
import main.Game;


public class GameTest {

	
	
	@Test
	public void testCreate() {
		
		
		Game g = new Game();
		assertThat(g.getBoard()).isEqualTo(new Board(10,24));
		
		
	}
	
}
