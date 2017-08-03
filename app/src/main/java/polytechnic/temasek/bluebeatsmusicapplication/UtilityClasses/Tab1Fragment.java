package polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import polytechnic.temasek.bluebeatsmusicapplication.R;

/**
 * Created by User on 23/7/2017.
 */

public class Tab1Fragment extends Fragment implements View.OnClickListener {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1_fragment, container, false);
        return rootView;
    }

    @Override
    public void onClick(View v) {

    }
}
