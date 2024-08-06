package ir.hadiagdamapps.wsc1401_module1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class IntroPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int) = IntroFragment(
        when (position) {
            0 -> R.drawable.pager1
            1 -> R.drawable.pager2
            2 -> R.drawable.pager3
            else -> -1
        }
    )

}