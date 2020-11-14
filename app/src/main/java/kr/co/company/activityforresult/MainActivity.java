package kr.co.company.activityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int GET_STRING = 1;
    TextView text1;
    TextView text2;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        button.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View arg0) {
                Intent in = new Intent(MainActivity.this, SubActivity.class);

                startActivityForResult(in, GET_STRING);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_STRING) {
            if (resultCode == RESULT_OK) {
                text1.setText(data.getStringExtra("string1"));
                text2.setText(data.getStringExtra("string2"));
            }
        }
    }
}
