import java.util.Random;
import java.util.ArrayList;


public class Deck {
    private ArrayList<Card> deck;
    private String[] validNames = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9","10", "Jack", "Queen", "King"};
    private String[] validSuits = {"Hearts", "Clubs", "Diamonds", "Spades"};

    public Deck(Card[] cards){     
        deck = new ArrayList<Card>();
        if (cards != null){              //check if the card array is null    
            for (int i = 0; i < cards.length; i++){ //add each element of the card array to the deck arraylist if they're not null
                if (cards[i]!=null){
                    deck.add(cards[i]);
      }
     }
     }
}

    public Deck(){              //use a nested loop to go through all suits and names and add to a deck arraylist
        deck = new ArrayList<Card>();
        for (int i = 0; i < validSuits.length; i ++){
            for (int j = 0; j < validNames.length; j++){
                Card card = new Card(validNames[j], validSuits[i], j+ 1);
                deck.add(card);
    }
    }
}

    public int size(){      //return length of deck
        return deck.size();
    }
   
    public Card draw(){                 //remove and return the first element of the deck
        if (deck.isEmpty()){
            return null;
        }
       return deck.remove(0);
    }

    public void shuffle(){
        int size = deck.size();
        Random random = new Random();   //create random number generator

        if (size <= 1){                 //can't shuffle a deck with 1 or less cards, so just return
            return;
        }
        for (int i = size - 1; i > 0; i--){
            int j = random.nextInt(i + 1);  //generate a random integer j with i+1 as the max value, making the range 0 to i
            Card temp = deck.get(i);       //swap cards at index i(highest unshuffled index) and j using a temporary variable
            deck.set(i,deck.get(j));
            deck.set(j, temp);
 }
 }

    public void addCard(Card card) {    //check if the inputted card is null, and add to the deck if it isn't
        if(card != null){
            deck.add(card);
        }
    }

    public void reshuffle(Card[] newCards) {        //check if the newcards list is null
        if (newCards != null){                      //loop through newcards list and add each card to the deck
            for (int i = 0; i < newCards.length; i++){
                 Card card = newCards[i];
                if (card != null){
                deck.add(card);      //call the addCard method to add the cards back to the deck
            }
        }
            shuffle();              //call the shuffle method to shuffle the deck
        }
    }    
}



  
