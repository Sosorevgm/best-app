package com.sosorevgm.best_app.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sosorevgm.best_app.R
import com.sosorevgm.best_app.models.Price

class PriceAdapter : ListAdapter<Price, PriceViewHolder>(PriceDiff()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PriceViewHolder {
        return PriceViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_price, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PriceViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PriceViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(price: Price) {
        view.findViewById<TextView>(R.id.tv_price).text =
            "${price.bpi.usd.rate}${price.bpi.usd.symbol}"
        view.findViewById<TextView>(R.id.tv_time).text = price.time.updated
    }
}

class PriceDiff() : DiffUtil.ItemCallback<Price>() {
    override fun areItemsTheSame(oldItem: Price, newItem: Price): Boolean =
        oldItem.bpi.usd.rate == newItem.bpi.usd.rate

    override fun areContentsTheSame(oldItem: Price, newItem: Price): Boolean = oldItem == newItem
}
