//** CSC232A: IMPLEMENTATION OF A SIMULATION PART 2
// NAME: Chi Ngo, Sunny Nguyen, Alice Tran
// DATE: May 9th, 2024
// PROFESSOR: Brian Howard
//**

import java.util.Scanner;

public class Main {
  public static void main(String[] args) 
  {
    //enter game info
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the height of the pyramid:");
    int height = scanner.nextInt(); //enter height
    
    scanner.nextLine();
    System.out.println("There are two game modes available. Option 1: Human vs. Human or Option 2: Human vs. Computer. \n Enter 1 for option 1. Enter 2 for option 2.");
    int option = scanner.nextInt();
    scanner.nextLine();
    
    if (option == 1) //Human vs Human option
    {
      System.out.println("Enter the name of player 1:");
      String player1Name = scanner.nextLine();

      System.out.println("Enter the name of player 2:");
      String player2Name = scanner.nextLine();

      Player p1 = new Player(player1Name, 0);
      Player p2 = new Player(player2Name, 1);

      PyramidGame game = new PyramidGame(p1,p2);
      //to create game
      game.initializeGame(height);
    
      Player currentPlayer = p1; // Set initial player to p1
      PlayerModeInterface playerGame = new PlayerGame(0); //for chooselss()
      
      // Game loop
      while (!game.endGame()) 
      {
        game.displayPyramid();
        System.out.printf("%s's turn. Enter level, square index, and segment number (0-indexed):\n", currentPlayer.getName());
        playerGame.chooselss(); //choose level/segment/square
        if (game.chooseSegment(playerGame.getLevel(), playerGame.getSquare(), playerGame.getSegment(), currentPlayer.getInd())) 
        {
          System.out.printf("Nice! %s completes a square! Total squares completed by %s: %d\n", currentPlayer.getName(), currentPlayer.getName(), game.getScores()[currentPlayer.getInd()]);
        } else {
          // Change turn
          currentPlayer = (currentPlayer == p1) ? p2 : p1;
        }
      }
      game.winner();
    }
      
    else if (option == 2) //human vs computer
    {
      System.out.println("Enter the name of player 1 :");
      PlayerModeInterface playerGame1= new PlayerGame(0);
      PlayerModeInterface computerGame= new ComputerGame(1);
      PyramidGame game = new PyramidGame();
      game.initializeGame(height);
      int currentPlayer = playerGame1.getIndex();
      
      //Game loop
      while (!game.endGame()) {
        game.displayPyramid();
        if (currentPlayer == playerGame1.getIndex())
        {
          System.out.printf("Player %d's turn. Enter level, square index, and segment number (0-indexed):\n", currentPlayer + 1);
          playerGame1.chooselss();
          if (game.chooseSegment(playerGame1.getLevel(), playerGame1.getSquare(), playerGame1.getSegment(), currentPlayer)) 
          {
            System.out.printf("Nice! Player %d completes a square! Total squares completed: %d\n", currentPlayer + 1, game.getScores()[currentPlayer]);
          } else 
          {
            currentPlayer = 1 - currentPlayer; // Change turn
          }
        }
        else
        {
          System.out.println("Computer's turn");
          computerGame.chooselss();
          if (game.chooseSegment(computerGame.getLevel(), computerGame.getSquare(),  computerGame.getSegment(), 1))
          {
            System.out.printf("Nice! Computer completes a square! Total squares completed", game.getScores()[currentPlayer]);
          } 
          else
          {
            currentPlayer = 1 - currentPlayer;
          }
      }
    }
    scanner.close();
  }
    System.out.println("Game over");
  } //end of main
} //end of class
