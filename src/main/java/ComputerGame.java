import java.util.Random;

public class ComputerGame implements PlayerModeInterface {
  
  private int level;
  private int square;
  private int segment;
  private int index;
  private Random random = new Random();
  private PyramidGame pyramidGame = new PyramidGame();
  public ComputerGame(int ind)
  {
    index = ind;
    level = 0;
    square = 0;
    segment = 0;
  }
  
  public int getIndex()
  {
    return index;
  }
  
  public void chooselss(){
    int height1 = PyramidGame.height;
    System.out.println("Height is: " + height1);
    this.level = random.nextInt(height1);
    this.square = random.nextInt(height1);
    this.segment = random.nextInt(4);
    System.out.println("Level: " + level + "; Square: " + square + "; Segment:" + segment);
  }
  
  public int getLevel(){
    return level;
  }
  
  public int getSquare(){
    return square;
  }
  
  public int getSegment(){
    return segment;
  }
}//end of class