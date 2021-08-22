package uz.mirzakomil.kafekotlin.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.item_food_description.*
import uz.mirzakomil.kafekotlin.R
import uz.mirzakomil.kafekotlin.adapters.FoodDescriptionAdapter
import uz.mirzakomil.kafekotlin.adapters.TaomTurlariAdapter
import uz.mirzakomil.kafekotlin.databinding.FragmentDescriptionBinding
import uz.mirzakomil.kafekotlin.databinding.FragmentTaomTurlariBinding
import uz.mirzakomil.kafekotlin.model.FoodDescription
import uz.mirzakomil.kafekotlin.model.TaomTurlari

class DescriptionFragment : Fragment() {
    private var _binding: FragmentDescriptionBinding? = null
    private var binding = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var number : Int = 0
        val items = arrayListOf<FoodDescription>(

            FoodDescription("Fanta", "10000", button_count),
            FoodDescription("Fanta", "10000", button_count),
            FoodDescription("Fanta", "10000", button_count),
            FoodDescription("Fanta", "10000", button_count),
            FoodDescription("Fanta", "10000", button_count),
            FoodDescription("Fanta", "10000", button_count),
            FoodDescription("Fanta", "10000", button_count),
            FoodDescription("Fanta", "10000", button_count),
            FoodDescription("Fanta", "10000", button_count),
            FoodDescription("Fanta", "10000", button_count)

        )

        val foodDescriptionAdapter = FoodDescriptionAdapter(
            food_description_item = items,
            foodDescriptionItemClickListener = FoodDescriptionAdapter.FoodDescriptionItemCallback{ pressedButtonCount ->

                button_count.setOnClickListener{
                    number += 1
                    button_count.text = number.toString()
                }

//                val navDirections =
//                    DescriptionFragmentDirections.actionDescriptionFragmentToTotalFragmentContainer(pressedFood.name)
//                requireView().findNavController().navigate(navDirections)
            }
        )

        val view = FragmentTaomTurlariBinding.inflate(inflater, container, false)
        view.recyclerView.layoutManager = LinearLayoutManager(activity)
        view.recyclerView.adapter = foodDescriptionAdapter

        return view.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}

