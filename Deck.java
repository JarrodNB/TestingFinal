import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck 
{
	private Stack<Card> deck; 
	
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
		int points;
		for (int index = 1; index <= 13; index++)
		{
			points = (index < 11) ? index : 10;
			card = new Card(CardType.CLUBS, index, points);
			deck.add(card);
		}
		for (int index = 1; index <= 13; index++)
		{
			points = (index < 11) ? index : 10;
			card = new Card(CardType.SPADES, index, points);
			deck.add(card);
		}
		for (int index = 1; index <= 13; index++)
		{
			points = (index < 11) ? index : 10;
			card = new Card(CardType.HEARTS, index, points);
			deck.add(card);
		}
		for (int index = 1; index <= 13; index++)
		{
			points = (index < 11) ? index : 10;
			card = new Card(CardType.DIAMONDS, index, points);
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
		deck = new Stack<>();
		createDeck();
		shuffle();
	}
}
