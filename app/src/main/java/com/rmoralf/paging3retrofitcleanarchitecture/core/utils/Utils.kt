package com.rmoralf.paging3retrofitcleanarchitecture.core.utils

import android.util.Log
import androidx.paging.LoadState
import com.rmoralf.paging3retrofitcleanarchitecture.core.utils.Constants.TAG

class Utils {
    companion object {
        fun printError(errorState: LoadState.Error) {
            val error = errorState.error
            Log.d(TAG, error.message ?: error.toString())
        }
    }


}