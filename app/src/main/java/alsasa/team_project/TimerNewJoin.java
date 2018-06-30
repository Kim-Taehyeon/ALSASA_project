package alsasa.team_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TimerNewJoin extends AppCompatActivity {


    FirebaseDatabase database;
    DatabaseReference dataUserName;

    Random rnd = new Random();
    int num = rnd.nextInt(100);
    String numS = String.valueOf(num);

    public final String PREFERENCE = "alsasa.team_project.sharepreference";

    ImageButton NewMember;
    EditText NewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_new_join);

        NewMember = findViewById(R.id.newjoin);
        NewName = findViewById(R.id.newname);
        database = FirebaseDatabase.getInstance();
        dataUserName = database.getReference().getRoot().child("store 1").child("User ID");

        NewMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = NewName.getText().toString();

                String Key = dataUserName.child(username).getKey();
                DatabaseReference dbRef = dataUserName.child(Key);
                Map<String, Object> objectMap = new HashMap<String, Object>();
                objectMap.put("name",username);
                objectMap.put("position","아르바이트");
                objectMap.put("workhour",numS);
                dbRef.updateChildren(objectMap);

                SharedPreferences userinfo = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = userinfo.edit();
                editor.putString("user_name",username);
                editor.putString("user_position","아르바이트");
                editor.commit();

                Intent NextPage = new Intent(getApplicationContext(),TimerMainHost.class);
                startActivity(NextPage);
                finish();
            }
        });

    }
}
