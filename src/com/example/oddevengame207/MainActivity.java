package com.example.oddevengame207;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	TextView txt_money, txt_number;
	EditText edit_money;
	Button btn_odd, btn_even;
	
	int rand, money, betting_money;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txt_money = (TextView)findViewById(R.id.textView2);
        txt_number = (TextView)findViewById(R.id.textView4);
        edit_money = (EditText)findViewById(R.id.editText1);
        btn_odd = (Button)findViewById(R.id.button1);
        btn_even = (Button)findViewById(R.id.button2);
        
        btn_odd.setOnClickListener(this);
        btn_even.setOnClickListener(this);
        
        money = 100;        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if (money <= 0){
			Toast.makeText(this, "돈이 없습니다.", 1000).show();
			return;			
		}
		
		if(edit_money.getText().toString().equals("")){
			Toast.makeText(this, "배팅 금액을 입력하세요.", 1000).show();
			return;
		}
		
		betting_money = Integer.parseInt(edit_money.getText().toString());
		
		if(betting_money > money){
			Toast.makeText(this, "배팅 금액이 너무 많습니다.", 1000).show();
			return;
		}
		
		rand = (int)Math.round(Math.random() * 99);
		
		txt_number.setText(Integer.toString(rand));
		
		
		switch(v.getId()){
		case R.id.button1:
			if (rand % 2 == 1){
				money += betting_money;
				txt_money.setText("당신의 돈 : " + money);
				Toast.makeText(this, "맞췄습니다. 배팅 금액을 획득했습니다.", 1000).show();
			}
			else
			{
				money -= betting_money;
				txt_money.setText("당신의 돈 : " + money);
				Toast.makeText(this, "틀렸습니다. 배팅 금액을 잃었습니다.", 1000).show();
			}
			break;
			
		case R.id.button2:
			if (rand % 2 == 0){
				money += betting_money;
				txt_money.setText("당신의 돈 : " + money);
				Toast.makeText(this, "맞췄습니다. 배팅 금액을 획득했습니다.", 1000).show();
			}
			else
			{
				money -= betting_money;
				txt_money.setText("당신의 돈 : " + money);
				Toast.makeText(this, "틀렸습니다. 배팅 금액을 잃었습니다.", 1000).show();
			}
			break;
		}
		
	}	    
}








