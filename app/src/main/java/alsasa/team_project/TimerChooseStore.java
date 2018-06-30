package alsasa.team_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ToggleButton;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TimerChooseStore extends AppCompatActivity {

    ToggleButton newstorebt1;
    ToggleButton newstorebt2;
    ToggleButton newstorebt3;
    ToggleButton newstorebt4;
    String a;

    FirebaseDatabase database;
    DatabaseReference dataStoreName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_choose_store);

        newstorebt1 = findViewById(R.id.newstorebt1);
        newstorebt2 = findViewById(R.id.newstorebt2);
        newstorebt3 = findViewById(R.id.newstorebt3);
        newstorebt4 = findViewById(R.id.newstorebt4);

        database = FirebaseDatabase.getInstance();
        dataStoreName = database.getReference("store 1");

        dataStoreName.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                newstorebt1.setButtonDrawable(R.drawable.storeicon);
                newstorebt1.setChecked(true);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                newstorebt1.setButtonDrawable(R.drawable.newstorebt);
                newstorebt1.setChecked(false);
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        newstorebt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newstorebt1.isChecked()) {
                    Intent NextPage = new Intent(getApplicationContext(), TimerNewJoin.class);
                    startActivity(NextPage);
                    newstorebt1.setChecked(false);
                } else {
                    Intent NextPage = new Intent(getApplicationContext(), TimerNewJoin.class);
                    startActivity(NextPage);
                    newstorebt1.setChecked(true);
                } }
        });
        newstorebt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newstorebt2.isChecked())
                {
                    Intent NextPage = new Intent(getApplicationContext(),OwnerNewStore.class);
                    startActivity(NextPage);
                    newstorebt2.setChecked(false);
                }
                else
                {
                    Intent NextPage = new Intent(getApplicationContext(), OwnerMain.class);
                    startActivity(NextPage);
                    newstorebt2.setChecked(true);
                }
            }
        });
        newstorebt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newstorebt3.isChecked())
                {
                    Intent NextPage = new Intent(getApplicationContext(),OwnerNewStore.class);
                    startActivity(NextPage);
                    newstorebt3.setChecked(false);
                }
                else
                {
                    Intent NextPage = new Intent(getApplicationContext(), OwnerMain.class);
                    startActivity(NextPage);
                    newstorebt3.setChecked(true);
                }
            }
        });
        newstorebt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newstorebt4.isChecked())
                {
                    Intent NextPage = new Intent(getApplicationContext(),OwnerNewStore.class);
                    startActivity(NextPage);
                    newstorebt4.setChecked(false);
                }
                else
                {
                    Intent NextPage = new Intent(getApplicationContext(), OwnerMain.class);
                    startActivity(NextPage);
                    newstorebt4.setChecked(true);
                }
            }
        });

    }
}
