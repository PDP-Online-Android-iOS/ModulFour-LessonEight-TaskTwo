package dev.ogabek.java.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import dev.ogabek.java.R;
import dev.ogabek.java.listener.FirstListener;
import dev.ogabek.java.listener.SecondListener;
import dev.ogabek.java.model.Person;

public class SecondFragment extends Fragment {

    Button btn_return;
    TextView name, surname;

    SecondListener secondListener = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        btn_return = view.findViewById(R.id.btn_return_second);
        name = view.findViewById(R.id.tv_name_second);
        surname = view.findViewById(R.id.tv_surname_second);

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondListener.onSecondSend(new Person("Bogibek", "Matyakubov"));
            }
        });

        return view;
    }

    public void updateData(Person person) {
        name.setText(person.getName());
        surname.setText(person.getSurname());
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FirstListener) {
            secondListener = (SecondListener) context;
        } else {
            throw new RuntimeException(context.toString() + " is unsupported format");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        secondListener = null;
    }

}