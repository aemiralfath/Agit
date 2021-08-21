package com.aemiralfath.agit.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aemiralfath.agit.databinding.FragmentFavoriteBinding
import com.aemiralfath.agit.ui.CoinAdapter
import com.aemiralfath.agit.ui.detail.DetailCoinActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private lateinit var coinAdapter: CoinAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            coinAdapter = CoinAdapter {
                val intent = Intent(activity, DetailCoinActivity::class.java)
                intent.putExtra(DetailCoinActivity.EXTRA_DATA, it)
                startActivity(intent)
            }

            populateView()
        }
    }

    private fun populateView() {

        with(binding) {
            rvFavorite.layoutManager = LinearLayoutManager(context)
            rvFavorite.setHasFixedSize(true)
            rvFavorite.adapter = coinAdapter
        }

        favoriteViewModel.setFavoriteCoin().observe(viewLifecycleOwner, {
            if (it != null) {
                coinAdapter.setData(it)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}