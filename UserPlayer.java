import java.util.Scanner;
/**
 * @author Meena Anwar
 */
public class UserPlayer extends Player {
  private String name;
  private Scanner input;

  /**
   *
   * @param input
   * @param name
   */
  public UserPlayer(Scanner input, String name) {
    this.name = name;
    this.input = input;
  }

  /**
   * @return
   */
  @Override
  public String toString() {
    return this.name;
  }

  /**
   * returns the current moves passed as argument.
   * gets the options from user as integer and assigns it to board
   * @param argument
   * @param userNumber
   * @return
   */
  @Override
  public TicTacToe chooseMove(TicTacToe argument) {
    input = new Scanner(System.in);
    
    System.out.println(argument.toString());
    TicTacToe[] userNumber = argument.possibleMoves(this);
    for(int i = 0; i < userNumber.length - 1; ++i) { 
      System.out.println(userNumber[i].toString());
    }
    System.out.println("select the number of the move you want to make!");
    int returnValue = input.nextInt();
    return userNumber[returnValue - 1];

  }
}
