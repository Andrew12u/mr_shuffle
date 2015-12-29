package com.aizu.cards;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Iterator;

public class Deck<T>{
  private List<T> deck;
  private String  shuffleAlgorithm = "";
  private String  deckName;

  //Constructors
  public Deck(List<T> deck){
    this.deck = deck;
  }
  public Deck(List<T> deck, String shuffleAlgorithm){
    this.deck = deck;
    this.shuffleAlgorithm = shuffleAlgorithm;
  }
  //Accessors/mutators
  public List<T> getDeck(){
    return this.deck;
  }
  public List<T> setDeck(List<T> deck){
    this.deck = deck;
    return this.deck;
  }
  public String getShuffleAlgorithm(){
    return this.shuffleAlgorithm;
  }
  public String setShuffleAlgorithm(String shuffleAlgorithm){
    this.shuffleAlgorithm = shuffleAlgorithm;
    return this.shuffleAlgorithm;
  }
  public String getDeckName(){
    return this.deckName;
  }
  public String setDeckName(String deckName){
    this.deckName = deckName;
    return this.deckName;
  }
  /*
    =====================
    Shuffle Functionality
    =====================
  */
  public List<T> shuffleDeck(){
    switch(shuffleAlgorithm){
      case "mongeanShuffle":
        this.deck = mongeanShuffle(this.deck);
        break;
      case "quarterShuffle":
        this.deck = quarterShuffle(this.deck);
        break;
      default:
        this.deck = handShuffle(this.deck);
    }
    return this.deck;
  }
  //helper methods
  /*
  Algorithm:
  The Mongean shuffle, or Monge's shuffle, is performed as follows (by a right-handed person): 
  Start with the unshuffled deck in the left hand and transfer the top card to the right. Then
  repeatedly take the top card from the left hand and transfer it to the right, putting the 
  second card at the top of the new deck, the third at the bottom, the fourth at the top, the
  fifth at the bottom, etc.
  */
  private List<T> mongeanShuffle(List<T> deck){
    ArrayDeque<T> shuffledDeque = new ArrayDeque<T>();
    List<T> shuffledDeck = new LinkedList<T>();
    
    for(int i=1; i<=deck.size(); i++){
      if((i%2)==0){
        shuffledDeque.addLast(deck.get(i-1)); //add to top of deck
      }else{
        shuffledDeque.addFirst(deck.get(i-1)); //add to bottom of deck
      }
    }
    //Transfer to LinkedList. Still O(n)
    for(Iterator<T> iter = shuffledDeque.iterator();iter.hasNext();){
      shuffledDeck.add(iter.next());
    }
    return shuffledDeck;
  }


  /*
  Algorithm:
  Split deck into two halves and then interleave two halves.
  */
  private List<T> handShuffle(List<T> deck){
    List<T> halfDeck_1   = new LinkedList<T>();
    List<T> halfDeck_2   = new LinkedList<T>();
    List<T> shuffledDeck = new LinkedList<T>();
    for(int i=0; i < deck.size(); i++){
      if(i<(deck.size()/2)){
        halfDeck_1.add(deck.get(i));
      }else{
        halfDeck_2.add(deck.get(i));
      }
    }
    //assuming there are two equal halves
    if(halfDeck_1.size()==halfDeck_2.size()){
      for(int j=0; j < halfDeck_1.size(); j++){
        shuffledDeck.add(halfDeck_1.get(j));
        shuffledDeck.add(halfDeck_2.get(j));
      }
    }
    return shuffledDeck;
  }

  /*
  Algorithm:
  Split deck into quarters.
  Add a card from each quarter to shuffleddeck.
  repeat 
  */
  private List<T> quarterShuffle(List<T> deck){
    List<T> shuffledDeck = new LinkedList<T>();

    List<T> quarterDeck_1   = new LinkedList<T>();
    List<T> quarterDeck_2   = new LinkedList<T>();
    List<T> quarterDeck_3   = new LinkedList<T>();
    List<T> quarterDeck_4   = new LinkedList<T>();

    //assuming that deck can be divided into quarters
    if((deck.size()%4) == 0){
      int quarterNum = deck.size()/4; 
      for(int i=0; i<quarterNum; i++){
        quarterDeck_1.add(deck.get(i));
        quarterDeck_2.add(deck.get(i + quarterNum));
        quarterDeck_3.add(deck.get(i + (2*quarterNum)));
        quarterDeck_4.add(deck.get(i + (3*quarterNum)));
      }
      for(int k=0; k<quarterNum; k++){
        shuffledDeck.add(quarterDeck_1.get(k));
        shuffledDeck.add(quarterDeck_2.get(k));
        shuffledDeck.add(quarterDeck_3.get(k));
        shuffledDeck.add(quarterDeck_4.get(k));
      }
    }

    return shuffledDeck;
  }
}
  
