package net.sample05_02_01_00;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity1 extends Activity {
	private TextView textView;
	private Button button;// 起動時に呼ばれる
	private Button button2;
	int i = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		textView = (TextView) findViewById(R.id.textView1);
		button = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);

		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				i++;
				if(i==1){
					
					button2.setWidth(50);
					button2.setHeight(200);
					button.setText("タ");
				 }
				textView.setText(String.valueOf(i));
			}
			
		});
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(i==100)
				{
					textView.setText("北斗百裂拳");
				}else{
					textView.setText(String.valueOf(i));
				}
			}
			
		});
	}
}
