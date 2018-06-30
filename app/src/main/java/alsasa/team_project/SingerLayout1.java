package alsasa.team_project;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerLayout1 extends LinearLayout {
    Context mContext;
    TextView textView;
    TextView textView2;
    ImageView positionview;

    private void init(){
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_practice,this,true);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        positionview = findViewById(R.id.imageView14);
    }
    public void setNameText(String name){
        textView.setText(name);
    }
    public void setPositionText(String Position){
        textView2.setText(Position);
    }
    public void setPositionview(int resId)
    {
        positionview.setImageResource(resId);
    }

    public SingerLayout1(Context context) {
        super(context);

        mContext = context;
        init();
    }

    public SingerLayout1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        init();
    }


}
