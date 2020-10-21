package com.android.gaurav.classproject.touch_helper;

import androidx.recyclerview.widget.RecyclerView;

public interface TouchListener {
    void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position);
}
