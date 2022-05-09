package com.decagon.aqua.feature.consumer.home.consumptionFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Pie
import com.decagon.aqua.R

class DayFragment : Fragment() {

    private var chart: AnyChartView? = null
    private val consumptionLevel = listOf<Double>(21.34, 35.59, 51.22, 38.67, 48.82, 20.94, 42.93)
    private val days = listOf<String>("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chart = requireView().findViewById(R.id.consumptionChart)
        configChart()
    }

    private fun configChart() {
        val pie: Pie = AnyChart.pie()
        val dataChart: MutableList<DataEntry> = mutableListOf()

        for (index in consumptionLevel.indices) {
            dataChart.add(ValueDataEntry(days.elementAt(index), consumptionLevel.elementAt(index)))
        }
        pie.data(dataChart)
        pie.title("12 Tuesday 2022")
        chart?.setChart(pie)
    }
}
