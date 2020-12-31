package com.muhammaduzaer.viewpager2.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.muhammaduzaer.viewpager2.R
import com.muhammaduzaer.viewpager2.adapter.SliderItem
import com.muhammaduzaer.viewpager2.adapter.ViewPagerAdapterExampleTwo
import kotlinx.android.synthetic.main.fragment_slider_sample_one.*
import kotlinx.android.synthetic.main.fragment_slider_sample_two.*
import kotlin.math.abs


class SliderSampleTwoFragment : Fragment() {

    private val sliderHandler = Handler()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slider_sample_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        slider()
    }

    private fun slider() {

        val sliderRunnable = Runnable {
            viewPagerExampleTwo.currentItem = viewPagerExampleTwo.currentItem + 1
        }

        val sliderItems: MutableList<SliderItem> = ArrayList()
        sliderItems.add(SliderItem(R.drawable.helpers_ad_one))
        sliderItems.add(SliderItem(R.drawable.helpers_ad_two))
        sliderItems.add(SliderItem(R.drawable.helpers_ad_three))
//        sliderItems.add(SliderItem(R.drawable.image_four))
//        sliderItems.add(SliderItem(R.drawable.image_five))

        viewPagerExampleTwo.adapter = ViewPagerAdapterExampleTwo(sliderItems, viewPagerExampleTwo)

        viewPagerExampleTwo.clipToPadding = false
        viewPagerExampleTwo.clipChildren = false
        viewPagerExampleTwo.offscreenPageLimit = 3
        viewPagerExampleTwo.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer{ page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.25f
        }

        viewPagerExampleTwo.setPageTransformer(compositePageTransformer)

        viewPagerExampleTwo.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000)
            }
        })

    }

}