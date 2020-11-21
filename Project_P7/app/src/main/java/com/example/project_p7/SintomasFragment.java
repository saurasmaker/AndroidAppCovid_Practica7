package com.example.project_p7;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SintomasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SintomasFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Boolean infected = false;

    /*
        Attributes PopUpDialog
     */
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog alertDialog;
    private TextView infoCovid;
    private Button buttonComoActuar, buttonHospitalCercano, buttonLlamarEmergencias;


    public SintomasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SintomasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SintomasFragment newInstance(String param1, String param2) {
        SintomasFragment fragment = new SintomasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        return inflater.inflate(R.layout.fragment_sintomas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //getView().findViewById(R.id.scrollView).setBackgroundColor(Color.BLUE);
        getView().findViewById(R.id.buttonCheck).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createNewInfoCheckedDialog(infected);
            }
        });

    }



    public void createNewInfoCheckedDialog(boolean infected) {

        dialogBuilder = new AlertDialog.Builder(getContext());

        final View infoCovidView = getLayoutInflater().inflate(R.layout.info_covid_popup, null);

        //TextView textViewInfo = infoCovidView.findViewById(R.id.textViewInfoInfectated);
        //ImageView image = infoCovidView.findViewById(R.id.imageView);
        Button buttonComoActuar = infoCovidView.findViewById(R.id.buttonComoActuar);
        Button buttonHospitalCercano = infoCovidView.findViewById(R.id.buttonHospitalCercano);
        Button buttonLlamarEmergencias = infoCovidView.findViewById(R.id.buttonLlamarEmergencias);
        Button buttonSalir = infoCovidView.findViewById(R.id.buttonSalir);

        if(infected){
            //textViewInfo.setText("Parece ser que efectivamente padeces síntomas de Covid. Aquí abajo te dejamos las cosas que puedes hacer.");
        }
        else{
            //textViewInfo.setText("Nada de lo que preocuparse. La enfermedad que tienes no se corresponde con Covid 19.");
        }

        buttonComoActuar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        buttonSalir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        dialogBuilder.setView(infoCovidView);
        alertDialog = dialogBuilder.create();
        alertDialog.show();

        return;
    }
}