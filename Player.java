import java.util.ArrayList;

public abstract class Player 
{
	protected ArrayList<Card> hand;
	private int money;
	
	public abstract int getScore();
	
	public void newHand(ArrayList<Card> hand)
	{
		this.hand = hand;
	}
	
	public void cardDrawn(Card card)
	{
		hand.add(card);
	}
	
	public ArrayList<Card> getHand()
	{
		return hand;
	}
	
	public void winMoney(int amount)
	{
		money += amount;
	}
	
	public void loseMoney(int amount)
	{
		money -= amount;
	}
	
	public int getMoney()
	{
		return money;
	}
	
}
