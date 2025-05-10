import java.util.Arrays;
import java.util.List;

public class Card {
    //create static lists to check if the attributes of the card are valid within this class
    private static String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9","10", "Jack", "Queen", "King"};
    private static String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
    List <String> validNames = Arrays.asList(names);    //create lists to use its methods
    List <String> validSuits = Arrays.asList(suits);

    private boolean validName(String name){     //use the list method .contains to check if the inputted attribute is valid
        return validNames.contains(name);
    }
    private boolean validSuit(String suit){
        return validSuits.contains(suit);
    }

    // Creating card object attribute variables

    private String name;
    private String suit;
    private int value;

    // Check if the inputted attributes are valid, and throw exceptions if they aren't
    // Create card objects using the valid attributes

    public Card(String cardName, String cardSuit, int cardValue){
        if (validName(cardName) == false){
            throw new IllegalArgumentException("Invalid card name " + '"' + cardName + '"');
        }
        if (validSuit(cardSuit) == false){
            throw new IllegalArgumentException("Invalid card suit " + '"' + cardSuit + '"');
        }
        name = cardName;
        suit = cardSuit;
        value = cardValue;
    }

    // Getter methods (returns specific attribute) 

    public String getName(){
        return name;
    }
    public String getSuit(){
        return suit;
    }
    public int getValue(){
        return value;
    }

    //toString method
    @Override

    public String toString(){
        return name + " of " + suit;
    }

    //equals method
    @Override

    public boolean equals(Object obj){
        Card test = (Card) obj; //cast variable type
        return name.equals(test.name) && //check if the attributes of the objects are equal 
            suit.equals(test.suit) &&
            value == test.value;
    }
}
