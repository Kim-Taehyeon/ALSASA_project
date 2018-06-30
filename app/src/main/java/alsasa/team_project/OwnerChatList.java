package alsasa.team_project;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OwnerChatList extends AppCompatActivity {

    private ListView ChatList;
    private ImageButton NewChatRoom;
    private ListView UserList;
    ImageButton Allchat;


    private String name;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> arr_roomList = new ArrayList<>();
    private MyAdapter adapter = new MyAdapter(this);
    DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference().child("store 1").child("User ID");
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference().getRoot().child("store 1").child("ChatList");
    private String position;
    private String str_room;

    Map<String, Object> map = new HashMap<String, Object>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_chat_list);

        UserList = findViewById(R.id.AllList);
        ChatList = findViewById(R.id.ChatList);
        Allchat = findViewById(R.id.allchat);
        NewChatRoom = findViewById(R.id.NewChatRoom);

        UserList.setAdapter(adapter);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr_roomList);
        ChatList.setAdapter(arrayAdapter);



        NewChatRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText et_inDialog = new EditText(OwnerChatList.this);
                final AlertDialog.Builder builder = new AlertDialog.Builder(OwnerChatList.this);
                builder.setTitle("채팅방 이름 입력");
                builder.setView(et_inDialog);
                builder.setPositiveButton("만들기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        str_room = et_inDialog.getText().toString();
                        map.put(str_room,"");
                        reference.updateChildren(map);
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
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Set<String> set = new HashSet<String>();
                Iterator i = dataSnapshot.getChildren().iterator();
                while(i.hasNext()){
                    set.add(((DataSnapshot)i.next()).getKey());
                }
                arr_roomList.clear();
                arr_roomList.addAll(set);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        reference2.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Iterator i = dataSnapshot.getChildren().iterator();
                while(i.hasNext()) {
                    name = (String)((DataSnapshot)i.next()).getValue();
                    position = (String)((DataSnapshot)i.next()).getValue();
                    i.next();
                    if(position.equals("사장"))
                    {
                        SingerItem1 item = new SingerItem1(name, position, R.drawable.iconsajang);
                        adapter.addItem(item);
                    }
                    else if(position.equals("매니저"))
                    {
                        SingerItem1 item = new SingerItem1(name, position, R.drawable.iconmanager);
                        adapter.addItem(item);
                    }
                    else
                    {
                        SingerItem1 item = new SingerItem1(name, position, R.drawable.icontimer);
                        adapter.addItem(item);
                    }
                }
                adapter.notifyDataSetChanged();
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

        UserList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ChatRoom2.class);
                intent.putExtra("room_name",adapter.item1s.get(position).name);
                startActivity(intent);
            }
        });

        ChatList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ChatRoom.class);
                intent.putExtra("room_name",((TextView) view).getText().toString());
                startActivity(intent);
            }
        });
        Allchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChatRoom2.class);
                intent.putExtra("room_name","모든 직원방");
                startActivity(intent);
            }
        });

    }

}
