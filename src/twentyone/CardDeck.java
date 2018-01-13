/*
 * CardDeck.java
 * This class provides functions to display playing cards
 * Jess Lorantfy
 * January 12th, 2018
 */
package twentyone;

/**
 *
 * @author Jessica
 */
public class CardDeck {
    private String cards = "";
    
    CardDeck () {
        // When creating a new deck, cards are loaded from the file system
        FileIO fileIO = new FileIO(); 
        cards = fileIO.readFile("cards.txt");
    }
    
    /**
     * Draws a picture of a card given the value
     * @param value The value of card
     * @return Returns the picture of the card
     */
    public String drawCard (int value){
        String card;
        int cardHeight, cardWidth, startRow, endRow;
        
        // The height of each card in cards.txt is the same
        cardHeight = 6;
        
        // The width of each card in cards.txt is the same
        cardWidth = 8;
        
        // Finds the row of the file where the card starts
        startRow = (value - 1) * cardHeight;
        
        // Finds the row of the file where the card ends
        endRow = startRow + cardHeight;     
        
        // Takes part of the file that is just the card we want
        card = cards.substring(startRow * cardWidth, endRow * cardWidth);
        
        return card;
    }
}
