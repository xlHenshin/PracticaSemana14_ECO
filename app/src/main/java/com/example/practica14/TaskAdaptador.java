package com.example.practica14;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.UUID;

public class TaskAdaptador extends BaseAdapter {

    private ArrayList<Task> tasks;

    public void addTask(Task task){
        tasks.add(task);
        notifyDataSetChanged();
    }

    public TaskAdaptador(){
        tasks = new ArrayList<>();
        tasks.add(new Task(UUID.randomUUID().toString(), "Alfa","Final ECO"));
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.row, null);

        Task task = tasks.get(position);

        ImageView deleteBtn = item.findViewById(R.id.deleteRow);
        ImageView estadoBtn = item.findViewById(R.id.estadoBtn);
        TextView tituloRow = item.findViewById(R.id.tituloRow);
        TextView tiempoRow = item.findViewById(R.id.tiempoRow);
        TextView descripcionRow = item.findViewById(R.id.descripcionRow);
        TextView estadoRow = item.findViewById(R.id.estadoRow);

        tituloRow.setText(tasks.get(position).getTitulo());
        descripcionRow.setText(tasks.get(position).getDescripcion());
        tiempoRow.setText(tasks.get(position).getDateStr());
        estadoRow.setText(tasks.get(position).isEstado()?"Completado":"Pendiente");

        deleteBtn.setOnClickListener(
                v->{
                    String id = tasks.get(position).getId();
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("tareas").child(id);
                    reference.setValue(null);
                }
        );

        estadoBtn.setOnClickListener(
                v->{
                    boolean actual = tasks.get(position).isEstado();
                    tasks.get(position).setEstado(!actual);
                    notifyDataSetChanged();
                    }
        );

        return item;
    }

    public void clear(){
        tasks.clear();
        notifyDataSetChanged();
    }

}
