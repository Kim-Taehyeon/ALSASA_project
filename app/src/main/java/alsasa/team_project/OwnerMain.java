package alsasa.team_project;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OwnerMain extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference dataStoreName;
    DatabaseReference dataStorePosition;
    DatabaseReference dataNotice;

    TextView ViewStoreName;
    TextView ViewStorePosition;
    TextView ViewStoreNotice;
    ImageButton EDITNOTICE;
    String notice;
    //Map<String, Object> map = new HashMap<String, Object>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_main);

        database = FirebaseDatabase.getInstance();
        dataStoreName = database.getReference("store 1").child("store name");
        dataStorePosition = database.getReference("store 1").child("store position");
        dataNotice = database.getReference().child("store 1").child("store notice");


        ViewStoreName = findViewById(R.id.ViewStoreName);
        ViewStorePosition = findViewById(R.id.ViewStorePosition);
        ViewStoreNotice = findViewById(R.id.ViewNotice);
        EDITNOTICE = findViewById(R.id.etnotice);



        EDITNOTICE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText et_inDialog = new EditText(OwnerMain.this);
                final AlertDialog.Builder builder = new AlertDialog.Builder(OwnerMain.this);
                builder.setTitle("공지사항을 적어주세요.");
                builder.setView(et_inDialog);
                builder.setPositiveButton("공지하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        notice = et_inDialog.getText().toString();
                        dataNotice.setValue(notice);
                    }
                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

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

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
