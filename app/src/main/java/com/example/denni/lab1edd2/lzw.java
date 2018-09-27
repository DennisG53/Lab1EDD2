package com.example.denni.lab1edd2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lzw {


        /** Compress a string to a list of output symbols. */
        public static List<Integer> Compresion(String uncompressed) {
            // Build the dictionary.
            int dictSize = 256;

            int j=0;
            Map<String, Integer> dictionary = new HashMap<String, Integer>();
           // Map<String, Integer> dictionaryP = new HashMap<String, Integer>();
            for (int i = 0; i < 256; i++)
                dictionary.put("" + (char) i, i);

            String w = "";
            List<Integer> result = new ArrayList<Integer>();
            List<Integer> result2 = new ArrayList<Integer>();
            for (char c : uncompressed.toCharArray()) {
                String wc = w + c;
                if (dictionary.containsKey(wc))
                    w = wc;
                  // dictionaryP.put(wc, dictSize++);
                else {
                    result.add(dictionary.get(w));
                    // Add wc to the dictionary.
                    dictionary.put(wc, dictSize++);
                    w = "" + c;
                }
            }

            // Output the code for w.
            if (!w.equals(""))
                result.add(dictionary.get(w));

            Object vec[] = result.toArray();
            for (int i=0; i < result.size(); i ++){

            }

            int VEC2[]=null;
            int contador =0;
            for (int i = 0; i < vec.length-1; i++) {
                if(vec[i]==vec[i+1]){
                    contador++;
                }
                VEC2=new int[contador];
            }



            return result;
        }



}
