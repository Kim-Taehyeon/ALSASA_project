package alsasa.team_project;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimerMainHost extends ActivityGroup {

    TabHost tabHost;
    ToggleButton btswitch;
    TextView goworktime;
    TextView gohometime;
    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("hh:mm a", Locale.KOREA);

    private String getTime() {
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_main_host);
        gohometime = findViewById(R.id.gohometime);
        goworktime = findViewById(R.id.goworktime);

        tabHost = findViewById(R.id.tabhost);
        tabHost.setup(getLocalActivityManager());

        tabHost.addTab(tabHost.newTabSpec("A").setContent(new Intent(this,TimerMain.class))
                .setIndicator("",getResources().getDrawable(R.drawable.bottombtaa)));
        tabHost.addTab(tabHost.newTabSpec("B").setContent(new Intent(this,TimerEdu.class))
                .setIndicator("",getResources().getDrawable(R.drawable.bottombtbb)));
        tabHost.addTab(tabHost.newTabSpec("C").setContent(new Intent(this,TimerChatList.class))
                .setIndicator("",getResources().getDrawable(R.drawable.bottombtcc)));
        tabHost.addTab(tabHost.newTabSpec("D").setContent(new Intent(this,TimerMoney.class))
                .setIndicator("",getResources().getDrawable(R.drawable.bottombtdd)));
        tabHost.addTab(tabHost.newTabSpec("E").setContent(new Intent(this,TimerInfo.class))
                .setIndicator("",getResources().getDrawable(R.drawable.bottombtee)));

        btswitch = findViewById(R.id.btswitch);




        btswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btswitch.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"출근하셨습니다.",Toast.LENGTH_LONG).show();
                    goworktime.setText(getTime());
                    goworktime.setVisibility(View.VISIBLE);
                    gohometime.setVisibility(View.INVISIBLE);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"퇴근하셨습니다.",Toast.LENGTH_LONG).show();
                    gohometime.setText(getTime());
                    gohometime.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
