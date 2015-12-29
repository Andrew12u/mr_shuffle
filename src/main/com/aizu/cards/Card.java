package com.aizu.cards;

public class Card implements ICard {
  private String cardValue;
  private String suit;
  private int    cardPriority;
  private int    suitPriority;

  public Card(String cardValue, String suit, int cardPriority, int suitPriority){
    this.cardValue    = cardValue;
    this.suit         = suit;
    this.cardPriority = cardPriority;
    this.suitPriority = suitPriority;
  }

  public int     setCardPriority(int priority){
    this.cardPriority = priority;
    return this.cardPriority;
  }
  public int     getCardPriority(){
    return this.cardPriority;
  }
  public int     setSuitPriority(int suitPriority){
    this.suitPriority = suitPriority;
    return this.suitPriority;
  }
  public int     getSuitPriority(){
    return this.suitPriority;
  }
  public String  setCardValue(String cardValue){
    this.cardValue = cardValue;
    return this.cardValue;
  }
  public String  getCardValue(){
    return this.cardValue;
  }
  public String  setSuit(String suit){
    this.suit = suit;
    return this.suit;
  }
  public String  getSuit(){
    return this.suit;
  }
}  
