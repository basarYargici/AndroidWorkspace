package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private var _score = MutableLiveData(0)
    private var _currentWordCount = MutableLiveData(0)
    private val _currentScrambledWord = MutableLiveData<String>()

    // Backing property
    val score: LiveData<Int>
        get() = _score
    val currentWordCount: LiveData<Int>
        get() = _currentWordCount
    val currentScrambledWord: LiveData<String>
        get() = _currentScrambledWord

    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    init {
        Log.d("GameFragment", "GameViewModel created!")
        getNextWord()
    }

    fun nextWord(): Boolean {
        return if (_currentWordCount.value!! < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    /*
    * Gets a random word for the list of words and shuffles the letters in it.
    */
    private fun getNextWord() {
        currentWord = allWordsList.random()
        Log.d("game", currentWord)
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord.value = String(tempWord)
            _currentWordCount.value = _currentWordCount.value?.inc()
            wordsList.add(currentWord)
        }
    }

    private fun increaseScore() {
        _score.value = _score.value?.plus(SCORE_INCREASE)
    }

    fun isUserWordCorrect(playerWord: String): Boolean {
        Log.d("Check", currentWord)
        if (playerWord.equals(currentWord, true)) {
            increaseScore()
            return true
        }
        return false
    }

    /*
    * Re-initializes the game data to restart the game.
    */
    fun reinitializeData() {
        _score.value = 0
        _currentWordCount.value = 0
        wordsList.clear()
        getNextWord()
    }

}