package alsasa.team_project;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;


public class Custom5 extends Dialog {

    String inname;
    String workhour;
    String tempwage;
    int resId;
    TextView ename;
    TextView eworkresult;
    TextView timemoney;
    TextView worktime;
    TextView result1;
    TextView result2;
    TextView result4;
    TextView result5;
    TextView result6;
    TextView incomeresult;
    TextView outcomeresult;
    ImageView background;
    private float weekTimeFloat;
    private float weekMoneyFloat, weekBonusFloat, monthMoneyFloat, monthTaxFloat;
    private float incomeFloat,maxFloat;
    private float monthTaxCitizenFloat, monthTaxHealthFloat, monthTaxEmploymentFlaot;


    public Custom5(Context context, String inname, String workhour, String tempwage, int resId) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.custom5);

        this.inname = inname;
        this.workhour = workhour;
        this.resId = resId;
        this.tempwage = tempwage;

        background = findViewById(R.id.background);
        ename = findViewById(R.id.ename);
        worktime = findViewById(R.id.worktime);
        eworkresult = findViewById(R.id.eworkresult);
        timemoney = findViewById(R.id.timemoney);

        result1= findViewById(R.id.result1);
        result2= findViewById(R.id.result2);

        result4= findViewById(R.id.result4);
        result5= findViewById(R.id.result5);
        result6= findViewById(R.id.result6);
        incomeresult = findViewById(R.id.incomeresult);
        outcomeresult = findViewById(R.id.outcomeresult);

        int workTime = Integer.parseInt(workhour);
        int MW = Integer.parseInt(tempwage);


        if((workTime>=15) && ((workTime*3)<60)) {      //만약 근로시간이 >= 15시간 이고
            weekTimeFloat = workTime;
            weekMoneyFloat = workTime * MW;             // 주급 = 일한시간 * 시급
            weekBonusFloat = (workTime/(float)40)*8*MW;  // 주휴주당 = (일한시간/(float)40)*8*시급
            monthTaxFloat = (weekMoneyFloat + weekBonusFloat)*(float)0.033;   // 한 달 세금 = (주급 + 주휴수당)*0.033(0.33%);
            monthMoneyFloat = ((weekMoneyFloat + weekBonusFloat) * 4) - monthTaxFloat;  // 월급 = (주급+주휴수당)*4;

            monthTaxCitizenFloat = (float)monthTaxFloat / (float)3;       // 국민보험 = 한달 세금 / 4;
            monthTaxHealthFloat =  (float)monthTaxFloat / (float)4;       // 건강보험 = 한달 세금 / 4;
            monthTaxEmploymentFlaot =  (float)monthTaxFloat / (float)5;  //  고용보험 = 한달 세금 / 4;
        }
        else if((workTime>=15) && ((workTime*3)>=60)) {
            weekTimeFloat = workTime;                   //일한시간
            weekMoneyFloat = workTime * MW;             // 주급 = 일한시간 * 시급
            weekBonusFloat = (workTime / (float) 40) * 8 * MW;  // 주휴주당 = (일한시간/(float)40)*8*시급
            monthTaxFloat = (weekMoneyFloat + weekBonusFloat) * (float) 0.0834;   // 한 달 세금 = (주급 + 주휴수당)*0.0834(8.34%);
            monthMoneyFloat = ((weekMoneyFloat + weekBonusFloat) * 4) - monthTaxFloat;  // 월급 = (주급+주휴수당)*4;

            monthTaxCitizenFloat = (float) monthTaxFloat / (float) 3;       // 국민보험 = 한달 세금 / 4;
            monthTaxHealthFloat = (float) monthTaxFloat / (float) 4;       // 건강보험 = 한달 세금 / 4;
            monthTaxEmploymentFlaot = (float) monthTaxFloat / (float) 5;  //  고용보험 = 한달 세금 / 4;
        }
        else if(workTime<=14) {                         //주근로시간이 14시간보다 작다면
            weekTimeFloat = workTime;                   //일한시간
            weekMoneyFloat = workTime * MW;             // 주급 = 일한시간 * 시급
            weekBonusFloat = 0;
            monthTaxFloat = (weekMoneyFloat + weekBonusFloat) * (float) 0.033;   // 한 달 세금 = (주급 + 주휴수당)*0.0834(8.34%);
            monthMoneyFloat = ((weekMoneyFloat + weekBonusFloat) * 4) - monthTaxFloat;  // 월급 = (주급+주휴수당)*4-세금;

            monthTaxCitizenFloat = (float) monthTaxFloat / (float) 3;       // 국민보험 = 한달 세금 / 4;
            monthTaxHealthFloat = (float) monthTaxFloat / (float) 4;       // 건강보험 = 한달 세금 / 4;
            monthTaxEmploymentFlaot = (float) monthTaxFloat / (float) 5;  //  고용보험 = 한달 세금 / 4;
        }
        incomeFloat = weekBonusFloat + weekMoneyFloat;
        maxFloat = incomeFloat - monthTaxFloat;

        String temp1 = (String.valueOf((int)weekMoneyFloat));
        String temp2 = (String.valueOf((int)weekBonusFloat));
        String temp3 = (String.valueOf((int)incomeFloat));
        String temp4 = (String.valueOf((int)monthTaxFloat));
        String temp5 = (String.valueOf((int)maxFloat));
        String temp6 = (String.valueOf((int)monthTaxCitizenFloat));
        String temp7 = (String.valueOf((int)monthTaxHealthFloat));
        String temp8 = (String.valueOf((int)monthTaxEmploymentFlaot));
        String temp9 = (String.valueOf(MW));
        String temp10 = moneycomma(temp9);

        String temp11 = moneycomma(temp1);
        String temp12 = moneycomma(temp2);
        String temp13 = moneycomma(temp3);
        String temp14 = moneycomma(temp4);
        String temp15 = moneycomma(temp5);
        String temp16 = moneycomma(temp6);
        String temp17 = moneycomma(temp7);
        String temp18 = moneycomma(temp8);

        ename.setText(inname);
        worktime.setText(workhour+"시간");
        timemoney.setText(temp10+"원");
        background.setImageResource(resId);
        result1.setText(temp11+"원");
        result2.setText(temp12+"원");
        incomeresult.setText(temp13+"원");
        outcomeresult.setText(temp14+"원");
        eworkresult.setText(temp15+"원");
        result4.setText(temp16+"원");
        result5.setText(temp17+"원");
        result6.setText(temp18+"원");

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


}