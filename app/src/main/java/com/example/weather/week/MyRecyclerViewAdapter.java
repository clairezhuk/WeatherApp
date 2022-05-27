package com.example.weather.week;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.R;

import java.util.List;

import retrofit2.Callback;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private java.util.List<com.example.weather.week.List> mData;//список данных, которые будем помещать в RecyclerView
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // передаём данные в конструктор
    public MyRecyclerViewAdapter(Context context, List<com.example.weather.week.List> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // “создает(надувает)” строку(пункт) RecyclerView из xml файла
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layoutstringitem, parent, false);
        return new ViewHolder(view);
    }

    // заполняет каждую строк RecyclerView данными
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        com.example.weather.week.List data = mData.get(position);
        holder.myTextView1.setText(data.getMain().getTemp().toString()+"K");
        holder.myTextView2.setText(data.getWind().getSpeed().toString()+"m/s");
    }

    // общее количество строк
    @Override
    public int getItemCount() {
        return mData.size();
    }



    // сохраняет и реиспользует view компоненты, когда строка прокручивается(уходит с экрана)
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        EditText myTextView1;
        EditText myTextView2;

        public ViewHolder(View itemView) {
            super(itemView);
            myTextView1 = itemView.findViewById(R.id.temp);
            myTextView2 = itemView.findViewById(R.id.wind);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // получение данных из строки RecyclerView, по которой щелкнули
    public com.example.weather.week.List getItem(int id) {
        return mData.get(id);
    }

    // добавление возможности перехата нажатия на кнопку
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
//    public void setClickListener(Callback<Example> itemClickListener) {
//        this.mClickListener = itemClickListener;
//    }

    //  Activity будет реализовывать этот метод, щелчек по элементу
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

