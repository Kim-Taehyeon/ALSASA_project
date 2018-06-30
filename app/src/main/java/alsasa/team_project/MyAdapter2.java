package alsasa.team_project;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class MyAdapter2 extends BaseAdapter {

    ArrayList<SingerItem2> item2s = new ArrayList<SingerItem2>();

    Context mContext;


    @Override
    public int getCount() {
        return item2s.size();
    }

    @Override
    public Object getItem(int position) {
        return item2s.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public void addItem(SingerItem2 item2){
        item2s.add(item2);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SingerLayout2 layout = new SingerLayout2(mContext);
        SingerItem2 item2 = item2s.get(position);
        layout.setNameText(item2.name);
        layout.setPositionText(item2.wow);
        layout.setMsgText(item2.msg);
        layout.setPositionview(item2.resId);
        layout.setBarColor(item2.resId2);
        return layout;
    }


    public MyAdapter2(Context context)
    {
        mContext = context;
    }
}