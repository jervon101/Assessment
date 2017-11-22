package nyc.c4q.whatismyaddress.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.whatismyaddress.R;
import nyc.c4q.whatismyaddress.data.Address;
import nyc.c4q.whatismyaddress.holder.AddressHolder;

/**
 * Created by jervon.arnoldd on 11/21/17.
 */

public class AdressAdapter extends RecyclerView.Adapter<AddressHolder> {
   List<Address> addressList;


    public AdressAdapter(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public AddressHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new AddressHolder(view);
    }

    @Override
    public void onBindViewHolder(AddressHolder holder, int position) {
        Address address = addressList.get(position);
        holder.onBind(address);

    }


    @Override
    public int getItemCount() {
        return addressList.size();
    }
}
