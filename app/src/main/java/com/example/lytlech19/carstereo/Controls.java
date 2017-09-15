package com.example.lytlech19.carstereo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Controls extends AppCompatActivity {

    private ToggleButton power;
    private ToggleButton FMAM;
    private ToggleButton bluetooth;
    private TextView display;
    private SeekBar volume;
    private SeekBar bass;
    private Button plusRadio;
    private Button minusRadio;
    private int am = 530;
    private double fm = 88.1;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;




    private int[] stationListAM = {550, 600, 650,700,750,800};
    private double[] stationListFm = {90.9,92.9,94.9,96.9,98.9,100.9};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controls);


        power = (ToggleButton) findViewById(R.id.Power);
        FMAM = (ToggleButton) findViewById(R.id.AmFm);
        bluetooth = (ToggleButton) findViewById(R.id.Bluetooth);
        display = (TextView) findViewById(R.id.Display);
        volume = (SeekBar) findViewById(R.id.MasterVolume);
        bass = (SeekBar) findViewById(R.id.Base);
        plusRadio = (Button) findViewById(R.id.PlusRadio);
        minusRadio = (Button) findViewById(R.id.MinusRadio);
        button1 = (Button) findViewById(R.id.Button1);
        button2 = (Button) findViewById(R.id.Button2);
        button3 = (Button) findViewById(R.id.Button3);
        button4 = (Button) findViewById(R.id.Button4);
        button5 = (Button) findViewById(R.id.Button5);
        button6 = (Button) findViewById(R.id.Button6);

    }

    public void powerClick(View Power){

        if (power.isChecked()){

            FMAM.setClickable(false);
            bluetooth.setClickable(false);
            display.setVisibility(View.INVISIBLE);
            volume.setEnabled(false);
            bass.setEnabled(false);
        }
        else {
            FMAM.setClickable(true);
            bluetooth.setClickable(true);
            display.setVisibility(View.VISIBLE);
            volume.setEnabled(true);
            bass.setEnabled(true);
        }
    }

    public void radioSwitch(View AmFm){

        if(FMAM.isChecked()){
            display.setText("AM : " + am);
        }
        else{
            display.setText("FM : " + fm);
        }
    }

    public void changeStation(View button){
        if (!(bluetooth.isChecked())){
            if ((FMAM.isChecked()) && (button.equals(plusRadio))){
                if ((am >= 530) && (am < 1700)){
                    am = am + 10;
                }
                else {
                    am = 530;
                }
                display.setText("AM : " + am);
            }
            else if ((button.equals((plusRadio)))){
                if((fm < 107.9) && (88.1 <= fm)) {
                    fm = fm + 0.2;
                }
                else {
                    fm = 88.1;
                }
                display.setText("FM : " + fm);
            }
            else if ((FMAM.isChecked()) && (button.equals(minusRadio))){
                if ((am > 530) && (am <= 1700)){
                    am = am - 10;
                }
                else {
                    am = 1700;
                }
                display.setText("AM : " + am);
            }
            else {
                if((fm <= 107.9) && (88.1 < fm)) {
                    fm = fm - 0.2;
                }
                else {
                    fm = 107.9;
                }
                display.setText("FM : " + fm);
            }
        }
    }

    public void buttonStations(View station){
        int newAMval = 0;
        if (station.equals(button1)){
            newAMval = 0;
        }
        else if(station.equals(button2)){
            newAMval = 1;
        }
        else if(station.equals(button3)){
            newAMval = 2;
        }
        else if(station.equals(button4)){
            newAMval = 3;
        }
        else if(station.equals(button5)){
            newAMval = 4;
        }
        else if(station.equals(button6)){
            newAMval = 5;
        }


        if (FMAM.isChecked()){
            display.setText("AM : " + stationListAM[newAMval]);
        }
        else {
            display.setText("FM : " + stationListFm[newAMval]);
        }
    }


}
