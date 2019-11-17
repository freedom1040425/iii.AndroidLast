package com.example.iiiorgandroidlast;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewAdapter extends BaseAdapter {
    private String[][] listData ;
    private LayoutInflater inflater;



    static class ViewHolder{
        LinearLayout item;
        TextView Case_name;
        TextView detail;
    }
    public ViewAdapter(String[][] data, LayoutInflater inflater){
        this.listData = data;
        this.inflater = inflater;


    }
//get數量
    @Override
    public int getCount() {
        return listData.length;
    }
//取得item
    @Override
    public Object getItem(int position) {
        return listData[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        //當ListView被拖拉時會不斷觸發getView，為了避免重複加載必須加上這個判斷
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.listitem, null);
            holder.Case_name = (TextView) convertView.findViewById(R.id.Case_name);
            holder.detail= (TextView) convertView.findViewById(R.id.detail);
            holder.item = (LinearLayout) convertView.findViewById(R.id.item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //1=事情 2=細節
        //不同類型用不同Style的表現方式
        if (listData[position][0].equals("1")){
            holder.detail.setText("★");
            holder.Case_name.setText(listData[position][1]);
            holder.item.setBackgroundColor(Color.parseColor("#FFDBC9"));

        }else{
            holder.detail.setText("");
            holder.Case_name.setText(listData[position][1]);
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) holder.item.getLayoutParams();
            //lp.setMargins(indentionBase,0, 0,0);//縮牌
        }
        return convertView;
    }
    }


}


