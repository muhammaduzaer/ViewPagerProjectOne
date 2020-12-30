package com.muhammaduzaer.viewpager2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muhammaduzaer.viewpager2.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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