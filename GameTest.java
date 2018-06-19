import java.util.*;


public class GameTest {
	
	public static void main(String[]args){
		
		Hangman test = new Hangman();
		
		test.getGrid();
		System.out.println("Hello");
		test.getUserWord();
		test.guessTest(test);
		
		
		
		
			
		
	}
	
	
}

class Hangman extends Word{
	int rows = 11;
	int columns = 20;
	String[][] body = new String[][]//generates an empty hangman grid
		{
		{"", "", "", "_", "_", "_", "_", "_", "", "", "", "", "", "", "", "", "", "", "", ""},
		{"", "", "", "|", " ", " ", " ", " ", "|", "", "", "", "", "", "", "", "", "", "", ""},
		{"", "", "", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
		{"", "", "", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
		{"", "", "", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
		{"", "", "", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
		{"", "", "", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
		{"", "", "", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
		{"", "", "", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
		{"", "-", "-", "-", "-", "-", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
		{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}
		};
	
	public Hangman(){}
	
	public void getGrid(){//displays grid to the console
		for (int i = 0; i < rows; i++) {
			
			for (int j = 0; j < columns; j++) {
				
				System.out.print(body[i][j]);
			}
			System.out.println();
			
		}
	}
	
	public void addHead(){ //adds a head to the hangman grid
		body[2][8] = "o";
		body[3][7] = "o";
		body[4][8] = "o";
		body[3][9] = "o";
	}
	
	public void addBody(){//adds a body to the hangman grid
		body[5][8] = "|";
		body[6][8] = "|";
		body[7][8] = "|";
		
	}
	
	public void addLeftArm(){//adds left arm to grid
		body[6][7] = "/";
	}
	
	public void addRightArm(){//adds right arm to grid
		body[6][9] = "\\";
	}
	
	public void addLeftLeg(){//adds left leg to grid
		body[8][7] = "/";
	}
	
	public void addRightLeg(){//adds right leg to grid
		body[8][9] = "\\";
	}
}

class Word {
	char[] guessWord;
	String userInput;
	char guess;
	char[] gList;
	
	Scanner in = new Scanner(System.in);
	
	public Word() {
		
	}
	
	public void getUserWord(){//gets the word the user wants their competitor to guess
		
		System.out.println("Enter a word for the other player to guess:");
		userInput = in.nextLine();
		
		guessWord = userInput.toCharArray();//adds the individual characters of the guess word to an array of characters
		gList = guessWord;
	}
	
	
	
	public void guessTest(Hangman h){
		int count = 0;
		int gallowCount = 0;
		int winCount = 0;
		int loseCount = 0;
		
		do{
		Scanner in = new Scanner(System.in);
		System.out.println("Please guess a letter:");
		guess = in.next().charAt(0);
		
		gList = new char[guessWord.length];
		
		for (int i = 0; i < guessWord.length; i++){
			if (!(guess == guessWord[i])){
				count++;
			}
			else {
				count = count;
			}
			if (guess == guessWord[i]){
				guessWord[i] = ' ';
			}
		}
		
		if (count == guessWord.length){
			loseCount++;
			if (loseCount == 1){
				h.addHead();
				h.getGrid();
			}
			else if (loseCount == 2){
				h.addBody();
				h.getGrid();
			}
			else if (loseCount == 3){
				h.addLeftArm();
				h.getGrid();
			}
			else if (loseCount == 4){
				h.addRightArm();
				h.getGrid();
			}
			else if (loseCount == 5){
				h.addLeftLeg();
				h.getGrid();
			}
			
			System.out.println("Wrong! Another body part is added to the gallows.");
		}
		else if (count < guessWord.length){
				winCount++;
				
				System.out.println("Correct!");
				h.getGrid();
				
			}
		
		count = 0;
		
		if (loseCount == 6){
			h.addRightLeg();
			h.getGrid();
			System.out.println("GAME OVER");
			System.out.println("The correct word was " + userInput + ".");
			break;
		}
		
		if (winCount == guessWord.length){
			System.out.println("You win! The word was " + userInput + "!");
		}
			
		}while((winCount <= (guessWord.length - 1)));
	
		
		//return winState;
	}
	
}