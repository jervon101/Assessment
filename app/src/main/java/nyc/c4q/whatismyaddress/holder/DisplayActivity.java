package nyc.c4q.whatismyaddress.holder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import nyc.c4q.whatismyaddress.R;

public class DisplayActivity extends AppCompatActivity {

    TextView view1,view2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        view1 = (TextView) findViewById(R.id.detail_view1);
        view2 = (TextView) findViewById(R.id.detail_view2);

        String intent  = getIntent().getStringExtra("value");


        view1.setText(intent.toString());

        view2.setText(intent.toString().length()+"");
    }
}
