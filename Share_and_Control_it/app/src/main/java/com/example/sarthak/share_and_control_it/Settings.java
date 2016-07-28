package com.example.sarthak.share_and_control_it;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.io.PrintStream;

/**
 * Created by sarthak on 2/4/16.
 */
public class Settings extends Activity {

    SeekBar brightBar,soundBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);
        brightBar = (SeekBar)findViewById(R.id.brightBar);
        soundBar = (SeekBar)findViewById(R.id.soundBar);
    }

    public void setBright(View view)
    {
        int value = brightBar.getProgress();

        String command;
        if(value< 10)
            command = "B 00"+value;
        else if(value < 100)
            command= "B 0"+value;
        else
            command = "B "+value;
        MainActivity.ps.println(command);
        System.out.println(command);
    }

    public void setSound(View view)
    {
        int value = soundBar.getProgress();

        String command;
        if(value< 10)
            command = "S 00"+value;
        else if(value < 100)
            command= "S 0"+value;
        else
            command = "S "+value;
        MainActivity.ps.println(command);
        System.out.println(command);
    }
}
