package com.example.snacksquad.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.snacksquad.R
import com.example.snacksquad.adapter.CartAdapter
import com.example.snacksquad.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding:FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCartBinding.inflate(inflater,container,false)

        val cartFoodName = listOf("Lays","Burger","Pizza","Cheese Bread","Cakes","Chocolates")

        val cartItemPrice = listOf("$5", "$6", "$8", "$9","$10", "$10")

        val cartImage = listOf(
            R.drawable.lays,

            R.drawable.burger,

            R.drawable.pizza,

            R.drawable.bread,

            R.drawable.cakes,

            R.drawable.chocolates,
        )
        val adapter = CartAdapter(ArrayList(cartFoodName), ArrayList(cartItemPrice), ArrayList(cartImage))

        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.cartRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}