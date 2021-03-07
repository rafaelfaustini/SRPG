package br.com.rafaelfaustini.srpg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import br.com.rafaelfaustini.srpg.adapters.CampaignRecyclerAdapter;
import br.com.rafaelfaustini.srpg.entity.Campaign;
import br.com.rafaelfaustini.srpg.service.CampaignService;

public class CampaignsActivity extends AppCompatActivity {
    private List<Campaign> campaigns;
    private CampaignRecyclerAdapter adapter;
    private RecyclerView campaignList;

    public List<Campaign> getCampaigns() {
        return campaigns;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign);
        campaigns = retrieveCampaigns();
        campaignList = findViewById(R.id.campaignList);
        adapter = new CampaignRecyclerAdapter(CampaignsActivity.this, campaigns);
        campaignList.setAdapter(adapter);
        campaignList.setLayoutManager(new LinearLayoutManager(CampaignsActivity.this));

    }

    private List<Campaign> retrieveCampaigns(){
        CampaignService service = new CampaignService(getApplicationContext());
        return service.getAll();
    }

}