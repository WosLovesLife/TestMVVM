package com.wosloveslife.testmvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.wosloveslife.testmvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        User user = new User("lovesLife","wos");
        binding.setUser(user);

        User coalescing = new User("lovesLife",null);
        binding.setCoalescing(coalescing);

        binding.setLargePadding(false);


        final ObservableUser observableUser = new ObservableUser();
        binding.setObservable(observableUser);

        EditText editText = (EditText) findViewById(R.id.edit_text);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                observableUser.setFirstName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        EditText changeLastText = (EditText) findViewById(R.id.edit_last_text);
        changeLastText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                observableUser.setLastName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
