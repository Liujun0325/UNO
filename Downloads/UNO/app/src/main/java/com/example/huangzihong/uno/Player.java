package com.example.huangzihong.uno;

import android.util.Log;
import android.widget.Toast;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by liujun on 16/6/1.
 */
public class Player {
    private int cards_numebr;
    private Card cards[];
    private Integer cards_values[];
    private Card[] card1;

    Player(){
        cards=new Card[100];
        cards_values=new Integer[100];
        //unit();
        cards_numebr=0;
    }

    protected void unit(){
        for(int i=0;i<50;++i){
            cards[i]=new Card(-1,' ');
            cards_values[i]=-1;
        }
    }

    public Card[] getscards(){
        //sortCards();
        return cards;
    }

    public int getCards_numebr(){
        return cards_numebr;
    }

    public void addCardsBycard(Card card){
        cards[cards_numebr]=card;
        cards_values[cards_numebr]=card.getCard_value();
        cards_numebr++;
        //sortCards();
    }//抓牌，参数是牌

    public void addCardsByint(int addcard_number){
        Random random=new Random();
        for(int i=0;i<addcard_number;++i){
            int tempCardValue=1+random.nextInt(107);
            //Log.v("addd", String.valueOf(tempCardValue));
            if(tempCardValue<=25){
                if(tempCardValue%2==1){
                    tempCardValue--;
                }
                Card AddtempCard=new Card(tempCardValue/2,'r');
                addCardsBycard(AddtempCard);
            }
            else if(tempCardValue<=50){
                tempCardValue-=25;
                if(tempCardValue%2==1){
                    tempCardValue--;
                }
                Card AddtempCard=new Card(tempCardValue/2,'g');
                addCardsBycard(AddtempCard);
            }
            else if(tempCardValue<=75){
                tempCardValue-=50;
                if(tempCardValue%2==1){
                    tempCardValue--;
                }
                Card AddtempCard=new Card(tempCardValue/2,'b');
                addCardsBycard(AddtempCard);
            }
            else if(tempCardValue<=100){
                tempCardValue-=75;
                if(tempCardValue%2==1){
                    tempCardValue--;
                }
                Card AddtempCard=new Card(tempCardValue/2,'y');
                addCardsBycard(AddtempCard);
            }
            else {
                if(tempCardValue<105){
                    Card AddtempCard=new Card(13,'a');
                    addCardsBycard(AddtempCard);
                }
                else{
                    Card AddtempCard=new Card(14,'a');
                    addCardsBycard(AddtempCard);
                }
            }
        }
        sortCards();
    }//抓牌，参数是牌的数量，随机抓牌，牌不单单只一副牌；

    public void reduceCards(int  position){
        for(int i=position;i<cards_numebr-1;i++){
            cards[i]=cards[i+1];
        }
        cards_numebr--;
        sortCards();
    }//出牌

    public void sortCards(){
        Map<Integer,Card>map=new TreeMap<Integer,Card>();
        for(int i=0;i<cards_numebr;++i){
            map.put(cards_values[i],cards[i]);
        }
        int count=0;
        for(Map.Entry<Integer, Card> entry : map.entrySet()){
            cards[count]=entry.getValue();
            //Log.e("count",String.valueOf(cards[count].getCard_value()));
            count++;
        }
    }//排序，在这里，根据red，yellow，green，blue，black排序，a代表black，先点数牌->禁牌->反转牌->+2牌->万能牌->+4牌；

    public Card[] outofcards(Card card){
        int card1_number=0;
        for(int i=0;i<cards_numebr;++i){
            if(card.getNumber()<10){
                if(card.getColor()==cards[i].getColor()){
                    card1[card1_number]=cards[i];
                    card1_number++;
                }
                else if(card.getNumber()==cards[i].getNumber()){
                    card1[card1_number]=cards[i];
                    card1_number++;
                }
                else if(cards[i].getColor()=='a'){
                    card1[card1_number]=cards[i];
                    card1_number++;
                }
            }//之前是点数牌的时候，同色可出
            else if(card.getNumber()==10){
                if(cards[i].getNumber()==10&&cards[i].getColor()==card.getColor()){
                    card1[card1_number]=cards[i];
                    card1_number++;
                }
            }//禁牌只有相同才能出
            else if(card.getNumber()==11){
                if(cards[i].getNumber()==11){
                    card1[card1_number]=cards[i];
                    card1_number++;
                }
            }//反转的话，是反转就可以出
            else if(card.getNumber()==12){
                if(cards[i].getNumber()==12){
                    card1[card1_number]=cards[i];
                    card1_number++;
                }
                else if(cards[i].getColor()=='a'){
                    card1[card1_number]=cards[i];
                    card1_number++;
                }
            }//+2只要是+2或者黑色都可以出;
            else if(card.getNumber()==14){
                if(card.getNumber()==14){
                    card1[card1_number]=cards[i];
                    card1_number++;
                }
            }//在这里+4只有+4可以出，此时我们跳过了万能牌，因为万能牌需要上一个玩家指定颜色，用card构造函数构造一个只确定颜色的card再作为参数传进来。
        }
        return  card1;
    }//该函数返回的是可以出的卡片的集合,card1_number是可以打出的牌的数目,但是此时card1还未赋值，用到card1前必须使用该函数。

    /*public boolean playerCanRobOrNot(Card card){
        for(int i=0;i<cards_numebr;i++){
            if(cards[i].getNumber()==card.getNumber()&&cards[i].getColor()==card.getColor()){
                return true;
            }
        }
        return false;
    }*/ //判断是否可以抢


}
