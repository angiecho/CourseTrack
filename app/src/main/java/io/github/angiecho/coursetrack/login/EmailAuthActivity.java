package io.github.angiecho.coursetrack.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Patterns;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import io.github.angiecho.coursetrack.BaseActivity;
import io.github.angiecho.coursetrack.R;

/**
 * Created by andytung on 2016-08-09.
 */
public abstract class EmailAuthActivity extends BaseActivity {

    private static String TAG = EmailSignUpActivity.class.getSimpleName();

    protected FirebaseAuth mAuth;
    protected FirebaseAuth.AuthStateListener mAuthListener;

    private LoginTaskDelegate loginTaskDelegate;

    @BindView(R.id.email_field)
    AutoCompleteTextView emailTextView;

    @BindView(R.id.password_field)
    TextView passwordTextView;

    @BindView(R.id.login_progress)
    ProgressBar loginProgressView;

    @BindView(R.id.login_form)
    ScrollView loginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());

//                    Intent intent = new Intent(EmailAuthActivity.this, CourseDataActivity.class);
//                    startActivity(intent);
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };

        loginTaskDelegate = new LoginTaskDelegate(this);
    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    protected String getValidEmail() {
        emailTextView.setError(null);
        String email = emailTextView.getText().toString();
        if(!isValidEmail(email)) {
            emailTextView.setError("Not a valid email.");
            return null;
        }

        return email;
    }

    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    protected String getValidPassword() {
        passwordTextView.setError(null);
        String password = passwordTextView.getText().toString();
        if(!isValidPassword(password)) {
            passwordTextView.setError("Not valid password. Password must be at least 8 characters long.");
            return null;
        }
        return password;
    }

    public void emailAuth() {
        String email = getValidEmail();
        String password = getValidPassword();
        if(email != null && password != null) {
            firebaseEmailAuth(email, password);
        }
    }

    protected void firebaseEmailAuth(String email, String password) {
        showProgress(true);
    }

    private boolean isValidPassword(String password) {
        return password.length() > 7;
    }

    protected void showProgress(final boolean show) {
        loginTaskDelegate.showProgress(show, loginFormView, loginProgressView);
    }
}
