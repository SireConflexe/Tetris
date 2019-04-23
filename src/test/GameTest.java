package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;	
import main.Game;

public class GameTest {
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
