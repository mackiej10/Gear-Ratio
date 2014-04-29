package com.example.test;

import java.text.DecimalFormat;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_TireConverter extends Activity implements OnClickListener  {

	RadioButton rbMetric;
	RadioButton rbInches;
	TextView tvDes;
	RadioGroup rg;
	TextView tvHeight;
	TextView tvWidth;
	TextView tvRim;
	EditText etHeight;
	EditText etWidth;
	EditText etRim;
	TextView tvResult;
	Button btn_calculate;
	int designation=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tireconverter);

		tvDes = (TextView) findViewById(R.id.tvDesignation);
		rg=(RadioGroup) findViewById(R.id.radioGroup1);
		tvHeight=(TextView) findViewById(R.id.tvHeight);
		tvWidth=(TextView) findViewById(R.id.tvWidth);
		tvRim=(TextView) findViewById(R.id.tvRim);
		etHeight=(EditText) findViewById(R.id.etHeight);
		etWidth=(EditText) findViewById(R.id.etWidth);
		etRim=(EditText) findViewById(R.id.etRim);
		
		btn_calculate=(Button) findViewById(R.id.btnCalculate);
		btn_calculate.setOnClickListener(this);
		tvResult=(TextView) findViewById(R.id.tvResult);
		
		
	}

	
	public void onRadioButtonClicked(View view) {
	    // Is the button now checked?
		int selectedId = rg.getCheckedRadioButtonId();
		boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.rb_inches:
	            if (checked) 
	            	//tv1.setVisibility(TextView.INVISIBLE);
	            	tvDes.setText("Inches");
	            
            		tvHeight.setText("");
            		tvWidth.setText("X");
            		tvRim.setText("R");
            		etHeight.setHint("31");
            		etWidth.setHint("10.50");
            		etRim.setHint("15");
	            	Toast.makeText(Activity_TireConverter.this,
	 						"Inches Tires Selected", Toast.LENGTH_SHORT).show();
	            	designation=0;
	            break;
	        case R.id.rb_metric:
	            if (checked)
	            	// tv1.setVisibility(TextView.VISIBLE);
	            	tvDes.setText("Metric");
	            	tvHeight.setText("P");
	            	tvWidth.setText("/");
	            	tvRim.setText("R");
	            	etHeight.setHint("225");
            		etWidth.setHint("65");
            		etRim.setHint("15");
	            	 Toast.makeText(Activity_TireConverter.this,
	 						"Metric Tires Selected", Toast.LENGTH_SHORT).show();
	            	 designation=1;
	            break;
	            
	           
	    }
	    
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	@Override
	public void onClick(View v) {
		//USE A FUCKING DOUBLE NOT A FLOAT ITS BETTER
		String a = "."+etWidth.getText().toString();
		double h = Double.parseDouble(etHeight.getText().toString());
		double w = Double.parseDouble(etWidth.getText().toString());
		double r = Double.parseDouble(etRim.getText().toString());
		
		if(designation==1){
			//metric all set
			double newWidth = (h/25.4);
			double newHeight = (h*(w/=100)*2/25.4+r);
			DecimalFormat df = new DecimalFormat("##.##");
			DecimalFormat dfr = new DecimalFormat("##");
			String tire = df.format(newHeight)+" X "+df.format(newWidth)+" R "+dfr.format(r);
			tvResult.setText("Your tire is equivalent to a "+tire);
		}
		else{
			//american all set
			double newHeight=h;
			double newWidth = ((newHeight-15)*25.4)/2;
			newHeight = (w*25.4);
			double newAspect = newWidth/newHeight;
			DecimalFormat df = new DecimalFormat("###");
			DecimalFormat df1 = new DecimalFormat("##");
			newWidth=newWidth/newAspect;
			newAspect = newAspect*=100;
			String tire = df.format(newWidth)+" / "+ df1.format(newAspect)+" R "+df.format(r);
			tvResult.setText("Your tire is equivalent to a "+tire);
			
			
			
			
		}
		
	}


	

	}


