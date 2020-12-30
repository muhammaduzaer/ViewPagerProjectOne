package com.muhammaduzaer.viewpager2.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.makeramen.roundedimageview.RoundedImageView
import com.muhammaduzaer.viewpager2.R
import kotlinx.android.synthetic.main.fragment_slider_sample_two.*

class ViewPagerAdapterExampleTwo internal constructor(
    sliderItems: MutableList<SliderItem>,
    viewPager: ViewPager2
) : RecyclerView.Adapter<ViewPagerAdapterExampleTwo.ViewHolderExampleTwo>() {

    private val sliderItems: List<SliderItem>
    private val viewPager2: ViewPager2

    init {
        this.sliderItems = sliderItems
        this.viewPager2 = viewPager
    }

    class ViewHolderExampleTwo(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: RoundedImageView = itemView.findViewById(R.id.roundImageView)

        fun image(sliderItem: SliderItem) {
            imageView.setImageResource(sliderItem.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderExampleTwo {
        return ViewHolderExampleTwo(
        LayoutInflater.from(parent.context).inflate(
            R.layout.view_pager_item_two, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolderExampleTwo, position: Int) {
        holder.image(sliderItems[position])
        if (position == sliderItems.size - 2) {
            viewPager2.post(runnable)
        }

    }

    override fun getItemCount(): Int {
        return sliderItems.size
    }

    private val runnable = Runnable {
        sliderItems.addAll(sliderItems)
        notifyDataSetChanged()
    }
}