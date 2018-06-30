package alsasa.team_project;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class MyAdapter3 extends BaseAdapter {

    ArrayList<SingerItem3> item3s = new ArrayList<SingerItem3>();

    Context mContext;


    @Override
    public int getCount() {
        return item3s.size();
    }

    @Override
    public Object getItem(int position) {
        return item3s.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public void addItem(SingerItem3 item3){
        item3s.add(item3);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SingerLayout3 layout = new SingerLayout3(mContext);
        SingerItem3 item3 = item3s.get(position);
        layout.setNameText(item3.name);
        layout.setPositionText(item3.wow);
        layout.setPositionview(item3.resId);
        layout.setMoneyText(item3.money);
        return layout;
    }


    public MyAdapter3(Context context)
    {
        mContext = context;
    }
}