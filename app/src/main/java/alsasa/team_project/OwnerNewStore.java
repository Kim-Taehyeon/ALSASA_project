package alsasa.team_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OwnerNewStore extends AppCompatActivity {


    FirebaseDatabase database;
    DatabaseReference dataUserName;
    DatabaseReference dataStoreName;
    DatabaseReference dataStorePosition;
    DatabaseReference dataStorePassword;
    DatabaseReference dataNotice;
    Random rnd = new Random();
    int num = rnd.nextInt(100);
    String numS = String.valueOf(num);

    public final String PREFERENCE = "alsasa.team_project.sharepreference";

    ImageButton btchoosee;
    EditText editname;
    EditText editstorename;
    EditText editpass;
    EditText editposition;
    String ownerposition;

    Map<String, Object> map = new HashMap<String, Object>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_new_store);

        ownerposition = getIntent().getExtras().get("position").toString();
        btchoosee = findViewById(R.id.btchoosee);
        editname = findViewById(R.id.editname);
        editstorename = findViewById(R.id.editstorename);
        editpass = findViewById(R.id.editpass);
        editposition = findViewById(R.id.editposition);

        database = FirebaseDatabase.getInstance();
        dataStoreName = database.getReference("store 1").child("store name");
        dataStorePosition = database.getReference("store 1").child("store position");
        dataStorePassword = database.getReference("store 1").child("store password");
        dataUserName = database.getReference().getRoot().child("store 1").child("User ID");
        dataNotice = database.getReference().child("store 1").child("store notice");



        btchoosee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editname.getText().toString();
                String storename = editstorename.getText().toString();
                String password = editpass.getText().toString();
                String storeposition = editposition.getText().toString();

                if(username.equals("")|| storename.equals("")|| password.equals("")|| storeposition.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"아직 입력하지 않은 칸이 있다 어리석은 인간",Toast.LENGTH_LONG).show();
                }
                else
                {
                    String Key = dataUserName.child(username).getKey();
                    DatabaseReference dbRef = dataUserName.child(Key);
                    Map<String, Object> objectMap = new HashMap<String, Object>();
                    objectMap.put("name",username);
                    objectMap.put("position",ownerposition);
                    objectMap.put("workhour",numS);
                    dbRef.updateChildren(objectMap);

                    SharedPreferences userinfo = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = userinfo.edit();
                    editor.putString("user_name",username);
                    editor.putString("user_position",ownerposition);
                    editor.commit();

                    dataStoreName.setValue(storename);
                    dataStorePosition.setValue(storeposition);
                    dataStorePassword.setValue(password);
                    dataNotice.setValue("새로운 공지사항을 등록해주세요");
                    Intent NextPage = new Intent(getApplicationContext(),OwnerNewStore2.class);
                    startActivity(NextPage);
                    finish();
                }
            }
        });

    }

}