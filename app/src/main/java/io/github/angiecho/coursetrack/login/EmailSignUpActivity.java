package io.github.angiecho.coursetrack.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import io.github.angiecho.coursetrack.R;

public class EmailSignUpActivity extends EmailAuthActivity {


    private static String TAG = EmailSignUpActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_signup);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.email_signin_text)
    public void redirectEmailSignIn() {
        Intent intent = new Intent(this, EmailSignInActivity.class);
        startActivity(intent);
    }


    @Override
    @OnClick(R.id.email_signup_button)
    public void emailAuth() {
        super.emailAuth();
    }

    @Override
    protected void firebaseEmailAuth(String email, String password) {
        super.firebaseEmailAuth(email, password);

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(EmailSignUpActivity.this, "Sign up failed.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(EmailSignUpActivity.this, "Registration succeeded.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        showProgress(false);
                    }
                });
    }
}
