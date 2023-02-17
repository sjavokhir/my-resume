package uz.myid.sample

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.view.setPadding
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.R as materialRes

class LoadingView : FrameLayout {

    private val indicator: CircularProgressIndicator by lazy {
        CircularProgressIndicator(context).apply {
            layoutParams = LayoutHelper.createFrame(
                context = context,
                width = LayoutHelper.WRAP_CONTENT,
                height = LayoutHelper.WRAP_CONTENT,
                gravity = Gravity.CENTER
            )
            isIndeterminate = true
            indeterminateTintList = context.colorStateList(R.color.green)
            indicatorSize = context.px(48)
            trackCornerRadius = context.px(48)
            trackThickness = context.px(4)
            beGone()
        }
    }

    private val tvMessage: TextView by lazy {
        TextView(context).apply {
            layoutParams = LayoutHelper.createFrame(
                context = context,
                width = LayoutHelper.WRAP_CONTENT,
                height = LayoutHelper.WRAP_CONTENT,
                gravity = Gravity.CENTER
            )
            gravity = Gravity.CENTER_HORIZONTAL
            setTextAppearance(materialRes.style.TextAppearance_Material3_TitleLarge)
            textColor(R.color.black)
            beGone()
        }
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        setPadding(context.px(16))

        removeAllViews()
        addView(indicator)
        addView(tvMessage)

        onGone()
    }

    fun onLoading() {
        beVisible()
        tvMessage.beGone()
        indicator.beVisible()
    }

    fun onError(message: String) {
        beVisible()
        indicator.beGone()
        tvMessage.text = message
        tvMessage.beVisible()
    }

    fun onGone() {
        beGone()
        indicator.beGone()
        tvMessage.beGone()
    }
}