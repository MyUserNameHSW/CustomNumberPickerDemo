package com.example.timepick;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.EditText;

public class CustomPickerDialog extends NumberPicker {
	public CustomPickerDialog(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void addView(View child) {
		super.addView(child);
		updateView(child);
	}

	@Override
	public void addView(View child, int index,
			android.view.ViewGroup.LayoutParams params) {
		super.addView(child, index, params);
		updateView(child);
	}

	@Override
	public void addView(View child, android.view.ViewGroup.LayoutParams params) {
		super.addView(child, params);
		updateView(child);
	}

	public void updateView(View view) {
		if (view instanceof EditText) { // �����޸����������
			((EditText) view).setTextSize(12);
			((EditText) view).setTextColor(Color.RED);
		}
	}

	@Override
	public void setEnabled(boolean enabled) {
		// TODO Auto-generated method stub
		super.setEnabled(enabled);
	}
}