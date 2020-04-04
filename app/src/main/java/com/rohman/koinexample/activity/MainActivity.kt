package com.rohman.koinexample.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rohman.koinexample.*
import com.rohman.koinexample.feature.contact.AdapterCallback
import com.rohman.koinexample.feature.contact.ContactAdapter
import com.rohman.koinexample.feature.contact.ContactViewModel
import com.rohman.koinexample.model.ContactModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(),
    AdapterCallback, View.OnClickListener {
    private val contactViewModel: ContactViewModel by viewModel()
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        btnInput.setOnClickListener(this)
    }

    private fun initRecyclerView() {
        adapter =
            ContactAdapter(this, this)
        contactViewModel.allContacts.observe(this, Observer { data ->
            data?.let { adapter.setData(it) }
        })

        recLayout.layoutManager = LinearLayoutManager(this)
        recLayout.setHasFixedSize(true)
        recLayout.adapter = adapter
    }

    override fun onItemClicked(contactModel: ContactModel) {
        contactViewModel.deleteContact(contactModel)
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btnInput) {
            val name = edtName.text.toString()
            val description = edtDescription.text.toString()
            edtDescription.text.clear()
            edtName.text.clear()
            contactViewModel.addContact(
                ContactModel(
                    0,
                    name,
                    description
                )
            )
        }
    }
}
