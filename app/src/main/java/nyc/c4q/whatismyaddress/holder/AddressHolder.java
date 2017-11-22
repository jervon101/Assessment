package nyc.c4q.whatismyaddress.holder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.whatismyaddress.R;
import nyc.c4q.whatismyaddress.data.Address;

/**
 * Created by jervon.arnoldd on 11/21/17.
 */

public class AddressHolder extends RecyclerView.ViewHolder {
    TextView textView;
     Context context;


    public AddressHolder(View itemView) {
        super(itemView);
        textView =(TextView) itemView.findViewById(R.id.item_view);
        context = itemView.getContext();
    }

    public void onBind(final Address address) {
        textView.setText(address.getAddress().toString());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(),DisplayActivity.class);
                intent.putExtra("value" , address.getAddress().toString());
                context.startActivity(intent);
            }
        });

    }
}
