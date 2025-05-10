import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class DeckTest {

    @Test
    void createFullDeck() {
        Deck deck = new Deck();
        assertEquals(52, deck.size());
    }

    @Test
    void createDeckFromCards() {
        Card[] cards = {new Card("Ace", "Hearts", 1), new Card("King", "Spades", 13)};
        Deck deck = new Deck(cards);
        assertEquals(2, deck.size());
    }

    @Test
    void createDeckFromNullCardsArray() {
        Deck deck = new Deck(null);
        assertEquals(0, deck.size());
    }

    @Test
    void createDeckFromCardsWithNullElement() {
        Card[] cards = {new Card("Ace", "Hearts", 1), null, new Card("King", "Spades", 13)};
        Deck deck = new Deck(cards);
        assertEquals(2, deck.size());
    }

    @Test
    void drawCardFromDeck() {
        Deck deck = new Deck();
        Card drawnCard = deck.draw();
        assertNotNull(drawnCard);
        assertEquals(51, deck.size());
    }

    @Test
    void drawFromEmptyDeck() {
        Deck deck = new Deck(new Card[0]);
        assertNull(deck.draw());
        assertEquals(0, deck.size());
    }

    @Test
    void shuffleDeck() {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        List<Card> drawn1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Card c = deck1.draw();
            if (c != null) drawn1.add(c);
        }
        deck2.shuffle();
        List<Card> drawn2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Card c = deck2.draw();
            if (c != null) drawn2.add(c);
        }
        assertNotEquals(drawn1, drawn2);
        assertEquals(47, deck1.size());
        assertEquals(47, deck2.size());
    }

    @Test
    void shuffleSmallDeck() {
        Card[] cards = {new Card("Ace", "Hearts", 1), new Card("King", "Spades", 13)};
        Deck deck = new Deck(cards);
        deck.shuffle();
        assertEquals(2, deck.size());
    }

    @Test
    void shuffleSingleCardDeck() {
        Card[] cards = {new Card("Ace", "Hearts", 1)};
        Deck deck = new Deck(cards);
        deck.shuffle();
        assertEquals(1, deck.size());
        assertEquals(new Card("Ace", "Hearts", 1), deck.draw());
    }

    @Test
    void shuffleEmptyDeck() {
        Deck deck = new Deck(new Card[0]);
        deck.shuffle();
        assertEquals(0, deck.size());
    }
@Test
    void testDrawFromNonEmptyDeck() {
        Card[] initialCards = {new Card("Ace", "Hearts", 1), new Card("King", "Spades", 13)};
        Deck deck = new Deck(initialCards);
        assertEquals(2, deck.size());

        Card drawn1 = deck.draw();
        assertNotNull(drawn1);
        assertEquals(1, deck.size());
        assertEquals(new Card("Ace", "Hearts", 1), drawn1); // Assuming order is maintained initially

        Card drawn2 = deck.draw();
        assertNotNull(drawn2);
        assertEquals(0, deck.size());
        assertEquals(new Card("King", "Spades", 13), drawn2);
    }

    @Test
    void testDrawFromEmptyDeckReturnsNull() {
        Deck deck = new Deck(new Card[0]);
        assertNull(deck.draw());
        assertEquals(0, deck.size());
    }
    @Test
    void addCardToDeck() {
        Deck deck = new Deck(new Card[0]);
        Card card = new Card("Queen", "Diamonds", 12);
        deck.addCard(card);
        assertEquals(1, deck.size());
        assertEquals(card, deck.draw());
    }

    @Test
    void addNullCardToDeck() {
        Deck deck = new Deck();
        int initialSize = deck.size();
        deck.addCard(null);
        assertEquals(initialSize, deck.size());
    }

 
    @Test
    void reshuffle_withEmptyArrayDoesNotChangeDeck() {
        // Given a deck
        Deck deck = new Deck();
        int initialSize = deck.size();
        Card[] cardsToReshuffle = {};

        // When we reshuffle with an empty array
        deck.reshuffle(cardsToReshuffle);

        // Then the deck size should remain the same
        assertEquals(initialSize, deck.size(),
                "Reshuffling with an empty array should not change the deck size.");
    }

    @Test
    void reshuffle_withNullArrayDoesNotChangeDeck() {
        // Given a deck
        Deck deck = new Deck();
        int initialSize = deck.size();

        // When we reshuffle with a null array
        deck.reshuffle(null);

        // Then the deck size should remain the same
        assertEquals(initialSize, deck.size(),
                "Reshuffling with a null array should not change the deck size.");
    }

    @Test
    void reshuffle_shouldShuffleTheDeck() {
        // Given two decks and we add a new card to the first
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        Card newCard = new Card("Ace", "Clubs", 1);
        Card[] cardsToAdd = {newCard};
        deck1.reshuffle(cardsToAdd);
        deck2.reshuffle(cardsToAdd);

        // When we draw a few cards from each
        List<Card> firstFew1 = new ArrayList<>();
        for (int i = 0; i < Math.min(5, deck1.size()); i++) {
            firstFew1.add(deck1.draw());
        }
        List<Card> firstFew2 = new ArrayList<>();
        for (int i = 0; i < Math.min(5, deck2.size()); i++) {
            firstFew2.add(deck2.draw());
        }

        // Then the order of cards should likely be different
        if (firstFew1.size() > 1) {
            assertNotEquals(firstFew1, firstFew2, "Reshuffling should likely result in a different card order.");
        }
    }
}