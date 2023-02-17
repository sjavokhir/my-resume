package uz.myid.sample

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import android.view.Gravity
import android.webkit.WebSettings
import android.widget.FrameLayout
import im.delight.android.webview.AdvancedWebView

class ResumeWebView : FrameLayout {

    private val webView by lazy {
        AdvancedWebView(context).apply {
            layoutParams = LayoutHelper.createFrame(
                context = context,
                width = LayoutHelper.MATCH_PARENT,
                height = LayoutHelper.MATCH_PARENT,
            )
        }
    }
    private val loadingView by lazy {
        LoadingView(context).apply {
            layoutParams = LayoutHelper.createFrame(
                context = context,
                width = LayoutHelper.MATCH_PARENT,
                height = LayoutHelper.WRAP_CONTENT,
                gravity = Gravity.CENTER
            )
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
        removeAllViews()
        addView(webView)
        addView(loadingView)

        configureWebView()
    }

    private fun configureWebView() {
        with(webView) {
            isLongClickable = false
            isHapticFeedbackEnabled = false
            setDesktopMode(true)
            setBrowserSettings()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun AdvancedWebView.setBrowserSettings() {
        settings.setSupportZoom(true)
        settings.displayZoomControls = false
        settings.javaScriptEnabled = true
        settings.cacheMode = WebSettings.LOAD_DEFAULT
        settings.databaseEnabled = true
        settings.domStorageEnabled = true
        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true
        @Suppress("DEPRECATION")
        settings.pluginState = WebSettings.PluginState.ON
    }

    fun setListener(activity: MainActivity) {
        webView.setListener(activity, object : AdvancedWebView.Listener {
            override fun onPageStarted(url: String?, favicon: Bitmap?) {
                loadingView.onLoading()
            }

            override fun onPageFinished(url: String?) {
                loadingView.onGone()
            }

            override fun onPageError(errorCode: Int, description: String?, failingUrl: String?) {
                loadingView.onError(description.orEmpty())
            }

            override fun onDownloadRequested(
                url: String?,
                suggestedFilename: String?,
                mimeType: String?,
                contentLength: Long,
                contentDisposition: String?,
                userAgent: String?
            ) {
            }

            override fun onExternalPageRequest(url: String?) {
            }
        })
    }

    fun onResume() {
        webView.onResume()
    }

    fun onPause() {
        webView.onPause()
    }

    fun onDestroy() {
        webView.onDestroy()
    }

    fun loadUrl() {
        tryCatch {
            webView.loadUrl("https://javokhirsavriev.github.io/")
        }
    }
}