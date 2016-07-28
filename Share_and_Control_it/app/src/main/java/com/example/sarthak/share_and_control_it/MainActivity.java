package com.example.sarthak.share_and_control_it;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends Activity {

    Button shutdown;
    public static  Socket soc;
    public static PrintStream ps;
    public final int port=2000;
//    private class Sock extends AsyncTask<String, Void, String> {
//        Socket socket;
//        @Override
//        protected String doInBackground(String... params) {
//            try {
//                socket = new Socket("192.168.43.179",5000);
//            }
//            catch (Exception e){
//                System.out.println("catch\n");
//                //e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//
//            try {
//                DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
//                dos.writeUTF(s);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        protected void onPreExecute() {
//
//        }
//
//        @Override
//        protected void onProgressUpdate(Void... values) {
//
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


    }
    public void go(View view){
        EditText et=(EditText)findViewById(R.id.edt);
        final String ip=et.getText().toString();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    soc=new Socket(ip,port);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    ps=new PrintStream(soc.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Intent in=new Intent(this,RemoteActivity.class);
        startActivity(in);

    }
}
