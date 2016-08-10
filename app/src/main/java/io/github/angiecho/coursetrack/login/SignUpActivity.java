package io.github.angiecho.coursetrack.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

public class SignUpActivity extends AuthActivity {


    private static String TAG = SignUpActivity.class.getSimpleName();

    @BindView(R.id.email_field)
    AutoCompleteTextView emailTextView;

    @BindView(R.id.password_field)
    TextView passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_signup);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.email_signin_text)
    public void redirectEmailSignIn() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }


    @OnClick(R.id.email_signup_button)
    public void emailSignUp() {
        String email = emailTextView.getText().toString();
        String password = passwordTextView.getText().toString();
        firebaseEmailSignUp(email, password);
    }

    private void firebaseEmailSignUp(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Sign up failed.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUpActivity.this, "Registration succeeded.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
