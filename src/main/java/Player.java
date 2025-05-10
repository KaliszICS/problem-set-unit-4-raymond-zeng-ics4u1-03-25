import java.util.ArrayList;

public class Player {
    private String playerName;
    private int playerAge;
    private ArrayList<Card> playerHand;

    public Player(String name, int age, Card[]startingHand){ //create player with a given hand
        playerName = name;
        playerAge = age;
        playerHand = new ArrayList<>();
        if (startingHand != null){
            for (int i = 0;i < startingHand.length;i++){
                if (startingHand[i] != null){
                    playerHand.add(startingHand[i]);
                }
            }
        }
    }
    public Player(String name, int age){ //create player with an empty hand
        playerName = name;
        playerAge = age;
        playerHand = new ArrayList<>();
    }
    public String getName(){    //getter methods
        return playerName;
    }
    public int getAge(){
        return playerAge;
    }
    public Card[] getHand(){
        Card[] cardsInHand = new Card[playerHand.size()];
        for (int i = 0; i < playerHand.size();i++){
            cardsInHand[i] = playerHand.get(i);
        }
        return cardsInHand;
    }
    public int size() {
        return playerHand.size();
    }
    public void draw(Deck deck){        //call draw method and add to the player's hand if it isn't a null card
        Card cardDrawn = deck.draw();       
        if (cardDrawn != null) {
            playerHand.add(cardDrawn);
        }
    }
     public boolean discardCard(Card card, DiscardPile discardPile) {   //check if the card is in the player's hand using loop
        for (int i = 0; i < playerHand.size(); i++) {  //remove and add to discard pile if it is
            if (playerHand.get(i).equals(card)) {
                Card discardedCard = playerHand.remove(i);
                discardPile.addCard(discardedCard);
                return true;
            }
        }
        return false;
    }
     public boolean returnCard(Card card, Deck deck) {      //check if the card is in the player's hand with a loop and remove it from the hand and return to the deck
        for (int i = 0; i < playerHand.size(); i++) {
            if (playerHand.get(i).equals(card)) {
                Card returnedCard = playerHand.remove(i);
                deck.addCard(returnedCard);
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {                  //concatenate the player's name and age, then concatenate each card in their hand to that string
        String playerDetails = playerName + ", " + playerAge;
        if (!playerHand.isEmpty()) {
            playerDetails += ", ";
            for (int i = 0; i < playerHand.size(); i++) {
                playerDetails += playerHand.get(i).toString();
                if (i < playerHand.size() - 1) {
                    playerDetails += ", ";
                }
            }
        }
        return playerDetails;
    }
}