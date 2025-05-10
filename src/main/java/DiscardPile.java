import java.util.ArrayList;

public class DiscardPile{
    private ArrayList<Card> discardedPile;

    public DiscardPile(Card[] cards){       //create pile arraylist and make sure that the input isn't null 
        discardedPile = new ArrayList<>();           //add each element of the card list to the arraylist
        if (cards != null) {
        for (int i = 0; i < cards.length; i++) {
             if (cards[i] != null) {
                discardedPile.add(cards[i]);
            }
    }
}
}
    public DiscardPile(){               //create an empty discard pile
        discardedPile = new ArrayList<>();
    }

    public Card[] getCards(){                    //create a card array of the same size as the pile
        Card[] cardPile = new Card[discardedPile.size()]; //add each element of the pile to the card array
        for (int i = 0; i < discardedPile.size(); i++){
            cardPile[i] = discardedPile.get(i);
        }
        return cardPile;
    }

    public int size(){
        return discardedPile.size();
    }

    public void addCard(Card card) {        //make sure the card isn't null and add to the pile
        if (card != null){
            discardedPile.add(card);
        }
    }

    public Card removeCard(Card card){      //search the pile to find the specified card and remove it
        for (int i = 0; i < discardedPile.size();i++){
            if (discardedPile.get(i).equals(card)){
                return discardedPile.remove(i);
               
        }
    }
    return null;
}
    public String toString(){               //loop through and convert the cards in the pile to string, and concatenate them to the card string
        if (discardedPile.isEmpty()){
            return null;
        }
        String cardString = "";
        for (int i = 0; i < discardedPile.size(); i++){
            cardString += discardedPile.get(i).toString();
            if (i < discardedPile.size() - 1) {
                cardString += ", ";
            }
        }
        return cardString;
    }
}
