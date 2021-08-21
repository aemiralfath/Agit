package com.aemiralfath.agit.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.aemiralfath.agit.R
import com.aemiralfath.agit.databinding.ActivityDetailCoinBinding
import com.aemiralfath.agit.domain.model.Coin
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailCoinActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailCoinViewModel: DetailCoinViewModel by viewModel()
    private lateinit var binding: ActivityDetailCoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailCoin = intent.getParcelableExtra<Coin>(EXTRA_DATA)
        showDetailCoin(detailCoin)
    }

    private fun showDetailCoin(detailCoin: Coin?) {
        detailCoin?.let {
            supportActionBar?.title = it.name

            with(binding) {
                content.tvCoinFullname.text = it.fullName
                content.tvCoinDate.text = it.date
                content.tvCoinAlgorithm.text = it.algorithm
                content.tvCoinMaxSupply.text = it.maxSupply.toString()
                content.tvCoinBlockNumber.text = it.blockNumber.toString()
                content.tvCoinBlockTime.text = it.blockTime.toString()
                content.tvCoinBlockReward.text = it.blockReward.toString()

                Glide.with(this@DetailCoinActivity)
                    .load("https://www.cryptocompare.com${it.imageUrl}")
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    ).into(ivDetailImage)

                var statusFavorite = it.isFavorite
                setStatusFavorite(statusFavorite)

                fab.setOnClickListener {
                    statusFavorite = !statusFavorite
                    detailCoinViewModel.setFavoriteCoin(detailCoin, statusFavorite)
                    setStatusFavorite(statusFavorite)
                }

                content.btnCoinWeb.setOnClickListener {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.cryptocompare.com${detailCoin.url}")
                        )
                    )
                }
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.ic_favorite_white)
            )
        } else {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white)
            )
        }
    }
}