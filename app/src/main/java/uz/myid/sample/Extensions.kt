package uz.myid.sample

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

fun AppCompatActivity.onLifecycleObserver(
    onStart: () -> Unit = {},
    onResume: () -> Unit = {},
    onPause: () -> Unit = {},
    onStop: () -> Unit = {},
    onDestroy: () -> Unit = {},
) {
    lifecycle.addObserver(object : DefaultLifecycleObserver {
        override fun onStart(owner: LifecycleOwner) {
            onStart()
        }

        override fun onResume(owner: LifecycleOwner) {
            onResume()
        }

        override fun onPause(owner: LifecycleOwner) {
            onPause()
        }

        override fun onStop(owner: LifecycleOwner) {
            onStop()
        }

        override fun onDestroy(owner: LifecycleOwner) {
            onDestroy()
        }
    })
}

fun tryCatch(onTryAction: () -> Unit) {
    try {
        onTryAction()
    } catch (_: Throwable) {
    }
}

fun Context.px(dp: Int) = (dp * resources.displayMetrics.density).toInt()

fun Context.color(color: Int) = ContextCompat.getColor(this, color)

fun Context.colorStateList(color: Int) = ContextCompat.getColorStateList(this, color)

fun TextView.textColor(@ColorRes color: Int) = setTextColor(context.color(color))

fun View.beVisible() {
    isVisible = true
}

fun View.beGone() {
    isGone = true
}