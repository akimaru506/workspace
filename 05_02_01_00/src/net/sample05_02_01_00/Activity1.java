package net.sample05_02_01_00;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Activity1 extends Activity
{
	private TextView textView;
	private TextView textView2;
	private Button button;// 起動時に呼ばれる
	private Button button2;
	private Button button3;
	private ImageView atata;
	private ImageView hretu;
	SeekBar skbar;
	int i = 0;
	int j = 0;
	int f = 0;
	int nan = 500;
	int pon = 250;
	long t = SystemClock.uptimeMillis();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		textView = (TextView) findViewById(R.id.textView1);
		textView2 = (TextView) findViewById(R.id.TextView01);
		button = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		atata = (ImageView) findViewById(R.id.imageView1);
		hretu = (ImageView) findViewById(R.id.imageView2);
		skbar = (SeekBar) findViewById(R.id.seekBar1);
		button2.setVisibility(View.INVISIBLE); 
		button3.setVisibility(View.INVISIBLE);
		atata.setVisibility(View.INVISIBLE); 
		hretu.setVisibility(View.INVISIBLE);
		
		
		skbar.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser) {
                //動かすと呼ばれる
               
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // 触れると呼ばれる
            }
         
            public void onStopTrackingTouch(SeekBar seekBar) {
                // 離すと呼ばれる
                nan=skbar.getProgress();
                pon=(1001-nan)/2;
                if(pon<1)pon=1;
            }
        });
			
			
				button.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						i++;
						
						if(i==1){
							
							button2.setVisibility(View.VISIBLE);  
							atata.setVisibility(View.VISIBLE); 
							skbar.setVisibility(View.INVISIBLE); 
							textView2.setVisibility(View.INVISIBLE); 
							textView.setText(""); 
							button.setText("た");
							t=SystemClock.uptimeMillis();
						 }
						if(SystemClock.uptimeMillis()-t>=nan){
							textView.setText("速さが\n足りない");
							hretu.setVisibility(View.INVISIBLE);
							atata.setVisibility(View.INVISIBLE);
							button.setVisibility(View.INVISIBLE);  
							button2.setVisibility(View.INVISIBLE);  
							button3.setVisibility(View.VISIBLE);
							pon/=2;
							if(pon<1)pon=1;
							j=1;
							
						}
						t=SystemClock.uptimeMillis();
						//textView.setText(String.valueOf(i));
					}
					
				});
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(i>0)
				{
					//i++;
					if(i==100)
					{
						atata.setVisibility(View.INVISIBLE);
						hretu.setVisibility(View.VISIBLE);
					}else{
						atata.setVisibility(View.INVISIBLE);
						textView.setText("北斗"+String.valueOf(i)+"裂拳");
					}
					j=1;
					
					button.setVisibility(View.INVISIBLE);  
					button2.setVisibility(View.INVISIBLE);  
					button3.setVisibility(View.VISIBLE);  
				}
			}
			
		});
		button3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(j==1)
				{
					hretu.setVisibility(View.INVISIBLE);
					button.setVisibility(View.VISIBLE);  
					button3.setVisibility(View.INVISIBLE);
					skbar.setVisibility(View.VISIBLE); 
					textView2.setVisibility(View.VISIBLE); 
					button.setText("あ");
					if(i>100){f=200-i;}
					else if(i==100){f=1000;}
					else{f=i;}
					textView.setText("SCORE:"+String.valueOf(pon*f));
					j=0;
					i=0;
				}
			}
			
		});
		
	}
}
