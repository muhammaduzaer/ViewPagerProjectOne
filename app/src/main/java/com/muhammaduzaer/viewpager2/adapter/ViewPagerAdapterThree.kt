package com.muhammaduzaer.viewpager2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.muhammaduzaer.viewpager2.R
import org.w3c.dom.Text

class ViewPagerAdapterThree(
    private var image: List<Int>,
    private var title: List<String>,
    private var about: List<String>
) : RecyclerView.Adapter<ViewPagerAdapterThree.ViewHolderThree>() {
    inner class ViewHolderThree(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemImage: ImageView = itemView.findViewById(R.id.imageView)
        val itemTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val itemAbout: TextView = itemView.findViewById(R.id.textViewAbout)

        init {
            itemImage.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "You clicked on item #${position + 1}", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderThree {
        return ViewHolderThree(
            LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item_three, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderThree, position: Int) {
        holder.itemImage.setImageResource(image[position])
        holder.itemTitle.text = title[position]
        holder.itemAbout.text = about[position]
    }

    override fun getItemCount(): Int {
        return title.size
    }
}