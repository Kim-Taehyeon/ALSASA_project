package alsasa.team_project;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerLayout3 extends LinearLayout {
    Context mContext;
    TextView textView;
    TextView textView2;
    TextView textView3;
    ImageView positionview;

    private void init(){
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.moneyicon,this,true);

        textView = findViewById(R.id.slavename);
        textView2 = findViewById(R.id.slavehour);
        textView3 = findViewById(R.id.slavemoney);
        positionview = findViewById(R.id.slavebar);
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
    public void setMoneyText(String money){textView3.setText(money);}

    public SingerLayout3(Context context) {
        super(context);

        mContext = context;
        init();
    }

    public SingerLayout3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        init();
    }


}
