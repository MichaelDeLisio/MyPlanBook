package utm.csc301.theBrogrammers.myPlanBook.LogBodyFat;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

import utm.csc301.theBrogrammers.myPlanBook.R;

public class LogBodyFatActivity extends AppCompatActivity {

    private LinearLayout.LayoutParams params1;
    private LinearLayout.LayoutParams params2;
    private LinearLayout.LayoutParams params3;
    private int MARGIN_SIZE;
    private int EDIT_MODE_TV_WIDTH = 875;
    private LinearLayout scrollViewLayoutLogBodyFat;
    private TextView calendarDate;
    private int currentMonth;
    private String currentDate;
    private EditText bodyFatInputTextField;
    private BodyFatModel bodyFatModel;
    private int bodyFatEntryLayoutId;
    private LinearLayout bodyFatEntryLayout;
    private int bodyFatEntryTVId;
    private TextView bodyFatEntryTV;
    private int PADDING_SIZE;
    private Button enterBodyFatEntryButton;
    private CalendarView calendarView;
    private int bodyFatEntryCheckBoxId;
    private CheckBox bodyFatEntryCheckBox;
    private FloatingActionButton editButton;
    private FloatingActionButton deleteButton;
    private Boolean editMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_body_fat);
        this.PADDING_SIZE = getResources().getDimensionPixelSize(R.dimen.padding_size);
        this.assignParams();
        this.assignScrollViewLayout();
        this.assignBodyFatInputTextField();
        this.setCurrentDate();
        bodyFatModel = new BodyFatModel();
        this.createBodyFatEntryLayout();
        this.createBodyFatEntryCheckBox();
        this.createBodyFatEntryTextView();
        this.setBodyFatEntryTextView();
        this.setEnterButtonListener();
        this.setCalendarViewListener();
        this.setEditFloatingButtonListener();
        this.setDeleteFloatingButtonListener();
    }

    private void assignParams(){
        this.MARGIN_SIZE = getResources().getDimensionPixelSize(R.dimen.margin_size);
        params1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params1.setMargins(MARGIN_SIZE, 0,MARGIN_SIZE,MARGIN_SIZE);
        params2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params2.setMargins(MARGIN_SIZE,MARGIN_SIZE,MARGIN_SIZE,MARGIN_SIZE);
        params3 = new LinearLayout.LayoutParams(
                EDIT_MODE_TV_WIDTH,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params3.setMargins(MARGIN_SIZE,0,MARGIN_SIZE,MARGIN_SIZE);
    }

    private void assignScrollViewLayout() {
        scrollViewLayoutLogBodyFat = (LinearLayout) findViewById(R.id.scrollview_layout_log_body_fat);
    }

    private void assignBodyFatInputTextField(){
        bodyFatInputTextField = (EditText) findViewById(R.id.edit_text_input_body_fat);
    }

    private void setCurrentDate(){
        calendarDate = (TextView) findViewById(R.id.date_log_body_fat);
        Calendar newCalendar = Calendar.getInstance();
        int currentYear = newCalendar.get(Calendar.YEAR);
        currentMonth = newCalendar.get(Calendar.MONTH) + 1;
        int currentDay = newCalendar.get(Calendar.DAY_OF_MONTH);
        currentDate = String.valueOf(currentDay) + "/" + String.valueOf(currentMonth) + "/" + String.valueOf(currentYear);
        calendarDate.setText(currentDate);
    }

    private void createBodyFatEntryLayout() {
        this.bodyFatEntryLayout = new LinearLayout(this);
        this.bodyFatEntryLayout.setId(ViewCompat.generateViewId());
        this.bodyFatEntryLayoutId = bodyFatEntryLayout.getId();
        this.bodyFatEntryLayout.setOrientation(LinearLayout.HORIZONTAL);
        this.bodyFatEntryLayout.setVisibility(View.GONE);
        this.bodyFatEntryLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        scrollViewLayoutLogBodyFat.addView(this.bodyFatEntryLayout, 6);
    }

    private void createBodyFatEntryCheckBox() {
        this.bodyFatEntryCheckBox = new CheckBox(this);
        this.bodyFatEntryCheckBox.setId(ViewCompat.generateViewId());
        this.bodyFatEntryCheckBoxId = this.bodyFatEntryCheckBox.getId();
        this.bodyFatEntryCheckBox.setVisibility(View.GONE);
        LinearLayout.LayoutParams checkBoxParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        checkBoxParams.setMargins(MARGIN_SIZE, 0, 0, 0);
        this.bodyFatEntryCheckBox.setLayoutParams(checkBoxParams);
        this.bodyFatEntryLayout.addView(this.bodyFatEntryCheckBox, 0);
    }

    private void createBodyFatEntryTextView(){
        this.bodyFatEntryTV = new TextView(this);
        this.bodyFatEntryTV.setBackgroundResource(R.drawable.box_outline_bordered);
        this.bodyFatEntryTV.setLayoutParams(params1);
        this.bodyFatEntryTV.setPadding(PADDING_SIZE,PADDING_SIZE,PADDING_SIZE,PADDING_SIZE);
        this.bodyFatEntryTV.setTextColor(Color.parseColor("#858585"));
        this.bodyFatEntryTV.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.text_size));
        this.bodyFatEntryTV.setTypeface(Typeface.SANS_SERIF);
        this.bodyFatEntryTV.setId(ViewCompat.generateViewId());
        this.bodyFatEntryTVId = bodyFatEntryTV.getId();
        this.bodyFatEntryTV.setVisibility(View.GONE);
        this.bodyFatEntryLayout.addView(this.bodyFatEntryTV, 1);
    }

    private void setBodyFatEntryTextView(){
        String bodyFatEntryForDate = bodyFatModel.getBodyFatEntry(currentDate);
        bodyFatEntryForDate = bodyFatEntryForDate == null? "": bodyFatEntryForDate;
        this.bodyFatEntryTV.setText(bodyFatEntryForDate);
        int visibility = bodyFatEntryForDate.isEmpty()? View.GONE: View.VISIBLE;
        this.bodyFatEntryTV.setVisibility(visibility);
        this.bodyFatEntryLayout.setVisibility(visibility);
    }

    private void setEnterButtonListener(){
        enterBodyFatEntryButton = (Button) findViewById(R.id.button_enter_body_fat);
        enterBodyFatEntryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addBodyFatEntry();
            }
        });
    }

    private void addBodyFatEntry(){
        String bodyFat = bodyFatInputTextField.getText().toString();
        if (bodyFat.length() > 10 || bodyFat.isEmpty()) {
            return;
        }
        bodyFatModel.addBodyFatEntry(currentDate, bodyFat + "%");
        setBodyFatEntryTextView();
    }

    private void setCalendarViewListener(){
        calendarView = (CalendarView) findViewById(R.id.calendar_view_log_body_fat);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                if (editMode == true) {
                    setEditModeFeatures();
                }
                String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                calendarDate.setText(date);
                currentDate = date;
                currentMonth = (currentMonth != month + 1)? month + 1: currentMonth;
                setBodyFatEntryTextView();
            }
        });
    }

    private void setEditFloatingButtonListener(){
        editButton = (FloatingActionButton) findViewById(R.id.edit_button_log_body_fat);
        editButton.setImageResource(R.drawable.edit_pencil);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!bodyFatEntryTV.getText().toString().isEmpty()) {
                    setEditModeFeatures();
                }
            }
        });
    }

    private void setDeleteFloatingButtonListener(){
        deleteButton = (FloatingActionButton) findViewById(R.id.delete_button_log_body_fat);
        deleteButton.setImageResource(R.drawable.garbage_can);
        deleteButton.hide();
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteBodyFatEntry();
            }
        });
    }

    private void setEditModeFeatures(){
        if (editMode == true){
            deleteButton.hide();
        }
        else {
            deleteButton.show();
        }
        int editDrawableId = editMode == true? R.drawable.edit_pencil: R.drawable.ex_cancel;
        editButton.setImageResource(editDrawableId);
        editMode = editMode == true? false: true;
        setCheckBoxVisibility();
        setBodyFatEntryTVParams();
    }

    private void setCheckBoxVisibility(){
        bodyFatEntryCheckBox.setChecked(false);
        int visibility = editMode == false? View.GONE: View.VISIBLE;
        bodyFatEntryCheckBox.setVisibility(visibility);
    }

    private void setBodyFatEntryTVParams(){
        if (editMode == false) {
            bodyFatEntryTV.setLayoutParams(params1);
        }
        else {
            bodyFatEntryTV.setLayoutParams(params3);
        }
    }

    private void deleteBodyFatEntry(){
        if (editMode == false || bodyFatEntryTV.getText().toString().isEmpty() || !bodyFatEntryCheckBox.isChecked()) {
            return;
        }
        bodyFatModel.deleteBodyFatEntry(currentDate);
        setEditModeFeatures();
        setBodyFatEntryTextView();
    }

}
