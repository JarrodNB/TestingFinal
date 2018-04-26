import java.util.ArrayList;

public class Player 
{
	private int playerScore;
	private int playerMoney;
	private Hand playerHand;
	
	public int getPlayerScore()
	{
	    int score = 0;
	    if (playerHand == null)
	    {
	    	return score;
	    }
	    return 0;
	}
	public int getPlayerMoney()
	{
	    return playerMoney;
	}
	public void setPlayerMoney(int playerMoney)
	{
	    this.playerMoney = playerMoney;
	}
	public Hand getPlayerHand() {
		return playerHand;
	}
	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}
	
	
	
}
