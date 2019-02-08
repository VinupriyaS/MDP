package mdp.jiaqi1993.com.mdp;

/**
 * Created by vinu on 14/9/17.
 */

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

import java.lang.reflect.Field;

import static mdp.jiaqi1993.com.mdp.R.id.grid;

public class GridItemView extends FrameLayout {

    private TextView textView;
    private GridView gridView;
   // private int[] binstr={0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0};


    public GridItemView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.item_grid, this);
        textView = (TextView) getRootView().findViewById(R.id.text);
        gridView=(GridView) getRootView().findViewById(grid);


    }

    public void display(String text, boolean isSelected,boolean type) {
        textView.setText(text);
        if(type==true)
        display(isSelected);
        else
            displayExplored(isSelected);
    }

    public void display(boolean isObtsacle) {
        //textView.setBackgroundResource(binstr[0]==1 ? R.drawable.green_square : R.drawable.gray_square);
        if (isObtsacle)
        {
            textView.setBackgroundColor(Color.LTGRAY);
        }
        else
        {
            textView.setBackgroundColor(Color.BLACK);
            //textView.setOnClickListener(null);
        }

       /* for (int i = 0; i < binstr.length; i++) {
            textView.setBackgroundResource(isSelected ? R.drawable.green_square : R.drawable.gray_square);
            //textView.setBackgroundResource(binstr[i]==1 ? R.drawable.green_square : R.drawable.gray_square);

        }*/
    }
    public void displayExplored(boolean isExplored){
        Log.d("call","im called");
        if (isExplored)
        {
            textView.setBackgroundColor(Color.LTGRAY);
        }
        else
        {
            textView.setBackgroundColor(Color.WHITE);
        }
    }
    public void waypoint(boolean isSelected){
        if(isSelected)
            textView.setBackgroundColor(Color.CYAN);
    }


    public static int getBackgroundColor(TextView textView) {
        ColorDrawable drawable = (ColorDrawable) textView.getBackground();
        if (Build.VERSION.SDK_INT >= 11) {
            return drawable.getColor();
        }
        try {
            Field field = drawable.getClass().getDeclaredField("mState");
            field.setAccessible(true);
            Object object = field.get(drawable);
            field = object.getClass().getDeclaredField("mUseColor");
            field.setAccessible(true);
            return field.getInt(object);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }

}