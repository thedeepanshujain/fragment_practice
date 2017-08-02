package com.example.deepanshu.learnfragments;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by deepanshu on 2/8/17.
 */

public class Course implements Serializable{

    @SerializedName("id")
    private int mId;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("name")
    private String mName;

    @SerializedName("is_active")
    private boolean mIsActive;

    @SerializedName("overview")
    private String mOverview;

    @SerializedName("fee_with_taxes")
    private double mFeeWithTaxes;

    public Course(int id, String title, String name, boolean isActive, String overview, int feeWithTaxes) {
        this.mId = id;
        this.mTitle = title;
        this.mName = name;
        this.mIsActive = isActive;
        this.mOverview = overview;
        this.mFeeWithTaxes = feeWithTaxes;
    }


    public String getTitle() {
        return mTitle;
    }

    public String getName() {
        return mName;
    }


    public boolean isIsActive() {
        return mIsActive;
    }

    public String getOverview() {
        return mOverview;
    }

    public double getFeeWithTaxes() {
        return mFeeWithTaxes;
    }

    public int getId() {
        return mId;
    }
}
