package com.global.yap.environment.data;

import com.global.yap.environment.data.remote.NetworkService;
import com.global.yap.environment.data.remote.EventPosterHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by YoungSoo Kim on 2016-06-23.
 * company Ltd
 * youngsoo.kim@yap.net
 * 데이터 매니져 데이터 접근 및 관리
 */
@Singleton
public class DataManager {

    private final NetworkService mNetworkService;
    private final EventPosterHelper mEventPoster;

    @Inject
    public DataManager(NetworkService networkService,
                       EventPosterHelper eventPoster) {
        mNetworkService = networkService;
        mEventPoster = eventPoster;
    }

//    public Single<List<Shot>> getShots(int perPage, int page) {
//        return mEnvironmentService.getShots(BuildConfig.DRIBBBLE_ACCESS_TOKEN, perPage, page);
//    }
//
//    public Single<List<Comment>> getComments(int id, int perPage, int page) {
//        return mEnvironmentService.getComments(id, BuildConfig.DRIBBBLE_ACCESS_TOKEN, perPage, page);
//    }
}