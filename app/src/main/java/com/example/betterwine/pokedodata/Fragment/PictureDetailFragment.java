package com.example.betterwine.pokedodata.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.betterwine.pokedodata.R;
import com.example.betterwine.pokedodata.Utils.SDFileUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PictureDetailFragment extends Fragment {
    @BindView(R.id.picture_detail)
    ImageView pictureDetail;
    Unbinder unbinder;

    public static PictureDetailFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("url", url);
        PictureDetailFragment fragment = new PictureDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_picture_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        final String url=getArguments().getString("url");
        Glide.with(getActivity()).load(url).asBitmap().into(pictureDetail);

        pictureDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finishAfterTransition();
            }
        });

        pictureDetail.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                new saveThread(view).start();
                return true;
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    Handler handler = new Handler()
    {
        public void handleMessage(android.os.Message msg) {
            if(msg.what==0x123)
            {
                Toast.makeText(getActivity(),"图片已保存", Toast.LENGTH_SHORT).show();
            }
        };
    };

    class saveThread extends Thread
    {
        View v;
        saveThread(View view){
            v=view;
        }
        @Override
        public void run() {
            //延迟两秒更新

            SDFileUtil sdFileUtil=new SDFileUtil(getActivity());
            sdFileUtil.SaveBitmapFromView(v);
            handler.sendEmptyMessage(0x123);
        }
    }
}
