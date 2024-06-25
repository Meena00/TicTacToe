

# TicTacToe
## Overview
This project implements a simple TicTacToe game where a human player competes against an AI player. The game is developed in Java without using external libraries. It consists of three main classes: TicTacToe, Player, and AIPlayer.

## Classes
## TicTacToe Class:
  
  The TicTacToe class manages the game board and the overall game state.

- Attributes
    char[][] board: A 2D array representing the game board.
    Player x: The player using the 'X' marker.
    Player o: The player using the 'O' marker.
## Key Methods
- Constructors and Initializers: Initializes the game with players and sets up the board with empty fields ('_').
- Setters and Getters: Methods to set and get the game board and players.
- Game Logic Methods: Includes methods to count empty spaces, determine the marker for a player, check for win/lose/draw conditions, and generate possible moves.
- toString: Returns a string representation of the current game board.
Player Class
The Player class is an abstract class representing a general player in the game.

## Abstract Methods
- chooseMove(TicTacToe argument): Abstract method to be implemented by subclasses to choose a move.
# Key Methods
- boardValue: Evaluates the game board to determine if the player wins, loses, or the game is a draw.
  
## AIPlayer Class
The AIPlayer class extends the Player class and represents an AI player using the minimax algorithm.
# Attributes
- String name: The name of the AI player.
- Player opponent: The opponent player.
# Key Methods
- Constructors and Initializers: Initializes the AI player with a name and an opponent.
- Setters and Getters: Methods to set and get the AI player's name and opponent.
- toString: Returns the name of the AI player with "(AI)" appended.
- Minimax Algorithm Methods: Implements the minimax algorithm through methods like minValue, maxValue, and chooseMove to determine the best move for the AI player.
# Technical Details
The AI player uses the minimax algorithm, a recursive algorithm for choosing the optimal move. It assumes that the opponent also plays optimally. The algorithm evaluates the game states by simulating all possible moves and selecting the one with the best outcome.

- Minimax Algorithm
The minimax algorithm operates by recursively evaluating the minimum and maximum possible values of the game board. It considers:

- minValue: The worst-case scenario for the AI player (best move for the opponent).
- maxValue: The best-case scenario for the AI player.


# Game States
The game states are represented by the TicTacToe class, which maintains the current board and allows checking for wins, losses, and draws. It also generates possible future game states based on the current state and the player's moves.
