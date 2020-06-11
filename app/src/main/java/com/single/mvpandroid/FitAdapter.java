package com.single.mvpandroid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FitAdapter extends RecyclerView.Adapter<FitAdapter.ViewHolder> {

    private List<Fit> fitnessList = new ArrayList<>();

    public FitAdapter(List<Fit> fits){
        this.fitnessList = fits;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fit, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FitAdapter.ViewHolder holder, int position) {

        Fit fit = fitnessList.get(position);
        holder.name.setText(fit.name);
        holder.teacher.setText(fit.teacher);
//        holder.description.setText(fit.description);
        holder.place.setText(fit.place);
        holder.startTime.setText(fit.startTime + " - " + fit.endTime);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("name", fit.name);
                intent.putExtra("description", fit.description);
                intent.putExtra("place", fit.place);
                intent.putExtra("teacher", fit.teacher);
                intent.putExtra("startTime", fit.startTime);
                intent.putExtra("endTime", fit.endTime);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fitnessList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.name_fit);
            teacher = view.findViewById(R.id.teacher_fit);
            description = view.findViewById(R.id.desciption_fit);
            place = view.findViewById(R.id.place_fit);
            startTime = view.findViewById(R.id.time_fit);
        }

        TextView name, teacher, description, place, startTime, endTime, weekday;

    }
}
