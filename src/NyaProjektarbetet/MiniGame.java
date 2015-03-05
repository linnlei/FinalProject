package NyaProjektarbetet;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MiniGame extends Room implements ActionListener,MouseListener{
	private static final long serialVersionUID = 1L;
	public JFrame window;
	public JPanelWithBackground pan, pan2;
    public JButton startB;
    public JButton instructB, closeB, cash, replay, emptyButton;
    public JTextArea text =  new JTextArea();
    public JLabel contentPane;
     
	public static JTextArea pointsSoFarText = new JTextArea();
	private static JTextArea mathProblem = new JTextArea();

    static boolean cursorClick = false;
    
    public MiniGameActions miniGameActions;
    public Player player;

    public MiniGame(Player player)
    {
    	this.player = player;
    	miniGameActions = new MiniGameActions(this);
    	window = new JFrame ("Whack A Mole-spel");
		pan = new JPanelWithBackground("pictures/falt.jpg");
    	
    	ImageIcon end = new ImageIcon("pictures/avsluta.png");
    	ImageIcon inst = new ImageIcon("pictures/instruk.png");
    	ImageIcon icon = new ImageIcon("pictures/c.png"); 
    	ImageIcon sticon = new ImageIcon("pictures/start.png");
    	ImageIcon money = new ImageIcon("pictures/coinsS.png");
    	
    	closeB = new JButton(end);
    	startB = new JButton(icon);
    	instructB = new JButton(inst);
    	cash = new JButton(money);
    	
    	drawWindowWithThings();

    	startB.setRolloverIcon(sticon);
    	
    	closeB.addActionListener(this);
    	startB.addActionListener(this);
    	instructB.addActionListener(this);
    	
    	window.pack();
    	window.setVisible(true);
    }
    
    /**
     * Adds components (buttons) to the visible JFrame and JPanel.
     */
    public void drawWindowWithThings(){

    	window.add(pan);

    	pan.setPreferredSize (new Dimension (700, 700));
    	pan.setLayout(new GridLayout(5,3));


    	closeB.setContentAreaFilled(false);
        closeB.setBorderPainted(false);
        
        startB.setContentAreaFilled(false);
        startB.setBorderPainted(false);
        
        instructB.setContentAreaFilled(false);
        instructB.setBorderPainted(false);
        
        cash.setContentAreaFilled(false);
        cash.setBorderPainted(false);
        
    	pan.add(closeB);
    	pan.add(instructB);
    	pan.add(startB);
     	pan.add(cash);
    	pan.add(text);
    }
    
    /**
     * Class-constructor
     * 
     * @param minigame
     */
    public void actionPerformed (ActionEvent e)
    {
		if (e.getSource() == startB)
		{
	    	window.remove(pan);

	    	Sound.playSomeSound("Randomize27.wav");
	    	startMoleGame();
		}
		else if (e.getSource() == closeB){
			Sound.stopSound();
			if( miniGameActions.getScore() > 0 ){
				player.changeMoney(miniGameActions.getScore());
			}
			Sound.stopSound();
			window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));	
		}
		else if (e.getSource() == instructB)
		{
			Sound.playSomeSound("Randomize8.wav");
			text.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 21));
			text.setText("  Spelinstruktioner:\n  Klicka p� mullvaderna som visar r�tt svar till matteproblemet\n  f�r att vinna pengar. \n  R�tt svar ger 10 kr och fel svar ger -2 kr. \n  Vinner man inget alls tas inga pengar bort.");
		    text.setEditable(false);
		}
		else if (e.getSource() == replay)
		{
			pan2.remove(replay);
			window.remove(pan2);
			startMoleGame();
		}
	}
    
    private void startMoleGame(){
    	pan2 = new JPanelWithBackground("pictures/falt.jpg");
    	pan2.setPreferredSize (new Dimension (700, 700));
    	pan2.setLayout(new GridLayout(6,5));
		window.add(pan2);

		setTheCursor();
    	createMole();

        pan2.addMouseListener(this);
		
        // �ndrar texten i textrutorna
    	//pointsSoFarText.setPreferredSize (new Dimension (40, 40));
    	pointsSoFarText.setFont(new Font("Serif", Font.BOLD, 28));
    	
    	//mathProblem.setPreferredSize (new Dimension (40, 40));
    	mathProblem.setFont(new Font("Serif", Font.BOLD, 50));

    	window.pack();
    }

    /**
     * �ndrar muspekaren till en hammare
     */
	public void setTheCursor(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		if(cursorClick == true){
			Image image = toolkit.getImage("pictures/hammer2.png");
			
			Point hotSpot = new Point(0,0);
			Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "hammer2");
			 
		    pan2.setCursor(cursor);
		    cursorClick = false;
		}
		else{
			Image image = toolkit.getImage("pictures/hammer.png");
	
			Point hotSpot = new Point(0,0);
			Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "hammer");
			 
		    pan2.setCursor(cursor);}  
	}

	@Override
	public void mousePressed(MouseEvent e) {
		cursorClick = true;
		setTheCursor();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		setTheCursor();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * Creates a field of moles
	 */
	public void createMole(){
    	int b = 0;
    	
    	String label = "";

    	Random rand = new Random();
    	int j = rand.nextInt(9) + 3;
    	
    	pan2.removeAll();
    	
    	pan2.add(pointsSoFarText);
    	pointsSoFarText.setEditable(false);
    	
    	pan2.add(mathProblem);
    	mathProblem.setEditable(false);
    	
    	pan2.add(closeB);
    	
    	for( int i=0; i<12; i++ ){
    		b = rand.nextInt(101); // slumpade tal till mullvadar
    		label = "" + b;
    		
    		if( i < 3 ){
    			emptyButton = new JButton();
    			//emptyButton.setBounds(100,a,100, 100);
    			emptyButton.setOpaque(false);
    			emptyButton.setContentAreaFilled(false);
    			emptyButton.setBorderPainted(false);
        		pan2.add(emptyButton);
    		}
    		else if( i == j ){
    			miniGameActions.createMathProblemSolution();
    			Mole moleIm = new Mole(miniGameActions.getMathSolutionString(),this);
	        	pan2.add(moleIm);
	        	moleIm.addMouseListener(this);

    		}
    		else{
    			Mole moleIm = new Mole(label, this);
        		pan2.add(moleIm);
        		moleIm.addMouseListener(this);
    		}
    	}
    	window.pack();
	}

	public void tryAgain(){
		replay = new JButton("Spela igen");
    	replay.addActionListener(this);
    	replay.setFont(new Font("Serif", Font.BOLD, 40));
    	replay.setForeground(Color.RED);
    	replay.setOpaque(false);
    	replay.setContentAreaFilled(false);
    	replay.setBorderPainted(false);
    	
		pan2.removeAll();
		pan2.add(replay);
		pan2.add(closeB);
		window.add(pan2);
		window.pack();
		
		System.out.println("add replay");
	}
    public JTextArea getPointsSoFarText()
    {
    	return pointsSoFarText;
    }
    
    public JTextArea getMathProblemTextArea()
    {
    	return mathProblem;
    }
}
