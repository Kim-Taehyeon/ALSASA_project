package alsasa.team_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OwnerNewStore2 extends AppCompatActivity {

    DatabaseReference dataStoreWage = FirebaseDatabase.getInstance().getReference().child("store 1").child("store wage");
    ImageButton Next;
    EditText editmoney;
    EditText edit1;
    EditText edit2;
    EditText edit3;
    EditText edit4;
    EditText edit5;
    String tempmoney;
    int tempint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_new_store2);

        Next = findViewById(R.id.editexit);
        editmoney = findViewById(R.id.editmoney);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);
        edit4 = findViewById(R.id.edit5);
        edit5 = findViewById(R.id.edit6);



        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempmoney = editmoney.getText().toString();
                tempint = Integer.parseInt(tempmoney);
                if(tempint<7530)
                {
                    Toast.makeText(getApplicationContext(),"최저시급보다 낮은 금액을 입력하셨습니다.",Toast.LENGTH_LONG).show();
                }
                else {
                    dataStoreWage.setValue(tempmoney);
                    Intent NextPage = new Intent(getApplicationContext(), OwnerMainHost.class);
                    startActivity(NextPage);
                    finish();
                }
            }
        });
    }
}
