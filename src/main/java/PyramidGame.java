public class PyramidGame {
  private boolean[][][] segments;
  public static int height;
  private int[] scores;
  private int squareCompleted = 0;
  private Player[] players;

  public PyramidGame(Player p1, Player p2) {
    this.players = new Player[]{p1, p2};
    this.scores = new int[2]; // Score for two players
  }
  
  public PyramidGame(){
    this.scores = new int[2];
  }

  public void initializeGame(int height) { // gameController class
    this.height = height;
    this.segments = new boolean[height][][];
      for (int i = 0; i < height; i++) {
      segments[i] = new boolean[i + 1][4]; // Each square can have 4 segments
    }
  }

  public boolean chooseSegment(int level, int square, int segment, int playerIndex) { // Segment class
    if (level < height && square <= level && segment < 4 && !segments[level][square][segment]) // that segment has not been filled, still false
    {
      segments[level][square][segment] = true; // Mark the line as chosen
      // Check if this choice completes a square
      if (isSquareComplete(level, square)) {
        scores[playerIndex]++;
        return true; // Square completed
      }
      return false; // Square not completed
    }
    System.out.println("Wrong move.");
    return false; // Invalid move
  }

  public void displayPyramid() { // pyramidGame class
    int count = 0;
    System.out.println("\n");
    for (int i = 0; i < height; i++) {
      System.out.print(count);
      count++;
      for (int j = 0; j < height - i - 1; j++) {
        System.out.print("    "); // Spaces for alignment
      }
      for (int k = 0; k <= i; k++) {
        System.out.print("[");
        System.out.print(segments[i][k][0] ? "X" : " "); // Top line
        System.out.print(segments[i][k][1] ? "|X|" : "| |"); // left lines with middle space or X
         System.out.print(segments[i][k][3] ? "X|" : " |");// right side
        System.out.print(segments[i][k][2] ? "X" : " "); // Bottom line
        System.out.print("] ");
      }
      System.out.println();
    }
    System.out.println("\n");
  }

  public int[] getScores() { // gameController class
    return scores;
  }

  private boolean isSquareComplete(int level, int square) { //
    for (boolean segment1 : segments[level][square]) {
      if (!segment1)
        return false; // If any line is not selected, square is not complete
    }
    squareCompleted++;
    return true; // All lines are selected, square is complete
  }
  public int totalSquare(int level)
  {
    if (level == 0)
      return 0;
    else
    {
      return level + totalSquare(level-1);
    }
    
  }
  public boolean endGame()
  {
    return (squareCompleted == totalSquare(height));
      // System.out.println (" Game over");  
  }
  public void winner()
  {
        // Logic to determine and announce the winner.
      System.out.println( " Game over! ");
        if (scores[0] > scores[1]) {
            System.out.println(players[0].getName() + " wins!");
        } else if (scores[1] > scores[0]) {
            System.out.println(players[1].getName() + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

  public int getHeight(){
    return height;
  }

  // public static void setHeight(int newheight)
  // {
  //   this.height = newheight;
  // }
    
    // int higherscore = 0;
    // int winner =  0;
    // if (endGame())
    // {
     
    //       if (score[0] > score[1])
    //       {
    //         higherscore = score[0];
    //         winner = 0;
    //       }
    //       else
    //       {
    //         higherscore = score[1];
    //         winner = 1;
    //       }
    // }
    // System.out.println("Game over");
    // System.out.println( "The winner is " +  + " with score of " + higherscore); 
  
}
