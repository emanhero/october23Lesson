package com.lesson.october23lesson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

import java.util.List;

public class CollegeAdapter extends ArrayAdapter<College>
{
    Context mContext;
    int mResource;
    public CollegeAdapter(Context context, int resource, List<College> objects)
    {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        int image = getItem(position).getLogo();
        String name = getItem(position).getName();
        String patron = getItem(position).getPatron();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvSaint = convertView.findViewById(R.id.tvSaint);
        ImageView ivLogo = convertView.findViewById(R.id.ivLogo);
        tvName.setText(name);
        tvSaint.setText(patron);
        ivLogo.setImageResource(image);
        return convertView;
       //     return super.getView(position, convertView, parent);
    }
}
