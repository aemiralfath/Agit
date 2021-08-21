package com.aemiralfath.agit.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aemiralfath.agit.R
import com.aemiralfath.agit.databinding.CoinItemBinding
import com.aemiralfath.agit.domain.model.Coin
import java.util.*

class HomeAdapter(
    private val onClick: (Coin) -> Unit
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var listData = ArrayList<Coin>()
    fun setData(newListData: List<Coin>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coin_item, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val coin = listData[position]
        holder.bind(coin)
    }

    override fun getItemCount(): Int = listData.size

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = CoinItemBinding.bind(itemView)

        fun bind(coin: Coin) {
            with(binding) {
                val formatter = Formatter()
                formatter.format("%.3f", coin.blockReward)

                tvNameItem.text = coin.name
                tvDateItem.text = coin.date
                tvFullnameItem.text = coin.fullName
                tvRewardItem.text = formatter.toString()
                itemView.setOnClickListener {
                    onClick(coin)
                }
            }
        }
    }
}