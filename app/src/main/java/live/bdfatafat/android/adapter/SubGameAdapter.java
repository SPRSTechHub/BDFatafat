package live.bdfatafat.android.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import live.bdfatafat.android.R;
import live.bdfatafat.android.databinding.RowSubGameBinding;

import java.util.List;

import live.bdfatafat.android.activity.BetSelectionActivity;
import live.bdfatafat.android.model.game_list.GameList;

public class SubGameAdapter extends RecyclerView.Adapter<SubGameAdapter.ViewHolder> {
    public List<GameList> mList;

    public SubGameAdapter(List<GameList> results) {
        this.mList = results;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder((RowSubGameBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_sub_game, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        GameList result = this.mList.get(position);
        holder.itemView.getRoot().setOnClickListener(view -> {
            if (position == this.mList.size() - 1) {
                Intent i = new Intent(holder.itemView.getRoot().getContext(), BetSelectionActivity.class);
                i.putExtra("id", result.getMatchId());
                i.putExtra("id2", "");
                i.putExtra("time", result.getMatchTime());
                holder.itemView.getRoot().getContext().startActivity(i);
                return;
            }
            Intent i2 = new Intent(holder.itemView.getRoot().getContext(), BetSelectionActivity.class);
            i2.putExtra("id", result.getMatchId());
            i2.putExtra("id2", this.mList.get(position + 1).getMatchId());
            i2.putExtra("time", result.getMatchTime());
            holder.itemView.getRoot().getContext().startActivity(i2);
        });
        if (result.getLive().equals("no")) {
            holder.itemView.getRoot().setAlpha(0.5f);
            holder.itemView.getRoot().setEnabled(false);
        }

        Glide.with(holder.itemView.getRoot())
                .load(result.getMatch_icon())
                .fitCenter()
                .into(holder.itemView.ivGame);
        holder.itemView.tvGameName.setText(result.getGameTitle());
        holder.itemView.tvGameTime.setText(result.getMatchTime());
    }


    public int getItemCount() {
        List<GameList> list = this.mList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final RowSubGameBinding itemView;

        private ViewHolder(RowSubGameBinding itemView2) {
            super(itemView2.getRoot());
            this.itemView = itemView2;
        }
    }
}
