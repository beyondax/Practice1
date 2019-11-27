package com.sergej.balabanov.practice1;

import androidx.annotation.StringRes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.sergej.balabanov.practice1.Unit.HECTARE;
import static com.sergej.balabanov.practice1.Unit.SQ_CENTIMETRES;
import static com.sergej.balabanov.practice1.Unit.SQ_KILOMETRES;
import static com.sergej.balabanov.practice1.Unit.SQ_METRES;

public enum Conversion {

    AREA(R.string.square, Arrays.asList(SQ_CENTIMETRES, SQ_KILOMETRES, SQ_METRES, HECTARE)),
    CURRENCY(R.string.currency, Collections.<Unit>emptyList()),
    STORAGE(R.string.storage, Collections.<Unit>emptyList()),
    TEMPERATURE(R.string.temperature, Collections.<Unit>emptyList()),
    VOLUME(R.string.volume, Collections.<Unit>emptyList()),
    WEIGHT(R.string.weight, Collections.<Unit>emptyList()),
    TIME(R.string.time, Collections.<Unit>emptyList()),
    MASS(R.string.energy, Collections.<Unit>emptyList()),
    SPEED(R.string.speed, Collections.<Unit>emptyList()),
    ENERGY(R.string.energy, Collections.<Unit>emptyList()),
    POWER(R.string.power, Collections.<Unit>emptyList());



    @StringRes
    public final int mLabelRes;
    public final List<Unit> mUnits;

    Conversion(int labelRes, List<Unit> units) {
        mLabelRes = labelRes;
        mUnits = units;
    }

}

