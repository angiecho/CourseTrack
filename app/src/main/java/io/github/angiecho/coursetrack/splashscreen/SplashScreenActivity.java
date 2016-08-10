package io.github.angiecho.coursetrack.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.angiecho.coursetrack.BaseActivity;
import io.github.angiecho.coursetrack.R;
import io.github.angiecho.coursetrack.coursedata.CourseDataActivity;
import io.github.angiecho.coursetrack.login.EmailSignUpActivity;

public class SplashScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.view_courses_button)
    public void viewCourses() {
        Intent intent = new Intent(this, CourseDataActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.google_signup_button)
    public void googleSignUp() {
        Toast.makeText(this, "Temporarily Unavailable", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.email_signup_text)
    public void emailSignUp() {
        Intent intent = new Intent(this, EmailSignUpActivity.class);
        startActivity(intent);
    }
}
