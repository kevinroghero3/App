package com.henninghall.date_picker.wheelFunctions;

import com.henninghall.date_picker.wheels.Wheel;

/* JADX INFO: loaded from: classes6.dex */
public class Hide implements WheelFunction {
    @Override // com.henninghall.date_picker.wheelFunctions.WheelFunction
    public void apply(Wheel wheel) {
        wheel.picker.setVisibility(8);
    }
}
