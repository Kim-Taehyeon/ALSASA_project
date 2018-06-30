package alsasa.team_project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class TimerMoneySubDialogActivity extends AppCompatActivity {
    private TextView weekMoney, weekBonus, monthMoney;
    private EditText edtWorkTime;
    private Button btnResult;

    private final int MW=7530;
    private int weekMoneyInt, weekBonusInt, monthMoneyInt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_money_sub_dialog);

        weekMoney = (TextView) findViewById(R.id.weekMoney);
        weekBonus = (TextView) findViewById(R.id.weekBonus);
        monthMoney = (TextView) findViewById(R.id.monthMoney);
        edtWorkTime = (EditText) findViewById(R.id.edtWorkTime);
        btnResult = (Button) findViewById(R.id.btnResult);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edtText = edtWorkTime.getText().toString();
                int workTime = Integer.parseInt(edtText);
                if(workTime>15)
                {
                    weekMoneyInt = workTime * MW;
                    weekBonusInt = workTime * MW * 40 / 8;
                    monthMoneyInt = weekMoneyInt * 4;
                }
                else
                {
                    weekMoneyInt = workTime*MW;
                    weekBonusInt=0;
                    monthMoneyInt=weekMoneyInt*4;
                }

                //TextView에 setText하기
                weekMoney.setText(String.valueOf(weekMoneyInt));
                weekBonus.setText(String.valueOf(weekBonusInt));
                monthMoney.setText(String.valueOf(monthMoneyInt));
            }
        });
    }
}
