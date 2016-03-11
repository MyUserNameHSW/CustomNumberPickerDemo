package com.example.timepick;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.NumberPicker;
import android.widget.NumberPicker.Formatter;
import android.widget.NumberPicker.OnScrollListener;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class CustomTimePicDialog extends Dialog implements Formatter,
		OnValueChangeListener, OnScrollListener {
	Context context;
	private String title;
	private String values[];
	private CustomPickerDialog picker;
	private String endNum;
	private ClickListenerInterface clickListenerInterface;

	public interface ClickListenerInterface {

		public void doConfirm();

		public void doCancel();
	}

	public CustomTimePicDialog(Context context, String title, String values[]) {
		super(context, R.style.ActionSheetDialogStyle);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.title = title;
		this.values = values;
	}

	public String getEndNum() {
		return endNum;
	}

	public void setEndNum(String endNum) {
		this.endNum = endNum;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub

		Window dialogWindow = getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		DisplayMetrics d = context.getResources().getDisplayMetrics(); // 获取屏幕宽、高用
		dialogWindow.setGravity(Gravity.CENTER | Gravity.BOTTOM);
		lp.x = 0;
		lp.y = 0;
		// lp.width = (int) (d.widthPixels * 0.8); // 高度设置为屏幕的0.6
		dialogWindow.setAttributes(lp);

		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.number_choose_dialog, null);
		setContentView(view);
		TextView titleTextView = (TextView) view.findViewById(R.id.txt_title);
		TextView cancleTextView = (TextView) view.findViewById(R.id.cancel);
		TextView confirmTextView = (TextView) view.findViewById(R.id.confirm);
		picker = (CustomPickerDialog) view.findViewById(R.id.numpic);
		cancleTextView.setOnClickListener(new ClickListener());
		confirmTextView.setOnClickListener(new ClickListener());
		titleTextView.setText(title);
		initPick();

	}

	public void setClicklistener(ClickListenerInterface clickListenerInterface) {
		this.clickListenerInterface = clickListenerInterface;
	}

	private void initPick() {
		// TODO Auto-generated method stub
//		picker.setFormatter(this);
		picker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
		picker.setOnValueChangedListener(this);
		picker.setOnScrollListener(this);
		picker.setMaxValue(values.length-1);
		picker.setMinValue(0);
		picker.setDisplayedValues(values);
		picker.setValue(values.length);

	}

	public String format(int value) {
		String tmpStr = values[value];
//		if (value < 10) {
//			tmpStr = "0" + tmpStr;
//		}
		return tmpStr;
	}

	public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//		Toast.makeText(context, values[newVal], Toast.LENGTH_SHORT).show();
		setEndNum(values[newVal]);
	}

	public void onScrollStateChange(NumberPicker view, int scrollState) {
		switch (scrollState) {
		case OnScrollListener.SCROLL_STATE_FLING:
			// Toast.makeText(context, "后续滑动(飞呀飞，根本停下来)", Toast.LENGTH_LONG)
			// .show();
			break;
		case OnScrollListener.SCROLL_STATE_IDLE:
			// Toast.makeText(this, "不滑动", Toast.LENGTH_LONG).show();
			break;
		case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
			// Toast.makeText(this, "滑动中", Toast.LENGTH_LONG)
			// .show();
			break;
		}
	}

	class ClickListener implements android.view.View.OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.confirm:
				clickListenerInterface.doConfirm();
				break;
			case R.id.cancel:
				clickListenerInterface.doCancel();
				break;

			default:
				break;
			}
		}
	}
}
