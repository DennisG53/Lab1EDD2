package com.example.denni.lab1edd2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LZW
{
    Map<Integer,String> TablaPrincipal;

    public ArrayList<String> ArmarTabla(String input)
    {
        ArrayList<String> lista = new ArrayList<>();
        lista.clear();
        boolean estaenlista;

        for (int i = 0; i < input.length();i++)
        {
            estaenlista = false;

            if (lista.size() == 0)
            {
                lista.add(String.valueOf(input.charAt(i)));
            }
            else
            {
                for (String s: lista)
                {
                    if ((String.valueOf(input.charAt(i))) == s)
                    {
                        estaenlista = true;
                    }
                }

                /*if (estaenlista == false)
                {
                    lista.add(String.valueOf(input.charAt(i)));
                }*/
            }

            if (estaenlista == false)
            {
                lista.add(String.valueOf(input.charAt(i)));
            }

        }
        return lista;
    }



}

