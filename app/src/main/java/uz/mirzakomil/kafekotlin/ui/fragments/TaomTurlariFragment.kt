package uz.mirzakomil.kafekotlin.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import uz.mirzakomil.kafekotlin.R
import uz.mirzakomil.kafekotlin.adapters.TaomTurlariAdapter
import uz.mirzakomil.kafekotlin.databinding.FragmentTaomTurlariBinding
import uz.mirzakomil.kafekotlin.model.TaomTurlari

class TaomTurlariFragment : Fragment() {
    private var _binding: FragmentTaomTurlariBinding? = null
    private var boolean: Boolean = false





//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val items = arrayListOf(
            TaomTurlari("Suyuq", "https://i.pinimg.com/564x/ba/07/ed/ba07ed98b4b63f6e5354feb3b60e1661.jpg"),
            TaomTurlari("Suyuq", "https://i.pinimg.com/564x/ba/07/ed/ba07ed98b4b63f6e5354feb3b60e1661.jpg")
        )

        val foodAdapter = TaomTurlariAdapter(
            food_item = items,
            foodItemClickListener = TaomTurlariAdapter.FoodItemCallback{pressedFood ->
                val navDirections =
                    TaomTurlariFragmentDirections.actionTaomTurlariFragmentToDescriptionFragmentContainer(pressedFood.name)
                requireView().findNavController().navigate(navDirections)
            }
        )

        val view = FragmentTaomTurlariBinding.inflate(inflater, container, false)
        view.recyclerView.layoutManager = LinearLayoutManager(activity)
        view.recyclerView.adapter = foodAdapter
        boolean = true
        return view.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (boolean){
//            val trans = fragmentManager?.beginTransaction()
//
//            // We use the "root frame" defined in "root_fragment.xml" as the reference to replace fragment
//            trans?.replace(R.id.nav_host_fragment, DescriptionFragment())
//
//            // The following lines allow us to add the fragment to the stack and return to it later, by pressing back
//            trans?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//            trans?.addToBackStack(null)
//            trans?.commit()


        }
    }



//    override fun onActivityCreated(savedInstanceState: Bundle?) =
//        super.onActivityCreated(savedInstanceState)


//        _binding!!.recyclerView.adapter = foodAdapter
//        val TAG = "Fragment"
//
//        if (_binding!!.recyclerView.adapter == null) {
//            Log.d(
//                TAG,
//                "onActivityCreated: Fragmentda binding.recyclerview.adapter null qaytaryapti"
//            )
//        }
//        else{
//            Log.d(
//                TAG,
//                "onActivityCreated: Fragmentda binding.recyclerview.adapter null qaytarmayapti"
//            )
//        }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


