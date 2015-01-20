package com.example.chase.myapplication;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.view.View.OnClickListener;


public class BlankFragment extends Fragment implements OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static TextView textView1;
    private static TextView textView2;
    private static ToggleButton toggle;
    private static CheckBox check;
    private View view;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false);

        textView1 = (TextView) view.findViewById(R.id.textView1);
        textView2 = (TextView) view.findViewById(R.id.textView2);
//        check = (CheckBox) view.findViewById(R.id.checkBox);
//        check.setOnClickListener(new OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Log.i("BJTEST","on click of checkbox triggered");
//                // your click actions go here
//            }
//        });
        toggle = (ToggleButton) view.findViewById(R.id.toggle);
//        toggle.setOnClickListener(new OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Log.i("BJTEST","on click of toggle triggered");
//                // your click actions go here
//            }
//        });
        toggle.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
                Log.i("BJTEST", "on check changed triggered for toggle");
                textView1.setText("toggle was clicked");
            }
        }) ;

        return view;
    }

    @Override
    public void onClick(View view) {
        Log.i("BJTEST", "onclick is triggered");
        boolean checked = ((CheckBox) view).isChecked();
        boolean on = ((ToggleButton) view).isChecked();

        switch (view.getId()) {
            case (R.id.checkBox): {
                if (checked) {
                    textView1.setText("The box is checked!");
                    Log.d("KJTEST", "The check box is clicked");
                }
                break;
            }
            case (R.id.toggle): {

                if (on) {
                    textView2.setText("The toggle is on");
                    Log.d("KJTEST", "The toggle is on");
                } else {
                    textView2.setText("The toggle is off");
                    Log.d("KJTEST", "The toggle is off");
                }
                break;
            }
        }
    }


//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }

   }

    @Override
    public void onDetach() {
        super.onDetach();
       // mListener = null;
    }

//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        public void onFragmentInteraction(Uri uri);
//    }

}