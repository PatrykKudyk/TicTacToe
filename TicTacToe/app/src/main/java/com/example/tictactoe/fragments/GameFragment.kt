package com.example.tictactoe.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.tictactoe.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AccountFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var rootView: View
    private lateinit var upLeftButton: Button
    private lateinit var upButton: Button
    private lateinit var upRightButton: Button
    private lateinit var centerLeftButton: Button
    private lateinit var centerButton: Button
    private lateinit var centerRightButton: Button
    private lateinit var bottomLeftButton: Button
    private lateinit var bottomButton: Button
    private lateinit var bottomRightButton: Button
    private lateinit var endGameFragment: EndGameFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_game, container, false);
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
        fun newInstance(param1: Int) =
            GameFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }

    private fun initFragment() {
        upLeftButton = rootView.findViewById(R.id.game_up_left)
        upButton = rootView.findViewById(R.id.game_up)
        upRightButton = rootView.findViewById(R.id.game_up_right)
        centerLeftButton = rootView.findViewById(R.id.game_center_left)
        centerButton = rootView.findViewById(R.id.game_center)
        centerRightButton = rootView.findViewById(R.id.game_center_right)
        bottomLeftButton = rootView.findViewById(R.id.game_bottom_left)
        bottomButton = rootView.findViewById(R.id.game_bottom)
        bottomRightButton = rootView.findViewById(R.id.game_bottom_right)

        if (param1 == 1) {
            handlePlayerGame()
        } else if (param1 == 2) {
            handleComputerGame()
        }
    }

    private fun handlePlayerGame() {
        var player = 0
        var board = arrayOf<Array<Int>>()
        for (i in 0..2) {
            var array = arrayOf<Int>()
            for (j in 0..2) {
                array += 0
            }
            board += array
        }
        upLeftButton.setOnClickListener {
            if (board[0][0] != 1) {
                if (player == 0) {
                    upLeftButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorGreenMedium
                        )
                    )
                    player = 1
                    board[0][0] = 1
                } else {
                    upLeftButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorBrown
                        )
                    )
                    player = 0
                    board[0][0] = 2
                }
                isEnd(board)
            }
        }

        upButton.setOnClickListener {
            if (board[0][1] != 1) {
                if (player == 0) {
                    upButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorGreenMedium
                        )
                    )
                    player = 1
                    board[0][1] = 1
                } else {
                    upButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorBrown
                        )
                    )
                    player = 0
                    board[0][1] = 2
                }
                isEnd(board)
            }
        }

        upRightButton.setOnClickListener {
            if (board[0][2] != 1) {
                if (player == 0) {
                    upRightButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorGreenMedium
                        )
                    )
                    player = 1
                    board[0][2] = 1
                } else {
                    upRightButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorBrown
                        )
                    )
                    player = 0
                    board[0][2] = 2
                }
                isEnd(board)
            }
        }

        centerLeftButton.setOnClickListener {
            if (board[1][0] != 1) {
                if (player == 0) {
                    centerLeftButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorGreenMedium
                        )
                    )
                    player = 1
                    board[1][0] = 1
                } else {
                    centerLeftButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorBrown
                        )
                    )
                    player = 0
                    board[1][0] = 2
                }
                isEnd(board)
            }
        }

        centerButton.setOnClickListener {
            if (board[1][1] != 1) {
                if (player == 0) {
                    centerButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorGreenMedium
                        )
                    )
                    player = 1
                    board[1][1] = 1
                } else {
                    centerButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorBrown
                        )
                    )
                    player = 0
                    board[1][1] = 2
                }
                isEnd(board)
            }
        }

        centerRightButton.setOnClickListener {
            if (board[1][2] != 1) {
                if (player == 0) {
                    centerRightButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorGreenMedium
                        )
                    )
                    player = 1
                    board[1][2] = 1
                } else {
                    centerRightButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorBrown
                        )
                    )
                    player = 0
                    board[1][2] = 2
                }
                isEnd(board)
            }
        }

        bottomLeftButton.setOnClickListener {
            if (board[2][0] != 1) {
                if (player == 0) {
                    bottomLeftButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorGreenMedium
                        )
                    )
                    player = 1
                    board[2][0] = 1
                } else {
                    bottomLeftButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorBrown
                        )
                    )
                    player = 0
                    board[2][0] = 2
                }
                isEnd(board)
            }
        }

        bottomButton.setOnClickListener {
            if (board[2][1] != 1) {
                if (player == 0) {
                    bottomButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorGreenMedium
                        )
                    )
                    player = 1
                    board[2][1] = 1
                } else {
                    bottomButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorBrown
                        )
                    )
                    player = 0
                    board[2][1] = 2
                }
                isEnd(board)
            }
        }

        bottomRightButton.setOnClickListener {
            if (board[2][2] != 1) {
                if (player == 0) {
                    bottomRightButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorGreenMedium
                        )
                    )
                    player = 1
                    board[2][2] = 1
                } else {
                    bottomRightButton.setBackgroundColor(
                        ContextCompat.getColor(
                            rootView.context,
                            R.color.colorBrown
                        )
                    )
                    player = 0
                    board[2][2] = 2
                }
                isEnd(board)
            }
        }
    }

    private fun handleComputerGame() {
        var board = arrayOf<Array<Int>>()
        for (i in 0..2) {
            var array = arrayOf<Int>()
            for (j in 0..2) {
                array += 0
            }
            board += array
        }


    }

    private fun isEnd(board: Array<Array<Int>>): Boolean {

        if (board[0][0] != 0 && board[1][0] != 0 && board[2][0] != 0) {
            if (board[0][0] == board[1][0] && board[0][0] == board[2][0]) {
                if(board[0][0] == 1){
                    greenWon()
                } else {
                    brownWon()
                }
                return true
            }
        }

        if (board[0][1] != 0 && board[1][1] != 0 && board[2][1] != 0) {
            if (board[0][1] == board[1][1] && board[0][1] == board[2][1]) {
                if(board[0][1] == 1){
                    greenWon()
                } else {
                    brownWon()
                }
                return true
            }
        }

        if (board[0][2] != 0 && board[1][2] != 0 && board[2][2] != 0) {
            if (board[0][2] == board[1][2] && board[0][2] == board[2][2]) {
                if(board[0][2] == 1){
                    greenWon()
                } else {
                    brownWon()
                }
                return true
            }
        }

        if (board[0][0] != 0 && board[0][1] != 0 && board[0][2] != 0) {
            if (board[0][0] == board[0][1] && board[0][0] == board[0][2]) {
                if(board[0][0] == 1){
                    greenWon()
                } else {
                    brownWon()
                }
                return true
            }
        }

        if (board[1][0] != 0 && board[1][1] != 0 && board[1][2] != 0) {
            if (board[1][0] == board[1][1] && board[1][0] == board[1][2]) {
                if(board[1][0] == 1){
                    greenWon()
                } else {
                    brownWon()
                }
                return true
            }
        }

        if (board[2][0] != 0 && board[2][1] != 0 && board[2][2] != 0) {
            if (board[2][0] == board[2][1] && board[2][0] == board[2][2]) {
                if(board[2][0] == 1){
                    greenWon()
                } else {
                    brownWon()
                }
                return true
            }
        }

        if (board[0][0] != 0 && board[1][1] != 0 && board[2][2] != 0) {
            if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
                if(board[0][0] == 1){
                    greenWon()
                } else {
                    brownWon()
                }
                return true
            }
        }

        if (board[2][0] != 0 && board[1][1] != 0 && board[0][2] != 0) {
            if (board[2][0] == board[1][1] && board[0][0] == board[0][2]) {
                if(board[2][0] == 1){
                    greenWon()
                } else {
                    brownWon()
                }
                return true
            }
        }

        var canMove = false
        for (i in 0..2) {
            for (j in 0..2) {
                if (board[i][j] == 0) {
                    canMove = true
                }
            }
        }
        if (!canMove) {
           draw()
            return true
        }
        return false
    }

    private fun draw() {
        Handler().postDelayed(
            {
                val parameter1 = param1 as Int
                endGameFragment = EndGameFragment.newInstance(parameter1, 0)
                fragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.frame_layout, endGameFragment)
                    ?.commit()
            }, 350
        )
    }

    private fun greenWon() {
        Handler().postDelayed(
            {
                val parameter1 = param1 as Int
                endGameFragment = EndGameFragment.newInstance(parameter1, 1)
                fragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.frame_layout, endGameFragment)
                    ?.commit()
            }, 600
        )
    }

    private fun brownWon() {
        Handler().postDelayed(
            {
                val parameter1 = param1 as Int
                endGameFragment = EndGameFragment.newInstance(parameter1, 2)
                fragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.frame_layout, endGameFragment)
                    ?.commit()
            }, 600
        )
    }
}