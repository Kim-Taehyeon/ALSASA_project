package alsasa.team_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FirstCome extends AppCompatActivity {

    ToggleButton Owner;
    ToggleButton Timer;
    ImageButton Choose;
    ImageView Anywhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_come);

        Owner = findViewById(R.id.Owner);
        Timer = findViewById(R.id.Timer);
        Choose = findViewById(R.id.Choose);
        Anywhere = findViewById(R.id.firstbg);

        Anywhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Timer.isChecked())
                {
                    Timer.setChecked(false);
                    Choose.setVisibility(View.INVISIBLE);
                }
                if(Owner.isChecked())
                {
                    Owner.setChecked(false);
                    Choose.setVisibility(View.INVISIBLE);
                }
                else
                {
                }
            }
        });

        Owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(Timer.isChecked())
                {
                    Timer.setChecked(false);
                }

                if(Owner.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"매장관리자를 선택하셨어요.",Toast.LENGTH_LONG).show();
                    Choose.setVisibility(View.VISIBLE);
                }
                else {
                    Choose.setVisibility(View.INVISIBLE);
                }
            }
        });

        Timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(Owner.isChecked())
                {
                    Owner.setChecked(false);
                }
                if(Timer.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"아르바이트를 선택하셨어요",Toast.LENGTH_LONG).show();
                    Choose.setVisibility(View.VISIBLE);
                }
                else{
                    Choose.setVisibility(View.INVISIBLE);
                }
            }
        });

        Choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Owner.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"Owner",Toast.LENGTH_LONG).show();
                    Intent Nextpage = new Intent(getApplicationContext(),OwnerPosition.class);
                    startActivity(Nextpage);
                }
                else if(Timer.isChecked())
                {

                    Toast.makeText(getApplicationContext(),"Timer",Toast.LENGTH_LONG).show();
                    Intent Nextpage = new Intent(getApplicationContext(),TimerChooseStore.class);
                    startActivity(Nextpage);
                }
                else{
                }
            }
        });

    }
}
