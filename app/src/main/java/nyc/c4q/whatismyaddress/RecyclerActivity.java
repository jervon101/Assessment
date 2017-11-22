package nyc.c4q.whatismyaddress;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nyc.c4q.whatismyaddress.adapter.AdressAdapter;
import nyc.c4q.whatismyaddress.data.Address;

public class RecyclerActivity extends AppCompatActivity {
    private static final String SHARED_PREF_KEY = "address_shared_preference";
private SharedPreferences log;
    // i didnt used steps 1-2 in RecyclerActivity Commit , this way i believe works better;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_recycler);

       recyclerView = (RecyclerView) findViewById(R.id.recycle);

        log = getSharedPreferences(SHARED_PREF_KEY, MODE_PRIVATE);


        Map<String, ?> keys = log.getAll();

        List<Address> myFav = new ArrayList<>();

        for (Map.Entry<String, ?> entry : keys.entrySet()) {

            myFav.add(new Address(entry.getValue().toString()));
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        AdressAdapter adapter = new AdressAdapter(myFav);


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);



    }

}
