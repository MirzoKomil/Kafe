package uz.mirzakomil.kafekotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.CollapsingToolbarLayout
import uz.mirzakomil.kafekotlin.R
import uz.mirzakomil.kafekotlin.databinding.ActivityMainBinding
//import uz.mirzakomil.kafekotlin.viewBinding.ActivityMainBinding
import uz.mirzakomil.kafekotlin.ui.fragments.DescriptionFragment
import uz.mirzakomil.kafekotlin.ui.fragments.TaomTurlariFragment
import uz.mirzakomil.kafekotlin.ui.fragments.TotalFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        setSupportActionBar(binding.toolbarMain)
        supportActionBar!!.title = ""

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(TaomTurlariFragment(), "Foods")
        viewPagerAdapter.addFragment(DescriptionFragment(), "Taom ma'lumotlari")
        viewPagerAdapter.addFragment(TotalFragment(), "Umumiy ma'lumot")

        viewPagerAdapter


        binding.viewPager.adapter = viewPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)


//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        val appBarConfiguration = AppBarConfiguration(navController.graph)
//        binding.collapsingToolbarLayout.apply {
//            setupWithNavController(
//                toolbar = binding.toolbarMain,
//                navController = navController,
//                configuration = appBarConfiguration
//            )
//        }


    }

    internal class ViewPagerAdapter(fragmentManager: FragmentManager) :
        FragmentPagerAdapter(fragmentManager){

        private val fragments: ArrayList<Fragment> = ArrayList()
        private val titles: ArrayList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        fun addFragment(fragment: Fragment, title: String){
            fragments.add(fragment)
            titles.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return titles[position]
        }

//        fun replaceFragment(fragment: Fragment, title: String){
//
//        }

    }

}