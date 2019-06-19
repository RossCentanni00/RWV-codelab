package com.example.roomwordsample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomwordsample.model.Word
import com.example.roomwordsample.model.WordRepository
import com.example.roomwordsample.model.WordRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application){
    private val repository : WordRepository
    val allWords: LiveData<List<Word>>

    init {
        val wordsDAO = WordRoomDatabase.getDatabase(application, viewModelScope).wordDAO()
        repository = WordRepository(wordsDAO)
        allWords = repository.allWords;
    }

    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(word)
    }
}