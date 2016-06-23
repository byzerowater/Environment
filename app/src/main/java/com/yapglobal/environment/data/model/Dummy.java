package com.yapglobal.environment.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by YoungSoo Kim on 2016-06-23.
 * company Ltd
 * youngsoo.kim@yap.net
 * 더미 데이터
 */
public class Dummy implements Parcelable {

    public String dummy = null;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.dummy);
    }

    public Dummy() {
    }

    protected Dummy(Parcel in) {
        this.dummy = in.readString();
    }

    public static final Parcelable.Creator<Dummy> CREATOR = new Parcelable.Creator<Dummy>() {
        @Override
        public Dummy createFromParcel(Parcel source) {
            return new Dummy(source);
        }

        @Override
        public Dummy[] newArray(int size) {
            return new Dummy[size];
        }
    };
}
