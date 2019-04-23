package main;

import java.awt.Font;
import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {

	public Board boardgame;
	private Form currentForm;
	private int time_alive;
	static GraphicsConfiguration gc;
	public JFrame frame;
	JTextPane text;
	
	public Game() {
		
		this.boardgame=new Board(10,24);
		this.time_alive=0;
		this.boardgame.nextForm();
		this.frame = new JFrame(gc);
		this.frame.setTitle("Tetris");
		this.frame.setSize(500,700);
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
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch( keyCode ) {
		        	case KeyEvent.VK_UP:
		        		System.out.println("UP");
		        		boardgame.rotateCurrentPiece();
		        		
		        		break;
			        case KeyEvent.VK_DOWN:
		        		System.out.println("DOWN");
		        		boardgame.moveCurrentPieceDown();
		        		
			            break;
			        case KeyEvent.VK_LEFT:
		        		System.out.println("LEFT");
		        		boardgame.moveCurrentPieceLeft();
			            break;
			        case KeyEvent.VK_RIGHT :
		        		System.out.println("RIGHT");
		        		boardgame.moveCurrentPieceRight();
			        	break;
			        case KeyEvent.VK_SPACE:
			        	System.out.println("SPACE");
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
		
		time_alive++;
		
		if(this.boardgame.isCurrentPieceFallen())
		{
			System.out.println("fallen");
			this.boardgame.deletePossibleLines();
			if(this.boardgame.isGameOver())
			{
				this.text.setText(this.boardgame.displayBoard()+"\n \n              GAME OVER NULLOS");
				return false;
			}
			this.boardgame.nextForm();
		}
		else {
			this.boardgame.moveCurrentPieceDown();
		}
		
		this.text.setText(this.boardgame.displayBoard());
		return true;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Game game = new Game();
		while(game.nextStep()) {
			Thread.sleep(400);
		}
	}


}
