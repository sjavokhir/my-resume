package uz.myid.sample

import android.content.Context
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout

object LayoutHelper {

    const val MATCH_PARENT = -1
    const val WRAP_CONTENT = -2

    private fun getSize(context: Context, size: Int): Int {
        return if (size < 0) size else context.px(size)
    }

    fun createConstraint(
        context: Context,
        width: Int,
        height: Int,
        ratio: String? = null,
        leftMargin: Int = 0,
        topMargin: Int = 0,
        rightMargin: Int = 0,
        bottomMargin: Int = 0
    ): ConstraintLayout.LayoutParams {
        val layoutParams = ConstraintLayout.LayoutParams(
            getSize(context, width),
            getSize(context, height)
        )
        layoutParams.dimensionRatio = ratio
        layoutParams.setMargins(
            context.px(leftMargin),
            context.px(topMargin),
            context.px(rightMargin),
            context.px(bottomMargin)
        )
        return layoutParams
    }

    fun createFrame(
        context: Context,
        width: Int,
        height: Int
    ): FrameLayout.LayoutParams {
        return FrameLayout.LayoutParams(
            getSize(context, width),
            getSize(context, height)
        )
    }

    fun createFrame(
        context: Context,
        width: Int,
        height: Int,
        gravity: Int
    ): FrameLayout.LayoutParams {
        return FrameLayout.LayoutParams(
            getSize(context, width),
            getSize(context, height),
            gravity
        )
    }

    fun createLinear(
        context: Context,
        width: Int,
        height: Int,
        leftMargin: Int = 0,
        topMargin: Int = 0,
        rightMargin: Int = 0,
        bottomMargin: Int = 0
    ): LinearLayout.LayoutParams {
        val layoutParams = LinearLayout.LayoutParams(
            getSize(context, width),
            getSize(context, height)
        )
        layoutParams.setMargins(
            context.px(leftMargin),
            context.px(topMargin),
            context.px(rightMargin),
            context.px(bottomMargin)
        )
        return layoutParams
    }

    fun createLinear(
        context: Context,
        width: Int,
        height: Int,
        weight: Float,
        leftMargin: Int = 0,
        topMargin: Int = 0,
        rightMargin: Int = 0,
        bottomMargin: Int = 0
    ): LinearLayout.LayoutParams {
        val layoutParams = LinearLayout.LayoutParams(
            getSize(context, width),
            getSize(context, height),
            weight
        )
        layoutParams.setMargins(
            context.px(leftMargin),
            context.px(topMargin),
            context.px(rightMargin),
            context.px(bottomMargin)
        )
        return layoutParams
    }

    fun createFlexbox(
        context: Context,
        width: Int,
        height: Int,
        leftMargin: Int = 0,
        topMargin: Int = 0,
        rightMargin: Int = 0,
        bottomMargin: Int = 0
    ): LinearLayout.LayoutParams {
        val layoutParams = LinearLayout.LayoutParams(
            getSize(context, width),
            getSize(context, height)
        )
        layoutParams.setMargins(
            context.px(leftMargin),
            context.px(topMargin),
            context.px(rightMargin),
            context.px(bottomMargin)
        )
        return layoutParams
    }
}
