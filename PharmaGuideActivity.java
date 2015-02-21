package com.android.pharmaguide;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class PharmaGuideActivity extends Activity {
	EditText txtSearchS;
	ImageButton cmdSubmitS;
	RadioGroup rgCathegoryS;
	RadioButton rdAdultS, rdChildS;
	ListView lstInfoS;
	
	boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharma_guide);
        copyRefIDs();
        rgCathegoryS.check(R.id.rdAdult);
        cmdSubmitS.setOnClickListener(cmdSubmitListener);
    }
    public void copyRefIDs(){
    	txtSearchS=(EditText)findViewById(R.id.txtSearch);
    	cmdSubmitS=(ImageButton)findViewById(R.id.cmdSubmit);
    	rgCathegoryS=(RadioGroup)findViewById(R.id.rgCathegory);
    	rdAdultS=(RadioButton)findViewById(R.id.rdAdult);
    	rdChildS=(RadioButton)findViewById(R.id.rdChild);
    	lstInfoS=(ListView)findViewById(R.id.lstInfo);
    }
    private OnClickListener cmdSubmitListener = new OnClickListener(){
    	public void onClick (View args){
    		if(checkEmptyField()){
    			Toast.makeText(PharmaGuideActivity.this, "Input illness or medicine", Toast.LENGTH_SHORT).show();
    		}
    		
    	}
    };
   
    public boolean checkEmptyField(){
    	flag = false;
    	if(txtSearchS.getText().toString().trim().equals("")){
    		flag= true;
    	}
    	return flag;
    } 
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pharma_guide, menu);
        return true;
        
    }
    
}
