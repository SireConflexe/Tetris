package main;

import java.awt.Font;
import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {

	public Board boardgame;
	public int level, nbOfLinesDeleted, nbPoints;
	static GraphicsConfiguration gc;
	public JFrame frame;
	JTextPane text;
	
	public Game() {
		this(10,24);
	}
	public Game(int rows,int columns) {
		this.nbOfLinesDeleted = 0;
		this.level = 0;
		this.boardgame=new Board(rows,columns);

		this.boardgame.nextForm();
		this.frame = new JFrame(gc);
		this.frame.setTitle("Tetris");
		this.frame.setSize(400,550);
		this.frame.setLocation(400, 200);
		
		this.text = new JTextPane();
		this.text.setEditable(false);
		this.text.setText(this.boardgame.displayBoard());
		Font f = new Font("Verdana", Font.BOLD, 12);
		this.text.setFont(f);
		this.frame.add(this.text);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		
		this.text.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch( keyCode ) {
		        	case KeyEvent.VK_UP:
		        		boardgame.rotateCurrentPiece();
		        		break;
			        case KeyEvent.VK_DOWN:
		        		boardgame.moveCurrentPieceDown();
			            break;
			        case KeyEvent.VK_LEFT:
		        		boardgame.moveCurrentPieceLeft();
			            break;
			        case KeyEvent.VK_RIGHT :
		        		boardgame.moveCurrentPieceRight();
			        	break;
			        case KeyEvent.VK_SPACE:
			        	boardgame.dropCurrentPiece();
			        	break;
				}
			}
		});
		this.frame.setFocusable(true);
		this.frame.requestFocusInWindow();
		this.frame.setVisible(true);
	}

	//called every second
	public boolean nextStep() {
		
		if(this.boardgame.isCurrentPieceFallen())
		{
			int nbOfLineDeletedCurrent = this.boardgame.deletePossibleLines();
			int nbPointsCurrent =  this.getNbPoints(nbOfLineDeletedCurrent);
			this.nbPoints += nbPointsCurrent;
			this.nbOfLinesDeleted += nbOfLineDeletedCurrent;
			this.level = (int) this.nbOfLinesDeleted/10;
			if(this.boardgame.isGameOver())
			{
				String textD= this.boardgame.displayBoard();
				textD+="                [  Level : "+this.level+"       Points : "+this.nbPoints+"    ]";
				textD+="\n \n                        GAME OVER";
				this.text.setText(textD);
				return false;
			}
			this.boardgame.nextForm();
		}
		else {
			this.boardgame.moveCurrentPieceDown();
		}
		
		String textD= this.boardgame.displayBoard();
		textD+="                [  Level : "+this.level+"       Points : "+this.nbPoints+"    ]";
		this.text.setText(textD);
		return true;
	}
	
	public int getNbPoints(int nbLinesDeleted)
	{
		return ((int) (nbLinesDeleted / 4))*800 + (nbLinesDeleted - (int) (nbLinesDeleted / 4) *4)*100;
	}
	
	public int getIntervalTime() {
		return (400-this.level*10>0)?400-this.level*10:10;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Game game = new Game();
		while(game.nextStep()) {
			Thread.sleep(game.getIntervalTime());
		}
	}


}
