package iori.model.activity;

import android.widget.TextView;

import butterknife.InjectView;
import iori.model.R;
import iori.model.activity.base.BaseActivity;
import iori.model.net.NetworkAPI;
import iori.model.net.NetworkConnectListener;
import iori.model.net.response.CheckVersionResponse;

public class MainActivity extends BaseActivity implements NetworkConnectListener {

	@InjectView(R.id.result)
	TextView result;

	@Override
	protected int setContentViewResId() {
		return R.layout.main;
	}

	@Override
	protected void initView() {
		setBackAction();
	}

	@Override
	protected void initData() {
		NetworkAPI.getNetworkAPI().checkVersion("1", 0, null, this);
	}

	@Override
	public void onRequestSucceed(Object data, String requestAction, int requestMark) {
		result.setText(((CheckVersionResponse)data).toString());
	}

	@Override
	public void onRequestFailure(int error, String errorMsg, String requestAction, int requestMark) {
		result.setText("error message : " + errorMsg);
	}
}