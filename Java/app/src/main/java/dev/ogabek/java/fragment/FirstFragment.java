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
import dev.ogabek.java.model.Person;

public class FirstFragment extends Fragment {

    Button btn_send;
    TextView name, surname;

    FirstListener listener = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        btn_send = view.findViewById(R.id.btn_send_first);
        name = view.findViewById(R.id.tv_name_first);
        surname = view.findViewById(R.id.tv_surname_first);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFirstSend(new Person("Ogabek", "Matyakubov"));
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
            listener = (FirstListener) context;
        } else {
            throw new RuntimeException(context.toString() + " is unsupported format");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}