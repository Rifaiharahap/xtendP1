package com.example.xyzskylake.extend;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class InputData extends AppCompatActivity {

    Button Btakeimge,BSend;
    EditText ETcomment;
    ImageView IVshowimage;
    LinearLayout LLComment;
    int TAKE_PHOTO_CODE = 0;
    Date now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        now = new Date();

        Btakeimge = (Button)findViewById(R.id.TakeImage);
        BSend = (Button)findViewById(R.id.BSend);
        ETcomment = (EditText) findViewById(R.id.EDcommet);
        IVshowimage = (ImageView) findViewById(R.id.ShowImage);
        LLComment = (LinearLayout)findViewById(R.id.LLComment);

        double latitude = getIntent().getDoubleExtra("Latitude",0);
        double longitude = getIntent().getDoubleExtra("Longitude",0);

        Log.i("Lat & Long ", "Value " + latitude + " " + longitude);

        Btakeimge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GetImage();

            }
        });
    }

    private void GetImage(){

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        final String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/picFolder/";
        File newdir = new File(dir);
        newdir.mkdirs();

        if (requestCode == TAKE_PHOTO_CODE && resultCode == RESULT_OK) {

            Btakeimge.setVisibility(View.GONE);
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            IVshowimage.setScaleType(ImageView.ScaleType.CENTER_CROP);
            IVshowimage.setVisibility(View.VISIBLE);
            IVshowimage.setImageBitmap(photo);
            LLComment.setVisibility(View.VISIBLE);
            Log.d("CameraDemo", "Pic saved");

            String file =  dir + now +".jpg";
            File newfile = new File(file);

            try{
                FileOutputStream outputStream = new FileOutputStream(newfile);
                photo.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
                outputStream.flush();
                outputStream.close();

            } catch (IOException e){}
        }
    }
}
