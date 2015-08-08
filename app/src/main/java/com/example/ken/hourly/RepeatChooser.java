package com.example.ken.hourly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RepeatChooser extends Activity {
	private RadioGroup mRadioGroup;
	private RadioButton mRadioBtnRptHourly, mRadioBtnRptMinutely;
    private RadioButton mRadioBtnRptHalfHourly, mRadioBtnRptQuarterHourly;
    private RadioButton mRadioBtnRptTenMinutely, mRadioBtnRptFiveMinutely;

	private Button.OnClickListener mOkOnClick = new Button.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent i = new Intent();
			i.putExtra(AlarmItem.KEY_RPT_HOURLY,  mRadioBtnRptHourly.isChecked());
            i.putExtra(AlarmItem.KEY_RPT_HALFHOURLY, mRadioBtnRptHalfHourly.isChecked());
            i.putExtra(AlarmItem.KEY_RPT_QUARTERHOURLY, mRadioBtnRptQuarterHourly.isChecked());
            i.putExtra(AlarmItem.KEY_RPT_TENMINUTELY, mRadioBtnRptTenMinutely.isChecked());
            i.putExtra(AlarmItem.KEY_RPT_FIVEMINUTELY, mRadioBtnRptFiveMinutely.isChecked());
            i.putExtra(AlarmItem.KEY_RPT_MINUTELY, mRadioBtnRptMinutely.isChecked());
			setResult(Activity.RESULT_OK, i);
			finish();
		}
		
	};
	private Button.OnClickListener mCancelOnClick = new Button.OnClickListener() {

		@Override
		public void onClick(View v) {
			setResult(Activity.RESULT_CANCELED);
			finish();
		}
		
	};

    private View.OnClickListener mRptHourlyOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            mRadioGroup.check(R.id.sr_chk_rpt_hourly);
        }
    };

    private View.OnClickListener mRptHalfHourlyOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            mRadioGroup.check(R.id.sr_chk_rpt_halfhourly);
        }
    };

    private View.OnClickListener mRptQuarterHourlyOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            mRadioGroup.check(R.id.sr_chk_rpt_quarterhourly);
        }
    };


    private View.OnClickListener mRptTenMinutelyOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            mRadioGroup.check(R.id.sr_chk_rpt_tenminutely);
        }
    };

    private View.OnClickListener mRptFiveMinutelyOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            mRadioGroup.check(R.id.sr_chk_rpt_fiveminutely);
        }
    };

    private View.OnClickListener mRptMinutelyOnClick = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			mRadioGroup.check(R.id.sr_chk_rpt_minutely);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.repeat_chooser);
		setTitle("Alarm Repeats...");

		mRadioGroup = (RadioGroup)findViewById(R.id.rgGroup1);

		mRadioBtnRptHourly     = (RadioButton)findViewById(R.id.sr_chk_rpt_hourly);
        mRadioBtnRptHalfHourly = (RadioButton)findViewById(R.id.sr_chk_rpt_halfhourly);
        mRadioBtnRptQuarterHourly = (RadioButton)findViewById(R.id.sr_chk_rpt_quarterhourly);
        mRadioBtnRptTenMinutely = (RadioButton)findViewById(R.id.sr_chk_rpt_tenminutely);
        mRadioBtnRptFiveMinutely = (RadioButton)findViewById(R.id.sr_chk_rpt_fiveminutely);
        mRadioBtnRptMinutely   = (RadioButton)findViewById(R.id.sr_chk_rpt_minutely);

        findViewById(R.id.sr_chk_rpt_hourly).setOnClickListener(mRptHourlyOnClick);
        findViewById(R.id.sr_chk_rpt_halfhourly).setOnClickListener(mRptHalfHourlyOnClick);
        findViewById(R.id.sr_chk_rpt_quarterhourly).setOnClickListener(mRptQuarterHourlyOnClick);
        findViewById(R.id.sr_chk_rpt_tenminutely).setOnClickListener(mRptTenMinutelyOnClick);
        findViewById(R.id.sr_chk_rpt_fiveminutely).setOnClickListener(mRptFiveMinutelyOnClick);
        findViewById(R.id.sr_chk_rpt_minutely).setOnClickListener(mRptMinutelyOnClick);

		findViewById(R.id.sr_btn_ok).setOnClickListener(mOkOnClick);
		findViewById(R.id.sr_btn_cancel).setOnClickListener(mCancelOnClick);
		
		Bundle b = getIntent().getExtras();
        mRadioBtnRptHourly.setChecked(b.getBoolean(AlarmItem.KEY_RPT_HOURLY, true));
        mRadioBtnRptHalfHourly.setChecked(b.getBoolean(AlarmItem.KEY_RPT_HALFHOURLY, false));
        mRadioBtnRptQuarterHourly.setChecked(b.getBoolean(AlarmItem.KEY_RPT_QUARTERHOURLY, false));
        mRadioBtnRptTenMinutely.setChecked(b.getBoolean(AlarmItem.KEY_RPT_TENMINUTELY, false));
        mRadioBtnRptFiveMinutely.setChecked(b.getBoolean(AlarmItem.KEY_RPT_FIVEMINUTELY, false));
        mRadioBtnRptMinutely.setChecked(b.getBoolean(AlarmItem.KEY_RPT_MINUTELY, false));
	}

}
