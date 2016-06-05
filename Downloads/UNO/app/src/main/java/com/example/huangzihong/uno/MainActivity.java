package com.example.huangzihong.uno;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    Button button_singlePlay;//单人游戏按键

    //dialog的控件与Adapter
    LayoutInflater inflater;
    Dialog dialog;
    View view_dialog;
    Button button_dialog_sure;
    Button button_dialog_cancel;
    SeekBar seekBar_dialog;
    TextView textView_dialog_number;
    SeekBar.OnSeekBarChangeListener seekBarChangeListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //屏蔽标题栏
        setContentView(R.layout.activity_main);

        init_view();

        init_set();

    }

    private void init_set() {
        seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textView_dialog_number.setText("" + ( progress + 2 ));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
    }

    private void init_view() {
        button_singlePlay = (Button)findViewById(R.id.button_singlePlayer);
        button_singlePlay.setOnClickListener(this);
    }


    private void putDialog() {
        inflater = getLayoutInflater();
        view_dialog = inflater.inflate(R.layout.dialog_single_set, (ViewGroup) findViewById(R.id.layout_DialogsingleSet));

        seekBar_dialog = (SeekBar) view_dialog.findViewById(R.id.seekBar_dialog);
        textView_dialog_number = (TextView) view_dialog.findViewById(R.id.textView_number);
        button_dialog_sure = (Button) view_dialog.findViewById(R.id.button_dialog_sure);
        button_dialog_cancel = (Button) view_dialog.findViewById(R.id.button_dialog_cancel);
        button_dialog_sure.setOnClickListener(this);
        button_dialog_cancel.setOnClickListener(this);
        seekBar_dialog.setOnSeekBarChangeListener(seekBarChangeListener);
        seekBar_dialog.setMax(6);
        seekBar_dialog.setProgress(3);

        dialog = new Dialog(this, R.style.dialog);
        dialog.setContentView(view_dialog);
        dialog.show();

        WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
        layoutParams.dimAmount = 0f;
        layoutParams.y = -DensityUtil.dip2px(this, 0);
        layoutParams.width = DensityUtil.dip2px(this, 400);
        layoutParams.height = DensityUtil.dip2px(this,260);
        layoutParams.alpha = 0.85f;
        dialog.getWindow().setAttributes(layoutParams);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_singlePlayer:
                putDialog();
                break;
            case R.id.button_dialog_sure:
                Intent intent = new Intent(MainActivity.this, SinglePlayActivity.class);
                intent.putExtra("NUMBER", textView_dialog_number.getText().toString());
                startActivity(intent);
                break;
            case R.id.button_dialog_cancel:
                dialog.dismiss();
                break;
            default:
                break;
        }
    }

}
