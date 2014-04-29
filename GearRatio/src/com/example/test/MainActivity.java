package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
Button btn_calculators;
Button btn_inputspecs;
Button btn_help;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_calculators=(Button) findViewById(R.id.btn_calculators);
		btn_calculators.setOnClickListener(this);
		
		btn_inputspecs=(Button) findViewById(R.id.btn_Input);
		btn_inputspecs.setOnClickListener(this);
		
		btn_help=(Button) findViewById(R.id.btn_help);
		btn_help.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()) {
		case R.id.btn_calculators:
			Intent i = new Intent(MainActivity.this, Activity_Calculators.class);
			startActivity(i);
			break;
			
		case R.id.btn_Input:
			Intent i2 = new Intent(MainActivity.this, Activity_TireConverter.class);
			startActivity(i2);
			break;
			
		case R.id.btn_help:
			Intent i3 = new Intent(MainActivity.this, Activity_Help.class);
			startActivity(i3);
			break;
		}
		
	}

}
