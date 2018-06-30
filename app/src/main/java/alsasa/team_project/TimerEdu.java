package alsasa.team_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class TimerEdu extends AppCompatActivity {

    ImageButton coffee;
    ImageButton drink;
    ImageButton open;
    ImageView edubg;
    Custom cd;
    Custom2 cd2;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_edu);

        edubg = findViewById(R.id.timeredubg);
        coffee = findViewById(R.id.coffeemachine);
        drink = findViewById(R.id.drink);
        open = findViewById(R.id.open);

        cd = new Custom(this);
        cd2 = new Custom2(this);

        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edubg.setImageResource(R.drawable.timeredua);
                i=1;
            }
        });
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edubg.setImageResource(R.drawable.timeredub);
                i=0;
            }
        });

        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0)
                {
                    cd.show();
                }
                else if(i==1)
                {
                    cd2.show();
                }
            }
        });
    }
}
