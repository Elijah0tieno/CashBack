package org.vosystems.cashback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.vosystems.cashback.Fragments.*

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigation : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(HomeFragment())
        editViews()

    }
    private fun editViews(){
        bottomNavigation = findViewById(R.id.bottomNavigationView) as BottomNavigationView
        bottomNavigation.setOnNavigationItemReselectedListener() {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.catalogue -> {
                    loadFragment(CatalogueFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.scan -> {
                    loadFragment(ScanFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.offers -> {
                    loadFragment(OfffersFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.profile -> {
                    loadFragment(ProfileFragment())
                    return@setOnNavigationItemReselectedListener
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}