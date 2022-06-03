package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.dataclasses.DoneTask;
import com.example.myapplication.dataclasses.persons.User;
import com.example.myapplication.repositories.DoneTasksRepository;
import com.example.myapplication.repositories.TasksRepository;
import com.example.myapplication.repositories.UsersRepository;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CheakActivity extends AppCompatActivity{
    static final int GALLERY_REQUEST = 1;
    private static int index;

    User user = UsersRepository.findByNickname(EnterActivity.enterist);

    private void saveAsBitmap(ImageView image, String filename) {
        Bitmap bitmap = image.getDrawingCache();
        try {
            FileOutputStream out = openFileOutput(filename, MODE_PRIVATE);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out); // ставить 85 бесполезно, PNG - это формат сжатия без потерь
            out.close();
        } catch (Exception ignored) {}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheak);

        index = getIntent().getIntExtra("position", 0);

        Button choose = findViewById(R.id.choose_photo);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
            }
        });

        Button post = (Button) findViewById(R.id.post_photo);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView photo = (ImageView) findViewById(R.id.photo);

                saveAsBitmap(photo, user.getNickname() + TasksRepository.repository.get(index).getAddress());
                DoneTask doneTask = new DoneTask(TasksRepository.repository.get(index), user);
                TasksRepository.repository.remove(index);
                DoneTasksRepository.add(doneTask);

                Intent i = new Intent(CheakActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        Bitmap bitmap = null;
        ImageView photo = (ImageView) findViewById(R.id.photo);

        switch(requestCode) {
            case GALLERY_REQUEST:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                        photo.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}