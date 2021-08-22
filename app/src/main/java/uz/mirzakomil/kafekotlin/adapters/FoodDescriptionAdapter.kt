package uz.mirzakomil.kafekotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import uz.mirzakomil.kafekotlin.databinding.ItemFoodDescriptionBinding
import uz.mirzakomil.kafekotlin.model.FoodDescription
import uz.mirzakomil.kafekotlin.model.TaomTurlari

class FoodDescriptionAdapter(
    var food_description_item: List<FoodDescription>,
    var foodDescriptionItemClickListener: FoodDescriptionItemCallback

) :
    RecyclerView.Adapter<FoodDescriptionAdapter.FoodDescriptionViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodDescriptionViewHolder {
        val binding =
            ItemFoodDescriptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodDescriptionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodDescriptionViewHolder, position: Int) {
        val button = food_description_item[position].button

        holder.binding.root.setOnClickListener{
            foodDescriptionItemClickListener.onFoodDescriptionClick(food_description_item[position])
        }
    }

    override fun getItemCount() = food_description_item.size

    class FoodDescriptionItemCallback(val foodDescriptionItemClickListener: (item: FoodDescription) -> Unit) {
        fun onFoodDescriptionClick(item: FoodDescription) = foodDescriptionItemClickListener(item)
    }

    inner class FoodDescriptionViewHolder(val binding: ItemFoodDescriptionBinding) :
        RecyclerView.ViewHolder(binding.root)
}