public class Player //to be able to store and display player's name + info
{
  private String name;
  private int index;
  private int score;

public Player( String name, int ind)
{
  this.name = name;
  index = ind;
  score = 0;
}
public Player()
  {
    this.name = "";
    index = 0 ;
    score = 0;
  }
  public String getName( )
  {
    return name;
  }
  public void setName( String name1)
  {
    name = name1;
  }
  public int getInd()
  {
    return index;
  }
  public int getScore()
  {
    return score;
  }
  
}