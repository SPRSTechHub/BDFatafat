package live.bdfatafat.android.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import live.bdfatafat.android.databinding.RowBetPlacementBinding;

import live.bdfatafat.android.R;
import live.bdfatafat.android.databinding.RowBetPlacementBinding;

import java.util.List;

import live.bdfatafat.android.model.betPlacement.BetPlacementRequest;

public class BetPlacementAdapter extends RecyclerView.Adapter<BetPlacementAdapter.ViewHolder> {
    public List<BetPlacementRequest> mList;

    public BetPlacementAdapter(List<BetPlacementRequest> list) {
        this.mList = list;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder((RowBetPlacementBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_bet_placement, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        BetPlacementRequest betPlacementRequest = this.mList.get(position);
        holder.itemView.tvDigit.setText(betPlacementRequest.getDigit());
        holder.itemView.tvAmount.setText(betPlacementRequest.getAmount());
        holder.itemView.btnDelete.setOnClickListener(view -> {
            this.mList.remove(position);
            notifyItemRemoved(position);
        });
    }

    public int getItemCount() {
        List<BetPlacementRequest> list = this.mList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final RowBetPlacementBinding itemView;

        private ViewHolder(RowBetPlacementBinding itemView2) {
            super(itemView2.getRoot());
            this.itemView = itemView2;
        }
    }
}
