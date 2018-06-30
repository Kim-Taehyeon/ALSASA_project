package alsasa.team_project;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TimerMain extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference dataStoreName;
    DatabaseReference dataStorePosition;
    DatabaseReference dataNotice;

    TextView ViewStoreName;
    TextView ViewStorePosition;
    TextView ViewStoreNotice;
    String notice;
    //Map<String, Object> map = new HashMap<String, Object>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_main);

        database = FirebaseDatabase.getInstance();
        dataStoreName = database.getReference("store 1").child("store name");
        dataStorePosition = database.getReference("store 1").child("store position");
        dataNotice = database.getReference().child("store 1").child("store notice");


        ViewStoreName = findViewById(R.id.ViewStoreName);
        ViewStorePosition = findViewById(R.id.ViewStorePosition);
        ViewStoreNotice = findViewById(R.id.ViewNotice);


        dataStoreName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String netname = dataSnapshot.getValue(String.class);
                ViewStoreName.setText(netname);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        dataStorePosition.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String netname = dataSnapshot.getValue(String.class);
                ViewStorePosition.setText(netname);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        dataNotice.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String netname = dataSnapshot.getValue(String.class);
                ViewStoreNotice.setText(netname);
                final TextView alert = new TextView(TimerMain.this);
                final AlertDialog.Builder builder = new AlertDialog.Builder(TimerMain.this);
                builder.setTitle("새로운 공지사항을 확인하세요!");
                builder.setView(alert);
                alert.setText("\n"+netname);
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}