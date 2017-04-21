package example.com.quickdeal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

/**
 * Created by swati on 20/04/2017.
 */

public class LeadActivity extends AppCompatActivity {

    private ArrayList<LeadDetails> leadDetails;
    private static RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_layout);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Leads");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_keyboard_arrow_left_white_36dp);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.default_recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        // Fill place holder text in Arraylist declared above
        inflatePlaceHolderData();

        // initialising new lead adapter
        adapter = new LeadAdapter(leadDetails);

        // setting recyclerview with lead adapter
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.lead_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    private void inflatePlaceHolderData(){
        leadDetails = new ArrayList<LeadDetails>();
        leadDetails.add (new LeadDetails("Rakesh Patel",
                "Need 1000 pcs of Electric fans",
                "Need Unique and loyal fan from Usha. Made out of stainless steel with white glossy finishing. Contact with quote.",
                "Screenshot999.jpg",
                true,
                "Posted 30 min ago"));
        leadDetails.add (new LeadDetails("Joseph Smith",
                "500 LED Television for New Showroom",
                "Need Unique LED TV from Sony with latest technology,great look. Contact with quote.",
                null,
                true,
                "Posted 45 min ago"));
        leadDetails.add (new LeadDetails("Shailee shah",
                "500 LED Television for New Hotel",
                "Need Unique LED TV from LG with latest technology,great look. Contact with quote.",
                "Screenshot1.jpg",
                false,
                "Posted 1 hr ago"));
        leadDetails.add (new LeadDetails("Vaibhav Gupta",
                "Requirement of 300 mobile phones",
                "Need android mobile phones with great configuration. Contact with quote.",
                "Screenshot1.jpg",
                false,
                "Posted 1 day ago"));
        leadDetails.add (new LeadDetails("harry d'souza",
                "Need 1000 ACs for New Hotel",
                "Need Unique LED TV from LG with latest technology,great look. Contact with quote.",
                "Details.pdf",
                false,
                "Posted 2 days ago"));
    }
}
