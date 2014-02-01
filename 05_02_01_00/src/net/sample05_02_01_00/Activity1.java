package net.sample05_02_01_00;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity1 extends Activity {
	private TextView textView;
	private Button button;//起動時に呼ばれる
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		textView=(TextView)findViewById(R.id.textView1);
		button=(Button)findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				textView.setText("Button Pushed.");
			}
		});
		
		
	}

}
