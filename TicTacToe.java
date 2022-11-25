
/**
 * @author Meena Anwar
 */
public class TicTacToe {

  private char[][] board = new char[3][3];
  private Player x;
  private Player o;

  /**
   * defines array as 2D and assigns _ for blank fields 
   * @param x
   * @param o
   */
  public TicTacToe(Player x, Player o) {
    this.x = x;
    this.o = o;
    char[][] blankArray = {{'_','_','_'},{'_','_','_'},{'_','_','_'}};
    this.setBoard(blankArray);
  }

  /**
   * 
   * @param newGameBoard
   */
  public void setBoard(char[][] newGameBoard) {
    this.board = newGameBoard;
  }

  /**
   *creates parameter for newX and sets it for player 
   * @param newX
   */
  public void setX(Player newX) {
    this.x = newX;
  }

  /**
   * creates parameter newO and sets it for player 
   * @param newO
   */
  public void setO(Player newO) {
    this.o = newO;
  }

  /**
   *
   * @return
   */
  public char[][] getBoard() {
    return this.board;
  }

  /**
   *
   * @return
   */
  public Player getX() {
    return this.x;
  }

  /**
   *
   * @return
   */
  public Player getO() {
    return this.o;
  }

  /**
   *returns number of spaces on board
   * @return
   */
  public int countBlanks() { 
    int blankCounter = 0;
    for(int i = 0; i < 3; ++i) {
      for(int j = 0; j < 3; ++j) {
        if(board[i][j] == '_') {
          blankCounter++;
        }
      }
    }
    return blankCounter;
  }

  /**
   * assigns x and o for each player 
   * @param secondPlayer
   * @return
   */
  public char markerForPlayer(Player secondPlayer) {
    char returnVal = ' ';
    if(secondPlayer == this.getO()) {
      returnVal = 'O';
    }else if(secondPlayer == this.getX()) {
      returnVal = 'X';
    }
    return returnVal;
  }

  /**
   * checks win condition for player 
   * @param secondPlayer
   * @return
   */
  public boolean checkWin(Player secondPlayer) {
    char winVal = this.markerForPlayer(secondPlayer);
    char[][] newGameBoard = this.getBoard();
    boolean win = false;
    for(int i = 0; i < 3; ++i) {
      if(((newGameBoard[i][0] == newGameBoard[i][1]) && (newGameBoard[i][1] == newGameBoard[i][2]) && (newGameBoard[i][2] == winVal)) || ((newGameBoard[0][i] == newGameBoard[1][i]) && (newGameBoard[1][i] == newGameBoard[2][i]) && (newGameBoard[2][i] == winVal))) {
        win = true;
      }
    }
    return win;
  }

  /**
   * checks loss condition for player 
   * @param secondPlayer
   * @return
   */
  public boolean checkLose(Player secondPlayer) {
    char winVal;
    if(this.markerForPlayer(secondPlayer) == 'O') {
      winVal = 'X';

    }else {
      winVal = 'O';
    }
    char[][] newGameBoard = this.getBoard();
    boolean lose = false;
    for(int i = 0; i < 3; ++i) {
      if(((newGameBoard[i][0] == newGameBoard[i][1]) && (newGameBoard[i][1] == newGameBoard[i][2]) && (newGameBoard[i][2] == winVal)) || ((newGameBoard[0][i] == newGameBoard[1][i]) && (newGameBoard[1][i] == newGameBoard[2][i]) && (newGameBoard[2][i] == winVal))) {
        lose = true;
      }
    }
    return lose;
  }

  /**
   * checks if draw for players 
   * @return
   * 
   */
  public boolean checkDraw() {
    char[][] newGameBoard = this.getBoard();
    boolean draw = true;
    Player newO = this.getO();
    Player newX = this.getX();
    for(int i = 0; i < 3; ++i) {
      for(int j = 0; j < 3; ++j) {
        if(newGameBoard[i][j] == '_') {
          draw = false;
        }
      }
    }
    if(checkWin(newO) == true || checkWin(newX) == true) {
      draw = false;
    }
    return draw;
  }

  /**
   * 
   * @return
   */
  public String toString() {
    char[][] newGameBoard = this.getBoard();
    String row1 = Character.toString(newGameBoard[0][0]) + Character.toString(newGameBoard[0][1]) + Character.toString(newGameBoard[0][2]) + "\n";
    String row2 = Character.toString(newGameBoard[1][0]) + Character.toString(newGameBoard[1][1]) + Character.toString(newGameBoard[1][2]) + "\n";
    String row3 = Character.toString(newGameBoard[2][0]) + Character.toString(newGameBoard[2][1]) + Character.toString(newGameBoard[2][2]) + "\n" + "\n";
    String wholeTable = row1 + row2 + row3;
    return wholeTable;
  }

  /**
   *
   * @param secondPlayer
   * @return
   */
  public TicTacToe[] possibleMoves(Player secondPlayer) {
    Player newX = this.getX();
    Player newO = this.getO();
    char playerMark = this.markerForPlayer(secondPlayer);

    int blankCounter = 0;
    for(int i = 0; i < 3; ++i) {
      for(int j = 0; j < 3; ++j) {
        if(this.board[i][j] == '_') {
          blankCounter++;
        }
      }
    }

    TicTacToe[] returnVal = new TicTacToe[blankCounter + 1]; //Add 1 to the array size, otherwise an error is thrown

    for(int m = 0; m < returnVal.length; ++m) {
      TicTacToe newGame = new TicTacToe(newX, newO);
      for(int i = 0; i < 3; ++i) {
        for(int j = 0; j < 3; ++j) {
          newGame.board[i][j] = this.board[i][j];
        }
      }
      returnVal[m] = newGame;
    }

    int counterReturn = 0;

    for(int i = 0; i < 3; ++i) {
      for(int j = 0; j < 3; ++j) {

        if(returnVal[counterReturn].board[i][j] == '_'){
          returnVal[counterReturn].board[i][j] = playerMark;
          counterReturn++;
        }
      }
    }
    return returnVal;
  }
}
