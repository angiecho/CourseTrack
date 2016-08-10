package io.github.angiecho.coursetrack.login;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.github.angiecho.coursetrack.R;

public class EmailResetActivity extends EmailAuthActivity {

    private static String TAG = EmailResetActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_reset);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.email_signup_text)
    public void redirectEmailSignUp() {
        Toast.makeText(EmailResetActivity.this, "Temporarily unavailable.",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    @OnClick(R.id.email_reset_button)
    public void emailAuth() {
        String email = getValidEmail();
        if(email != null) {
            firebaseEmailAuth(email, "");
        }
    }

    @Override
    protected void firebaseEmailAuth(String email, String password) {
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Email sent.");
                            Toast.makeText(EmailResetActivity.this, "An email has been sent to the address.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(EmailResetActivity.this, "Oops. Something went wrong.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        showProgress(false);
                    }
                });
    }
}
