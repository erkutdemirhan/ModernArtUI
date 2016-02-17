package modernartui.erkutdemirhan.com.modernartui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * This class implements the dialog window that shows up from 
 * the options menu of the main screen
 * @author Erkut Demirhan
 */
public class InformationDialog extends Dialog implements
        android.view.View.OnClickListener {

    private static final String TAG = "InformationDialog";

    /** Link to the museum of modern art in New York */
    private static final String WEBSITE = "http://www.moma.org";

    private Activity mActivity;

    /** Button for opening browser and going into the website of the modern art museum in
     *  New York */
    private Button mGetInfoButton;

    /** Button for closing the dialog */
    private Button mNotGetInfoButton;

    public InformationDialog(Activity activity) {
        super(activity);
        mActivity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.information_dialog);
        Log.i(TAG, "Information dialog window was created");
        // initialize buttons
        mGetInfoButton = (Button) findViewById(R.id.get_information);
        mNotGetInfoButton = (Button) findViewById(R.id.not_get_information);
        // set onclick listeners to buttons
        mGetInfoButton.setOnClickListener(this);
        mNotGetInfoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // TODO Auto-generated method stub
        switch(view.getId()) {
            case R.id.get_information:
                Log.i(TAG, "Button was pressed to get more information");
                this.dismiss();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(WEBSITE));
                mActivity.startActivity(intent);
                break;
            case R.id.not_get_information:
                Log.i(TAG, "Button was pressed not to get more information");
                this.dismiss();
                break;
            default:
                break;
        }
    }

}
