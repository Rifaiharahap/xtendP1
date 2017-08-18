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

        Btakeimge = (Button)findViewById(R.id.TakeImage);
        BSend = (Button)findViewById(R.id.BSend);
        ETcomment = (EditText) findViewById(R.id.EDcommet);
        IVshowimage = (ImageView) findViewById(R.id.ShowImage);
        LLComment = (LinearLayout)findViewById(R.id.LLComment);
        now = new Date();

        Btakeimge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GetImage();

            }
        });
    }

    private void GetImage(){



        /*final String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/picFolder/";
        File newdir = new File(dir);
        newdir.mkdirs();

        // Here, the counter will be incremented each time, and the
        // picture taken by camera will be stored as 1.jpg,2.jpg
        // and likewise.
        String file =  dir + date +".jpg";
        File newfile = new File(file);
        try {

            newfile.createNewFile();

        }
        catch (IOException e)
        { }

        Uri outputFileUri = Uri.fromFile(newfile);*/

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);

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

            //Uri outputFileUri = Uri.fromFile(newfile);
            //data.putExtra(MediaStore.EXTRA_OUTPUT,outputFileUri);
        }
    }

}
