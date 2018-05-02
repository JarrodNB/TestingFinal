import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;


public class BlackJackTestCases
{
	Deck deck;
	
    @Before
    public void setUp() throws Exception
    {
    	deck = new Deck();
    	deck.newGame();
    }

    @Test 
    public void testPlayerMoney() 
    {
		BlackJackPlayer player;
		player = new BlackJackPlayer();
		assertEquals(1000, player.getMoney());
    }

    @Test 
    public void testPlayerWinMoney() 
    {
		BlackJackPlayer player;
		player = new BlackJackPlayer();
		player.winMoney(1000);
		assertEquals(2000, player.getMoney());
    }

    public void testPlayerWinMoneyMax()  
    {
		BlackJackPlayer player;
		player = new BlackJackPlayer();
		player.winMoney(1000);
		assertEquals(2000, player.getMoney());
    }

    @Test 
    public void testPlayerLoseMoney() 
    {
		BlackJackPlayer player;
		player = new BlackJackPlayer();
		player.loseMoney(500);
		assertEquals(500, player.getMoney());
    }

    @Test 
    public void testPlayerLoseMoneyNegative() 
    {
		BlackJackPlayer player;
		player = new BlackJackPlayer();
		player.loseMoney(1500);
		assertEquals(-500, player.getMoney());
    }

    @Test 
    public void testDealerMoney() 
    {
		BlackJackDealer dealer;
		dealer = new BlackJackDealer();
		assertEquals(10000, dealer.getMoney());
    }

    @Test 
    public void testDealerWinMoney() 
    {
		BlackJackDealer dealer;
		dealer = new BlackJackDealer();
		dealer.winMoney(1000);
		assertEquals(11000, dealer.getMoney());
    }

    @Test 
    public void testDealerLoseMoney() 
    {
		BlackJackDealer dealer;
		dealer = new BlackJackDealer();
		dealer.loseMoney(1000);
		assertEquals(9000, dealer.getMoney());
    }

    @Test 
    public void testNewHand() 
    {
		BlackJackPlayer player;
		player = new BlackJackPlayer();
		ArrayList<Card> hand = deck.dealHand();
		player.newHand(hand);
		assertEquals(hand, player.getHand());
    }

    public void testAddCard() 
    {
		BlackJackPlayer player;
		player = new BlackJackPlayer();
		ArrayList<Card> hand = new ArrayList<>();;
		player.newHand(hand);
		Card card = new Card(CardType.CLUBS, 2 , 2);
		player.cardDrawn(card);
		assertEquals(1, player.getHand().size());
    }

    @Test 
    public void testScore() 
    {
		BlackJackPlayer player;
		player = new BlackJackPlayer();
		ArrayList<Card> hand = new ArrayList<>();
		player.newHand(hand);
		Card card = deck.dealCard();
		player.cardDrawn(card);
		assertEquals(card.getPoints(), player.getScore());
    }
    
    @Test(expected = RuntimeException.class)
    public void testInvalidCardSetPoints()
    {
    	Card card = deck.dealCard();
    	card.setPoints(50);
    }
    
    @Test
    public void testCardSetPoints()
    {
    	Card card = deck.dealCard();
    	card.setPoints(11);
    	assertEquals(11, card.getPoints());
    }
    
    @Test(expected = RuntimeException.class)
    public void testInvalidCardSetValue()
    {
    	Card card = deck.dealCard();
    	card.setValue(50);
    }
    
    @Test
    public void testCardSetValue()
    {
    	Card card = deck.dealCard();
    	card.setValue(5);
    	assertEquals(5, card.getValue());
    }
    
    @Test
    public void testDeck()
    {
    	assertEquals(52, deck.getSizeOfDeck());
    	deck.dealHand();
    	assertEquals(50, deck.getSizeOfDeck());
    	deck.dealCard();
    	assertEquals(49, deck.getSizeOfDeck());
    	deck.newGame();
    	assertEquals(52, deck.getSizeOfDeck());
    }
    
}
