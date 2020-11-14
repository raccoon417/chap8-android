package kr.co.company.activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by igchun on 2017-05-01.
 */

public class SubActivity2 extends AppCompatActivity {
    EditText edit;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub2);

        edit = (EditText) findViewById(R.id.edit);
        Button button_ok = (Button) findViewById(R.id.button_ok);
        button_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.putExtra("second_text", edit.getText().toString());
                setResult(RESULT_OK, intent2);
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
    }
}
