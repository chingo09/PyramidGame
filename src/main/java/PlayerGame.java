import java.util.Scanner;

public class PlayerGame implements PlayerModeInterface{
  private int level;
  private int square;
  private int segment;
  public int index;

  public PlayerGame(int ind)
  {
    index = ind;
  }
  public int getIndex()
  {
    return index;
  }
  
  private Scanner scanner = new Scanner(System.in);
  
  public void chooselss(){
    this.level = scanner.nextInt();
    this.square = scanner.nextInt();
    this.segment = scanner.nextInt();
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

}