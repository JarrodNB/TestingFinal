import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerTurn
{
	private BlackJackDealer dealer;
	private BlackJackPlayer player;
	private Deck deck;
	
	public PlayerTurn(BlackJackDealer dealer, BlackJackPlayer player, Deck deck)
	{
		this.dealer = dealer;
		this.player = player;
		this.deck = deck;
	}
	
	public void start() throws TwentyOne, Bust
	{
		dealHand();
		drawCards();
	}
	
	private void drawCards() throws TwentyOne, Bust 
	{
		// sound for card draw
		GameSession.println("Would you like to draw a card? Y or N" + "\n");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		if (input.equalsIgnoreCase("N"))
		{
			return;
		}
		else if (!input.equalsIgnoreCase("Y"))
		{
			GameSession.println("I don't understand" + "\n");
			drawCards();
		}
		else
		{
			Card card = deck.dealCard();
			GameSession.println("You drew a " + card + "\n");
			player.cardDrawn(card);
			if (card.getValue() == 1 && player.getScore() + 10 <= 21)
			{
				if (player.getScore() + 10 == 21)
				{
					card.setPoints(11);
					throw new TwentyOne();
				}
				ace(card);
			}
			GameSession.println("Your current score is " + player.getScore() + "\n");
			if (player.getScore() > 21)
			{
				throw new Bust();
			}
			else if (player.getScore() == 21)
			{
				throw new TwentyOne();
			}
			else 
			{
				drawCards();
			}
		}
		
	}

	
	private void displayScore()
	{
		
	}
	
	private void dealHand() throws TwentyOne
	{
		GameSession.println("The hands are being dealt.\n");
		ArrayList<Card> hand = deck.dealHand();
		ArrayList<Card> dealerHand = deck.dealHand();
		player.newHand(hand);
		dealer.newHand(dealerHand);
		GameSession.println("The dealer has a face up card of " + dealerHand.get(1) + "\n");
		for (Card card: hand)
		{
			GameSession.println("You have a " + card + "\n");
		}
		for (Card card: hand)
		{
			if (card.getValue() == 1 && player.getScore() + 10 <= 21)
			{
				if (player.getScore() + 10 == 21)
				{
					card.setPoints(11);
					throw new TwentyOne();
				}
				ace(card);
			}
		}
		GameSession.println("Your current score is " + player.getScore() + "\n");
	}
	
	private void ace(Card card)
	{
		GameSession.println("You have an ace."
				+ "Would you like to count it as a 1 or 11" + "\n");
		GameSession.println("If counted as a 1 your score is " 
				+ player.getScore() + "\n");
		GameSession.println("If counted as an 11 your score is " 
				+ (player.getScore()+10) + "\n");
		Scanner scanner = new Scanner(System.in);
		boolean trigger = true;
		int ace = 1;
		while (trigger) 
		{
			try 
			{
				ace = Integer.valueOf(scanner.nextLine());
				if (ace != 1 && ace != 11)
				{
					throw new Exception("Invalid number." + "\n");
				}
				trigger = false;
			} 
			catch (InputMismatchException error) 
			{
				GameSession.println("Please enter a valid number." + "\n");
			} 
			catch (Exception e) 
			{
				GameSession.println("That is not a valid value." + "\n");
			} 
		}
		card.setPoints(ace);
	}
	
}
