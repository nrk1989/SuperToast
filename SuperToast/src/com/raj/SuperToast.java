/**
 * SuperToast.java
 * 
 * A tool used to show context sensitive toasts.
 *
 * @category   Utils
 * @package    com.raj
 * @version    1.0
 * @author     Rajkumar.N <rkmail1989@gmail.com>
 * @license    http://www.apache.org/licenses/LICENSE-2.0 
 */

package com.raj;

import com.raj.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

/**
 *  A tool used to show context sensitive toasts.
 * 
 */
/**
 * @author Rajkumar.N
 * 
 */
public class SuperToast implements AnimationListener {
	private Context mContext;
	private TextView txtToastMessage;
	private View toastView;

	// Default Toast
	private Toast toast;
	private TextView toastText;

	// Animation
	private Animation startAnimation;
	private Animation endAnimation;

	// Hide Delay
	private static final int LONG_DELAY = 3500;
	private static final int SHORT_DELAY = 2000;
	private Delays mDelay;

	// Handler and runnable
	private final Handler mHandler = new Handler();
	private final Runnable mRunnable = new Runnable() {

		@Override
		public void run() {
			txtToastMessage.startAnimation(endAnimation);
		}
	};

	private enum Delays {
		SHORT, LONG;
	}

	/**
	 * Creates the instance of Andy.
	 * 
	 * @param context
	 *            - Environment context of current reference
	 * 
	 */
	public SuperToast(Context context) {
		this.mContext = context;
		// View Group for toast view.
		ViewGroup container = (ViewGroup) ((Activity) mContext)
				.findViewById(android.R.id.content);
		toastView = ((Activity) mContext).getLayoutInflater().inflate(
				R.layout.toast_app, container);
		// Custom Toast View
		txtToastMessage = (TextView) toastView
				.findViewById(R.id.txtToastMessage);
		startAnimation = AnimationUtils.loadAnimation(mContext,
				R.anim.slide_down);
		endAnimation = AnimationUtils.loadAnimation(mContext, R.anim.slide_up);
		startAnimation.setAnimationListener(this);
		endAnimation.setAnimationListener(this);
		// Default Toast Customs
		toast = new Toast(mContext);
		toastText = new TextView(mContext);
		toastText.setTextColor(mContext.getResources().getColor(
				android.R.color.black));
		toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL,
				0, 25);
		toast.setView(toastText);
	}

	/**
	 * Used to show short toast message in default toast view.
	 * 
	 * @param msg
	 *            - Message to display
	 */
	public void showDefaultShortToast(String msg) {
		toastText.setBackgroundResource(R.drawable.bg_toast_default);
		toastText.setText(msg);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.show();
	}

	/**
	 * Used to show long toast message in default toast view.
	 * 
	 * @param msg
	 *            - Message to display
	 */
	public void showDefaultLongToast(String msg) {
		toastText.setBackgroundResource(R.drawable.bg_toast_default);
		toastText.setText(msg);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.show();
	}

	/**
	 * Used to show short information toast message in default toast view.
	 * 
	 * @param msg
	 *            - Message to display
	 */
	public void showDefaultShortInfoToast(String msg) {
		toastText.setBackgroundResource(R.drawable.bg_toast_info);
		toastText.setText(msg);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.show();
	}

	/**
	 * Used to show long information toast message in default toast view.
	 * 
	 * @param msg
	 *            - Message to display
	 */
	public void showDefaultLongInfoToast(String msg) {
		toastText.setBackgroundResource(R.drawable.bg_toast_info);
		toastText.setText(msg);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.show();
	}

	/**
	 * Used to show short error toast message in default toast view.
	 * 
	 * @param msg
	 *            - Message to display
	 */
	public void showDefaultShortErrorToast(String msg) {
		toastText.setBackgroundResource(R.drawable.bg_toast_error);
		toastText.setText(msg);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.show();
	}

	/**
	 * Used to show long error toast message in default toast view.
	 * 
	 * @param msg
	 *            - Message to display
	 */
	public void showDefaultLongErrorToast(String msg) {
		toastText.setBackgroundResource(R.drawable.bg_toast_error);
		toastText.setText(msg);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.show();
	}

	/**
	 * Used to show short toast message
	 * 
	 * @param msg
	 *            - Message to display
	 */
	public void showShortToast(String msg) {
		txtToastMessage.setBackgroundColor(Color.parseColor(mContext
				.getString(R.color.bg_toast_default)));
		txtToastMessage.setText(msg);
		mHandler.removeCallbacks(mRunnable);
		txtToastMessage.setVisibility(View.VISIBLE);
		mDelay = Delays.SHORT;
		txtToastMessage.startAnimation(startAnimation);
	}

	/**
	 * Used to show long toast message
	 * 
	 * @param msg
	 *            - Message to display
	 */
	public void showLongToast(String msg) {
		txtToastMessage.setBackgroundColor(Color.parseColor(mContext
				.getString(R.color.bg_toast_default)));
		txtToastMessage.setText(msg);
		mHandler.removeCallbacks(mRunnable);
		txtToastMessage.setVisibility(View.VISIBLE);
		mDelay = Delays.LONG;
		txtToastMessage.startAnimation(startAnimation);
	}

	/**
	 * Used to show short information toast message
	 * 
	 * @param msg
	 *            - Message to display
	 */
	public void showShortInfoToast(String msg) {
		txtToastMessage.setBackgroundColor(Color.parseColor(mContext
				.getString(R.color.bg_toast_info)));
		txtToastMessage.setText(msg);
		mHandler.removeCallbacks(mRunnable);
		txtToastMessage.setVisibility(View.VISIBLE);
		mDelay = Delays.SHORT;
		txtToastMessage.startAnimation(startAnimation);
	}

	/**
	 * Used to show long information toast message
	 * 
	 * @param msg
	 *            - Message to display
	 */
	public void showLongInfoToast(String msg) {
		txtToastMessage.setBackgroundColor(Color.parseColor(mContext
				.getString(R.color.bg_toast_info)));
		txtToastMessage.setText(msg);
		mHandler.removeCallbacks(mRunnable);
		txtToastMessage.setVisibility(View.VISIBLE);
		mDelay = Delays.LONG;
		txtToastMessage.startAnimation(startAnimation);
	}

	/**
	 * Used to show short error toast message
	 * 
	 * @param msg
	 *            - Message to display
	 */
	public void showShortErrorToast(String msg) {
		txtToastMessage.setBackgroundColor(Color.parseColor(mContext
				.getString(R.color.bg_toast_error)));
		txtToastMessage.setText(msg);
		mHandler.removeCallbacks(mRunnable);
		txtToastMessage.setVisibility(View.VISIBLE);
		mDelay = Delays.SHORT;
		txtToastMessage.startAnimation(startAnimation);
	}

	/**
	 * Used to show long error toast message.
	 * 
	 * @param msg
	 *            - Message to display
	 */
	public void showLongErrorToast(String msg) {
		txtToastMessage.setBackgroundColor(Color.parseColor(mContext
				.getString(R.color.bg_toast_error)));
		txtToastMessage.setText(msg);
		mHandler.removeCallbacks(mRunnable);
		txtToastMessage.setVisibility(View.VISIBLE);
		mDelay = Delays.LONG;
		txtToastMessage.startAnimation(startAnimation);
	}

	/**
	 * Used to hide toast message.
	 */
	public void hideToast() {
		txtToastMessage.setVisibility(View.GONE);
		mHandler.removeCallbacks(mRunnable);
	}

	/*** Animation Listener ***/
	@Override
	public void onAnimationEnd(Animation animation) {
		if (animation == startAnimation) {
			if (mDelay == Delays.LONG) {
				mHandler.postDelayed(mRunnable, LONG_DELAY);
			} else {
				mHandler.postDelayed(mRunnable, SHORT_DELAY);
			}
		} else if (animation == endAnimation) {
			txtToastMessage.setVisibility(View.GONE);
		}
	}

	@Override
	public void onAnimationRepeat(Animation animation) {

	}

	@Override
	public void onAnimationStart(Animation animation) {
		txtToastMessage.setVisibility(View.VISIBLE);
	}
}
