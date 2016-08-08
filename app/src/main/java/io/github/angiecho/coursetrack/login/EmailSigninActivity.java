package io.github.angiecho.coursetrack.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.angiecho.coursetrack.R;

public class EmailSigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_signin);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.email_signup_text)
    public void emailSignUp() {
        finish();
    }
}
