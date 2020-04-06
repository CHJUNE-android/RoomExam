package kr.hdev.roomexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(this, AppDatabase::class.java, "todo_db")
            .allowMainThreadQueries()
            .build()

        db.todoDao().getAll().observe(this, androidx.lifecycle.Observer {
            tv_result.text = it.toString()
        })
        btn_add.setOnClickListener{
            db.todoDao().insert(Todo(title = et_todo.text.toString(),id = 0))
        }
    }
}
