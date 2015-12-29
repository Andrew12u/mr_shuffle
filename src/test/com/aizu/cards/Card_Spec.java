package com.aizu.cards;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.apache.log4j.Logger;
import com.aizu.cards.Card;

public class Card_Spec{
  final static Logger logger = Logger.getLogger(Card_Spec.class);
  @Test
  public void Testing_Card_Gets(){
    logger.info("=====");
    logger.info("Testing Card POJO Gets() ");
    logger.info("=====");
    Card card = new Card("2","heart",2,4);
    logger.info("\tCard Value:"  + card.getCardValue());
    logger.info("\tCard Suit :"  + card.getSuit());
    logger.info("\tCard Suit Priority :" + card.getSuitPriority());
    logger.info("\tCard Card Priority:" + card.getCardPriority());
    assertEquals(card.getCardValue(),"2");
    assertEquals(card.getSuit(),"heart");
    assertEquals(card.getCardPriority(),2);
    assertEquals(card.getSuitPriority(),4);
  }
}
