package main;

import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {

	private Board boardgame;
	private Form currentForm;
	private int time_alive;
	static GraphicsConfiguration gc;
	JFrame frame;
	JTextPane text;
	
	public Game() {
		
		this.boardgame=new Board(10,24);
		this.time_alive=0;
		this.currentForm=this.boardgame.nextForm();
		this.frame = new JFrame(gc);
		this.frame.setTitle("Tetris tududu");
		this.frame.setSize(980,640);
		this.frame.setLocation(400, 200);
		
		this.text = new JTextPane();
		this.text.setEditable(false);
		this.text.setText(this.boardgame.displayBoard());
		this.frame.add(this.text);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		System.out.println("salut");
		
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
		        	case 38:
		        		System.out.println("UP");
		        		break;
			        case KeyEvent.VK_DOWN:
		        		System.out.println("DOWN");
			            break;
			        case KeyEvent.VK_LEFT:
		        		System.out.println("LEFT");
			            break;
			        case KeyEvent.VK_RIGHT :
		        		System.out.println("RIGHT");
			        	break;
				}
				
			}
		});
		this.frame.setFocusable(true);
		this.frame.requestFocusInWindow();
		this.frame.setVisible(true);
		
	}
	
	
	//called every second
	public void nextStep() {
		
		time_alive++;
		
		
		if(this.detectForm()) {
			
			this.fixForm();

			this.currentForm=this.boardgame.nextForm();
		}
		
		else {
			//en cran en bas
		}
		
		
		this.text.setText(this.boardgame.displayBoard()+"2");
		
	}
	
	
	//Detect if current playable form will be in contact with a solid form at next step
	public boolean detectForm() {
		
		
		return false;
	}
	
	
	//fix current if solid form detected
	public void fixForm() {
		
		
		
		
	}
	


	
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		Game superTetrisOfDoom = new Game();
		while(true) {
			Thread.sleep(10000);
			//superTetrisOfDoom.nextStep();
		}
	}


}
