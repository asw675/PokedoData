package com.example.betterwine.pokedodata.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.betterwine.pokedodata.R;

public class search_dialog extends Dialog {

    private EditText search;

    public interface PriorityListener {
        /**
         * 回调函数，用于在Dialog的监听事件触发后刷新Activity的UI显示
         */
        void setActivityText(String string);
    }

    private PriorityListener listener;
    public search_dialog(@NonNull Context context,PriorityListener listener) {
        super(context);
        this.listener=listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v=getLayoutInflater().inflate(R.layout.dialog_search,null);
        setContentView(v);
        search=findViewById(R.id.search);
        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i== EditorInfo.IME_ACTION_SEND ||(keyEvent!=null&&keyEvent.getKeyCode()== KeyEvent.KEYCODE_ENTER))
                {
                    listener.setActivityText(search.getText().toString().trim());
                    dismiss();
                    return true;
                }
                return false;
            }
        });
    }
}
