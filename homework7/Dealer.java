public class Dealer extends Player
{
   // TODO: Implement this
   
   private Hand dealerHand;
   public Dealer()
   {
	super();
   }
   
   public void play(Deck deck)
   {
	if (this.hand.getValue() <= 16)
	{
	    Card c = deck.drawCard();
	    this.hand.add(c);
	}
   }

}
