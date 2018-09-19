package com.example.denni.lab1edd2;

import android.support.annotation.NonNull;

public class Option implements Comparable<Option> {

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    public String getPath() {
        return path;
    }

    private String name;
    private String data;
    private String path;

    public Option(String n, String d, String p)
    {
        name = n;
        data = d;
        path = p;
    }







    @Override
    public int compareTo(Option o) {

        if (this.name != null)
        {
            return this.name.toLowerCase().compareTo(o.getName().toLowerCase());
        }
        else
        {
            throw new IllegalArgumentException();
        }

    }
}
