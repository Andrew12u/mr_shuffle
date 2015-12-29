package com.aizu.cards;

public interface ICard extends ISuit {
  public int    setCardPriority(int priority);
  public int    getCardPriority();
  public String setCardValue(String cardValue);
  public String getCardValue();
}
