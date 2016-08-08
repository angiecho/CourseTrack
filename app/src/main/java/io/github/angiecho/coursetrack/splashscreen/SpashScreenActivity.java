package io.github.angiecho.coursetrack.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.angiecho.coursetrack.BaseActivity;
import io.github.angiecho.coursetrack.R;
import io.github.angiecho.coursetrack.login.EmailSignupActivity;

public class SpashScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.view_courses_button)
    public void viewCourses(Button button) {
        button.setText("Hello!");
    }

    @OnClick(R.id.google_signup_button)
    public void googleSignUp() {
        Toast.makeText(SpashScreenActivity.this, "Temporarily Unavailable", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.email_signup_text)
    public void emailSignUp() {
        Intent intent = new Intent(this, EmailSignupActivity.class);
        startActivity(intent);
    }
}
