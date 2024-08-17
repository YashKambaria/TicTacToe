import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		char[][] board=new char[3][3];
		int count=0; // this is used to count number of turns and if 9 inputs are taken and no one was
		//able to win then it will declare draw
		for (int i = 0; i <board.length ; i++) {
			for (int j = 0; j <board[i].length ; j++) {
				board[i][j]=' ';
			}
		}
		char player='X';
		boolean gameOver=false;
		Scanner sc=new Scanner(System.in);
		while (!gameOver){
			printboard(board);
			System.out.println("Player "+player+" enter : ");
			int row=sc.nextInt();
			int col=sc.nextInt();
			if(row > 2 || col > 2){
				System.out.println("Enter the values in the range");
			}
			else if(board[row][col]==' '){
				count++;
				board[row][col]=player;
				gameOver=hasWon(board,player);
				if (count==9){
					System.out.println("Its a draw as no Player was able to win the game");
					printboard(board);
					return;
				}
				if(gameOver){
					System.out.println("Player "+player+" has won the game");
					printboard(board);
				}
				else{
					player=(player=='X')?'O':'X';
				}
			}
			else{
				System.out.println("Invalid Move! ,Please try again ");
			}
			
		}
	}
	
	static boolean hasWon(char[][] board, char player) {
		//check for row
		for (int row = 0; row < board.length; row++) {
			if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
				return true;
			}
		}
		//check for column
		for (int col = 0; col < board[0].length; col++) {
			if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
				return true;
			}
		}
		//check for diagonal
		if (board[0][0] == player && board[1][1] == player && board[2][2] == player){
			return true;
		}
		if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
			return true;
		}
		return false;
	}
	
	static void printboard(char[][] board) {
		for (int i = 0; i <board.length ; i++) {
			for (int j = 0; j <board[i].length ; j++) {
				System.out.print(board[i][j]+" "+" | ");
			}
			System.out.println();
		}
	}
}
