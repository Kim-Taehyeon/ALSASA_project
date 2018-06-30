package alsasa.team_project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class Logo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        Handler Autopage = new Handler();
        Autopage.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),"앱을 시작합니다",Toast.LENGTH_LONG).show();
                Intent nextpage = new Intent(getApplicationContext(),FirstCome.class);
                startActivity(nextpage);
                finish();
            }
        }, 5000);
    }
}
