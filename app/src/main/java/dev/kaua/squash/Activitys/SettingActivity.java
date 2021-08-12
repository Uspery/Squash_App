package dev.kaua.squash.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;
import dev.kaua.squash.BuildConfig;
import dev.kaua.squash.Data.Account.DtoAccount;
import dev.kaua.squash.Data.Post.DtoPost;
import dev.kaua.squash.Data.Post.PostServices;
import dev.kaua.squash.Fragments.MainFragment;
import dev.kaua.squash.R;
import dev.kaua.squash.Security.EncryptHelper;
import dev.kaua.squash.Security.Login;
import dev.kaua.squash.Tools.LoadingDialog;
import dev.kaua.squash.Tools.Methods;
import dev.kaua.squash.Tools.MyPrefs;
import dev.kaua.squash.Tools.Warnings;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *  Copyright (c) 2021 Kauã Vitório
 *  Official repository https://github.com/Kauavitorio/Squash_App
 *  Responsible developer: https://github.com/Kauavitorio
 *  @author Kaua Vitorio
 **/

public class SettingActivity extends AppCompatActivity {
    TextView txt_username;
    CircleImageView profile_image;
    TextView txt_app_version;
    private LinearLayout btn_notifications, btn_data, btn_logout;
    private LinearLayout btn_policy_and_Privacy;
    private DtoAccount mAccount;
    private Animation myAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Ids();

        Toolbar toolbar = findViewById(R.id.toolbar_setting);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        btn_notifications.setOnClickListener(v -> {
            btn_notifications.startAnimation(myAnim);
        });

        btn_data.setOnClickListener(v -> {
            btn_data.startAnimation(myAnim);
            Intent intent = new Intent(this, ConnectionUsageActivity.class);
            startActivity(intent);
        });

        //  Privacy Policy click
        btn_policy_and_Privacy.setOnClickListener(v -> {
            btn_policy_and_Privacy.startAnimation(myAnim);
            Methods.browseTo(this, Methods.POLICY_PRIVACY_LINK);
        });

        //  Logout click
        btn_logout.setOnClickListener(v -> {
            btn_logout.startAnimation(myAnim);
            AlertDialog.Builder alert = new AlertDialog.Builder(this, R.style.MyAlertDialogStyle)
                    .setTitle(getString(R.string.logout))
                    .setMessage(getString(R.string.really_want_to_log_out))
                    .setPositiveButton(getString(R.string.yes), (dialog, which) -> {
                        dialog.dismiss();
                        Login.LogOut(this, 0);
                    })
                    .setNeutralButton(getString(R.string.no), (dialogInterface, i) -> dialogInterface.dismiss());
            Dialog mDialog = alert.create();
            mDialog.getWindow().getAttributes().windowAnimations = R.style.MyAlertDialogStyle;
            mDialog.show();
        });
    }

    @SuppressLint("SetTextI18n")
    private void Ids() {
        myAnim = AnimationUtils.loadAnimation(this,R.anim.click_anim);
        getWindow().setStatusBarColor(getColor(R.color.background_menu_sheet));
        getWindow().setNavigationBarColor(getColor(R.color.background_setting));
        mAccount = MyPrefs.getUserInformation(this);
        txt_app_version = findViewById(R.id.txt_app_version);
        btn_logout = findViewById(R.id.btn_logout);
        txt_username = findViewById(R.id.txt_username_setting);
        btn_notifications = findViewById(R.id.btn_notifications);
        btn_data = findViewById(R.id.btn_data);
        btn_policy_and_Privacy = findViewById(R.id.btn_policy_and_Privacy);
        profile_image = findViewById(R.id.profile_image_setting);

        txt_app_version.setText(getString(R.string.squash_for_mobile, BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE) + " " + getAbi());

        txt_username.setText(mAccount.getName_user());
        Glide.with(this).load(mAccount.getProfile_image()).into(profile_image);
    }

    public String getAbi() {
        return Build.SUPPORTED_ABIS[0];
    }
}