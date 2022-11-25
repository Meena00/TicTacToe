/**
 * @author Meena Anwar
 */

public abstract class Player {

  /**
   *
   * @param argument
   * @return
   */
  public abstract TicTacToe chooseMove(TicTacToe argument);


  /**
   *
   * returns possible moves to play
   * @param newGame
   * @return
   */

  public double boardValue(TicTacToe newGame) {
    double returnValue = 0.0;
    if(newGame.checkWin(this) == true) {
      returnValue = 1.0;
    }
    else if(newGame.checkLose(this) == true) {
      returnValue = -1.0;
    }
    return returnValue;
  }
}