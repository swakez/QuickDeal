package example.com.quickdeal;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by swati on 20/04/2017.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private ArrayList<ChatDetails> dataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewShop;
        public TextView mTextViewNumOfMsg;
        public TextView mTextViewLasMsg;
        public TextView mTextViewTime;
        public ImageView mImageViewDeal;

        private Context mContext;

        public ViewHolder(Context context, View itemView) {
            super(itemView);
            mContext = context;

            mTextViewShop = (TextView) itemView.findViewById(R.id.text_view_shop_name);
            mTextViewLasMsg = (TextView) itemView.findViewById(R.id.text_view_last_msg);
            mTextViewNumOfMsg = (TextView) itemView.findViewById(R.id.text_view_num_of_unread_msg);
            mTextViewTime = (TextView) itemView.findViewById(R.id.text_view_time);
            mImageViewDeal = (ImageView) itemView.findViewById(R.id.image_deal);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ChatAdapter(ArrayList<ChatDetails> data) {
        this.dataSet = data;
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(parent.getContext(), view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position) {
        TextView textViewShop = holder.mTextViewShop;
        TextView textViewNumOfMsg = holder.mTextViewNumOfMsg;
        TextView textViewLasMsg = holder.mTextViewLasMsg;
        TextView textViewTime = holder.mTextViewTime;
        ImageView imageViewDeal = holder.mImageViewDeal;

        textViewShop.setText(dataSet.get(position).getShopName());
        textViewLasMsg.setText(dataSet.get(position).getLastMessage());

        int numOfMsg = dataSet.get(position).getNoOfUnreadMessage();

        if (numOfMsg > 0) {
            textViewNumOfMsg.setText("" + numOfMsg);
            textViewShop.setTextColor(ContextCompat.getColor(holder.mContext, R.color.colorYellow));
        } else {
            textViewNumOfMsg.setVisibility(View.GONE);
            textViewShop.setTextColor(ContextCompat.getColor(holder.mContext, R.color.colorTextBlue));
        }

        if (dataSet.get(position).isDealConfirm()) {
            imageViewDeal.setColorFilter(ContextCompat.getColor(holder.mContext, R.color.colorYellow));
        }
        textViewTime.setText(dataSet.get(position).getTime());

        boolean deal = dataSet.get(position).isDealConfirm();

//        if (deal)
        //          imageViewDeal.setTint

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


}
