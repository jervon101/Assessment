package nyc.c4q.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String SHARED_PREF_KEY = "address_shared_preference";

    private SharedPreferences log;

    EditText editText;
    Button button1,button2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText) findViewById(R.id.edit);
        button1 =(Button) findViewById(R.id.button01);
        button2 =(Button) findViewById(R.id.button02);

        log = getSharedPreferences(SHARED_PREF_KEY, MODE_PRIVATE);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor =log.edit();
                editor.putString(editText.getText().toString(),editText.getText().toString());
                editor.commit();
                editText.setText("");
                editText.clearComposingText();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RecyclerActivity.class);
                intent.putExtra("sharedpref",log.getString(editText.getText().toString(),null));
                startActivity(intent);
            }
        });
    }
}
