package example.com.quickdeal;

/**
 * Created by swati on 19/04/2017.
 */

public class ChatDetails {

    private String mShopName;
    private String mLastMessage;
    private int mNoOfUnreadMessage;
    private boolean mDealConfirm;
    private String mTime;

    public ChatDetails(String shopName,
                       String lastMessage,
                       int numOfMessages,
                       boolean dealConfirm,
                       String time){
                      // int textColor){
        mShopName = shopName;
        mLastMessage = lastMessage;
        mNoOfUnreadMessage = numOfMessages;
        mDealConfirm = dealConfirm;
        mTime = time;
        //mColorResourceId = textColor;
    }

    public String getShopName(){
        return mShopName;
    }

    public String getLastMessage(){
        return mLastMessage;
    }

    public int getNoOfUnreadMessage(){
        return mNoOfUnreadMessage;
    }

    public String getTime (){
        return mTime;
    }

    public boolean isDealConfirm(){
        return mDealConfirm;
    }

}
