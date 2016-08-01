package com.global.yap.environment.ui.splash;

import com.global.yap.environment.data.DataManager;
import com.global.yap.environment.data.model.AccessTokenData;
import com.global.yap.environment.data.model.AccessTokenResponse;
import com.global.yap.environment.ui.base.Presenter;
import com.global.yap.environment.util.AESUtil;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class SplashPresenter implements Presenter<SplashMvpView> {

    private final DataManager mDataManager;
    private SplashMvpView mMvpView;
    private Subscription mSubscription;

    @Inject
    public SplashPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(SplashMvpView mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
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
