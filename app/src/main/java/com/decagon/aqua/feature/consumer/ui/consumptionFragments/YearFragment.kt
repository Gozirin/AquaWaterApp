package com.decagon.aqua.feature.consumer.ui.consumptionFragments

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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YearFragment : Fragment() {

    private var chart: AnyChartView? = null
    private val consumptionLevel = listOf<Double>(51.22, 11.23, 34.12, 36.92)
    private val years = listOf<String>("Year1", "Year2", "Year3", "Year4")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.year_consumption_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chart = requireView().findViewById(R.id.chart1)
        configChart()
    }

    private fun configChart() {
        val pie: Pie = AnyChart.pie()
        val dataChart: MutableList<DataEntry> = mutableListOf()

        for (index in consumptionLevel.indices) {
            dataChart.add(ValueDataEntry(years.elementAt(index), consumptionLevel.elementAt(index)))
        }
        pie.data(dataChart)
        pie.title("12 Tuesday 2022")
        chart?.setChart(pie)
    }

}
