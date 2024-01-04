package com.example.viloriamark;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class VaccinationAdapter extends ArrayAdapter<Vaccination> {

    private final Context context;
    private final int resource;
    private final List<Vaccination> vaccinationList;

    public VaccinationAdapter(Context context, int resource, List<Vaccination> vaccinationList) {
        super(context, resource, vaccinationList);
        this.context = context;
        this.resource = resource;
        this.vaccinationList = vaccinationList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(resource, null);
        }

        Vaccination vaccination = vaccinationList.get(position);

        if (vaccination != null) {
            TextView childNameTextView = view.findViewById(R.id.childNameTextView);
            TextView vaccinationDateTextView = view.findViewById(R.id.vaccinationDateTextView);

            childNameTextView.setText(vaccination.getChildName());
            vaccinationDateTextView.setText(vaccination.getVaccinationDate());
        }

        return view;
    }
}


