package com.example.t00592163.bcbirds;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by t00592163 on 6/21/2018.
 */

public class BirdAdapter extends BaseAdapter
{
    private ArrayList<Bird> birdArrayList;
    private Context context;

    public BirdAdapter(ArrayList birds, Context c)
    {
        birdArrayList = birds;
        context = c;
    }

    @Override
    public int getCount()
    {
        return birdArrayList.size();
    }

    @Override
    public Object getItem(int i)
    {
        return null;
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {

        ImageView imageView;
        if (view == null)
        {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(400, 400));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        }
        else
        {
            imageView = (ImageView)view;
        }

        imageView.setImageResource(birdArrayList.get(i).smallImage);

        return imageView;
    }
}
