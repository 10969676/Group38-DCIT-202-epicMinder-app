package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.my_app.model.TaskModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Collection;

public class HomeActivity extends AppCompatActivity {
    RecyclerView taskRv;
    ArrayList<TaskModel> dataList = new ArrayList<>();
    TaskListAdapter  taskListAdapter;
    FirebaseFirestore db;
    //String TAG = "Homepage query docs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        taskRv = findViewById(R.id.taskListRv);
        String taskId;
        String taskName;
        String taskStatus;
        dataList.add(new TaskModel("testId", "Demo task", "completed"));
        dataList.add(new TaskModel("testId", "Go to Gym", "pending"));
        dataList.add(new TaskModel("testId", "Cook Jollof", "pending"));
        dataList.add(new TaskModel("testId", "Prayer Meeting", "completed"));
        dataList.add(new TaskModel("testId", "Study Comp. Science", "completed"));
        taskListAdapter = new TaskListAdapter(dataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false
        );
        taskRv.setLayoutManager(layoutManager);
        taskRv.setAdapter(taskListAdapter);

        findViewById(R.id.addTaskFAB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, AddTaskActivity.class));
            };




        });
        findViewById(R.id.leftSecond_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            };

        });

//        db.collection( "tasks")
//              //  .whereEqualTo("capital", true)
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Log.d(TAG, document.getId() + " => " + document.getData());
//
//                                TaskModel taskModel= document.toObject(TaskModel.class);
//                                dataList.add(taskModel);
//                                taskListAdapter.notifyDataSetChanged();
//
//
//                            }
//                        } else {
//                            Log.d(TAG, "Error getting documents: ", task.getException());
//                        }
//                    }
//                });


    }};