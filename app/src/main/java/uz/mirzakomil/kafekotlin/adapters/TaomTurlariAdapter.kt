package uz.mirzakomil.kafekotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import uz.mirzakomil.kafekotlin.databinding.ItemTaomTurlariBinding
import uz.mirzakomil.kafekotlin.model.TaomTurlari

class TaomTurlariAdapter(
    var food_item: List<TaomTurlari>,
    var foodItemClickListener: FoodItemCallback
) :
    RecyclerView.Adapter<TaomTurlariAdapter.TaomlarTuriViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaomlarTuriViewHolder {
        val binding =
            ItemTaomTurlariBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaomlarTuriViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaomlarTuriViewHolder, position: Int) {
        val url = food_item[position].image

        val myOptions = RequestOptions()

        Glide.with(holder.binding.root)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .apply(myOptions)
            .into(holder.binding.imgPhoto)


        holder.binding.root.setOnClickListener {

            foodItemClickListener.onFoodClick(food_item[position])

        }
    }

    override fun getItemCount() = food_item.size

    class FoodItemCallback(val foodItemClickListener: (item: TaomTurlari) -> Unit) {
        fun onFoodClick(item: TaomTurlari) = foodItemClickListener(item)
    }

    inner class TaomlarTuriViewHolder(val binding: ItemTaomTurlariBinding) :
        RecyclerView.ViewHolder(binding.root)

}


