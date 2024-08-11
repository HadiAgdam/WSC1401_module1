package ir.hadiagdamapps.wsc1401_module1

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {

    private val maleGenderView: ImageView by lazy { findViewById(R.id.maleGenderView) }
    private val maleGenderCheck: ImageView by lazy { findViewById(R.id.maleCheckedIcon) }

    private val femaleGenderView: ImageView by lazy { findViewById(R.id.femaleGenderView) }
    private val femaleGenderCheck: ImageView by lazy { findViewById(R.id.femaleCheckedIcon) }

    private val mainMotionLayout: MotionLayout by lazy { findViewById(R.id.main) }

    private val nextButton: MotionLayout by lazy { findViewById(R.id.nextButtonMotionLayout) }

    private var current = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        Handler().postDelayed({
            mainMotionLayout.transitionToState(R.id.nameAgeGenderMotionSet)

        }, 1000)

        maleGenderView.setOnClickListener {
            maleGenderCheck.visibility = View.VISIBLE
            maleGenderView.setBackgroundResource(R.drawable.selected_input_background)

            femaleGenderCheck.visibility = View.INVISIBLE
            femaleGenderView.setBackgroundResource(R.drawable.unselected_input_background)
        }

        femaleGenderView.setOnClickListener {
            femaleGenderCheck.visibility = View.VISIBLE
            femaleGenderView.setBackgroundResource(R.drawable.selected_input_background)

            maleGenderCheck.visibility = View.INVISIBLE
            maleGenderView.setBackgroundResource(R.drawable.unselected_input_background)
        }


        nextButton.setOnClickListener {
            current++
            when (current) {
                1 -> mainMotionLayout.transitionToState(R.id.heightWeightMotionSet)

                2 -> {mainMotionLayout.transitionToState(R.id.bmiRateMotionSet); nextButton.transitionToState(R.id.nextButtonState2)}


            }
        }

    }
}