package com.example.travelapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.travelapp.R
import com.example.travelapp.data.Attraction
import com.example.travelapp.databinding.ViewHolderAttractionBinding
import com.squareup.picasso.Picasso

class HomeFragmentAdapter(
    private val onClickedCallBack: () -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val attractions = ArrayList<Attraction>()

    inner class AttractionViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_attraction, parent, false)
    ) {
        private val binding = ViewHolderAttractionBinding.bind(itemView)

        fun onBind(attraction: Attraction, onClick: () -> Unit) {
            with(binding) {
                tvTitle.text = attraction.title
                val picasso = Picasso.get()
                picasso.isLoggingEnabled = true
                picasso.load(attraction.imageUrls?.get(3)).into(imgAttraction)

                tvMonthsToVisit.text = attraction.monthsToVisit
                imgGoDetails.setOnClickListener {
                    onClick()
                }
            }
        }
    }

    fun setData(attractions: ArrayList<Attraction>) {
        this.attractions.clear()
        this.attractions.addAll(attractions)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AttractionViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AttractionViewHolder).onBind(attractions[position], onClickedCallBack)
    }

    override fun getItemCount() = attractions.size
}