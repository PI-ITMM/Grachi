package com.example.grachi

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.grachi.Models.User
import com.example.grachi.databinding.ActivityMainBinding
import com.example.grachi.databinding.ActivityMenuBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.rengwuxian.materialedittext.MaterialEditText

private lateinit var binding: ActivityMainBinding
lateinit var auth: FirebaseAuth
lateinit var login: MaterialEditText
lateinit var pass: MaterialEditText
lateinit var btnSignIn: Button
lateinit var users: DatabaseReference
lateinit var userID:String
lateinit var userEnteredPassword: String
lateinit var db: FirebaseDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnSignIn = binding.btnSignIn
        auth = FirebaseAuth.getInstance()
        db = FirebaseDatabase.getInstance()
        users = db.reference
        login = binding.loginField
        pass = binding.passField
    btnSignIn.setOnClickListener {
            users.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    showData(dataSnapshot)
                }

                override fun onCancelled(databaseError: DatabaseError) {

                }
            })
        }
    }

private fun showData(dataSnapshot: DataSnapshot) {
        var uInfo= User()
    var password: String = "";
        userID = login.text.toString();
        userEnteredPassword = pass.text.toString();
        if (dataSnapshot.child("Users").child(userID).child("pass").exists())
        {
        password=dataSnapshot.child("Users").child(userID).child("pass").value.toString();
        }
        if (password.equals(userEnteredPassword)) {

            uInfo.setKl(
                dataSnapshot.child("Users").child(userID)
                    .getValue(User::class.java)?.getKl()) //set the klass
            uInfo.setLetter(
                dataSnapshot.child("Users").child(userID)
                    .getValue(User::class.java)?.getLetter()) //set the letter
            uInfo.setName(
                dataSnapshot.child("Users").child(userID)
                    .getValue(User::class.java)?.getName())
            uInfo.setSurname(
                dataSnapshot.child("Users").child(userID)
                    .getValue(User::class.java)?.getSurname())
            val monday = ArrayList<String>()
            val tuesday = ArrayList<String>()
            val wednesday = ArrayList<String>()
            val thursday = ArrayList<String>()
            val friday = ArrayList<String>()
            val saturday = ArrayList<String>()
            val teachers = uInfo.getteach()
            val teachersname = ArrayList<String>()
            val marks = ArrayList<String>()
            val NAME = uInfo.getSurname()+ " "+uInfo.getName()
            for (i in 1..8)
            {
                monday.add(
                    dataSnapshot.child("Расписание").child(uInfo.getKl().toString()).
                    child(uInfo.getLetter().toString()).
                    child("Понедельник")
                        .child(i.toString()).getValue(
                            String::class.java
                        )!!)
                tuesday.add(
                    dataSnapshot.child("Расписание").child(uInfo.getKl().toString()).
                    child(uInfo.getLetter().toString()).
                    child("Вторник")
                        .child(i.toString()).getValue(
                            String::class.java
                        )!!)
                wednesday.add(
                    dataSnapshot.child("Расписание").child(uInfo.getKl().toString()).
                    child(uInfo.getLetter().toString()).
                    child("Среда")
                        .child(i.toString()).getValue(
                            String::class.java
                        )!!)
                thursday.add(
                    dataSnapshot.child("Расписание").child(uInfo.getKl().toString()).
                    child(uInfo.getLetter().toString()).
                    child("Четверг")
                        .child(i.toString()).getValue(
                            String::class.java
                        )!!)
                friday.add(
                    dataSnapshot.child("Расписание").child(uInfo.getKl().toString()).
                    child(uInfo.getLetter().toString()).
                    child("Пятница")
                        .child(i.toString()).getValue(
                            String::class.java
                        )!!)
                saturday.add(
                    dataSnapshot.child("Расписание").child(uInfo.getKl().toString()).
                    child(uInfo.getLetter().toString()).
                    child("Суббота")
                        .child(i.toString()).getValue(
                            String::class.java
                        )!!)
            }
for (i in 1..teachers!!.size)
{
    teachersname.add(dataSnapshot.child("Учителя").child(uInfo.getKl()!!).child(uInfo.getLetter()!!).child(teachers[i-1]).getValue(
        String::class.java
    )!!)
    marks.add(dataSnapshot.child("Оценки").child(teachers[i-1]).child(uInfo.getKl()!!).child(uInfo.getLetter()!!)
        .child(NAME)
        .getValue(
            String::class.java
        )!!)
}

intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("userID",userID)
            intent.putExtra("monday",monday)
            intent.putExtra("tuesday",tuesday)
            intent.putExtra("wednesday",wednesday)
            intent.putExtra("thursday",thursday)
            intent.putExtra("friday",friday)
            intent.putExtra("saturday",saturday)
            intent.putExtra("teachersthings",teachers)
            intent.putExtra("teachersname",teachersname)
            intent.putExtra("marks",marks)
            startActivity(intent)
        } else
    {
        Toast.makeText(applicationContext, "Попробуйте ещё раз!", Toast.LENGTH_SHORT).show()
    }
}


    }
