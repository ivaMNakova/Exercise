package com.example.exercise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    public interface ItemClickListener {
        void onItemClick(int position);
    }

    private ItemClickListener clickListener;

    void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    private ArrayList<Tramvai> tramvai1;

    public CustomAdapter(ArrayList<Tramvai> tramvai) {
        this.tramvai1=tramvai;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tramvai_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Tramvai tramvai_new = (Tramvai) tramvai1.get(position);

        holder.number.setText(tramvai_new.getNumber());
        holder.hour.setText(tramvai_new.getHour());
        holder.positions.setText(tramvai_new.getPositions());
        holder.taken_positions.setText(tramvai_new.getTaken_positions());

        holder.actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tramvai1.remove(tramvai_new);
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return tramvai1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView number;
        TextView hour;
        TextView positions;
        TextView taken_positions;
        Button actionButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.number);
            hour = itemView.findViewById(R.id.hour);
            positions = itemView.findViewById(R.id.positions);
            taken_positions = itemView.findViewById(R.id.taken_positions);
            actionButton = itemView.findViewById(R.id.action_button);
        }

    }

}
