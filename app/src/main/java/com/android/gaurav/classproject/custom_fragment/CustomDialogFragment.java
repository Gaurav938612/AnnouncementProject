package com.android.gaurav.classproject.custom_fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.gaurav.classproject.R;
import com.android.gaurav.classproject.databinding.CustomDialogFragmentBinding;

public class CustomDialogFragment  extends DialogFragment {
    CustomDialogFragmentBinding binding;
    CustomDialogAdapter adapter;
    private static final String TAG="CustomDialogFragment";

    public CustomDialogFragment(CustomDialogAdapter adapter){
        this.adapter=adapter;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater,R.layout.custom_dialog_fragment,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Dialog dialog=getDialog();
        if(dialog!=null){
            int width=ViewGroup.LayoutParams.WRAP_CONTENT;
            int height=ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setLayout(width,height);
        }
        binding.recyclerViewID.setLayoutManager(new LinearLayoutManager(view.getContext()));
        binding.recyclerViewID.setAdapter(adapter);
    }
}
