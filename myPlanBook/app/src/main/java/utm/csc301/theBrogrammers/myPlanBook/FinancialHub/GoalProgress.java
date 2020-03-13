package utm.csc301.theBrogrammers.myPlanBook.FinancialHub;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import utm.csc301.theBrogrammers.myPlanBook.R;

public class GoalProgress extends AppCompatActivity {

    private Button enter, change;
    private EditText goalText, priceText, gainText, spendText;
    private TextView progressText;
    private String goal, price, gain, spend;
    private float goal_int = 1;
    private float add = 0;
    private float sub = 0;
    private float currently_at = 0;
    private ProgressBar bar;
    float set = 0;
    Drawable bgDrawable;
    DatabaseReference db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}


