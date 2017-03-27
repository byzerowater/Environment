package com.zerowater.environment.ui.splash;

import com.zerowater.environment.data.DataManager;
import com.zerowater.environment.data.model.AccessTokenData;
import com.zerowater.environment.data.model.AccessTokenResponse;
import com.zerowater.environment.ui.base.BasePresenter;
import com.zerowater.environment.util.AESUtil;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class SplashPresenter extends BasePresenter<SplashMvpView> {

    private final DataManager mDataManager;
    private Subscription mSubscription;

    @Inject
    public SplashPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void getAccessToken() {
        mSubscription = mDataManager.getAccessToken()
                .map(accessTokenResponse -> decryptClientId(accessTokenResponse))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Timber.d("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.d("onError");
                        Timber.e("Error getAccessToken out: " + e);
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(String clientId) {
                        Timber.i("onNext : " + clientId);
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
