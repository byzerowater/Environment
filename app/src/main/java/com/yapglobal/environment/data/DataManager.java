package com.yapglobal.environment.data;

import com.yapglobal.environment.data.remote.EnvironmentService;

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

    private final EnvironmentService mEnvironmentService;

    @Inject
    public DataManager(EnvironmentService environmentService) {
        mEnvironmentService = environmentService;
    }

//    public Single<List<Shot>> getShots(int perPage, int page) {
//        return mEnvironmentService.getShots(BuildConfig.DRIBBBLE_ACCESS_TOKEN, perPage, page);
//    }
//
//    public Single<List<Comment>> getComments(int id, int perPage, int page) {
//        return mEnvironmentService.getComments(id, BuildConfig.DRIBBBLE_ACCESS_TOKEN, perPage, page);
//    }
}