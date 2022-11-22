package live.bdfatafat.android.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import live.bdfatafat.android.R;
import live.bdfatafat.android.databinding.RowTranscationHistoryBinding;

import java.util.List;

import live.bdfatafat.android.model.transaction_history.Transactions;

public class TransactionHistoryAdapter extends RecyclerView.Adapter<TransactionHistoryAdapter.TranscationHistoryViewHolder> {
    public List<Transactions> mList;

    public TransactionHistoryAdapter(List<Transactions> list) {
        this.mList = list;
    }

    public TranscationHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TranscationHistoryViewHolder((RowTranscationHistoryBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_transcation_history, parent, false));
    }

    public void onBindViewHolder(TranscationHistoryViewHolder holder, int position) {
        Transactions transactions = this.mList.get(position);
        TextView textView = holder.itemView.tvAmount;
        textView.setText("Rs. " + transactions.getTr_amnt());
        holder.itemView.tvDate.setText(transactions.getDate());
        holder.itemView.tvDesc.setText(transactions.getDescp());
        TextView textView2 = holder.itemView.tvBalanceValue;
        textView2.setText("Rs. " + transactions.getBal());
    }

    public int getItemCount() {
        List<Transactions> list = this.mList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    static class TranscationHistoryViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final RowTranscationHistoryBinding itemView;

        private TranscationHistoryViewHolder(RowTranscationHistoryBinding itemView2) {
            super(itemView2.getRoot());
            this.itemView = itemView2;
        }
    }
}
