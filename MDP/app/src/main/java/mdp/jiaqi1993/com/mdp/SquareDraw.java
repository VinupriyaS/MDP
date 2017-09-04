package mdp.jiaqi1993.com.mdp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by vinu on 2/9/17.
 */

public class SquareDraw extends Fragment {
     View inflatedView = null;
        ProgressDialog pd ;

        public SquareDraw() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            inflatedView=inflater.inflate(R.layout.square, container, false);

            Intent i=new Intent(getActivity(),SquareActivity.class);
            startActivity(i);

            return  inflatedView;

        }

}
