package io.github.angiecho.coursetrack.login;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import io.github.angiecho.coursetrack.R;

public class EmailSignInActivity extends EmailAuthActivity {

    private static String TAG = EmailSignInActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_signin);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.email_signup_text)
    public void redirectEmailSignUp() {
        finish();
    }

    @Override
    @OnClick(R.id.email_signin_button)
    public void emailAuth() {
        super.emailAuth();
    }

    @Override
    protected void firebaseEmailAuth(String email, String password) {
        super.firebaseEmailAuth(email, password);

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail:failed", task.getException());
                            Toast.makeText(EmailSignInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(EmailSignInActivity.this, "Authentication succeeded.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        showProgress(false);
                    }
                });
    }
}
