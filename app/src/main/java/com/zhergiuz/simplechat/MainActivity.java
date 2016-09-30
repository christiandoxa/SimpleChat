package com.zhergiuz.simplechat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView fireData; //Untuk menampilkan data dari firebase
    Firebase ref; //Inisialisasi Firebase untuk project

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        fireData = (TextView) findViewById(R.id.TextViewFireBase);
        ref = new Firebase("https://simple-chat-781cf.firebaseio.com/");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String superData = (String) dataSnapshot.getValue();
                fireData.setText(superData);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
