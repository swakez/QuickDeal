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

public class ChatActivity extends AppCompatActivity{

    private ArrayList<ChatDetails> chatDetails;

    private static RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_layout);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Chats");
      //  actionBar.//setCustomView();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_keyboard_arrow_left_white_36dp);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.default_recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        // Fill place holder text in Arraylist declared above
        inflatePlaceHolderData();

        // initialising new chat adapter
        adapter = new ChatAdapter(chatDetails);

        // setting recyclerview with chat adapter
        recyclerView.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.chat_menu, menu);
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
        chatDetails = new ArrayList<ChatDetails>();
        chatDetails.add (new ChatDetails("Global Electronics",
                "Fine sir we will deliver sample on your registered address",
                1,
                false,
                "2 min ago"));
        chatDetails.add (new ChatDetails("Patel Electronics",
                "Yes sir! We have product available in stock",
                3,
                false,
                "5 min ago"));
        chatDetails.add (new ChatDetails("Bombay Electronics",
                "Thank you sir!",
                0,
                true,
                "10 min ago"));
        chatDetails.add (new ChatDetails("Opera Electronics",
                "No problem sir. Will update you soon.",
                0,
                false,
                "30 min ago"));
        chatDetails.add (new ChatDetails("Hari Om Electronics",
                "Sorry sir. But you can check with other vendors as well",
                0,
                true,
                "2 days ago"));
        chatDetails.add (new ChatDetails("Krishna Light Electronics",
                "Your requirement has been received sir.",
                0,
                false,
                "3 days ago"));
        chatDetails.add (new ChatDetails("Gada Electronics",
                "Happy to serve you sir",
                0,
                false,
                "2 days ago"));
    }
}
