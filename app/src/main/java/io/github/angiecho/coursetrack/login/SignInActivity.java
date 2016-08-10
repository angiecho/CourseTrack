package io.github.angiecho.coursetrack.login;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import io.github.angiecho.coursetrack.R;

public class SignInActivity extends AuthActivity {

    private static String TAG = SignInActivity.class.getSimpleName();

    @BindView(R.id.email_field)
    AutoCompleteTextView emailTextView;

    @BindView(R.id.password_field)
    TextView passwordTextView;


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

    @OnClick(R.id.email_signin_button)
    public void emailSignIn() {
        String email = emailTextView.getText().toString();
        String password = passwordTextView.getText().toString();
        firebaseEmailSignIn(email, password);
    }

    private void firebaseEmailSignIn(String email, String password) {
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
                            Toast.makeText(SignInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignInActivity.this, "Authentication succeeded.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
