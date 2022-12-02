import org.junit.*;
import static org.junit.Assert.*;

public class UnitTest
{
    
    @Test
    public void DealerTestUnder17()
    {
	Dealer d = new Dealer();
	Deck deck = new Deck();
	d.getHand().add(new Card(Card.Face.NINE, Card.Suite.CLUBS));
	d.getHand().add(new Card(Card.Face.TWO, Card.Suite.HEARTS));
	d.play(deck);
	assertNotEquals("A new card should be added since hand was less than 16", 11, d.getHand().getValue());
    }

    @Test
    public void DealerTestOver17()
    {
	Dealer d = new Dealer();
	Deck deck = new Deck();
	d.getHand().add(new Card(Card.Face.NINE, Card.Suite.CLUBS));
	d.getHand().add(new Card(Card.Face.NINE, Card.Suite.HEARTS));
	d.play(deck);
	assertEquals("No new card should be added", 18, d.getHand().getValue());
    }
    @Test
    public void HandTestAce1()
    {
	Player p = new Player();
	p.getHand().add(new Card(Card.Face.NINE, Card.Suite.CLUBS));
	p.getHand().add(new Card(Card.Face.ACE, Card.Suite.HEARTS));
	p.getHand().add(new Card(Card.Face.EIGHT, Card.Suite.SPADES));
	assertEquals("Value of Ace should convert to 1", 18, p.getHand().getValue());
    }
    @Test
    public void HandTestAce11()
    {
	Player p = new Player();
	p.getHand().add(new Card(Card.Face.TWO, Card.Suite.CLUBS));
	p.getHand().add(new Card(Card.Face.ACE, Card.Suite.HEARTS));
	p.getHand().add(new Card(Card.Face.TWO, Card.Suite.SPADES));
	assertEquals("Value of Ace should stay 11", 15, p.getHand().getValue());
    }
}
