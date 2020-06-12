package com.example.tictactoe.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.tictactoe.R
import kotlinx.android.synthetic.main.fragment_end_game.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AccountFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EndGameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null
    private var param2: Int? = null
    private var param3: Int? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var rootView: View
    private lateinit var backToMenuButton: Button
    private lateinit var playAgainButton: Button
    private lateinit var gameFragment: GameFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getInt(ARG_PARAM2)
            param3 = it.getInt(ARG_PARAM3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_end_game, container, false);
        initFragment()
        return rootView
    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int, param2: Int, param3: Int) =
            EndGameFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putInt(ARG_PARAM2, param2)
                    putInt(ARG_PARAM3, param3)
                }
            }
    }

    private fun initFragment() {
        backToMenuButton = rootView.findViewById(R.id.back_to_menu_button)
        playAgainButton = rootView.findViewById(R.id.play_again_button)

        if (param2 == 0) {
            rootView.who_won_text_view.text =
                getString(getStringIdentifier(rootView.context, "end_game_draw"))
        } else if (param2 == 1) {
            rootView.who_won_text_view.setTextColor(
                ContextCompat.getColor(
                    rootView.context,
                    R.color.colorGreenMedium
                )
            )
            rootView.who_won_text_view.text =
                getString(getStringIdentifier(rootView.context, "end_game_green_wins"))
        } else if (param2 == 2) {
            rootView.who_won_text_view.setTextColor(
                ContextCompat.getColor(
                    rootView.context,
                    R.color.colorBrown
                )
            )
            rootView.who_won_text_view.text =
                getString(getStringIdentifier(rootView.context, "end_game_brown_wins"))
        }

        backToMenuButton.setOnClickListener {
            fragmentManager
                ?.popBackStackImmediate()
        }

        playAgainButton.setOnClickListener {
            gameFragment = GameFragment.newInstance(param1 as Int, param3 as Int)
            fragmentManager
                ?.beginTransaction()
                ?.setCustomAnimations(
                    R.anim.enter_left_to_right, R.anim.exit_right_to_left,
                    R.anim.enter_right_to_left, R.anim.exit_left_to_right
                )
                ?.replace(R.id.frame_layout, gameFragment)
                ?.commit()
        }
    }

    private fun getStringIdentifier(context: Context, name: String): Int {
        return context.resources.getIdentifier(name, "string", context.packageName)
    }
}