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
import kotlin.random.Random


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
    private var param2: Int? = null
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
    private var isEnd = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getInt(ARG_PARAM2)
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
        fun newInstance(param1: Int, param2: Int) =
            GameFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putInt(ARG_PARAM2, param2)
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

        upLeftButton.setOnClickListener {
            if (board[0][0] == 0) {
                upLeftButton.setBackgroundColor(
                    ContextCompat.getColor(
                        rootView.context,
                        R.color.colorGreenMedium
                    )
                )
                board[0][0] = 1
                isEnd(board)
                if (canMove(board)) {
                    val move = makeComputerMove(board)
                    board[move[0]][move[1]] = 2
                    changeButtonToBrown(move[0], move[1])
                    if(!isEnd){
                        isEnd(board)
                    }
                }
            }
        }

        upButton.setOnClickListener {
            if (board[0][1] == 0) {
                upButton.setBackgroundColor(
                    ContextCompat.getColor(
                        rootView.context,
                        R.color.colorGreenMedium
                    )
                )
                board[0][1] = 1
                isEnd(board)
                if (canMove(board)) {
                    val move = makeComputerMove(board)
                    board[move[0]][move[1]] = 2
                    changeButtonToBrown(move[0], move[1])
                    if(!isEnd){
                        isEnd(board)
                    }
                }
            }
        }

        upRightButton.setOnClickListener {
            if (board[0][2] == 0) {
                upRightButton.setBackgroundColor(
                    ContextCompat.getColor(
                        rootView.context,
                        R.color.colorGreenMedium
                    )
                )
                board[0][2] = 1
                isEnd(board)
                if (canMove(board)) {
                    val move = makeComputerMove(board)
                    board[move[0]][move[1]] = 2
                    changeButtonToBrown(move[0], move[1])
                    if(!isEnd){
                        isEnd(board)
                    }
                }
            }
        }

        centerLeftButton.setOnClickListener {
            if (board[1][0] == 0) {
                centerLeftButton.setBackgroundColor(
                    ContextCompat.getColor(
                        rootView.context,
                        R.color.colorGreenMedium
                    )
                )
                board[1][0] = 1
                isEnd(board)
                if (canMove(board)) {
                    val move = makeComputerMove(board)
                    board[move[0]][move[1]] = 2
                    changeButtonToBrown(move[0], move[1])
                    if(!isEnd){
                        isEnd(board)
                    }
                }
            }
        }

        centerButton.setOnClickListener {
            if (board[1][1] == 0) {
                centerButton.setBackgroundColor(
                    ContextCompat.getColor(
                        rootView.context,
                        R.color.colorGreenMedium
                    )
                )
                board[1][1] = 1
                isEnd(board)
                if (canMove(board)) {
                    val move = makeComputerMove(board)
                    board[move[0]][move[1]] = 2
                    changeButtonToBrown(move[0], move[1])
                    if(!isEnd){
                        isEnd(board)
                    }
                }
            }
        }

        centerRightButton.setOnClickListener {
            if (board[1][2] == 0) {
                centerRightButton.setBackgroundColor(
                    ContextCompat.getColor(
                        rootView.context,
                        R.color.colorGreenMedium
                    )
                )
                board[1][2] = 1
                isEnd(board)
                if (canMove(board)) {
                    val move = makeComputerMove(board)
                    board[move[0]][move[1]] = 2
                    changeButtonToBrown(move[0], move[1])
                    if(!isEnd){
                        isEnd(board)
                    }
                }
            }
        }

        bottomLeftButton.setOnClickListener {
            if (board[2][0] == 0) {
                bottomLeftButton.setBackgroundColor(
                    ContextCompat.getColor(
                        rootView.context,
                        R.color.colorGreenMedium
                    )
                )
                board[2][0] = 1
                isEnd(board)
                if (canMove(board)) {
                    val move = makeComputerMove(board)
                    board[move[0]][move[1]] = 2
                    changeButtonToBrown(move[0], move[1])
                    if(!isEnd){
                        isEnd(board)
                    }
                }
            }
        }

        bottomButton.setOnClickListener {
            if (board[2][1] == 0) {
                bottomButton.setBackgroundColor(
                    ContextCompat.getColor(
                        rootView.context,
                        R.color.colorGreenMedium
                    )
                )
                board[2][1] = 1
                isEnd(board)
                if (canMove(board)) {
                    val move = makeComputerMove(board)
                    board[move[0]][move[1]] = 2
                    changeButtonToBrown(move[0], move[1])
                    if(!isEnd){
                        isEnd(board)
                    }
                }
            }
        }

        bottomRightButton.setOnClickListener {
            if (board[2][2] == 0) {
                bottomRightButton.setBackgroundColor(
                    ContextCompat.getColor(
                        rootView.context,
                        R.color.colorGreenMedium
                    )
                )
                board[2][2] = 1
                isEnd(board)
                if (canMove(board)) {
                    val move = makeComputerMove(board)
                    board[move[0]][move[1]] = 2
                    changeButtonToBrown(move[0], move[1])
                    if(!isEnd){
                        isEnd(board)
                    }
                }
            }
        }

    }

    private fun isEnd(board: Array<Array<Int>>): Boolean {

        if (board[0][0] != 0 && board[1][0] != 0 && board[2][0] != 0) {
            if (board[0][0] == board[1][0] && board[0][0] == board[2][0]) {
                if (board[0][0] == 1) {
                    greenWon()
                } else {
                    brownWon()
                }
                return true
            }
        }

        if (board[0][1] != 0 && board[1][1] != 0 && board[2][1] != 0) {
            if (board[0][1] == board[1][1] && board[0][1] == board[2][1]) {
                if (board[0][1] == 1) {
                    greenWon()
                } else {
                    brownWon()
                }
                return true
            }
        }

        if (board[0][2] != 0 && board[1][2] != 0 && board[2][2] != 0) {
            if (board[0][2] == board[1][2] && board[0][2] == board[2][2]) {
                if (board[0][2] == 1) {
                    greenWon()
                } else {
                    brownWon()
                }
                return true
            }
        }

        if (board[0][0] != 0 && board[0][1] != 0 && board[0][2] != 0) {
            if (board[0][0] == board[0][1] && board[0][0] == board[0][2]) {
                if (board[0][0] == 1) {
                    greenWon()
                } else {
                    brownWon()
                }
                return true
            }
        }

        if (board[1][0] != 0 && board[1][1] != 0 && board[1][2] != 0) {
            if (board[1][0] == board[1][1] && board[1][0] == board[1][2]) {
                if (board[1][0] == 1) {
                    greenWon()
                } else {
                    brownWon()
                }
                return true
            }
        }

        if (board[2][0] != 0 && board[2][1] != 0 && board[2][2] != 0) {
            if (board[2][0] == board[2][1] && board[2][0] == board[2][2]) {
                if (board[2][0] == 1) {
                    greenWon()
                } else {
                    brownWon()
                }
                return true
            }
        }

        if (board[0][0] != 0 && board[1][1] != 0 && board[2][2] != 0) {
            if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
                if (board[0][0] == 1) {
                    greenWon()
                } else {
                    brownWon()
                }
                return true
            }
        }

        if (board[2][0] != 0 && board[1][1] != 0 && board[0][2] != 0) {
            if (board[2][0] == board[1][1] && board[2][0] == board[0][2]) {
                if (board[2][0] == 1) {
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
                endGameFragment = EndGameFragment.newInstance(parameter1, 0, param2 as Int)
                fragmentManager
                    ?.beginTransaction()
                    ?.setCustomAnimations(
                        R.anim.enter_left_to_right, R.anim.exit_right_to_left,
                        R.anim.enter_right_to_left, R.anim.exit_left_to_right
                    )
                    ?.replace(R.id.frame_layout, endGameFragment)
                    ?.commit()
            }, 350
        )
    }

    private fun greenWon() {
        isEnd = true
        Handler().postDelayed(
            {
                val parameter1 = param1 as Int
                endGameFragment = EndGameFragment.newInstance(parameter1, 1, param2 as Int)
                fragmentManager
                    ?.beginTransaction()
                    ?.setCustomAnimations(
                        R.anim.enter_left_to_right, R.anim.exit_right_to_left,
                        R.anim.enter_right_to_left, R.anim.exit_left_to_right
                    )
                    ?.replace(R.id.frame_layout, endGameFragment)
                    ?.commit()
            }, 600
        )
    }

    private fun brownWon() {
        isEnd = true
        Handler().postDelayed(
            {
                val parameter1 = param1 as Int
                endGameFragment = EndGameFragment.newInstance(parameter1, 2, param2 as Int)
                fragmentManager
                    ?.beginTransaction()
                    ?.setCustomAnimations(
                        R.anim.enter_left_to_right, R.anim.exit_right_to_left,
                        R.anim.enter_right_to_left, R.anim.exit_left_to_right
                    )
                    ?.replace(R.id.frame_layout, endGameFragment)
                    ?.commit()
            }, 600
        )
    }

    private fun makeComputerMove(board: Array<Array<Int>>): Array<Int> {
        if (param2 == 0) {
            return makeEasyMove(board)
        } else if (param2 == 1) {
            return makeMediumMove(board)
        } else if (param2 == 2) {
            return makeHardMove(board)
        }
        return makeEasyMove(board)
    }

    private fun makeEasyMove(board: Array<Array<Int>>): Array<Int> {
        var x: Int
        var y: Int
        do {
            x = Random.nextInt(0, 3)
            y = Random.nextInt(0, 3)
        } while (board[x][y] != 0)
        return arrayOf(x, y)
    }

    private fun makeMediumMove(board: Array<Array<Int>>): Array<Int> {
        var probability = Random.nextInt(0, 1001)
        return if (probability <= 570) {
            makeCalculatedMove(board)
        } else {
            makeEasyMove(board)
        }
    }

    private fun makeHardMove(board: Array<Array<Int>>): Array<Int> {
        var probability = Random.nextInt(0, 1001)
        return if (probability <= 900) {
            makeCalculatedMove(board)
        } else {
            makeEasyMove(board)
        }
    }

    private fun makeCalculatedMove(board: Array<Array<Int>>): Array<Int> {
        //  CHECK IF CAN WIN
        if(board[0][0] == 2 && board[0][1] == 2 && board[0][2] == 0) {
            return arrayOf(0, 2)
        } else if (board[0][0] == 2 && board[0][2] == 2 && board[0][1] == 0) {
            return arrayOf(0, 1)
        } else if (board[0][1] == 2 && board[0][2] == 2 && board[0][0] == 0) {
            return arrayOf(0, 0)
        } else  if(board[1][0] == 2 && board[1][1] == 2 && board[1][2] == 0) {
            return arrayOf(1, 2)
        } else if (board[1][0] == 2 && board[1][2] == 2 && board[1][1] == 0) {
            return arrayOf(1, 1)
        } else if (board[1][1] == 2 && board[1][2] == 2 && board[1][0] == 0) {
            return arrayOf(1, 0)
        } else  if(board[2][0] == 2 && board[2][1] == 2 && board[2][2] == 0) {
            return arrayOf(2, 2)
        } else if (board[2][0] == 2 && board[2][2] == 2 && board[2][1] == 0) {
            return arrayOf(2, 1)
        } else if (board[2][1] == 2 && board[2][2] == 2 && board[2][0] == 0) {
            return arrayOf(2, 0)
        } else if (board[0][0] == 2 && board[1][0] == 2 && board[2][0] == 0) {
            return arrayOf(2, 0)
        } else if (board[0][0] == 2 && board[2][0] == 2 && board[1][0] == 0) {
            return arrayOf(1, 0)
        } else if (board[2][0] == 2 && board[1][0] == 2 && board[0][0] == 0) {
            return arrayOf(0, 0)
        } else if (board[0][1] == 2 && board[1][1] == 2 && board[2][1] == 0) {
            return arrayOf(2, 1)
        } else if (board[0][1] == 2 && board[2][1] == 2 && board[1][1] == 0) {
            return arrayOf(1, 1)
        } else if (board[2][1] == 2 && board[1][1] == 2 && board[0][1] == 0) {
            return arrayOf(0, 1)
        } else if (board[0][2] == 2 && board[1][2] == 2 && board[2][2] == 0) {
            return arrayOf(2, 2)
        } else if (board[0][2] == 2 && board[2][2] == 2 && board[1][2] == 0) {
            return arrayOf(1, 2)
        } else if (board[2][2] == 2 && board[1][2] == 2 && board[0][2] == 0) {
            return arrayOf(0, 2)
        } else if (board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 0) {
            return arrayOf(2, 2)
        } else if (board[0][0] == 2 && board[2][2] == 2 && board[1][1] == 0) {
            return arrayOf(1, 1)
        } else if (board[2][2] == 2 && board[1][1] == 2 && board[0][0] == 0) {
            return arrayOf(0, 0)
        } else if (board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 0) {
            return arrayOf(2, 0)
        } else if (board[0][2] == 2 && board[2][0] == 2 && board[1][1] == 0) {
            return arrayOf(1, 1)
        } else if (board[2][0] == 2 && board[1][1] == 2 && board[0][2] == 0) {
            return arrayOf(0, 2)
        }
        //  CHECK IF CAN WIN

        //  CHECK IF ENEMY GONNA WIN
        if(board[0][0] == 1 && board[0][1] == 1 && board[0][2] == 0) {
            return arrayOf(0, 2)
        } else if (board[0][0] == 1 && board[0][2] == 1 && board[0][1] == 0) {
            return arrayOf(0, 1)
        } else if (board[0][1] == 1 && board[0][2] == 1 && board[0][0] == 0) {
            return arrayOf(0, 0)
        } else  if(board[1][0] == 1 && board[1][1] == 1 && board[1][2] == 0) {
            return arrayOf(1, 2)
        } else if (board[1][0] == 1 && board[1][2] == 1 && board[1][1] == 0) {
            return arrayOf(1, 1)
        } else if (board[1][1] == 1 && board[1][2] == 1 && board[1][0] == 0) {
            return arrayOf(1, 0)
        } else  if(board[2][0] == 1 && board[2][1] == 1 && board[2][2] == 0) {
            return arrayOf(2, 2)
        } else if (board[2][0] == 1 && board[2][2] == 1 && board[2][1] == 0) {
            return arrayOf(2, 1)
        } else if (board[2][1] == 1 && board[2][2] == 1 && board[2][0] == 0) {
            return arrayOf(2, 0)
        } else if (board[0][0] == 1 && board[1][0] == 1 && board[2][0] == 0) {
            return arrayOf(2, 0)
        } else if (board[0][0] == 1 && board[2][0] == 1 && board[1][0] == 0) {
            return arrayOf(1, 0)
        } else if (board[2][0] == 1 && board[1][0] == 1 && board[0][0] == 0) {
            return arrayOf(0, 0)
        } else if (board[0][1] == 1 && board[1][1] == 1 && board[2][1] == 0) {
            return arrayOf(2, 1)
        } else if (board[0][1] == 1 && board[2][1] == 1 && board[1][1] == 0) {
            return arrayOf(1, 1)
        } else if (board[2][1] == 1 && board[1][1] == 1 && board[0][1] == 0) {
            return arrayOf(0, 1)
        } else if (board[0][2] == 1 && board[1][2] == 1 && board[2][2] == 0) {
            return arrayOf(2, 2)
        } else if (board[0][2] == 1 && board[2][2] == 1 && board[1][2] == 0) {
            return arrayOf(1, 2)
        } else if (board[2][2] == 1 && board[1][2] == 1 && board[0][2] == 0) {
            return arrayOf(0, 2)
        } else if (board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 0) {
            return arrayOf(2, 2)
        } else if (board[0][0] == 1 && board[2][2] == 1 && board[1][1] == 0) {
            return arrayOf(1, 1)
        } else if (board[2][2] == 1 && board[1][1] == 1 && board[0][0] == 0) {
            return arrayOf(0, 0)
        } else if (board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 0) {
            return arrayOf(2, 0)
        } else if (board[0][2] == 1 && board[2][0] == 1 && board[1][1] == 0) {
            return arrayOf(1, 1)
        } else if (board[2][0] == 1 && board[1][1] == 1 && board[0][2] == 0) {
            return arrayOf(0, 2)
        }
        //  CHECK IF ENEMY GONNA WIN
        return makeEasyMove(board)
    }

    private fun changeButtonToBrown(x: Int, y: Int) {
        if (x == 0 && y == 0) {
            upLeftButton.setBackgroundColor(
                ContextCompat.getColor(
                    rootView.context,
                    R.color.colorBrown
                )
            )
        } else if (x == 0 && y == 1) {
            upButton.setBackgroundColor(
                ContextCompat.getColor(
                    rootView.context,
                    R.color.colorBrown
                )
            )
        } else if (x == 0 && y == 2) {
            upRightButton.setBackgroundColor(
                ContextCompat.getColor(
                    rootView.context,
                    R.color.colorBrown
                )
            )
        } else if (x == 1 && y == 0) {
            centerLeftButton.setBackgroundColor(
                ContextCompat.getColor(
                    rootView.context,
                    R.color.colorBrown
                )
            )
        } else if (x == 1 && y == 1) {
            centerButton.setBackgroundColor(
                ContextCompat.getColor(
                    rootView.context,
                    R.color.colorBrown
                )
            )
        } else if (x == 1 && y == 2) {
            centerRightButton.setBackgroundColor(
                ContextCompat.getColor(
                    rootView.context,
                    R.color.colorBrown
                )
            )
        } else if (x == 2 && y == 0) {
            bottomLeftButton.setBackgroundColor(
                ContextCompat.getColor(
                    rootView.context,
                    R.color.colorBrown
                )
            )
        } else if (x == 2 && y == 1) {
            bottomButton.setBackgroundColor(
                ContextCompat.getColor(
                    rootView.context,
                    R.color.colorBrown
                )
            )
        } else if (x == 2 && y == 2) {
            bottomRightButton.setBackgroundColor(
                ContextCompat.getColor(
                    rootView.context,
                    R.color.colorBrown
                )
            )
        }
    }

    private fun canMove(board: Array<Array<Int>>): Boolean {
        var canMove = false
        for (i in 0..2) {
            for (j in 0..2) {
                if (board[i][j] == 0) {
                    canMove = true
                }
            }
        }
        return canMove
    }
}