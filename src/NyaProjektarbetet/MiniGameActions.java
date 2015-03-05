package NyaProjektarbetet;

import java.util.Random;

/**
 * The MiniGameActions class creates a button and its graphics.
 * This class contains an instance of the MiniGame class.
 * 
 * @author Linda Karlsson
 * @version 2015-03-05
 */
public class MiniGameActions {
	private MiniGame miniGame;
	private static int mathSolution = 0;
	private static int product1 = 0;
	private static int product2 = 0;
	
    private int wrongAnsweres;
    private int score;
    
    /**
     * Class-constructor
     * 
     * @param minigame
     */
	public MiniGameActions(MiniGame miniGame) {
		Sound.stopSound();
		this.miniGame = miniGame;
		Sound.soundInLoop("Jaunty_Gumption.wav");
	}

    /**
     * Creates a mathproblem and a solution to the problem.
     */
	public void createMathProblemSolution() {
    	Random rand = new Random();
    	product1 = rand.nextInt(11); 
    	product2 = rand.nextInt(11); 
    	
    	mathSolution = product1 * product2;
    	miniGame.getMathProblemTextArea().setText(getMathProblemString());
    }
    
    /**
     * Turns the products of the problem into a string and returns it.
     * 
     * @return mathProbText    a string containing the mathproblem to solve
     */
    public String getMathProblemString() {
    	String mathProbText = ("\n      " + product1 + "x"+ product2);
    	return mathProbText;
    }
    
    /**
     * Turns the mathsolution of the problem into a string and returns it.
     * 
     * @return solution    a string containing the solution to the mathproblem
     */
    public String getMathSolutionString() {
    	String solution = ("" + mathSolution);
    	return solution;
    }
    
    /**
     * Returns how many times the player got the answere wrong.
     * 
     * @return wrongAnsweres    an int
     */
    public int getWrongAnswers() {
    	return wrongAnsweres;
    }
    
    /**
     * Turns the products of the problem into a string and returns it.
     */
    public void setWrongAnswers() {
    	if(wrongAnsweres > 3){
    		wrongAnsweres = 0;
    	}
    	else{
    		wrongAnsweres += 1;
    	}
    }
    
    /**
     * Returns the score.
     */
    public int getScore() {
    	return score;
    }

    /**
     * Sets the score.
     */
    public void setScore(int value) {
    	score += value;
    }
}
