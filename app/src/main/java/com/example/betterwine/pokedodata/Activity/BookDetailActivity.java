package com.example.betterwine.pokedodata.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.betterwine.pokedodata.Fragment.BookDetailFragment;
import com.example.betterwine.pokedodata.Interface.RetrofitInterface;
import com.example.betterwine.pokedodata.Model.BookDetail;
import com.example.betterwine.pokedodata.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BookDetailActivity extends AppCompatActivity {
    @BindView(R.id.book_img)
    ImageView bookImg;
    @BindView(R.id.book_title)
    TextView bookTitle;
    @BindView(R.id.book_text)
    TextView bookText;
    @BindView(R.id.book_toolbar)
    Toolbar bookToolbar;
    @BindView(R.id.func_collapsingToolbarLayout)
    CollapsingToolbarLayout funcCollapsingToolbarLayout;
    @BindView(R.id.func_appbar)
    AppBarLayout funcAppbar;
    @BindView(R.id.book_tab)
    TabLayout bookTab;
    @BindView(R.id.book_type)
    ViewPager bookType;

    private ArrayList<String> Summary=new ArrayList<>();
    private String[] title={"导言","目录","图书信息"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_book_detail);
        ButterKnife.bind(this);
        setSupportActionBar(bookToolbar);
        bookToolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getBookDetail();
    }

    public void initView()
    {
        bookTab.setupWithViewPager(bookType);
        FragmentManager fragmentManager=getSupportFragmentManager();
        bookType.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int i) {
                return BookDetailFragment.newInstance(Summary.get(i));
            }

            @Override
            public int getCount() {
                return Summary.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
            }
        });
    }

    public void getBookDetail()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/book/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

        String id=getIntent().getStringExtra("id");

        retrofitInterface.getBookDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(BookDetailActivity.this,"暂无图书数据",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(BookDetail bookDetail) {
                        Toast.makeText(BookDetailActivity.this,"舒服",Toast.LENGTH_SHORT).show();
                        Glide.with(BookDetailActivity.this).load(bookDetail.getImage()).asBitmap().into(bookImg);
                        bookTitle.setText(bookDetail.getTitle());
                        String str="";
                        str+="作者：";
                        for (int i=0;i<bookDetail.getAuthor().size();i++)
                        {
                            str+=bookDetail.getAuthor().get(i);
                        }
                        str+="\n";
                        str+="译者：";
                        for (int i=0;i<bookDetail.getTranslator().size();i++)
                        {
                            str+=bookDetail.getTranslator().get(i);
                        }
                        str+="\n";
                        str+="出版时间：";
                        str+=bookDetail.getPubdate();
                        str+="\n";
                        str+="页数："+bookDetail.getPages()+"页";
                        bookText.setText(str);
                        setSummary(bookDetail);
                    }
                });
    }
    public void setSummary(BookDetail bookDetail)
    {
        Summary.add(bookDetail.getSummary());
        Summary.add(bookDetail.getCatalog());
        String str="";
        str+="作者：";
        for (int i=0;i<bookDetail.getAuthor().size();i++)
        {
            str+=bookDetail.getAuthor().get(i);
        }
        str+="\n";
        str+="译者：";
        for (int i=0;i<bookDetail.getTranslator().size();i++)
        {
            str+=bookDetail.getTranslator().get(i);
        }
        str+="\n";
        str+="出版社：";
        str+=bookDetail.getPublisher();
        str+="\n";
        str+="出版时间：";
        str+=bookDetail.getPubdate();
        str+="\n";
        str+="来源：";
        str+=bookDetail.getSeries().getTitle();
        str+="\n";
        str+="标签：";
        for(int i=0;i<bookDetail.getTags().size();i++)
        {
            str+=bookDetail.getTags().get(i).getName()+"  ";
        }
        str+="\n";
        Summary.add(str);
        initView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
