package com.example.sarthak.share_and_control_it;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.PrintStream;
import java.net.Socket;

public class MouseActivity extends Activity {

    private JoystickView joystickView;
    private TextView textView;
    Socket sock ;
    PrintStream ps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouse);

        joystickView = (JoystickView) findViewById(R.id.joystick);
        //textView = (TextView) findViewById(R.id.text);
        sock = MainActivity.soc;
        ps = MainActivity.ps;
        joystickView.setOnJoystickMoveListener(new JoystickView.OnJoystickMoveListener() {
            @Override
            public void onValueChanged(int angle, int power, int direction) {
                int originX = (int)joystickView.getCenterX();
                int originY = (int)joystickView.getCenterY();
                int finalX = (joystickView.getxPosition()-originX);
                int finalY = (originY-joystickView.getyPosition());
                MouseCoordinate coordinate = new MouseCoordinate(finalX,finalY);
                final String command = coordinate.getCommand();
                //textView.setText(command);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ps.println(command);
                    }
                }).start();
            }
        },JoystickView.DEFAULT_LOOP_INTERVAL);
    }

    public void rightClick(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ps.println("Mc r");
            }
        }).start();
    }

    public void leftClick(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ps.println("Mc l");
            }
        }).start();
    }
}