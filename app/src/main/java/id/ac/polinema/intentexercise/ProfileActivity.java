package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private TextView aboutText;
    private TextView nameText;
    private TextView emailText;
    private TextView homePageText;
    private ImageView avatarImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        aboutText = findViewById(R.id.label_about);
        nameText = findViewById(R.id.label_fullname);
        emailText = findViewById(R.id.label_email);
        homePageText = findViewById(R.id.label_homepage);
        avatarImage = findViewById(R.id.image_profile);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            // TODO: display value here
            Bundle extra = getIntent().getExtras();
            Bitmap bmp = extra.getParcelable("image");
            avatarImage.setImageBitmap(bmp);

            aboutText.setText(extras.getString("about"));
            nameText.setText(extras.getString("fullname"));
            emailText.setText(extras.getString("email"));
            homePageText.setText(extras.getString("homepage"));
        }
    }
    public void handleHomePage(View view) {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String homepageText = bundle.getString("homepage");
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + homepageText));
             startActivity(intent);
        }
    }
}
