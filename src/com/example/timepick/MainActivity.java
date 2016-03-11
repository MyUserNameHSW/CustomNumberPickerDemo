package com.example.timepick;

import com.example.timepick.CustomTimePicDialog.ClickListenerInterface;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.Formatter;
import android.widget.NumberPicker.OnScrollListener;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity  {
   NumberPicker picker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        picker = (NumberPicker) findViewById(R.id.pick);
//        init();
    }
//    private void init() {
//		// TODO Auto-generated method stub
//    	picker.setFormatter(this);
//    	picker.setOnValueChangedListener(this);
//    	picker.setOnScrollListener(this);
//    	picker.setMaxValue(24);
//    	picker.setMinValue(0);
//    	picker.setValue(9);
//         
//	}
//	public String format(int value) {
//        String tmpStr = String.valueOf(value);
//        if (value < 10) {
//            tmpStr = "0" + tmpStr;
//        }
//        return tmpStr;
//    }
//    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
////        Toast.makeText(
////                this,
////                "原来的值 " + oldVal + "--新值: "
////                        + newVal, Toast.LENGTH_SHORT).show();
//}
//    public void onScrollStateChange(NumberPicker view, int scrollState) {
//        switch (scrollState) {
//        case OnScrollListener.SCROLL_STATE_FLING:
////            Toast.makeText(this, "后续滑动(飞呀飞，根本停下来)", Toast.LENGTH_LONG)
////                    .show();
//            break;
//        case OnScrollListener.SCROLL_STATE_IDLE:
////            Toast.makeText(this, "不滑动", Toast.LENGTH_LONG).show();
//            break;
//        case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
////            Toast.makeText(this, "滑动中", Toast.LENGTH_LONG)
////                    .show();
//            break;
//        }
//    }
    public void showDialog(View view){
    	String values[] = {"item1","item2","item3","item4"};
    	final CustomTimePicDialog dialog = new CustomTimePicDialog(this, "choose", values);
    	dialog.show();
    	dialog.setClicklistener(new ClickListenerInterface() {
			
			@Override
			public void doConfirm() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, dialog.getEndNum(), Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void doCancel() {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
    }
}
