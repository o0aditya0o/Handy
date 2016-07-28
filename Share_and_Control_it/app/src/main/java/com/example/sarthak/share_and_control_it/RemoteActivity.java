package com.example.sarthak.share_and_control_it;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;


public class RemoteActivity extends Activity {
    String User_name=null;
    Dialog dg;
    Button shutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_remote);
        //    shutButton = (Button)findViewById(R.id.shut);
        //  con = new Connection("ds");
        //con.start();
    }
    public void mouse(View view){
        Intent in=new Intent(this,MouseActivity.class);
        startActivity(in);
    }
    public void poweroff(View view)
    {
        MainActivity.ps.println("P");
    }
    public void logoff(View view){
        dg=new Dialog(this);

        dg.setContentView(R.layout.user);
        dg.setTitle("Enter Username ");
        System.out.println(User_name);
        Button byt=(Button)dg.findViewById(R.id.confirm);
        byt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edt=(EditText)dg.findViewById(R.id.username);
                User_name =edt.getText().toString();
                MainActivity.ps.println("L"+" "+User_name);
                dg.dismiss();
            }
        });

        dg.show();
    }

    public void setting(View view) {
        Intent in=new Intent(this, Settings.class);
         startActivity(in);
    }

}