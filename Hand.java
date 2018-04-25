import java.util.ArrayList;

public class Hand
{	

	private ArrayList<Card> currentHand = new ArrayList<>();
	
	
	public ArrayList<Card> getCurrentHand()
	{
	    return currentHand;
	}


	public void setCurrentHand(ArrayList<Card> currentHand)
	{
	    this.currentHand = currentHand;
	}


	public void addCard (Card card)
	{
	    currentHand.add(card);
	}
}
