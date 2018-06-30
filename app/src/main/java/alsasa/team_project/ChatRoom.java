package alsasa.team_project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChatRoom extends AppCompatActivity {

    //ArrayAdapter<String> MyArray;

    public final String PREFERENCE = "alsasa.team_project.sharepreference";
    int x = 0;

    Button SEND;
    EditText EDIT;
    ListView CHAT;
    TextView who;

    String user_name;
    String room_name;
    String chat_user;
    String chat_message;
    String myposition;
    String position;

    DatabaseReference reference;
    private MyAdapter2 adapter = new MyAdapter2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        SharedPreferences userinfo = getSharedPreferences(PREFERENCE,MODE_PRIVATE);

        SEND = findViewById(R.id.SEND);
        EDIT = findViewById(R.id.edit_msg);
        CHAT = findViewById(R.id.Chat_View);
        user_name = userinfo.getString("user_name",toString());
        myposition = userinfo.getString("user_position",toString());
        room_name = getIntent().getExtras().get("room_name").toString();
        who = findViewById(R.id.who);
        who.setText(room_name);


        reference = FirebaseDatabase.getInstance().getReference().child("store 1").child("ChatList").child(room_name);

        //MyArray = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        CHAT.setAdapter(adapter);
        CHAT.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);

        SEND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Map<String, Object> map = new HashMap<String, Object>();
                String Key = reference.push().getKey();
                DatabaseReference dbRef = reference.child(Key);
                Map<String, Object> objectMap = new HashMap<String, Object>();
                objectMap.put("name",user_name);
                objectMap.put("chat",EDIT.getText().toString());
                objectMap.put("position",myposition);
                dbRef.updateChildren(objectMap);
                EDIT.setText("");
            }
        });

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                chatListener(dataSnapshot);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    void chatListener(DataSnapshot dataSnapshot)
    {
        Iterator i = dataSnapshot.getChildren().iterator();
        while(i.hasNext()){
            chat_message = (String)((DataSnapshot) i.next()).getValue();
            chat_user = (String)((DataSnapshot) i.next()).getValue();
            position = (String)((DataSnapshot) i.next()).getValue();
            if(x==0) {
                if (position.equals("사장")) {
                    SingerItem2 item = new SingerItem2(chat_user, position, chat_message, R.drawable.iconsajang, R.drawable.ownerchata);
                    adapter.addItem(item);
                } else if (position.equals("매니저")) {
                    SingerItem2 item = new SingerItem2(chat_user, position, chat_message, R.drawable.iconmanager, R.drawable.ownerchata);
                    adapter.addItem(item);
                } else if (position.equals("아르바이트")) {
                    SingerItem2 item = new SingerItem2(chat_user, position, chat_message, R.drawable.icontimer, R.drawable.timerchata);
                    adapter.addItem(item);
                }
                x=1;
            }
            else
            {
                if (position.equals("사장")) {
                    SingerItem2 item = new SingerItem2(chat_user, position, chat_message, R.drawable.iconsajang, R.drawable.ownerchatb);
                    adapter.addItem(item);
                } else if (position.equals("매니저")) {
                    SingerItem2 item = new SingerItem2(chat_user, position, chat_message, R.drawable.iconmanager, R.drawable.ownerchatb);
                    adapter.addItem(item);
                } else if (position.equals("아르바이트")) {
                    SingerItem2 item = new SingerItem2(chat_user, position, chat_message, R.drawable.icontimer, R.drawable.timerchatb);
                    adapter.addItem(item);
                }
                x=0;
            }
        }
        adapter.notifyDataSetChanged();
    }
}
