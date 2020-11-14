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
    EditText edit; // 입력창
    TextView second_text; //두번째 값 표시위한 TextView선언
    String[] string = new String[] {"SubActivity1_text", "SubActivity2_text"}; // 값 저장을 위한 배열생성

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);
        edit = (EditText) findViewById(R.id.edit);
        second_text = (TextView) findViewById(R.id.second_text); //아이디로 TextView 찾기

        Button button_ok = (Button) findViewById(R.id.button_ok);
        button_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                string[0] = edit.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("string1", string[0]);
                intent.putExtra("string2", string[1]); // 인텐트에 값 넣기
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
                second_text.setText(string[1]); // 2차입력값 1차에서 보이기
            }
        }
    }
}
