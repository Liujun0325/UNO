package com.example.huangzihong.uno;

import java.util.Random;

/**
 * Created by liujun on 16/6/5.
 */
public class Controller {
    private int FirstId;
    private Player player;
    private ComputerPlayer[] computerPlayers;
    private Card lastCard;
    private Card FirstCard;

    Controller(int playerNumber){
        Random random=new Random();
        FirstId=1+random.nextInt(playerNumber-1);

        player=new Player();
        player.addCardsByint(7);

        computerPlayers=new ComputerPlayer[playerNumber-1];
        for(int i=0;i<playerNumber-1;++i){
            computerPlayers[i]=new ComputerPlayer();
            computerPlayers[i].AddCards(7);
        }
        FirstCard=new Card();
        lastCard=new Card();
    }
    public int getFirstId(){
        return  FirstId;
    }
    public Card getLastCard(){
        return lastCard;
    }
    public Card[] playerOutCardAtPosition(int position){
        Card[] cards=new Card[player.getCards_numebr()];
        cards=player.getscards();
        lastCard=cards[position];
        player.reduceCards(position);
        return player.getscards();
    }
    public int getNumOfCardsById(int id){
        if(id==0){
            return player.getCards_numebr();
        }
        else {
            return computerPlayers[id-1].getCardsNumber();
        }
    }
    public Card[] getPlayerCards(){
        return player.getscards();
    }
    public int  ifComputerCanOutCardsAndDo(int id,Card card){
        return computerPlayers[id-1].getOutCardsNumber(card);
    }
    public Card[] getCardsOutFromCom(int id){
        Card[] temp_cards=new Card[ifComputerCanOutCardsAndDo(id,lastCard)];
        for(int i=0;i<ifComputerCanOutCardsAndDo(id,lastCard);++i){
            temp_cards[i]=computerPlayers[id-1].OutOfCard(lastCard);
            lastCard=temp_cards[i];
        }
        return temp_cards;
    }
    public void addCardsByid(int id,int num){
        if(id==0){
            player.addCardsByint(num);
        }
        else {
            computerPlayers[id-1].AddCards(num);
        }
    }
    public Card getFirstCard(){
        return FirstCard;
    }
    public boolean ifComputerCanSave(int id){
        return computerPlayers[id-1].OutCardOrnot(lastCard);
    }








}
