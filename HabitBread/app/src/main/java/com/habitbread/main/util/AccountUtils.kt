package com.habitbread.main.util

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.habitbread.main.base.BaseApplication

class AccountUtils(context: Context) {
    lateinit var googleSignInClient : GoogleSignInClient
    init {
        val gso = GoogleSignInOptions.Builder()
            .requestIdToken("191839451290-81q6qni5lt1s5nad9lfrhahabjtrp2pa.apps.googleusercontent.com")
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(context, gso);
    }

    fun signOut() : Task<Void> {
        return googleSignInClient.signOut()
    }

    fun revokeAccess() : Task<Void> {
        return googleSignInClient.revokeAccess()
    }

    fun isAlreadyLoggedIn() : Boolean {
        return (BaseApplication.preferences.googleIdToken != null && GoogleSignIn.getLastSignedInAccount(googleSignInClient.applicationContext) != null)
    }
}