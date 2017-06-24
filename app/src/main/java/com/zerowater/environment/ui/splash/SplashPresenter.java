package com.zerowater.environment.ui.splash;

import com.zerowater.environment.data.DataManager;
import com.zerowater.environment.data.model.AccessTokenData;
import com.zerowater.environment.data.model.AccessTokenResponse;
import com.zerowater.environment.ui.base.BasePresenter;
import com.zerowater.environment.util.AESUtil;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class SplashPresenter extends BasePresenter<SplashMvpView> {

    private final DataManager mDataManager;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Inject
    public SplashPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mCompositeDisposable != null) mCompositeDisposable.dispose();
    }

    public void getAccessToken() {
     mDataManager.getAccessToken()
                .map(accessTokenResponse -> decryptClientId(accessTokenResponse))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(String s) {
                        Timber.i("onNext : " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e("Error getAccessToken out: " + e);
                        e.printStackTrace();
                    }
                });
    }

    private String decryptClientId(AccessTokenResponse accessTokenResponse) {
        AccessTokenData data = accessTokenResponse.getData();
        String clientId = null;
        try {
            clientId = AESUtil.decrypt(data.getClientId());
            mDataManager.putClientId(clientId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientId;
    }
}
