package modernartui.erkutdemirhan.com.modernartui;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/**
 * This class implements the main screen of the ModernArtUI app
 * @author Erkut Demirhan
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainScreen";

    /** color array that holds color values of linear layouts */
    private int[] mLayoutColors;

    // linear layout elements
    private LinearLayout mLayout1a;
    private LinearLayout mLayout1b;
    private LinearLayout mLayout2a;
    private LinearLayout mLayout2b;
    private LinearLayout mLayout2c;

    private SeekBar      mSeekBar;
    private Toolbar      mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Main screen activity was created");
        initVariables();

        mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            private int mProgress = 0;

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                int change = progress - mProgress;
                mProgress = progress;
                for(int i=0; i<mLayoutColors.length; i++) {
                    mLayoutColors[i] += change;
                }
                updateColors();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.more_info:
                Log.i(TAG, "More information tab was pressed");
                InformationDialog dialog = new InformationDialog(this);
                dialog.show();
                return true;
            default:
                return false;
        }
    }

    private void initVariables() {
        // initialize seekbar
        mSeekBar = (SeekBar) findViewById(R.id.seekbar);
        // initialize linear layout elements
        mLayout1a = (LinearLayout) findViewById(R.id.LinearLayout1a);
        mLayout1b = (LinearLayout) findViewById(R.id.LinearLayout1b);
        mLayout2a = (LinearLayout) findViewById(R.id.LinearLayout2a);
        mLayout2b = (LinearLayout) findViewById(R.id.LinearLayout2b);
        mLayout2c = (LinearLayout) findViewById(R.id.LinearLayout2c);
        // initialize linear layout colors
        mLayoutColors = new int[5];
        mLayoutColors[0] = ((ColorDrawable) mLayout1a.getBackground()).getColor();
        mLayoutColors[1] = ((ColorDrawable) mLayout1b.getBackground()).getColor();
        mLayoutColors[2] = ((ColorDrawable) mLayout2a.getBackground()).getColor();
        mLayoutColors[3] = ((ColorDrawable) mLayout2b.getBackground()).getColor();
        mLayoutColors[4] = ((ColorDrawable) mLayout2c.getBackground()).getColor();

        mToolBar = (Toolbar) findViewById(R.id.main_toolbar);
        if(mToolBar != null) {
            mToolBar.setTitle(getString(R.string.app_name));
            setSupportActionBar(mToolBar);
        }
    }

    private void updateColors() {
        mLayout1a.setBackgroundColor(mLayoutColors[0]);
        mLayout1b.setBackgroundColor(mLayoutColors[1]);
        mLayout2a.setBackgroundColor(mLayoutColors[2]);
        mLayout2b.setBackgroundColor(mLayoutColors[3]);
        mLayout2c.setBackgroundColor(mLayoutColors[4]);
    }
}