package com.example.tictactoe

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe.fragments.*

class MainActivity : AppCompatActivity(),
    MainMenuFragment.OnFragmentInteractionListener,
    GameFragment.OnFragmentInteractionListener,
    RulesFragment.OnFragmentInteractionListener,
    GameChoiceFragment.OnFragmentInteractionListener,
    EndGameFragment.OnFragmentInteractionListener,
    ComputerChoiceFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainMenuFragment = MainMenuFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.enter_left_to_right, R.anim.exit_right_to_left,
                R.anim.enter_right_to_left, R.anim.exit_left_to_right
            )
            .add(R.id.frame_layout, mainMenuFragment)
            .commit()
    }

    override fun onFragmentInteraction(uri: Uri) {

    }
}