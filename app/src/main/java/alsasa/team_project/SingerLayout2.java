package alsasa.team_project;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerLayout2 extends LinearLayout {
    Context mContext;
    TextView textView;
    TextView textView2;
    ImageView positionview;
    ImageView BarColor;
    TextView textView5;

    private void init(){
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.chaticon,this,true);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView5 = findViewById(R.id.textView5);
        positionview = findViewById(R.id.imageView13);
        BarColor = findViewById(R.id.barcolor);
    }
    public void setNameText(String name){
        textView.setText(name);
    }
    public void setPositionText(String Position){
        textView2.setText(Position);
    }
    public void setMsgText(String msg){
        textView5.setText(msg);
    }
    public void setPositionview(int resId)
    {
        positionview.setImageResource(resId);
    }
    public void setBarColor(int resld2){BarColor.setImageResource(resld2);}


    public SingerLayout2(Context context) {
        super(context);

        mContext = context;
        init();
    }

    public SingerLayout2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        init();
    }


}
