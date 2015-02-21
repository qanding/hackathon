package com.hackathon.pharmaguide;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	DbIllness dbIll;
	InsertIllness populateIllness;
	InsertMedicine populateMed;
	InsertReference poulat3dr3f;
	String txtInput;
	
	EditText txtSearchS;
	ImageButton cmdSubmitS;
	RadioGroup rgCathegoryS;
	RadioButton rdAdultS, rdChildS;
	ListView lstInfoS;
	
	DbMedicine dbM3d;
	DbMedReference dbR3f;
	
	ArrayList<String> m3dDataMod3l;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pharma_guide);
		dbIll = new DbIllness(MainActivity.this);
		dbM3d = new DbMedicine(MainActivity.this);
		dbR3f = new DbMedReference(MainActivity.this);
		m3dDataMod3l = new ArrayList<String>();
		copyRefIDs();
		//ADFASLKJFSLKJF
		//SDFSADLKFJSALKDFJSLAD
		//ASDFKASDJFLKSDJF
		poulat3dr3f = new InsertReference(MainActivity.this);
		populateIllness = new InsertIllness(MainActivity.this);
		populateMed = new InsertMedicine(MainActivity.this);
		cmdSubmitS.setOnClickListener(cmdSubmitListener);
	}

	public boolean checkEmptyField(){
    	boolean flag = false;
    	txtInput = txtSearchS.getText().toString().trim();
    	if(txtInput.equals("")){
    		flag= true;
    	}
    	return flag;
    } 
	
	private OnClickListener cmdSubmitListener = new OnClickListener(){
    	public void onClick (View args){
    		if(checkEmptyField()){
    			Toast.makeText(MainActivity.this, "Input illness or medicine", Toast.LENGTH_SHORT).show();
    			
    		}
    		else{
    			IllnessDataModel m3dMod = dbIll.getRow_Table_Illness(txtInput);
    			ArrayList<MedReferenceDataModel> r3fMod3l = dbR3f.getMed(m3dMod.getIllID());
    			for(MedReferenceDataModel t : r3fMod3l){
    				MedicineDataModel m = dbM3d.getRow_Table_Medicine(t.getMedRefId());
    				m3dDataMod3l.add(m.getMedBranchName());
    			}
    			
    			ArrayAdapter<String> myshit = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, m3dDataMod3l);
    			lstInfoS.setAdapter(myshit);
    			
    		}
    		
    	}
    };
    
	public void copyRefIDs(){
    	txtSearchS=(EditText)findViewById(R.id.txtSearch);
    	cmdSubmitS=(ImageButton)findViewById(R.id.cmdSubmit);
    	rgCathegoryS=(RadioGroup)findViewById(R.id.rgCathegory);
    	rdAdultS=(RadioButton)findViewById(R.id.rdAdult);
    	rdChildS=(RadioButton)findViewById(R.id.rdChild);
    	lstInfoS=(ListView)findViewById(R.id.lstInfo);
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
