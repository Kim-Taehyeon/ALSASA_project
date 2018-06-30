package alsasa.team_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class OwnerPosition extends AppCompatActivity {

    ImageButton Sajang;
    ImageButton Jumjang;
    ImageButton Manager;
    ImageView Chooseview;
    ImageButton pchoose;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_position);

        Sajang = findViewById(R.id.Sajang);
        Jumjang = findViewById(R.id.Jumjang);
        Manager = findViewById(R.id.Manager);
        Chooseview = findViewById(R.id.chooseview);
        pchoose = findViewById(R.id.btchoose);

        Sajang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chooseview.setImageResource(R.drawable.choosesajang);
                pchoose.setVisibility(View.VISIBLE);
                i = 0;
            }
        });
        Jumjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chooseview.setImageResource(R.drawable.choosejumjang);
                pchoose.setVisibility(View.VISIBLE);
                i = 1;
            }
        });
        Manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chooseview.setImageResource(R.drawable.choosemanager);
                pchoose.setVisibility(View.VISIBLE);
                i = 2;
            }
        });

        pchoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Nextpage = new Intent(getApplicationContext(),OwnerChooseStore.class);
                if(i==0)
                {
                    Nextpage.putExtra("position","사장");
                }
                else if(i==1)
                {
                    Nextpage.putExtra("position","매니저");
                }
                else if(i==2)
                {
                    Nextpage.putExtra("position","매니저");
                }
                startActivity(Nextpage);
            }
        });

    }
}
