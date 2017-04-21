package example.com.quickdeal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by swati on 20/04/2017.
 */

public class LeadAdapter extends RecyclerView.Adapter<LeadAdapter.ViewHolder> {

    private ArrayList<LeadDetails> dataSet;

    public LeadAdapter(ArrayList<LeadDetails> data) {
        this.dataSet = data;
    }

    @Override
    public LeadAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_leads, parent, false);
        ViewHolder viewHolder = new ViewHolder(parent.getContext(), view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final LeadAdapter.ViewHolder holder, final int position) {

        TextView textViewLead = holder.textViewLead;
        TextView textViewTitle = holder.textViewTitle;
        TextView textViewTime = holder.textViewTime;

        // Setting values to respective textviews
        textViewLead.setText(dataSet.get(position).getmLeadName());
        textViewTitle.setText(dataSet.get(position).getmTitle());
        textViewTime.setText(dataSet.get(position).getmTime());

        if(dataSet.get(position).ismDealConfirm()){
            textViewLead.setTextColor(ContextCompat.getColor(holder.mContext, R.color.colorLeadNameYellow));
        }
        else textViewLead.setTextColor(ContextCompat.getColor(holder.mContext, R.color.colorLeadNameBlueGray));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("LeadActivity", "" +position);
                Bundle bundle = new Bundle();
            //    Log.e("LeadAdapter", dataSet.get(position).getmTitle());
                // TODO Set keys in a seperate java file

                bundle.putString("Key_lead_name",dataSet.get(position).getmLeadName());
                bundle.putString("Key_post_time",dataSet.get(position).getmTime());
                bundle.putString("Key_title",dataSet.get(position).getmTitle());
                bundle.putString("Key_description",dataSet.get(position).getmDescription());
                bundle.putString("Key_file_name",dataSet.get(position).getmFileName());

                Intent intent = new Intent(holder.mContext,RequirementDetailActivity.class);
                intent.putExtras(bundle);
                holder.mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewLead;
        public TextView textViewTitle;
        public TextView textViewTime;

        private Context mContext;

        public ViewHolder(Context context, View itemView) {

            super(itemView);

            mContext = context;

            textViewLead = (TextView) itemView.findViewById(R.id.text_view_lead_name);
            textViewTitle = (TextView) itemView.findViewById(R.id.text_view_title);
            textViewTime = (TextView) itemView.findViewById(R.id.text_view_post_time);

        }

    }
}
