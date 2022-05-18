package com.decagon.aqua.feature.consumer.ui.consumptionFragments.snackbar

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.decagon.aqua.R
import com.google.android.material.snackbar.BaseTransientBottomBar

class CustomSnackbar(
    parent: ViewGroup,
    content: CustomSnackBarView
) : BaseTransientBottomBar<CustomSnackbar>(parent, content, content) {

    init {
        getView().setBackgroundColor(
            ContextCompat.getColor(
                view.context,
                android.R.color.transparent
            )
        )
        getView().setPadding(0, 0, 0, 0)
    }

    companion object {

        fun make(viewGroup: ViewGroup): CustomSnackbar {
            val customView = LayoutInflater.from(viewGroup.context).inflate(
                R.layout.layout_custom_snackbar,
                viewGroup,
                false
            ) as CustomSnackBarView

            customView.findViewById<TextView>(R.id.success_msg_tv).text = "Successfully added to Cart"

            return CustomSnackbar(viewGroup, customView)
        }
    }
}
