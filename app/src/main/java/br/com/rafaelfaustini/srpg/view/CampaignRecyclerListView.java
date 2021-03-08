package br.com.rafaelfaustini.srpg.view;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import br.com.rafaelfaustini.srpg.CampaignsActivity;
import br.com.rafaelfaustini.srpg.R;
import br.com.rafaelfaustini.srpg.adapters.CampaignRecyclerAdapter;
import br.com.rafaelfaustini.srpg.entity.Campaign;
import br.com.rafaelfaustini.srpg.service.CampaignService;

public class CampaignRecyclerListView {
    private RecyclerView list;
    private List<Campaign> campaigns;
    private Context context;
    private CampaignRecyclerAdapter adapter;

    public RecyclerView getList() {
        return list;
    }

    public CampaignRecyclerListView(Context context, RecyclerView list) {
        this.context = context;
        this.list = list;
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(list);
    }

    public void bindContent(List<Campaign> itemsList){
        this.campaigns = itemsList;
        adapter = new CampaignRecyclerAdapter(context, campaigns);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(context));
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            int position = viewHolder.getAdapterPosition();


            switch (direction){
                case ItemTouchHelper.LEFT:
                case ItemTouchHelper.RIGHT:
                    Campaign deletedCampaign = campaigns.get(position);
                    campaigns.remove(position);
                    adapter.notifyItemRemoved(position);
                    Snackbar snack = Snackbar.make(list, deletedCampaign.getName(), Snackbar.LENGTH_LONG)
                            .setAction(context.getString(R.string.undoSnackbar), new View.OnClickListener(){
                               @Override
                               public void onClick(View view){
                                   campaigns.add(position, deletedCampaign);
                                   adapter.notifyItemInserted(position);
                               }
                            });
                    snack.addCallback(new Snackbar.Callback() {
                        @Override
                        public void onDismissed(Snackbar snackbar, int event) {
                            if(event != 1){
                                CampaignService service = new CampaignService(context);
                                service.delete(deletedCampaign.getId());
                            }
                        }
                    });
                    snack.show();
                    break;
            }
        }

    };


}
