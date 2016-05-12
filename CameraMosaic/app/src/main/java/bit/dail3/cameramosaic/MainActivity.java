package bit.dail3.cameramosaic;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private String photoFileName;
    private File mPhotoFile;
    private Uri photoFilrUri;
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPhotoIntent = (Button) findViewById(R.id.btnPhotoIntent);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);

        btnPhotoIntent.setOnClickListener(new TakeAPhoto());
    }

    private File createTimeStampFile()
    {
        File rootPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File thisImage = new File(rootPath, "Mosaic");
        if(!thisImage.exists())
        {
            thisImage.mkdirs();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date currentDate = new Date();
        String timeStamp = dateFormat.format(currentDate);
        photoFileName = "IMG_" + timeStamp + ".jpg";
        return new File(thisImage.getPath() + File.separator + photoFileName);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        if(requestCode == 1)
        {
            if(resultCode == RESULT_OK)
            {
                String filePath = mPhotoFile.getPath();
                Bitmap thePhoto = BitmapFactory.decodeFile(filePath);

                imageView.setImageBitmap(thePhoto);
                imageView2.setImageBitmap(thePhoto);
                imageView3.setImageBitmap(thePhoto);
                imageView4.setImageBitmap(thePhoto);
            }
            else
            {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }

    class TakeAPhoto implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            mPhotoFile = createTimeStampFile();
            photoFilrUri = Uri.fromFile(mPhotoFile);
            Intent photoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            photoIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoFilrUri);
            startActivityForResult(photoIntent, 1);
        }
    }
}
