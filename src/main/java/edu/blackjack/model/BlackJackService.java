package edu.blackjack.model;

import edu.blackjack.data.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service

public class BlackJackService {
    @Autowired
    Data data;
    List<Card> deck = new ArrayList<>();
    boolean isStop = false;
    List<Card> delivery = new ArrayList<>();
    List<Card> forComp = new ArrayList<>();
    public int counterPlayer = 0;
    public int counterPC = 0;
    public int roundCounter = 1;

    @PostConstruct
    public void init() {
        deck = new ArrayList<>(data.getDeck()) ;
    }

    public void setScore(boolean youWin){
        if(youWin == true){
            counterPlayer++;
        }else {
            counterPC++;
        }
    }

    public List<Card> getShuffleDeck() {
        Collections.shuffle(deck);
        return deck;
    }
    public void newGame() {
        delivery = new ArrayList<>();
        forComp = new ArrayList<>();
        deck = new ArrayList<>();
        deck = data.getDeck();
        counterPC = 0;
        counterPlayer = 0;
        roundCounter = 1;

    }

    public void playNext() {
        delivery = new ArrayList<>();
        forComp = new ArrayList<>();
    }
    public int getDeckSize() {
        return deck.size();
    }

    public Card pickFirstCardFromShuffleDeck() {
        Card card = this.getShuffleDeck().get(0);
        deck.remove(card);  //видалити цю карту з колоди
        return card;
    }

    public List<Card> getCardList() {
        if (!isStop || delivery.stream().mapToInt(Card::getValue).sum() < 20) {
            Card card = this.pickFirstCardFromShuffleDeck();
            delivery.add(card);
        }  //видати цю карту на роздачу
        return delivery;
    }

    public Player InitPlayer(Player player) {
        player.getPrivateSet().clear();
        return player;

    }

    public int getPlayerSum(Player player) {
        List<Card> cards = player.getPrivateSet();
        return cards.stream().mapToInt(Card::getValue).sum();
    }


    public Card showSixPike() {
        Card sixPike = deck.get(0);
        return sixPike;
    }

    public List<Card> getDeck() {
        return deck;
    }


    public List<Card> getDelivery() {
        return delivery;
    }

    public List<Card> getDeliveryForComp() {
       /* Card card = this.pickFirstCardFromShuffleDeck();
        forComp.add(card);
        card= pickFirstCardFromShuffleDeck();
        forComp.add(card);
        card= pickFirstCardFromShuffleDeck();
        forComp.add(card);*/
        for (int i = 0; i < 3; i++) {
            if (forComp.size() < 3) {
                Card card = this.pickFirstCardFromShuffleDeck();
                forComp.add(card);
            }
        }
        return forComp;
    }

    public String getWinner(int sum, int sum1) {
        String youWin = "You are Winner";
        String youLost = "You are Looser";
        String draw = "Draw";
        String message = "";
        isStop = true;

        if (sum == sum1) {
            message = draw;
        } else {
            if (sum == 21 && sum1 != 21) {
                message = youWin;
            } else {
                if (sum < 21 && sum1 > 21) {
                    message = youWin;
                } else {
                    if (sum < 21 && sum1 < 21 && sum > sum1) {
                        message = youWin;
                    } else {
                        if (sum < 21 && sum1 < 21 && sum < sum1) {
                            message = youLost;
                        } else {
                            if (sum > 21 && sum1 > 21 && sum < sum1) {
                                message = youWin;
                            } else {
                                if (sum > 21 && sum1 > 21 && sum > sum1) {
                                    message = youLost;
                                } else {
                                    if (sum > 21 && sum1 < 21) {
                                        message = youLost;
                                    } else {
                                        if (sum1 == 21 && sum != 21) {
                                            message = youLost;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (message.equals(youWin)){
            this.setScore(true);
        }else {
            this.setScore(false);
        }
        ++roundCounter;

        return message;
    }

    public List<Card> getNewDeck() {
        deck = data.getDeck();
        return deck;
    }
}
