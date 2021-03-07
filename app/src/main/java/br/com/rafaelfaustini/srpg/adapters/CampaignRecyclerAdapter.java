package br.com.rafaelfaustini.srpg.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.rafaelfaustini.srpg.R;
import br.com.rafaelfaustini.srpg.entity.Campaign;

public class CampaignRecyclerAdapter extends RecyclerView.Adapter<CampaignRecyclerAdapter.MyViewHolder> {

    private Context context;
    private List<Campaign> campaigns;

    public CampaignRecyclerAdapter(Context context, List<Campaign> campaigns) {
        this.context = context;
        this.campaigns = campaigns;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_campaign_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.campaignId.setText(String.valueOf(campaigns.get(position).getId()));
        holder.campaignTitle.setText(String.valueOf(campaigns.get(position).getName()));
        holder.campaignDesc.setText(String.valueOf(campaigns.get(position).getStory()));

    }

    @Override
    public int getItemCount() {
        return campaigns.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView campaignId, campaignTitle, campaignDesc;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            campaignId = itemView.findViewById(R.id.campaignId);
            campaignTitle = itemView.findViewById(R.id.campaignTitle);
            campaignDesc = itemView.findViewById(R.id.campaignDesc);
        }
    }
}
