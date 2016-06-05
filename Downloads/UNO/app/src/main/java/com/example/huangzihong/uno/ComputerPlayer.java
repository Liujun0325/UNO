package com.example.huangzihong.uno;

/**
 * Created by liujun on 16/6/1.
 */
public class ComputerPlayer  {
    private double OutCardProbablity;
    private int OutCardNumber;
    private int CardsNumber;

    ComputerPlayer(){
        this.CardsNumber=0;
        OutCardProbablity=0.0;
        OutCardNumber=0;
    }
    public void AddCards(int add_numebr){
        CardsNumber+=add_numebr;
    }//增加牌
    public int getCardsNumber(){
        return CardsNumber;
    }
    public double getOutCardProbablity(Card card){
        OutCardProbablity=0.0;
        if(card.getNumber()==0){
            OutCardProbablity=1-Math.pow(1-0.33,CardsNumber);
        }
        else if(card.getNumber()<10){
            OutCardProbablity=1-Math.pow(1-0.35,CardsNumber);
        }
        else if(card.getNumber()==10){
            OutCardProbablity=1-Math.pow(1-0.02,CardsNumber);
        }
        else if(card.getNumber()==11){
            OutCardProbablity=1-Math.pow(1-0.1,CardsNumber);
        }
        else if(card.getNumber()==12){
            OutCardProbablity=1-Math.pow(1-0.15,CardsNumber);
        }
        else {
            OutCardProbablity=1-Math.pow(1-0.04,CardsNumber);
        }
        return OutCardProbablity;
    }
    public int getOutCardsNumber(Card card){
        OutCardNumber=0;
        double temp_OutCardprobablity=getOutCardProbablity(card);
        if(CardsNumber>10){
            if(temp_OutCardprobablity>0.9)return 3;
            else return 1;
        }
        else if(CardsNumber>5){
            if(temp_OutCardprobablity>0.9)return 2;
            else return 1;
        }
        else  if(CardsNumber>3){
            if(temp_OutCardprobablity>0.8)return 2;
            else if(temp_OutCardprobablity<0.3)return 0;
            else return 1;
        }
        else if(CardsNumber>1){
            if(temp_OutCardprobablity>0.56)return 1;
            else return 0;
        }
        else {
            int t=(int)(1+Math.random()*3);
            if(t==1)return 1;
            else return 0;
        }
    }

    public boolean OutCardOrnot(Card card){
        if(getOutCardsNumber(card)==0)return false;
        return true;
    }
    public  Card OutOfCard(Card card){
        CardsNumber--;
        if(card.getNumber()<10){
            int t=(int)(0+Math.random()*9);
            return new Card(t,card.getColor());
        }
        else if(card.getNumber()==10){
            return new Card(10,card.getColor());
        }
        else if(card.getNumber()==11){
            int t=(int)(1+Math.random()*4);
            char temp;
            if(t==1)temp='r';
            else if(t==2)temp='g';
            else if(t==3)temp='b';
            else temp='y';
            return new Card(11,temp);
        }
        else if(card.getNumber()==12){
            int t=(int)(1+Math.random()*4);
            char temp;
            if(t==1)temp='r';
            else if(t==2)temp='g';
            else if(t==3)temp='b';
            else temp='y';
            return new Card(12,temp);
        }
        else {
            return new Card(14,'a');
        }

    }//此时每次只打出一张牌；

}
