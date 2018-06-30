package alsasa.team_project;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<SingerItem1> item1s = new ArrayList<SingerItem1>();

    Context mContext;


    @Override
    public int getCount() {
        return item1s.size();
    }

    @Override
    public Object getItem(int position) {
        return item1s.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public void addItem(SingerItem1 item1){
        item1s.add(item1);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SingerLayout1 layout = new SingerLayout1(mContext);
        SingerItem1 item1 = item1s.get(position);
        layout.setNameText(item1.name);
        layout.setPositionText(item1.wow);
        layout.setPositionview(item1.resId);
        return layout;
    }


    public MyAdapter(Context context)
    {
        mContext = context;
    }
}