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
import dev.ogabek.kotlin.model.Person
import java.lang.Exception

class FirstFragment : Fragment() {

    private lateinit var btn_send: Button
    private lateinit var tv_name: TextView
    private lateinit var tv_surname: TextView

    private var listener: FirstListener? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        btn_send = view.findViewById(R.id.btn_send_first)
        tv_name = view.findViewById(R.id.tv_name_first)
        tv_surname = view.findViewById(R.id.tv_surname_first)

        btn_send.setOnClickListener {
            listener!!.onFirstSend(Person("Ogabek", "Matyakubov"))
        }

        return view
    }

    fun updateData(person: Person) {
        tv_name.text = person.name
        tv_surname.text = person.surname
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FirstListener) {
            listener = context
        } else {
            throw ClassCastException("$context must be FirstListener.class")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

}