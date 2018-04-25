import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck 
{
	private Stack<Card> deck = new Stack<>();
	
	public Deck()
	{
		newGame();
	}
	
	private void shuffle() 
	{
		for (int index = 0; index < 5; index++)
		{
			Collections.shuffle(deck);
		}
	}

	private void createDeck()
	{
		Card card;
		for (int index = 1; index <= 13; index++)
		{
			card = new Card(CardType.CLUBS, index);
			deck.add(card);
		}
		for (int index = 1; index <= 13; index++)
		{
			card = new Card(CardType.SPADES, index);
			deck.add(card);
		}
		for (int index = 1; index <= 13; index++)
		{
			card = new Card(CardType.HEARTS, index);
			deck.add(card);
		}
		for (int index = 1; index <= 13; index++)
		{
			card = new Card(CardType.DIAMONDS, index);
			deck.add(card);
		}
	}
	
	public ArrayList<Card> dealHand()
	{
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(deck.pop());
		hand.add(deck.pop());		
		return hand;
	}
	
	public Card dealCard()
	{
		return deck.pop();
	}
	
	public void newGame()
	{
		createDeck();
		shuffle();
	}
}
