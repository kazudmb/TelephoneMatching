package com.nakano.telephonematching

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.OAuthProvider

class LoginTwitterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_twitter)

        auth = FirebaseAuth.getInstance()

        val provider = OAuthProvider.newBuilder("twitter.com")
        provider.addCustomParameter("lang", "jp")

        val pendingResultTask = auth.pendingAuthResult
        if (pendingResultTask != null) {
            // There's something already here! Finish the sign-in for your user.
            pendingResultTask
                .addOnSuccessListener(
                    OnSuccessListener<AuthResult> {
                        Log.d(TAG, "pendingResultTask:success")
                        // User is signed in.
                        // IdP data available in
                        // authResult.getAdditionalUserInfo().getProfile().
                        // The OAuth access token can also be retrieved:
                        // authResult.getCredential().getAccessToken().
                        // The OAuth secret can be retrieved by calling:
                        // authResult.getCredential().getSecret().
                    })
                .addOnFailureListener {
                    Log.w(TAG, "pendingResultTask:failure", it)
                    // Handle failure.
                }
        } else {
            // There's no pending result so you need to start the sign-in flow.
            // See below.
        }

        auth
            .startActivityForSignInWithProvider(/* activity= */this, provider.build())
            .addOnSuccessListener {
                Log.d(TAG, "startActivityForSignInWithProvider:success")
                // User is signed in.
                // IdP data available in
                // authResult.getAdditionalUserInfo().getProfile().
                // The OAuth access token can also be retrieved:
                // authResult.getCredential().getAccessToken().
                // The OAuth secret can be retrieved by calling:
                // authResult.getCredential().getSecret().
            }
            .addOnFailureListener {
                Log.w(TAG, "startActivityForSignInWithProvider:failure", it)
                // Handle failure.
            }


        // The user is already signed-in.
        val firebaseUser = auth.currentUser

        firebaseUser
            ?.startActivityForLinkWithProvider(/* activity= */this, provider.build())
            ?.addOnSuccessListener {
                Log.d(TAG, "startActivityForLinkWithProvider:success")
                // Twitter credential is linked to the current user.
                // IdP data available in
                // authResult.getAdditionalUserInfo().getProfile().
                // The OAuth access token can also be retrieved:
                // authResult.getCredential().getAccessToken().
                // The OAuth secret can be retrieved by calling:
                // authResult.getCredential().getSecret().
            }
            ?.addOnFailureListener {
                Log.w(TAG, "startActivityForLinkWithProvider:failure", it)
                // Handle failure.
            }


    }

    companion object {
        private const val TAG = "TwitterActivity"
    }
}
