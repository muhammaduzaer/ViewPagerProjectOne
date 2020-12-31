package com.muhammaduzaer.viewpager2.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.muhammaduzaer.viewpager2.R
import com.muhammaduzaer.viewpager2.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_slider_sample_one.*
import kotlinx.android.synthetic.main.fragment_slider_sample_two.*


class SliderSampleOneFragment : Fragment() {

    private val sliderHandler = Handler()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slider_sample_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val images = listOf(
            R.drawable.helpers_ad_one,
            R.drawable.helpers_ad_two,
            R.drawable.helpers_ad_three,
//            R.drawable.image_four,
//            R.drawable.image_five,
//            R.drawable.image_six,
//            R.drawable.image_seven
        )

        val adapter = ViewPagerAdapter(images)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000)
            }
        })
    }

    private val sliderRunnable = Runnable {
        viewPager.currentItem = viewPager.currentItem + 1
    }

}