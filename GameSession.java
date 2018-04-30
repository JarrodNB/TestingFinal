import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameSession {

	private BlackJackDealer dealer;
	private BlackJackPlayer player;
	private Deck deck;
	private int currentBet;
	
	public void play()
	{
		println("Welcome to a game of black jack!\n");
		println("If you can double your money then you'll be a Pro!\n");
		deck = new Deck();
		dealer = new BlackJackDealer();
		player = new BlackJackPlayer();
		newRound();
		result();
		boolean trigger = true;
		while (trigger)
		{
			if (player.getMoney() == 0)
			{
				println("It looks like your broke.\n");
				println("Your wife won't be happy about this.\n");
				println("Goodbye");
				return;
			}
			else if (player.getMoney() >= 2000)
			{
				println("You've doubled what you started with!\n");
				println("You should go home while your still ahead.\n");
				println("Goodbye.");
				return;
			}
			println("Would you like to play another round? Y or N\n");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("N"))
			{
				trigger = false;
				println("Thanks for playing!");
			}
			else if (input.equalsIgnoreCase("Y"))
			{
				newRound();
				result();
			}
			else
			{
				println("I don't understand.\n");
			}
		}	
	}

	private void result() 
	{
		println("The round is over!\n");
		println("The dealer flips over his face down Card.\n");
		println("It is a " + dealer.getFaceDownCard() + "\n");
		println("You have a score of " + player.getScore() + "\n");
		println("The dealer has a score of " + dealer.getScore() + "\n");
		int pScore = player.getScore();
		int dScore = dealer.getScore();
		boolean pBust = pScore > 21;
		boolean dBust = dScore > 21;
		if (pScore == dScore || (pBust && dBust))
		{
			println("Looks like you tied!" + "\n");
			println("Your bet will be returned to you." + "\n");
		}
		else if (pScore > dScore && !pBust || dBust)
		{
			println("You won!" + "\n");
			println("You won $" + (currentBet) + "\n");
			player.winMoney(currentBet);
			dealer.loseMoney(currentBet);
			println("You now have $" + player.getMoney() + "\n");
			println("The dealer now has $" + dealer.getMoney() + "\n");
		}
		else if (pScore < dScore && !dBust || pBust)
		{
			println("You lost!" + "\n");
			println("You lost $" + (currentBet) + "\n");
			player.loseMoney(currentBet);
			dealer.winMoney(currentBet);
			println("You now have $" + player.getMoney() + "\n");
			println("The dealer now has $" + dealer.getMoney() + "\n");
		}
		else
		{
			println("Whats wrong here?" + "\n");
		}
	}


	private void newRound() {
		deck.newGame();
		println("Your current money is $" + player.getMoney() + "\n");
		currentBet = getBet(player.getMoney());
		PlayerTurn playerTurn = new PlayerTurn(dealer, player, deck);
		try 
		{
			playerTurn.start();
		} 
		catch (TwentyOne e) 
		{
			println("You got 21! We still have to see if you tie though!" + "\n");
		} 
		catch (Bust e) 
		{
			println("Looks like you busted!" + "\n");
			return;
		}
		DealerTurn dealerTurn = new DealerTurn();
		try 
		{
			dealerTurn.start(dealer, player, deck);
		} 
		catch (TwentyOne e) 
		{
			println("The dealer flips over his cards and shows you 21!" + "\n");
		} 
		catch (Bust e) 
		{
			println("The dealer busted!" + "\n");
		}
	}
	
	private int getBet(int max)
	{
		println("How much would you like to bet?" + "\n");
		Scanner scanner = new Scanner(System.in);
		boolean trigger = true;
		int bet = 0;
		while (trigger) 
		{
			try 
			{
				bet = Integer.valueOf(scanner.nextLine());
				if (bet < 1 || bet > max)
				{
					throw new Exception("Invalid amount" + "\n");
				}
				trigger = false;
			} 
			catch (InputMismatchException error) 
			{
				println("Please enter a valid number." + "\n");
			} 
			catch (Exception e) 
			{
				println("You can not bet that amount" + "\n");
			} 
		}
		return bet;
	}
	
	
	public static void println(String string)
	{
		System.out.println(string);
		try 
		{
			TimeUnit.MILLISECONDS.sleep(800);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
