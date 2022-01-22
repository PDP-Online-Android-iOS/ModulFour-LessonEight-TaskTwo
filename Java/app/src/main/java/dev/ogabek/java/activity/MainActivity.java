package dev.ogabek.java.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import dev.ogabek.java.R;
import dev.ogabek.java.fragment.FirstFragment;
import dev.ogabek.java.fragment.SecondFragment;
import dev.ogabek.java.listener.FirstListener;
import dev.ogabek.java.listener.SecondListener;
import dev.ogabek.java.model.Person;

public class MainActivity extends AppCompatActivity implements FirstListener, SecondListener {

    FirstFragment firstFragment;
    SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.firstFragment, firstFragment)
                .replace(R.id.secondFragment, secondFragment)
                .commit();
    }

    @Override
    public void onFirstSend(Person person) {
        secondFragment.updateData(person);
    }

    @Override
    public void onSecondSend(Person person) {
        firstFragment.updateData(person);
    }
}