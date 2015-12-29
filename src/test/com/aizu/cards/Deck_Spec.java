package com.aizu.cards;

import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.apache.log4j.Logger;
import com.aizu.cards.Card;
import com.aizu.cards.Deck;

public class Deck_Spec{
  final static Logger logger = Logger.getLogger(Deck_Spec.class);
  @Test
  public void Testing_Deck_Setup(){
    List<Card> llist = setupDeck();

    logger.info("=====");
    logger.info("Testing Deck Setup");
    logger.info("=====");
    Deck<Card> deck = new Deck<Card>(llist);
    printDeck(deck);
    assertEquals(deck.getDeck().size(),52);
  }
  @Test
  public void Testing_Deck_Shuffle_Default(){
    List<Card> llist = setupDeck();
    logger.info("=====");
    logger.info("Testing Deck Default Shuffle");
    logger.info("=====");
    Deck<Card> deck = new Deck<Card>(llist,"");
    deck.shuffleDeck();
    printDeck(deck);
    assertEquals(deck.getDeck().size(),52);
  }
  @Test
  public void Testing_Deck_Shuffle_Quarter(){
    List<Card> llist = setupDeck();
    logger.info("=====");
    logger.info("Testing Quarter Deck Shuffle");
    logger.info("=====");
    Deck<Card> deck = new Deck<Card>(llist,"quarterShuffle");
    deck.shuffleDeck();
    printDeck(deck);
    assertEquals(deck.getDeck().size(),52);
  }
  @Test
  public void Testing_Deck_Shuffle_Mongean(){
    List<Card> llist = setupDeck();
    logger.info("=====");
    logger.info("Testing Mongean Deck Shuffle");
    logger.info("=====");
    Deck<Card> deck = new Deck<Card>(llist,"mongeanShuffle");
    deck.shuffleDeck();
    printDeck(deck);
    assertEquals(deck.getDeck().size(),52);
  }

  private List<Card> setupDeck(){
    List<Card> llist = new LinkedList<Card>();
    String[] faceCards = {"J","Q","K","A"};
    String[] suits = {"spades","clubs","diamonds","hearts"};

    for(int i=2; i<=10; i++){
      for(int j=1; j<=4; j++){
        llist.add(new Card(Integer.toString(i), suits[j-1], j, i));
      }
    }
    for(int k=1; k<=4; k++){
      for(int l=1; l<=4; l++){
        llist.add(new Card(faceCards[k-1],suits[l-1], l, k+10));
      }
    }
    return llist; 
  }
  
  public void printDeck(Deck<Card> deck){
    for(int i=0; i < deck.getDeck().size(); i++){
      logger.info("\t" + deck.getDeck().get(i).getCardValue() + "-" + deck.getDeck().get(i).getSuit());
    }
  }
  
}
