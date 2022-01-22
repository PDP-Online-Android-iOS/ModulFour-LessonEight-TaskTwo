package dev.ogabek.kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.ogabek.kotlin.Fragment.FirstFragment
import dev.ogabek.kotlin.Fragment.SecondFragment
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.listener.FirstListener
import dev.ogabek.kotlin.listener.SecondListener
import dev.ogabek.kotlin.model.Person

class MainActivity : AppCompatActivity(), FirstListener, SecondListener {

    private lateinit var firstFragment: FirstFragment
    private lateinit var secondFragment: SecondFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.firstFragment, firstFragment)
            .replace(R.id.secondFragment, secondFragment)
            .commit()
    }

    override fun onFirstSend(person: Person) {
        secondFragment.updateData(person)
    }

    override fun onSecondSend(person: Person) {
        firstFragment.updateData(person)
    }
}