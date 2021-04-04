package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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
    private View myView;
    /*
        Attributes PopUpDialog
     */
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog alertDialog;
    private TextView infoCovid;
    private Button buttonComoActuar, buttonHospitalCercano, buttonLlamarEmergencias;


    MainActivity mainActivity;

    public SintomasFragment(MainActivity mainActivity) {
        // Required empty public constructor
        this.mainActivity = mainActivity;
    }

    public SintomasFragment(){

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
        myView = inflater.inflate(R.layout.fragment_sintomas, container, false);
        return myView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //getView().findViewById(R.id.scrollView).setBackgroundColor(Color.BLUE);
        getView().findViewById(R.id.buttonCheck).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createNewInfoCheckedDialog();
            }
        });

    }

    public void createNewInfoCheckedDialog() {

        dialogBuilder = new AlertDialog.Builder(getContext());
        final View infoCovidView = getLayoutInflater().inflate(R.layout.info_covid_popup, null);

        ImageView image = infoCovidView.findViewById(R.id.imageView);
        Button buttonComoActuar = infoCovidView.findViewById(R.id.buttonComoActuar);
        Button buttonHospitalCercano = infoCovidView.findViewById(R.id.buttonHospitalCercano);
        Button buttonLlamarEmergencias = infoCovidView.findViewById(R.id.buttonLlamarEmergencias);
        Button buttonSalir = infoCovidView.findViewById(R.id.buttonSalir);
        TextView textViewInfo =  (TextView) infoCovidView.findViewById(R.id.textViewInfoInfectated);

        CheckBox checkFiebre = (CheckBox)  myView.findViewById(R.id.checkFiebre);
        CheckBox checkTosSeca = (CheckBox)  myView.findViewById(R.id.checkTosSeca);
        CheckBox checkCansancio = (CheckBox)  myView.findViewById(R.id.checkCansancio);

        CheckBox checkMolestiasDolores = (CheckBox)  myView.findViewById(R.id.checkMolestiasDolores);
        CheckBox checkDolorGarganta = (CheckBox)  myView.findViewById(R.id.checkDolorGarganta);
        CheckBox checkDiarrea = (CheckBox)  myView.findViewById(R.id.checkDiarrea);
        CheckBox checkConjuntivitis = (CheckBox)  myView.findViewById(R.id.checkConjuntivitis);
        CheckBox checkDolorCabeza = (CheckBox)  myView.findViewById(R.id.checkDolorCabeza);
        CheckBox checkPerdidaOlfatoGusto = (CheckBox)  myView.findViewById(R.id.checkPerdidaOlfatoGusto);
        CheckBox checkErupciones = (CheckBox)  myView.findViewById(R.id.checkErupciones);

        CheckBox checkDificultadRespirar = (CheckBox)  myView.findViewById(R.id.checkDificultadRespirar);
        CheckBox checkPresionPecho = (CheckBox)  myView.findViewById(R.id.checkPresionPecho);
        CheckBox checkIncapacidadHablar = (CheckBox)  myView.findViewById(R.id.checkIncapacidadHablar);

        textViewInfo.setText("Nada de lo que preocuparse.");
        buttonComoActuar.setEnabled(false);
        buttonHospitalCercano.setEnabled(false);
        buttonLlamarEmergencias.setEnabled(false);

        if(checkFiebre.isChecked() || checkTosSeca.isChecked() || checkCansancio.isChecked()){
            textViewInfo.setText("Parece ser que efectivamente padeces síntomas compatibles con Covid. No obstante no son graves, por el momento puedes permanecer en casa. Aquí abajo te dejamos las cosas que puedes hacer.");
            buttonComoActuar.setEnabled(true);
            buttonHospitalCercano.setEnabled(false);
            buttonLlamarEmergencias.setEnabled(false);
        }
        if(checkMolestiasDolores.isChecked() || checkDolorGarganta.isChecked() || checkDiarrea.isChecked() || checkConjuntivitis.isChecked() || checkDolorCabeza.isChecked() || checkPerdidaOlfatoGusto.isChecked() ||checkErupciones.isChecked()){
            textViewInfo.setText("Parece ser que efectivamente padeces síntomas compatibles con Covid. Te recomendamos llamar a tu médico de cabecera o seguir las instrucciones que te dejamos aquí. En caso de necesitar un hospital, antes di ir, haz una llamada al hospital que tenías pensado visitar y los profesionales te darán instrucciones de como actuar. Aquí abajo te dejamos las cosas que puedes hacer.");
            buttonComoActuar.setEnabled(true);
            buttonHospitalCercano.setEnabled(true);
            buttonLlamarEmergencias.setEnabled(false);
        }
        if(checkDificultadRespirar.isChecked() || checkPresionPecho.isChecked() || checkIncapacidadHablar.isChecked()){
            textViewInfo.setText("Parece ser que efectivamente padeces síntomas compatibles con Covid. Son bastante graves, llama al hospital más cercano, o en caso de gravedad extrema, te facilitamos el número de urgencias. Aquí abajo te dejamos las cosas que puedes hacer.");
            buttonComoActuar.setEnabled(true);
            buttonHospitalCercano.setEnabled(true);
            buttonLlamarEmergencias.setEnabled(true);
        }


        buttonComoActuar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mainActivity.tabLayout.selectTab(mainActivity.tabLayout.getTabAt(1));
                alertDialog.dismiss();
            }
        });

        buttonHospitalCercano.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Uri gmmIntentUri = Uri.parse("geo:0,0?q=hospitals");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        buttonLlamarEmergencias.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:622887253"));
                startActivity(i);
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