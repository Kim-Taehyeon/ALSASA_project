package alsasa.team_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class OwnerEdu extends AppCompatActivity {

    ImageButton coffee;
    ImageButton drink;
    ImageButton open;
    ImageView edubg;
    Custom3 cd3;
    Custom4 cd4;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_edu);

        edubg = findViewById(R.id.timeredubg);
        coffee = findViewById(R.id.coffeemachine);
        drink = findViewById(R.id.drink);
        open = findViewById(R.id.open);

        cd3 = new Custom3(this);
        cd4 = new Custom4(this);

        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edubg.setImageResource(R.drawable.owneredua);
                i=1;
            }
        });
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edubg.setImageResource(R.drawable.owneredub);
                i=0;
            }
        });

        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0)
                {
                    cd3.show();
                }
                else if(i==1)
                {
                    cd4.show();
                }
            }
        });
    }
}