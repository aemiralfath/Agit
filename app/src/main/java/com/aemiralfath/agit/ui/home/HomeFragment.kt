package com.aemiralfath.agit.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aemiralfath.agit.R
import com.aemiralfath.agit.data.Resource
import com.aemiralfath.agit.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            homeAdapter = HomeAdapter {
                // move intent
//                val intent = Intent(activity, DetailMovieActivity::class.java)
//                intent.putExtra(DetailMovieActivity.EXTRA_DATA, it)
//                startActivity(intent)
            }

            populateView()
        }
    }

    private fun populateView() {

        with(binding) {
            rvHome.layoutManager = LinearLayoutManager(context)
            rvHome.setHasFixedSize(true)
            rvHome.adapter = homeAdapter
        }

        homeViewModel.setCoin().observe(viewLifecycleOwner, {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> showLoading(true)
                    is Resource.Success -> {
                        showLoading(false)
                        homeAdapter.setData(it.data)
                        binding.viewEmpty.root.visibility =
                            if (it.data?.isNotEmpty() == true) View.GONE else View.VISIBLE
                    }
                    is Resource.Error -> {
                        showLoading(false)
                        binding.viewError.tvError.text =
                            it.message ?: getString(R.string.something_wrong)
                    }
                }
            }
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.rvHome.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.rvHome.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}