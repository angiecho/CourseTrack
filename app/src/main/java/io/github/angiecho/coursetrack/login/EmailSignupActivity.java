package io.github.angiecho.coursetrack.login;

import android.content.Intent;
import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.angiecho.coursetrack.BaseActivity;
import io.github.angiecho.coursetrack.R;

public class EmailSignupActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_signup);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.email_signin_text)
    public void emailSignIn() {
        Intent intent = new Intent(this, EmailSigninActivity.class);
        startActivity(intent);
    }
}
