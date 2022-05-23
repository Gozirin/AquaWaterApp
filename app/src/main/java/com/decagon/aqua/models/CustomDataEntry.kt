package com.decagon.aqua.models

import com.anychart.chart.common.dataentry.ValueDataEntry

private class CustomDataEntry internal constructor(
    x: String?,
    value: Number?
) :
    ValueDataEntry(x, value)
