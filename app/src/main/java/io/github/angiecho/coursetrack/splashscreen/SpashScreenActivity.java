package io.github.angiecho.coursetrack.splashscreen;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.angiecho.coursetrack.BaseActivity;
import io.github.angiecho.coursetrack.R;

public class SpashScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.viewCoursesButton)
    public void viewCourses(Button button) {
        button.setText("Hello!");
    }

    @OnClick(R.id.googleSignUpButton)
    public void googleSignUp() {
        Toast.makeText(SpashScreenActivity.this, "Temporarily Unavailable", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.regularSignUpButtton)
    public void regularSignUp(TextView textView) {
        textView.setText("Hello!");
    }
}
