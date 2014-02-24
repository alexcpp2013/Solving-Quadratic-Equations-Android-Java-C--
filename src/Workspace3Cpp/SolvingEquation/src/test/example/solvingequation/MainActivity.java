package test.example.solvingequation;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends Activity {

	private final double NUMBERDEAFULT = 1.0;
	
	private class Data{
		private Double first = null;
    	private Double second = null;
    	private Double third = null;
		
    	private Double getFirst() {
			return first;
		}
		private void setFirst(Double first) {
			this.first = first;
		}
		
		private Double getSecond() {
			return second;
		}
		private void setSecond(Double second) {
			this.second = second;
		}
		
		private Double getThird() {
			return third;
		}
		private void setThird(Double third) {
			this.third = third;
		}
		
		public void getNumber(EditText t0, EditText t1, EditText t2) {
			try{
				first = Double.parseDouble(t0.getText().toString());
	        } catch (final NumberFormatException e) {
	        	first = NUMBERDEAFULT;
	        }
			
			try{
				second = Double.parseDouble(t1.getText().toString());
	        } catch (final NumberFormatException e) {
	        	second = NUMBERDEAFULT;
	        }
			
			try{
				third = Double.parseDouble(t2.getText().toString());
	        } catch (final NumberFormatException e) {
	        	third = NUMBERDEAFULT;
	        }
		}
	};
	
	private Button btnStart;
	private EditText eTResult;
	private EditText eTFirst;
	private EditText eTSecond;
	private EditText eTThird;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnStart = (Button)findViewById(R.id.bStart);
        eTResult = (EditText)findViewById(R.id.eTResult);
        eTFirst = (EditText)findViewById(R.id.eTa);
        eTSecond = (EditText)findViewById(R.id.eTb);
        eTThird = (EditText)findViewById(R.id.eTc);
        
        btnStart.setOnClickListener(new View.OnClickListener(){

        	public void onClick(View v) {        		
            	Data data = new Data();
        		data.getNumber(eTFirst, eTSecond, eTThird);
        		
        		/*String str = "\n" + data.first.toString() + "   " + 
        							data.second.toString() + "   " + 
        							data.third.toString() + "\n";
        		messageShow(str);*/
        		
        		eTResult.setText(SolvingEquation.Solving(data.getFirst(), 
        						data.getSecond(), 
        						data.getThird()));
        	}
        	
        });
      
    }

	private void messageShow(String str) {
		AlertDialog.Builder alertDialog;
		alertDialog = new AlertDialog.Builder(this);
		alertDialog.setPositiveButton("OK", null);
		alertDialog.setCancelable(true);
		alertDialog.setTitle("Debug Message");
		alertDialog.setMessage(str);
		alertDialog.create().show();
	}

	//!--
	/*public static native String Solving(double a, double b, double c);*/
	//
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    //!--
    /*static {
		System.loadLibrary("AndroidNDK");
	}*/
    //--    
}
