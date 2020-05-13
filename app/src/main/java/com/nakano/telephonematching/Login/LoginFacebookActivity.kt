package com.nakano.telephonematching.Login

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.util.Log.w
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.nakano.telephonematching.R
import kotlinx.android.synthetic.main.activity_login_facebook.*

class LoginFacebookActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_facebook)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Initialize Facebook Login button
        callbackManager = CallbackManager.Factory.create()

        button_sign_in_facebook.setReadPermissions("email", "public_profile")
        button_sign_in_facebook.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                d(TAG, "facebook:onSuccess:$loginResult")
                handleFacebookAccessToken(loginResult.accessToken)
            }

            override fun onCancel() {
                d(TAG, "facebook:onCancel")
                // ...
            }

            override fun onError(error: FacebookException) {
                d(TAG, "facebook:onError", error)
                // ...
            }
        })
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
//        updateUI(currentUser)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Pass the activity result back to the Facebook SDK
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    private fun handleFacebookAccessToken(token: AccessToken) {
        d(TAG, "handleFacebookAccessToken:$token")

        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    d(TAG, "signInWithCredential:success")
                    val user = auth.currentUser
//                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    w(TAG, "signInWithCredential:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
//                    updateUI(null)
                }
            }
    }

    fun signOut() {
        auth.signOut()
        LoginManager.getInstance().logOut()

//        updateUI(null)
    }

    companion object {
        private const val TAG = "FacebookLogin"
    }
}
