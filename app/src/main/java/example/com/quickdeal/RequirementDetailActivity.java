package example.com.quickdeal;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by swati on 20/04/2017.
 */

public class RequirementDetailActivity extends AppCompatActivity {

    private int mProgressStatus = 0;
    private ProgressDialog mProgressDialog;
    private ProgressBarAsync mProgressbarAsync;

    String time;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_layout);
        Log.e("RequirementDetails", "log");

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);

       // CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
       // collapsingToolbarLayout.setTitle("");
        Bundle bundle = this.getIntent().getExtras();

        if (bundle != null) {
            setSupportActionBar(toolbar);

            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("");
            actionBar.setDisplayHomeAsUpEnabled(true);
           // actionBar.setElevation((float) 0.0);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_keyboard_arrow_left_white_36dp);


            time = bundle.getString("Key_post_time");

            TextView textViewPostTime = (TextView)findViewById(R.id.Key_post_time1);
            textViewPostTime.setText(time);

            TextView textViewLeadName = (TextView) findViewById(R.id.text_view_lead_name1);
            textViewLeadName.setText(bundle.getString("Key_lead_name"));

            TextView textViewTitle = (TextView) findViewById(R.id.text_view_title_chatlayout);
            textViewTitle.setText(bundle.getString("Key_title"));

            TextView textViewDesciption = (TextView) findViewById(R.id.text_view_description);
            textViewDesciption.setText(bundle.getString("Key_description"));

            TextView textViewFileName = (TextView) findViewById(R.id.text_view_file_name);

            String fileName = bundle.getString("Key_file_name");
            // Checking if there is any attachment or not
            if (fileName != null) {
                textViewFileName.setText(fileName);
                ImageView imageViewDownload = (ImageView) findViewById(R.id.image_download);

                mProgressDialog = new ProgressDialog(this);

                // Creating a progress dialog window
                mProgressDialog = new ProgressDialog(this);

                // Close the dialog window on pressing back button
                mProgressDialog.setCancelable(true);

                // Setting a horizontal style progress bar
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

                /** Setting a message for this progress dialog
                 * Use the method setTitle(), for setting a title
                 * for the dialog window
                 *  */

                mProgressDialog.setMessage("Downloading" + '\n' + bundle.getString("Key_file_name"));

                imageViewDownload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Show the progress dialog window
                        mProgressDialog.show();

                        // Creating an instance of ProgressBarAsync
                        mProgressbarAsync = new ProgressBarAsync();

                        // ProgressBar starts its execution
                        mProgressbarAsync.execute();
                    }
                });
            }
            // If file attachment is not there then remove the visibility of attachment
            else {
                TextView textViewAttachmentHeading = (TextView) findViewById(R.id.text_view_attachment_heading);
                textViewAttachmentHeading.setVisibility(View.GONE);
                LinearLayout linearLayoutAttachment = (LinearLayout) findViewById(R.id.linear_layout_attachment);
                linearLayoutAttachment.setVisibility(View.GONE);
            }
        }
    }

    private class ProgressBarAsync extends AsyncTask<Void, Integer, Void> {
        /**
         * This callback method is invoked, before starting the background process
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressStatus = 0;
        }

        /**
         * This callback method is invoked on calling execute() method
         * on an instance of this class
         */
        @Override
        protected Void doInBackground(Void... params) {
            while (mProgressStatus < 100) {
                try {

                    mProgressStatus++;

                    /** Invokes the callback method onProgressUpdate */
                    publishProgress(mProgressStatus);

                    /** Sleeps this thread for 100ms */
                    Thread.sleep(100);

                } catch (Exception e) {
                    Log.d("Exception", e.toString());
                }
            }
            return null;
        }

        /**
         * This callback method is invoked when publishProgress()
         * method is called
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            mProgressDialog.setProgress(mProgressStatus);
        }

        /**
         * This callback method is invoked when the background function
         * doInBackground() is executed completely
         */
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            mProgressDialog.dismiss();
        }
    }
}
