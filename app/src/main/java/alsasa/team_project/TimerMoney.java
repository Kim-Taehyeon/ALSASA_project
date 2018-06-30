package alsasa.team_project;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.Iterator;

public class TimerMoney extends AppCompatActivity {


    float weekTimeFloat;
    float weekMoneyFloat, weekBonusFloat, monthMoneyFloat, monthTaxFloat;
    float incomeFloat,maxFloat;
    float monthTaxCitizenFloat, monthTaxHealthFloat,monthTaxEmploymentFlaot;
    String tempname;
    String temphour;
    String tempwage;

    Custom5 cd5;
    ListView slavelist;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("store 1").child("User ID");
    DatabaseReference dataStoreWage = FirebaseDatabase.getInstance().getReference("store 1").child("store wage");

    int x = 0;

    private MyAdapter3 adapter = new MyAdapter3(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_money);

        slavelist = findViewById(R.id.slavelist);
        slavelist.setAdapter(adapter);
        dataStoreWage.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tempwage = dataSnapshot.getValue(String.class);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Iterator i = dataSnapshot.getChildren().iterator();
                while(i.hasNext()) {
                    String name = (String)((DataSnapshot)i.next()).getValue();
                    String position = (String)((DataSnapshot)i.next()).getValue();
                    String hour = (String)((DataSnapshot)i.next()).getValue();
                    Calculate(hour,tempwage);
                    String tempmoney = Calculate(hour,tempwage);
                    String tempmoney2 = moneycomma(tempmoney)+"원";
                    if(x==0)
                    {
                        if(position.equals("사장"))
                        {

                        }
                        else if(position.equals("매니저"))
                        {
                            SingerItem3 item = new SingerItem3(name, hour,tempmoney2,R.drawable.persona);
                            adapter.addItem(item);
                            x=1;
                        }
                        else
                        {
                            SingerItem3 item = new SingerItem3(name, hour,tempmoney2,R.drawable.persona);
                            adapter.addItem(item);
                            x=1;
                        }
                    }
                    else
                    {
                        if(position.equals("사장"))
                        {
                        }
                        else if(position.equals("매니저"))
                        {
                            SingerItem3 item = new SingerItem3(name, hour,tempmoney2,R.drawable.personb);
                            adapter.addItem(item);
                            x=0;
                        }
                        else
                        {
                            SingerItem3 item = new SingerItem3(name, hour,tempmoney2,R.drawable.personb);
                            adapter.addItem(item);
                            x=0;
                        }
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

        slavelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tempname = adapter.item3s.get(position).name;
                temphour = adapter.item3s.get(position).wow;
                cd5 = new Custom5(TimerMoney.this,tempname,temphour,tempwage,R.drawable.timercal);
                cd5.show();
            }
        });
    }

    public String moneycomma(String a)
    {
        String money= a;
        long value = Long.parseLong(money);
        DecimalFormat format = new DecimalFormat("###,###");//콤마
        format.format(value);
        String result_int = format.format(value);
        return result_int;
    }
    public String Calculate(String a,String b)
    {
        int workTime = Integer.parseInt(a);
        int MW = Integer.parseInt(b);


        if((workTime>=15) && ((workTime*3)<60)) {      //만약 근로시간이 >= 15시간 이고
            weekTimeFloat = workTime;
            weekMoneyFloat = workTime * MW;             // 주급 = 일한시간 * 시급
            weekBonusFloat = (workTime/(float)40)*8*MW;  // 주휴주당 = (일한시간/(float)40)*8*시급
            monthTaxFloat = (weekMoneyFloat + weekBonusFloat)*(float)0.033;   // 한 달 세금 = (주급 + 주휴수당)*0.033(0.33%);
            monthMoneyFloat = ((weekMoneyFloat + weekBonusFloat) * 4) - monthTaxFloat;  // 월급 = (주급+주휴수당)*4;

            monthTaxCitizenFloat = (float)monthTaxFloat / (float)4;       // 국민보험 = 한달 세금 / 4;
            monthTaxHealthFloat =  (float)monthTaxFloat / (float)4;       // 건강보험 = 한달 세금 / 4;
            monthTaxEmploymentFlaot =  (float)monthTaxFloat / (float)4;  //  고용보험 = 한달 세금 / 4;
        }
        else if((workTime>=15) && ((workTime*3)>=60)) {
            weekTimeFloat = workTime;                   //일한시간
            weekMoneyFloat = workTime * MW;             // 주급 = 일한시간 * 시급
            weekBonusFloat = (workTime / (float) 40) * 8 * MW;  // 주휴주당 = (일한시간/(float)40)*8*시급
            monthTaxFloat = (weekMoneyFloat + weekBonusFloat) * (float) 0.0834;   // 한 달 세금 = (주급 + 주휴수당)*0.0834(8.34%);
            monthMoneyFloat = ((weekMoneyFloat + weekBonusFloat) * 4) - monthTaxFloat;  // 월급 = (주급+주휴수당)*4;

            monthTaxCitizenFloat = (float) monthTaxFloat / (float) 4;       // 국민보험 = 한달 세금 / 4;
            monthTaxHealthFloat = (float) monthTaxFloat / (float) 4;       // 건강보험 = 한달 세금 / 4;
            monthTaxEmploymentFlaot = (float) monthTaxFloat / (float) 4;  //  고용보험 = 한달 세금 / 4;
        }
        else if(workTime<=14) {                         //주근로시간이 14시간보다 작다면
            weekTimeFloat = workTime;                   //일한시간
            weekMoneyFloat = workTime * MW;             // 주급 = 일한시간 * 시급
            weekBonusFloat = 0;
            monthTaxFloat = (weekMoneyFloat + weekBonusFloat) * (float) 0.033;   // 한 달 세금 = (주급 + 주휴수당)*0.0834(8.34%);
            monthMoneyFloat = ((weekMoneyFloat + weekBonusFloat) * 4) - monthTaxFloat;  // 월급 = (주급+주휴수당)*4-세금;

            monthTaxCitizenFloat = (float) monthTaxFloat / (float) 4;       // 국민보험 = 한달 세금 / 4;
            monthTaxHealthFloat = (float) monthTaxFloat / (float) 4;       // 건강보험 = 한달 세금 / 4;
            monthTaxEmploymentFlaot = (float) monthTaxFloat / (float) 4;  //  고용보험 = 한달 세금 / 4;
        }
        incomeFloat = weekBonusFloat + weekMoneyFloat;
        maxFloat = incomeFloat - monthTaxFloat;
        int tempint = Integer.valueOf((int)maxFloat);
        String numStr2 = String.valueOf(tempint);
        return numStr2;
    }
}
