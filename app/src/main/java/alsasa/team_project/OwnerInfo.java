package alsasa.team_project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class OwnerInfo extends AppCompatActivity {

    Button link1;
    Button link2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_info);

        link1 = findViewById(R.id.link1);
        link2 = findViewById(R.id.link2);

        link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent WebPage = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moel.go.kr"));
                startActivity(WebPage);
            }
        });
        link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Call = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:1350"));
                startActivity(Call);

            }
        });

    }
}
