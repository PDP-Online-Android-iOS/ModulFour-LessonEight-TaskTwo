package dev.ogabek.kotlin.Fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.listener.FirstListener
import dev.ogabek.kotlin.listener.SecondListener
import dev.ogabek.kotlin.model.Person

class SecondFragment : Fragment() {

    private lateinit var btn_return: Button
    private lateinit var tv_name: TextView
    private lateinit var tv_surname: TextView

    private var listener: SecondListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_second, container, false)

        btn_return = view.findViewById(R.id.btn_return_second)
        tv_name = view.findViewById(R.id.tv_name_second)
        tv_surname = view.findViewById(R.id.tv_surname_second)

        btn_return.setOnClickListener {
            listener!!.onSecondSend(Person("Bogibek", "Matyaqubov"))
        }

        return view
    }

    fun updateData(person: Person) {
        tv_name.text = person.name
        tv_surname.text = person.surname
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SecondListener) {
            listener = context
        } else {
            throw ClassCastException("$context must be SecondListener.class")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}