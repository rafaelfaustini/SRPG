package br.com.rafaelfaustini.srpg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.com.rafaelfaustini.srpg.entity.Campaign;
import br.com.rafaelfaustini.srpg.service.CampaignService;
import br.com.rafaelfaustini.srpg.util.LoggingUtil;

public class ManageCampaignActivity extends AppCompatActivity {
    private EditText name;
    private EditText story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_campaign);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        name = findViewById(R.id.editCampaignName);
        story = findViewById(R.id.editCampaignStory);
        createCampaign();
    }
    private void createCampaign(){
        Button createCampaign = (Button) findViewById(R.id.btnCreateCampaign);
        createCampaign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Campaign campaign = new Campaign(name.getText().toString(), story.getText().toString());
                CampaignService service = new CampaignService(ManageCampaignActivity.this);
                service.insert(campaign);
                Toast.makeText(ManageCampaignActivity.this, getString(R.string.createSuccess), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ManageCampaignActivity.this, CampaignsActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), CampaignsActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}