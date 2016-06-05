package com.example.huangzihong.uno;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangzihong on 16/6/1.
 */
public class SinglePlayActivity extends Activity {

    int playerNumber;

    TextView textView_info;

    private List<Card> cardList = new ArrayList<Card>();
    private ListViewCards hListView;
    private ListViewAdapterCards hListViewAdapter;

    private Player player;
    private ComputerPlayer[] computerPlayers;
    private Card[] playerCards;
    private Card[] computerCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_single_play);

        initView();

//        getPlayerNumber();

        playerInit();

//        computerPlayersInit();

        showPlayerListView();
    }

    private void showPlayerListView() {
        hListViewAdapter = new ListViewAdapterCards(SinglePlayActivity.this, R.layout.horizontal_list_item, cardList);
        hListView = (ListViewCards)findViewById(R.id.horizon_listview);
        hListView.setAdapter(hListViewAdapter);
    }

    private void getPlayerNumber() {
        Intent intent = getIntent();
        String Number = intent.getStringExtra("NUMBER");
        playerNumber = Integer.parseInt(Number);
        textView_info.setText("" + playerNumber);
    }

    private void computerPlayersInit() {
        computerPlayers = new ComputerPlayer[7];
        for (int i = 0; i < playerNumber - 1; i++){
            computerPlayers[i].AddCards(7);
        }
    }

    private void playerInit() {
        player = new Player();
        player.addCardsByint(7);

        playerCards = player.getscards();
        for (int i = 0; i < player.getCards_numebr(); i++){
            cardList.add(playerCards[i]);
        }
    }

    public void initView(){
        textView_info = (TextView)findViewById(R.id.textView_info);

    }
}
