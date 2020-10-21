package com.android.gaurav.classproject.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.gaurav.classproject.R;
import com.android.gaurav.classproject.authentication.User;
import com.android.gaurav.classproject.base_activity.BaseActivity;
import com.android.gaurav.classproject.databinding.ActivityHomeBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class HomeActivity extends BaseActivity<ActivityHomeBinding> {
    private NavigationView navigationView;
    ProgressDialog dialog;
    TextView userName,email;
    ImageView imageView;
    MenuItem signOut;
    User user;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected Activity getActivity() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding=getViewDataBinding();
        navigationView = findViewById(R.id.nav_drawer_view);
        Menu nav_menu=navigationView.getMenu();
        signOut=nav_menu.findItem(R.id.nav_item4);

        userName=navigationView.getHeaderView(0).findViewById(R.id.userNameId);
        email=navigationView.getHeaderView(0).findViewById(R.id.emailId);
        imageView=navigationView.getHeaderView(0).findViewById(R.id.imageViewId);
        if (FirebaseAuth.getInstance() != null) {
            if(userName!=null) {
                Log.d("user name ",User.name);
                Log.d("email ",User.email);
                userName.setText(User.name);
                email.setText(User.email);
                Picasso.get().load(User.pic_url).into(imageView);
            }
        }

    }
}
