package alsasa.team_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class ChatList extends AppCompatActivity implements View.OnClickListener {
    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("hh:mm a", Locale.KOREA);

    ToggleButton ToggleTest;
    TextView mTextView;     //출근
    TextView mmTextView;    //퇴근

    //Button mRefreshBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        //bind view
        mTextView = (TextView) findViewById(R.id.textView);
        mmTextView = (TextView) findViewById(R.id.textViewTwo);

        //mRefreshBtn = (Button) findViewById(R.id.refreshBtn);
        ToggleTest = (ToggleButton) findViewById(R.id.ToggleTest);

        //bind listener
        //mRefreshBtn.setOnClickListener(this);
        ToggleTest.setOnClickListener(this);
    }

    private String getTime() {
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    @Override
    public void onClick(View v) {           //토글 한 번 누르면

        if (ToggleTest.isChecked()) {
            switch (v.getId()) {
                case R.id.ToggleTest:
                    mTextView.setText(getTime());
                    break;
                default:
                    break;
            }
        } else {
            switch (v.getId()) {
                case R.id.ToggleTest:
                    mmTextView.setText(getTime());
                    break;
                default:
                    break;
            }
        }
    }
}