package com.example.huangzihong.uno;

/**
 * Created by liujun on 16/6/1.
 */
//每一付牌中每种普通颜色0一张，1-9两张，禁牌反转牌+2牌两张，万能牌和——4牌四张，共108张
public class Card {
    private int number;
    private char color;
    private int card_value;
    //private int ImageId;
    Card(int number,char color){
        this.number=number;
        this.color=color;
        this.card_value=getCard_value();
    }
    Card(char color){
        number=-1;
        this.color=color;
        this.card_value=-1;
    }//此时构造一个只有颜色的卡片;当万能牌或者+4牌出现时使用
    Card(String s){
        int lenth=s.length();
        if(lenth<3){
            color=s.charAt(0);
            number=Integer.parseInt(String.valueOf(s.charAt(1)));
        }
        else {
            char s0=s.charAt(0);
            char s2=s.charAt(2);
            if(s0!='w'){
                color=s0;
                if(s2=='s'){
                    number=10;
                }
                else if(s2=='r'){
                    number=11;
                }
                else {
                    number=12;
                }
            }
            else {
                if(lenth>5){
                    number=14;
                }
                else {
                    number=13;
                }
            }
        }
    }

    Card(){
        int i=(int)(0+Math.random()*40);
        if(i<10){
            number=i%10;
            color='r';
        }
        else if(i<20){
            number=i%10;
            color='g';
        }
        else if(i<30){
            number=i%10;
            color='b';
        }
        else if(i<40){
            number=i%10;
            color='y';
        }
    }//随机出现一张卡片，此时只出现点数牌；


    public int getNumber(){
        return number;
    }//得到牌的点数或者功能作用,0-9代表点数，10代表禁牌，11代表反转，12代表+2，13代表万能，14代表+4；
    public char getColor(){
        return color;
    }//得到牌的颜色,a代表功能牌，r代表red，g代表green，b代表blue，y代表yellow；
    public int getCard_value(){
        int temp=0;
        if(color=='r')temp+=0;
        else if(color=='y')temp+=15;
        else if(color=='g')temp+=30;
        else if(color=='b')temp+=45;
        else if(color=='a')temp+=60;
        temp+=number;
        return temp;
    }//card_value是用于对卡片的排序，TreeMap排序；作为key；
    public void init(){
        number=-1;
        color=' ';
        card_value=-1;
    }//初始化牌

    public int getImageId(){
        if(color=='r'){
            if(number==0)return R.drawable.r0;
            else if(number==1)return R.drawable.r1;
            else if(number==2)return R.drawable.r2;
            else if(number==3)return R.drawable.r3;
            else if(number==4)return R.drawable.r4;
            else if(number==5)return R.drawable.r5;
            else if(number==6)return R.drawable.r6;
            else if(number==7)return R.drawable.r7;
            else if(number==8)return R.drawable.r8;
            else if(number==9)return R.drawable.r9;
            else if(number==10)return R.drawable.r_skip;
            else if(number==11)return R.drawable.r_reverse;
            else return R.drawable.r_add_2;
        }
        else if(color=='g'){
            if(number==0)return R.drawable.g0;
            else if(number==1)return R.drawable.g1;
            else if(number==2)return R.drawable.g2;
            else if(number==3)return R.drawable.g3;
            else if(number==4)return R.drawable.g4;
            else if(number==5)return R.drawable.g5;
            else if(number==6)return R.drawable.g6;
            else if(number==7)return R.drawable.g7;
            else if(number==8)return R.drawable.g8;
            else if(number==9)return R.drawable.g9;
            else if(number==10)return R.drawable.g_skip;
            else if(number==11)return R.drawable.g_reverse;
            else return R.drawable.g_add_2;
        }
        else if(color=='b'){
            if(number==0)return R.drawable.b0;
            else if(number==1)return R.drawable.b1;
            else if(number==2)return R.drawable.b2;
            else if(number==3)return R.drawable.b3;
            else if(number==4)return R.drawable.b4;
            else if(number==5)return R.drawable.b5;
            else if(number==6)return R.drawable.b6;
            else if(number==7)return R.drawable.b7;
            else if(number==8)return R.drawable.b8;
            else if(number==9)return R.drawable.b9;
            else if(number==10)return R.drawable.b_skip;
            else if(number==11)return R.drawable.b_reverse;
            else return R.drawable.b_add_2;
        }
        else if(color=='y'){
            if(number==0)return R.drawable.y0;
            else if(number==1)return R.drawable.y1;
            else if(number==2)return R.drawable.y2;
            else if(number==3)return R.drawable.y3;
            else if(number==4)return R.drawable.y4;
            else if(number==5)return R.drawable.y5;
            else if(number==6)return R.drawable.y6;
            else if(number==7)return R.drawable.y7;
            else if(number==8)return R.drawable.y8;
            else if(number==9)return R.drawable.y9;
            else if(number==10)return R.drawable.y_skip;
            else if(number==11)return R.drawable.y_reverse;
            else return R.drawable.y_add_2;
        }
        else {
            if(number==13)return R.drawable.wild;
            else return R.drawable.wild_add_4;
        }
    }

}
