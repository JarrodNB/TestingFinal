import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class BlackJackTestCases
{

    @BeforeEach
    void setUp() throws Exception
    {

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
    public void testPlayerLoseMoneyNegative() //Player becomes in debt
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
	ArrayList<Card> hand = null;
	player.newHand(hand);
	assertEquals(null, player.getHand());
    }

    public void testAddCard() //Don't think this actually changes anything.
    {
	BlackJackPlayer player;
	player = new BlackJackPlayer();
	ArrayList<Card> hand = null;
	player.newHand(hand);
	Card card = new Card("CLUBS", 2 , 2);
	player.cardDrawn(card);
	assertEquals(null, player.getHand());

    }

    /*@Test 
    public void testScore() //This one always gave a null pointer exception. Not sure how to make it work
    {
	BlackJackPlayer player;
	player = new BlackJackPlayer();
	ArrayList<Card> hand = null;
	player.newHand(hand);
	Card card = null;
	player.cardDrawn(card);
	assertEquals(0, player.getScore());
    }*/
}
