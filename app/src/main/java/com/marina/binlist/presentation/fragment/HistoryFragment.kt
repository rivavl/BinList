package com.marina.binlist.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.marina.binlist.R
import com.marina.binlist.app.App
import com.marina.binlist.databinding.FragmentHistoryBinding
import com.marina.binlist.presentation.adapter.CardAdapter
import com.marina.binlist.presentation.view_model.HistoryViewModel
import com.marina.binlist.presentation.view_model.factory.ViewModelFactory
import javax.inject.Inject

class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null
    private val binding: FragmentHistoryBinding
        get() = _binding ?: throw RuntimeException("FragmentHistoryBinding == null")

    private lateinit var recyclerView: RecyclerView
    private lateinit var cardsListAdapter: CardAdapter

    private lateinit var viewModel: HistoryViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as App).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[HistoryViewModel::class.java]
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        recyclerView = binding.rvHistory
        cardsListAdapter = CardAdapter()
        recyclerView.apply {
            adapter = cardsListAdapter
        }
        setupItemClickListener()
    }

    private fun setupItemClickListener() {
        cardsListAdapter.onCardItemClick = {
            requireActivity().supportFragmentManager.beginTransaction()
                .addToBackStack(this.javaClass.simpleName)
                .replace(R.id.fragment_container, InfoFragment.newInstanceFromHistory(it))
                .commit()
        }
    }

    private fun observeViewModel() {
        viewModel.cardsList.observe(viewLifecycleOwner) {
            if (it.data != null) {
                cardsListAdapter.submitList(it.data)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance(): HistoryFragment {
            return HistoryFragment()
        }
    }

}