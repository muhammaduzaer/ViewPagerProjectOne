package com.muhammaduzaer.viewpager2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.muhammaduzaer.viewpager2.R
import com.muhammaduzaer.viewpager2.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_slider_sample_one.*


class SliderSampleOneFragment : Fragment() {


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
            R.drawable.image_one,
            R.drawable.image_two,
            R.drawable.image_three,
            R.drawable.image_four,
            R.drawable.image_five,
            R.drawable.image_six,
            R.drawable.image_seven
        )

        val adapter = ViewPagerAdapter(images)
        viewPager.adapter = adapter
    }

}