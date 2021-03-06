package com.zerowater.environment.data;

import com.zerowater.environment.data.local.PreferencesHelper;
import com.zerowater.environment.data.model.AccessTokenResponse;
import com.zerowater.environment.data.remote.EventPosterHelper;
import com.zerowater.environment.data.remote.NetworkService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by YoungSoo Kim on 2016-06-23.
 * company Ltd
 * youngsoo.kim@yap.net
 * 데이터 매니져 데이터 접근 및 관리
 */
@Singleton
public class DataManager {

    private final NetworkService mNetworkService;
    private final PreferencesHelper mPreferencesHelper;
    private final EventPosterHelper mEventPoster;

    @Inject
    public DataManager(NetworkService networkService,
                       PreferencesHelper preferencesHelper,
                       EventPosterHelper eventPoster) {
        mNetworkService = networkService;
        mPreferencesHelper = preferencesHelper;
        mEventPoster = eventPoster;
    }

    public void putClientId(String clientId) {
        mPreferencesHelper.putClientId(clientId);
    }

    public Single<AccessTokenResponse> getAccessToken() {
        return mNetworkService.getAccessToken();
    }

//    public Single<List<Shot>> getShots(int perPage, int page) {
//        return mEnvironmentService.getShots(BuildConfig.DRIBBBLE_ACCESS_TOKEN, perPage, page);
//    }
//
//    public Single<List<Comment>> getComments(int id, int perPage, int page) {
//        return mEnvironmentService.getComments(id, BuildConfig.DRIBBBLE_ACCESS_TOKEN, perPage, page);
//    }
}