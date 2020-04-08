package kr.hdev.roomexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider.AndroidViewModelFactory(application).create(MainViewModel::class.java)

        viewModel.getAll().observe(this, Observer {
            tv_result.text = it.toString()
        })
        btn_add.setOnClickListener{
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.insert(Todo(et_todo.text.toString()))
            }
        }
    }
}
