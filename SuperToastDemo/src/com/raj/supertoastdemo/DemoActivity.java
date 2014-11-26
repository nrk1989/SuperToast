/**
 * DemoActivity.java
 * 
 * An demo activity.
 *
 * @category   Contus
 * @package    com.raj.supertoastdemo
 * @version    1.0
 * @author     Contus Team <developers@contus.in>
 * @copyright  Copyright (C) 2014 Contus. All rights reserved.
 * @license    http://www.apache.org/licenses/LICENSE-2.0 
 */
package com.raj.supertoastdemo;

import com.raj.SuperToast;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class DemoActivity extends Activity {

	private SuperToast mSuperToast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);
		mSuperToast = new SuperToast(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		mSuperToast.hideToast();
	}

	public void onClick(View clickedView) {
		switch (clickedView.getId()) {
		case R.id.btnShortInfo: {
			mSuperToast.showShortInfoToast("This is short info toast");
			break;
		}
		case R.id.btnLongInfo: {
			mSuperToast.showShortInfoToast("This is long info toast");
			break;
		}

		case R.id.btnShortError: {
			mSuperToast.showShortErrorToast("This is short error toast");
			break;
		}
		case R.id.btnLongError: {
			mSuperToast.showShortErrorToast("This is long error toast");
			break;
		}
		case R.id.btnHide: {
			mSuperToast.hideToast();
		}
		default:
			break;
		}
	}
}
