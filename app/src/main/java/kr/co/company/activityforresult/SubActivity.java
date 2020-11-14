package kr.co.company.activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by igchun on 2017-05-01.
 */

public class SubActivity extends AppCompatActivity {
    static final int GET_STRING = 1;
    EditText edit;
    TextView second_text;
    String[] string = new String[] {"SubActivity1_text", "SubActivity2_text"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);
        edit = (EditText) findViewById(R.id.edit);
        second_text = (TextView) findViewById(R.id.second_text);

        Button button_ok = (Button) findViewById(R.id.button_ok);
        button_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                string[0] = edit.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("string1", string[0]);
                intent.putExtra("string2", string[1]);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button button_cancel = (Button) findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        Button second_set = (Button) findViewById(R.id.second_set);
        second_set.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View arg0) {
                Intent in2 = new Intent(SubActivity.this, SubActivity2.class);

                startActivityForResult(in2, GET_STRING);
            }
        });
    }

    //@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_STRING) {
            if (resultCode == RESULT_OK) {
                string[1] = data.getStringExtra("second_text");
                second_text.setText(string[1]);
            }
        }
    }
}
