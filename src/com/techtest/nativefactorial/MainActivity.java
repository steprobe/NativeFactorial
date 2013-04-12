package com.techtest.nativefactorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    static {
        System.loadLibrary("factlib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et = (EditText)findViewById(R.id.fact);

        final Button bt = (Button)findViewById(R.id.calcFact);
        bt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                if(et.getText().toString().length() == 0) {
                    return;
                }

                //Will overflow pretty quickly...
                double res = calculateFactorial(Integer.parseInt(et.getText().toString()));
                Toast.makeText(MainActivity.this, "Result is: " + res, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private native double calculateFactorial(int fact);
}
