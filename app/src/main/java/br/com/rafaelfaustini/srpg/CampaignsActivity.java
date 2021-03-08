package br.com.rafaelfaustini.srpg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
        onAdd();
    }


    private List<Campaign> retrieveCampaigns(){
        CampaignService service = new CampaignService(getApplicationContext());
        return service.getAll();
    }

    private void onAdd(){
        FloatingActionButton addCampaign = findViewById(R.id.btnCreateCampaign);
        addCampaign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(CampaignsActivity.this, ManageCampaignActivity.class);
                startActivity(intent);
            }
        });
    }

}