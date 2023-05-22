package it_school.sumdu.edu.myreminder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(R.string.help_activity_action_bar_title);

        TextView helpActivityTextView=findViewById(R.id.help_activity_text_view);

        helpActivityTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendHelpEmail();
            }
        });

    }

    private void sendHelpEmail() {
        String[] helpEmailReceiverAddresses={"baristin43@gmail.com"};
        Intent sendHelpEmailIntent = new Intent(Intent.ACTION_SENDTO);
        sendHelpEmailIntent.setData(Uri.parse("mailto:"));
        sendHelpEmailIntent.putExtra(Intent.EXTRA_EMAIL, helpEmailReceiverAddresses);

        if (sendHelpEmailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendHelpEmailIntent);
        }
    }

}
