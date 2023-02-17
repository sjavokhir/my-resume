package uz.myid.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.myid.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            webView.setListener(this@MainActivity)

            onLifecycleObserver(
                onResume = { webView.onResume() },
                onPause = { webView.onPause() },
                onDestroy = { webView.onDestroy() }
            )

            webView.loadUrl()
        }
    }
}