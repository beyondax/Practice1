package com.sergej.balabanov.practice1;

import androidx.annotation.StringRes;

public enum Unit {

    SQ_CENTIMETRES(R.string.sq_centi, 0.0001, 10000.0),
    SQ_KILOMETRES(R.string.sq_kilo, 1000000.0, 0.000001),
    SQ_METRES(R.string.sq_metres, 1.0, 1.0),
    HECTARE(R.string.hectare, 10000.0, 0.0001);


    @StringRes
    public int mLabelResource;
    public double mConversionToBase;
    public double mConversionFromBase;

    Unit(int labelResource, double conversionToBase, double conversionFromBase) {
        this.mLabelResource = labelResource;
        this.mConversionToBase = conversionToBase;
        this.mConversionFromBase = conversionFromBase;
    }


    @StringRes
    public int getLabelResource() {
        return mLabelResource;
    }

    public double getConversionToBase() {
        return mConversionToBase;
    }

    public double getConversionFromBase() {
        return mConversionFromBase;
    }
}




