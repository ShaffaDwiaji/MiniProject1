package com.currency.miniproject1

import androidx.lifecycle.ViewModel

class ScoreViewModel:ViewModel() {
    var scoreA : Int = 0
    var scoreB : Int = 0

    fun incrementSkorA() {
        scoreA++
    }
    fun incrementSkorB() {
        scoreB++
    }
    fun resetSkor() {
        scoreA = 0
        scoreB = 0
    }

}