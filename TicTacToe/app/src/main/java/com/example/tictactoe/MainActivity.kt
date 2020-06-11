package com.example.tictactoe

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe.fragments.GameFragment
import com.example.tictactoe.fragments.MainMenuFragment
import com.example.tictactoe.fragments.RulesFragment

class MainActivity : AppCompatActivity(),
    MainMenuFragment.OnFragmentInteractionListener,
    GameFragment.OnFragmentInteractionListener,
    RulesFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainMenuFragment = MainMenuFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame_layout, mainMenuFragment)
            .commit()
    }

    override fun onFragmentInteraction(uri: Uri) {

    }
}