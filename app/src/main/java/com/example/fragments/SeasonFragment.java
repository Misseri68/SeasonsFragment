package com.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class SeasonFragment extends Fragment {
    /*
    * He hecho un solo fragment para todos para poder reutilizar codigo y no tener codigo duplicado,
    * ya que todos comparten la misma estrucutra pero con un dato distinto.*/

    private static final String ARG_SEASON = "season";
    private String season;


    public SeasonFragment() {
        // Required empty public constructor
    }

    public static SeasonFragment newInstance(String season) {
        SeasonFragment fragment = new SeasonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SEASON, season);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            season = getArguments().getString(ARG_SEASON);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        TextView textView = view.findViewById(R.id.text_season);
        textView.setText(season);
        FrameLayout frameLayout = view.findViewById(R.id.frameLayout);
        frameLayout.setBackgroundColor(getColorIdBySeason(season));
        return view;
    }

    private int getColorIdBySeason(String season) {
        switch (season) {
            case "Spring":
                return ContextCompat.getColor(getContext(), R.color.spring);
            case "Summer":
                return ContextCompat.getColor(getContext(), R.color.summer);
            case "Fall":
                return ContextCompat.getColor(getContext(), R.color.fall);
            case "Winter":
                return ContextCompat.getColor(getContext(), R.color.winter);
            default:
                return android.R.color.white;
        }
    }
}