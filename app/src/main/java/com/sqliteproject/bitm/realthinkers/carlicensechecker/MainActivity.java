package com.sqliteproject.bitm.realthinkers.carlicensechecker;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.net.PasswordAuthentication;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    EditText checkEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkEt = findViewById(R.id.etCheckByNo);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* getMenuInflater().inflate(R.menu.menu_main, menu);*/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            menu.add(0, 1, 1, menuIconWithText(Objects.requireNonNull(getDrawable(R.drawable.add_new)), getString(R.string.adnew)));
            menu.add(0, 2, 2, menuIconWithText(Objects.requireNonNull(getDrawable(R.drawable.show_all)), getString(R.string.show_all)));
            menu.add(0, 3, 3, menuIconWithText(Objects.requireNonNull(getDrawable(R.drawable.exit)), getString(R.string.exit)));
        }
        return true;
    }


    private CharSequence menuIconWithText(Drawable r, String title) {

        r.setBounds(0, 0, r.getIntrinsicWidth(), r.getIntrinsicHeight());
        SpannableString sb = new SpannableString("    " + title);
        ImageSpan imageSpan = new ImageSpan(r, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sb;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case 1:
                enterNewMenuClk();
                break;
            case 2:
                showAllMenuClk();
                break;
            case 3:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void showAllMenuClk() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Authority log in!");

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        final EditText userNameEt = new EditText(this);
        final EditText passEt = new EditText(this);
        passEt.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        userNameEt.setInputType(InputType.TYPE_CLASS_TEXT);
        layout.addView(userNameEt);
        layout.addView(passEt);
        dialog.setView(layout);
        dialog.setPositiveButton("LogIn", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String givenUser = userNameEt.getText().toString();
                String givenPass = passEt.getText().toString();
                if (givenUser.equals("abbas") && givenPass.equals("208760")) {
                    showAllIntent();
                } else if (givenUser.equals("rony") && givenPass.equals("213639")) {
                    showAllIntent();
                } else if (givenUser.equals("nazmul") && givenPass.equals("213101")) {
                    showAllIntent();
                }else {
                    Toast.makeText(MainActivity.this, "You are not authority", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.setNegativeButton("Cancen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();

    } public void enterNewMenuClk() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Authority log in!");

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        final EditText userNameEt = new EditText(this);
        final EditText passEt = new EditText(this);
        passEt.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        userNameEt.setInputType(InputType.TYPE_CLASS_TEXT);
        layout.addView(userNameEt);
        layout.addView(passEt);
        dialog.setView(layout);
        dialog.setPositiveButton("LogIn", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String givenUser = userNameEt.getText().toString();
                String givenPass = passEt.getText().toString();
                if (givenUser.equals("abbas") && givenPass.equals("208760")) {
                    entryIntent();
                } else if (givenUser.equals("rony") && givenPass.equals("213639")) {
                    entryIntent();
                } else if (givenUser.equals("nazmul") && givenPass.equals("213101")) {
                    entryIntent();
                }else {
                    Toast.makeText(MainActivity.this, "You are not authority", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();

    }

    public void entryIntent() {
        Intent intent = new Intent(MainActivity.this, NewEntryActivity.class);
        startActivity(intent);
    }
    public void showAllIntent(){
        Intent intent = new Intent(MainActivity.this,ShowAllCarActivity.class);
        startActivity(intent);
    }



}
