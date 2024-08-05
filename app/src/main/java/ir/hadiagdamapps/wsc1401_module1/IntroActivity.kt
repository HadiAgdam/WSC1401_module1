package ir.hadiagdamapps.wsc1401_module1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback

class IntroActivity : AppCompatActivity() {

    private val pager: ViewPager2 by lazy { findViewById(R.id.pager) }
    private val duration: Int = 300

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val adapter = IntroPagerAdapter(supportFragmentManager, lifecycle)
        pager.adapter = adapter

        val textMotionLayout: MotionLayout = findViewById(R.id.textMotionLayout)
//        textMotionLayout.transitionToState(R.id.textContainerState1)

        pager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.e("position", position.toString())

                textMotionLayout.transitionToState(
                    when (position) {

                        0 -> R.id.textState1
                        1 -> R.id.textState2
                        2 -> R.id.textState3

                        else -> 0
                    }, duration
                )
            }
        })
    }
}