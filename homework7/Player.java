public class Player
{
   protected Hand hand;
   public Player()
   {
       hand = new Hand();
   }
   public void addToHand(Card c)
   {
       hand.add(c);
   }
   public Hand getHand()
   {
       return hand;
   }
}
