package com.benio.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.benio.componentservice.ShareRoadMap;

public class ShareRoadMapImpl implements ShareRoadMap {
    @Override
    public void share(Context context) {
        Intent intent = new Intent(context, ShareActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }
}
