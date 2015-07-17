package marta.rodriguez.mercadonaapp.mercadona.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import marta.rodriguez.mercadonaapp.mercadona.R;
import marta.rodriguez.mercadonaapp.mercadona.model.Supermarket;

/**
 * Created by martarodriguez on 9/7/15.
 */
public class SupermarketAdapter extends RecyclerView.Adapter<SupermarketAdapter.ViewHolder> {

    private List<Supermarket> items;
    private int itemLayout;

    public SupermarketAdapter(List<Supermarket> items, int itemLayout) {
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v, parent.getContext());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Supermarket item = items.get(position);
        holder.bindSupermarket(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.address)
        TextView address;
        @Bind(R.id.town)
        public TextView town;
        @Bind(R.id.schedule)
        public TextView schedule;

        private Context mCtx;

        public ViewHolder(View itemView, Context c) {
            super(itemView);
            this.mCtx = c;
            ButterKnife.bind(c, itemView);
        }

        public void bindSupermarket(Supermarket supermarket) {
            address.setText(supermarket.getAddress());
            town.setText(supermarket.getTown());
            schedule.setText(mCtx.getResources().getString(R.string.schedule, supermarket.getHours()));
            itemView.setTag(supermarket);
        }
    }
}