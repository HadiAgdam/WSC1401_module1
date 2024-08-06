package ir.hadiagdamapps.wsc1401_module1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class IntroFragment(private val image: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.intro_fragment_layout, container, false)

        view.findViewById<ImageView>(R.id.image).apply {
            setImageResource(image)
        }

        return view
    }


}