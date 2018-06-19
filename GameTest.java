import java.util.*;


public class GameTest {
	
	public static void main(String[]args){
		
		Hangman test = new Hangman();
		
		test.getUserWord();
		
	}
	
	
}

class Hangman extends Word{
	int rows = 10;
	int columns = 20;
	String[][] body = new String[][]
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
		{"", "-", "-", "-", "-", "-", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}
		};
	public Hangman(){}
	
	public void getGrid(){
		for (int i = 0; i < rows; i++) {
			
			for (int j = 0; j < columns; j++) {
				
				System.out.print(body[i][j]);
			}
			System.out.println();
			
		}
		
	}
	
	public void addHead(){
		body[2][8] = "o";
		body[3][7] = "o";
		body[4][8] = "o";
		body[3][9] = "o";
	}
	
	public void addBody(){
		body[5][8] = "|";
		body[6][8] = "|";
		body[7][8] = "|";
		
	}
	
	public void addLeftArm(){
		body[6][7] = "/";
	}
	
	public void addRightArm(){
		body[6][9] = "\\";
	}
	
	public void addLeftLeg(){
		body[8][7] = "/";
	}
	
	public void addRightLeg(){
		body[8][9] = "\\";
	}
}

class Word {
	char[] guessWord;
	String userInput;
	
	Scanner in = new Scanner(System.in);
	
	public Word() {
		
	}
	
	public void getUserWord(){
		System.out.println("Enter a word for the other player to guess:");
		userInput = in.nextLine();
		
		guessWord = userInput.toCharArray();
		for (int i = 0; i < guessWord.length; i++){
			System.out.print(guessWord[i] + ", ");
		}
	}
	
}