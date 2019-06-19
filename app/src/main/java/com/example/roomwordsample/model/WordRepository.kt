package com.example.roomwordsample.model

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class WordRepository(private val wordDAO: WordDAO){
    val allWords: LiveData<List<Word>> = wordDAO.getAllWords()

    @WorkerThread
    suspend fun insert(word: Word){
        wordDAO.insert(word)
    }
}