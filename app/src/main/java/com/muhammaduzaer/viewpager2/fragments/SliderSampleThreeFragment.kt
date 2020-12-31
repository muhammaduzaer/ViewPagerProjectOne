package com.muhammaduzaer.viewpager2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.muhammaduzaer.viewpager2.R
import com.muhammaduzaer.viewpager2.adapter.ViewPagerAdapterThree
import kotlinx.android.synthetic.main.fragment_slider_sample_three.*


class SliderSampleThreeFragment : Fragment() {

    private var imageList = mutableListOf<Int>()
    private var titleList = mutableListOf<String>()
    private var aboutList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slider_sample_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postToList()

        viewPagerExampleThree.adapter = ViewPagerAdapterThree(imageList, titleList, aboutList)
        viewPagerExampleThree.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        circularIndicator.setViewPager(viewPagerExampleThree)

    }

    private fun addToList(title: String, about: String, image: Int) {
        titleList.add(title)
        aboutList.add(about)
        imageList.add(image)
    }

    private fun postToList() {
        for (i: Int in 1..5) {
            addToList("Title $i", "Description $i", R.mipmap.ic_launcher_round)
        }
    }
}