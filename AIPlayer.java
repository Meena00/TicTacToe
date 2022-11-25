import java.util.Scanner;
/**
 * @author Meena Anwar 
 */
public class AIPlayer extends Player{
  private String name;
  private Player opponent;

  /**
   *
   * @param name
   * @param opponent
   */

  public AIPlayer(String name, Player opponent) {
    this.name = name;
    this.opponent = opponent;
  }

  /**
   *
   * @return
   */

  public String getName() {
    return this.name;
  }

  /**
   *
   * @return
   */

  public Player setOpponent() {
    return this.opponent;
  }

  /**
   *
   * @param name
   */

  public void setName(String name) {
    this.name = name;
  }

  /**
   *
   * @param opponent
   */

  public void setOpponent(Player opponent) {
    this.opponent = opponent;
  }

  /**
   * assigns name with (AI)
   * @return
   */

  @Override
  public String toString() { 
    String newString = this.getName() + " (AI)";
    return newString;
  }

  /**
   * sets possible moves for opponent
   * returns 1 if player has won
   * returns -1 if player has lost
   * returns 0 if game is draw
   * @param argument
   * @return
   */

  public double minValue(TicTacToe argument) {
    double minimum = 1000000;
    TicTacToe[] listMove = argument.possibleMoves(opponent);
    if(argument.checkWin(this) == true) {
      return 1;

    }else if(argument.checkLose(this) == true) {
      return -1;

    }
    else if(argument.checkDraw() == true) {
      return 0;

    }
/*
 * recursive method for min value for max value 
 */
    else {
      for(int i = 0; i < listMove.length - 1; ++i) {

        if(maxValue(listMove[i]) < minimum) {
          minimum = maxValue(listMove[i]);
        }

      }

      return minimum;
    }

  }


  /**
   * recursive method for maxvalue for minvalue 
   * sets possible moves for opponent
   * returns 1 if player has won
   * returns -1 if player has lost
   * returns 0 if game is draw
   * @param argument
   * @return
   */
  
  public double maxValue(TicTacToe argument) {
    double maximum = -1000000;

    TicTacToe[] listMove = argument.possibleMoves(this);
    if(argument.checkWin(this) == true) {
      return 1;

    }

    else if(argument.checkLose(this) == true) {
      return -1;
    }


    else if(argument.checkDraw() == true) {
      return 0;
    }
    else {
      for(int i = 0; i < listMove.length - 1; ++i) {
        if(minValue(listMove[i]) > maximum) {
          maximum = minValue(listMove[i]);
        }
      }

      return maximum;
    }
  }

  /**
   * gets moves for each player and calculates minvalue and returns max value 
   * @param argument
   * @return
   */
  @Override

  public TicTacToe chooseMove(TicTacToe argument) {
    double maximum = -1000000;
    int maxIndex = 0;
    TicTacToe[] listMove = argument.possibleMoves(this);
    for(int i = 0; i < listMove.length - 1; ++i) {
      if(minValue(listMove[i]) > maximum) {

        maximum = minValue(listMove[i]);
        maxIndex = i;
      }
    }
    return listMove[maxIndex];
  }

  /**
   *
   * @param newGame
   * @return
   */
  @Override
  public double boardValue(TicTacToe newGame) {
    double minimum = maxValue(newGame);
    return minimum;
  }
}