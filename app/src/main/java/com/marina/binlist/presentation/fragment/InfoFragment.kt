package com.marina.binlist.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.marina.binlist.R
import com.marina.binlist.app.App
import com.marina.binlist.databinding.FragmentInfoBinding
import com.marina.binlist.presentation.entity.*
import com.marina.binlist.presentation.entity.Number
import com.marina.binlist.presentation.view_model.InfoViewModel
import com.marina.binlist.presentation.view_model.factory.ViewModelFactory
import javax.inject.Inject

class InfoFragment : Fragment() {

    private var _binding: FragmentInfoBinding? = null
    private val binding: FragmentInfoBinding
        get() = _binding ?: throw RuntimeException("FragmentInfoBinding == null")

    private val screenMode by lazy {
        arguments?.getString(SCREEN_MODE)
    }
    private val infoItem by lazy {
        arguments?.getParcelable<CardInfoUI>(CARD_INFO_ITEM)

    }

    private lateinit var viewModel: InfoViewModel

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
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[InfoViewModel::class.java]
        if (screenMode == MODE_HISTORY) {
            binding.etBin.setText(infoItem?.bin)
            setAllInfo(infoItem!!)
            hideButtons()

        }
        setOnClickListener()
        observeViewModel()
    }

    private fun hideButtons() {
        binding.fabHistory.visibility = View.GONE
        binding.btnFind.visibility = View.GONE
    }

    private fun setOnClickListener() {
        binding.btnFind.setOnClickListener {
            viewModel.getInfo(getCardBIN())
        }
        binding.fabHistory.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .addToBackStack(this.javaClass.simpleName)
                .replace(R.id.fragment_container, HistoryFragment.newInstance())
                .commit()
        }
    }

    private fun getCardBIN(): String {
        val bin = binding.etBin.text.toString()
        return bin
    }

    private fun observeViewModel() {
        viewModel.info.observe(viewLifecycleOwner) {
            if (it.info != null) {
                val card = it.info
                setAllInfo(card)
            }
        }
    }

    private fun setAllInfo(card: CardInfoUI) {
        setNumberInfo(card.number)
        setMainInfo(card.mainInfo)
        setCountryInfo(card.country)
        setBankInfo(card.bank)
    }

    private fun setNumberInfo(number: Number?) = with(binding) {
        if (number == null) {
            cvNumber.visibility = View.GONE
        } else {
            cvNumber.visibility = View.VISIBLE
            tvLength.text = number.length.toString()
            tvLuhn.text = number.length.toString()
        }

    }

    private fun setMainInfo(mainInfo: MainInfo?) = with(binding) {
        if (mainInfo == null) {
            cvMain.visibility = View.GONE
        } else {
            cvMain.visibility = View.VISIBLE
            tvScheme.text = mainInfo.scheme
            tvType.text = mainInfo.type
            tvBrand.text = mainInfo.brand
            tvPrepaid.text = mainInfo.prepaid.toString()
        }
    }

    private fun setCountryInfo(country: Country?) = with(binding) {
        if (country == null) {
            cvCountry.visibility = View.GONE
        } else {
            cvCountry.visibility = View.VISIBLE
            tvNumeric.text = country.numeric
            tvAlpha2.text = country.letter
            tvName.text = country.name
            tvCurrency.text = country.currency
            "${country.latitude} ${country.longitude}".also { tvCoords.text = it }
        }
    }

    private fun setBankInfo(bank: Bank?) = with(binding) {
        if (bank == null) {
            cvBank.visibility = View.GONE
        } else {
            cvBank.visibility = View.VISIBLE
            tvNameBank.text = bank.name
            tvUrl.text = bank.url
            tvPhone.text = bank.phone
            tvCity.text = bank.city
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val SCREEN_MODE = "extra_mode"
        private const val MODE_HISTORY = "mode_history"
        private const val MODE_SIMPLE = "mode_simple"
        private const val CARD_INFO_ITEM = "card_info_item"
        private const val MODE_UNKNOWN = ""

        fun newInstance(): InfoFragment {
            return InfoFragment().apply {
                arguments = Bundle().apply {
                    putString(SCREEN_MODE, MODE_SIMPLE)
                }
            }
        }

        fun newInstanceFromHistory(item: CardInfoUI): InfoFragment {
            return InfoFragment().apply {
                arguments = Bundle().apply {
                    putString(SCREEN_MODE, MODE_HISTORY)
                    putParcelable(CARD_INFO_ITEM, item)
                }
            }
        }
    }
}