package example.com.quickdeal;

/**
 * Created by swati on 20/04/2017.
 */

public class LeadDetails {

    // Name of lead to display in Leads
    private String mLeadName;

    // Title of message by lead to display in Leads
    private String mTitle;

    // Desciption of message to be displayed in detailed chat with lead
    private String mDescription;

    // Name of attached file
    private String mFileName ;

    // Size of attached file


    // Confirmation of deal to change the text color of leadname
    private boolean mDealConfirm;

    // Time to display
    private String mTime;

    public LeadDetails(String leadName,
                       String title,
                       String disciption,
                       String fileName,
                       boolean dealConfirm,
                       String time) {
        mLeadName = leadName;
        mTitle = title;
        mDescription = disciption;
        mFileName = fileName;
        mDealConfirm = dealConfirm;
        mTime = time;
    }

    public String getmLeadName() {
        return mLeadName;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmFileName() {
        return mFileName;
    }

    public boolean ismDealConfirm() {
        return mDealConfirm;
    }

    public String getmTime() {
        return mTime;
    }

}
