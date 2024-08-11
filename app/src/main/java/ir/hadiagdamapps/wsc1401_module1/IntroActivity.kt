package ir.hadiagdamapps.wsc1401_module1

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class IntroActivity : AppCompatActivity() {

    private val pager: ViewPager2 by lazy { findViewById(R.id.pager) }
    private val nextButton: View by lazy { findViewById(R.id.nextButtonMotionLayout) }
    private val textMotionLayout: MotionLayout by lazy { findViewById(R.id.textMotionLayout) }
    private val nextButtonMotionLayout: MotionLayout by lazy { findViewById(R.id.nextButtonMotionLayout) }
    private val tabLayout: TabLayout by lazy { findViewById(R.id.indicator) }
    private val skipButton: View by lazy { findViewById(R.id.skipButton) }

    private val duration: Int = 300

    private fun end() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_intro)

        val adapter = IntroPagerAdapter(supportFragmentManager, lifecycle)
        pager.adapter = adapter
        TabLayoutMediator(tabLayout, pager) { _, _ ->
        }.attach()

        val textMotionLayout: MotionLayout = findViewById(R.id.textMotionLayout)

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

                nextButtonMotionLayout.transitionToState(
                    when (position) {
                        0, 1 -> R.id.nextButtonState1
                        2 -> R.id.nextButtonState2
                        else -> 0
                    }, duration
                )

            }
        })

        nextButton.setOnClickListener {
            if (pager.currentItem < 2)
                pager.currentItem++
            else
                end()
        }

        skipButton.setOnClickListener {
            end()
        }
    }
}