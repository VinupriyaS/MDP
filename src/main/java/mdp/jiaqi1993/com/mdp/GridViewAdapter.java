package mdp.jiaqi1993.com.mdp;

/**
 * Created by vinu on 04/9/07.
 */

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class GridViewAdapter extends BaseAdapter {

    private String hex;
    private Activity activity;
    private String[] strings;
    private boolean type;
    public List<Integer> selectedPositions;


    private int[] binstr={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public GridViewAdapter(String[] strings, Activity activity,String hex,boolean type) {
        this.strings = strings;
        this.activity = activity;
        this.hex=hex;
        this.type=type;
        selectedPositions = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return strings.length;
    }

    @Override
    public Object getItem(int position) {
        return strings[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridItemView customView = (convertView == null) ? new GridItemView(activity) : (GridItemView) convertView;

        if(!hex.isEmpty())
            converttoBinary(hex);


        boolean isSelected=binstr[position]==0?true:false;

        customView.display(strings[position], isSelected,type);



        return customView;
    }

    public void converttoBinary(String hex){

        if(hex.isEmpty())
            return;


        hex=hex.replaceAll("\"","");
        hex=hex.trim();

        String bin=new BigInteger(hex, 16).toString(2);

        String str=String.format("%300s", bin).replace(" ", "0");
        str.replaceAll("",",");

        String[] sr=str.split("");

        int[] bt=new int[300];
        for(int i=0;i<str.length();i++)
        {
            try {
                //bt[i] = Integer.parseInt(sr[i].trim());
                bt[i]=Character.digit(str.charAt(i), 10);
                binstr[i] = bt[i];
            }
            catch(NumberFormatException numberEx) {
                Log.d("myTag","Exception"+numberEx );
            }

        }



    }

    }


