package com.example.denni.lab1edd2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

public class FileArrayAdapter extends ArrayAdapter<Option>{

    private Context c;
    private int id;
    private List<Option> items;


    public FileArrayAdapter(Context context, int textViewResourceId, List<Option> objects) {
        super(context, textViewResourceId);

        c = context;
        id = textViewResourceId;
        items = objects;
    }

    public Option getItem(int i)
    {
        return items.get(i);
        //11:11
    }

}
