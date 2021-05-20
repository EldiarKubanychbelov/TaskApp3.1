package com.example.taskapp31.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapp31.MainActivity;
import com.example.taskapp31.R;
import com.example.taskapp31.models.Task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private ArrayList<Task> list = new ArrayList<>();



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_task,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));



        if (position%2 == 0) {
            holder.itemView.setBackgroundResource(R.color.white);
        } else {
            holder.itemView.setBackgroundResource(R.color.black);
        }

        
       holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {
               AlertDialog.Builder alertDialog = new AlertDialog.Builder(v.getContext());
               alertDialog.setMessage("Вы действительно хотите удалить?");
               alertDialog.setTitle("Внимание!");
               alertDialog.setPositiveButton("Да!", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       list.remove(position);
                       notifyDataSetChanged();
                   }
               });

               alertDialog.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                   }
               });
               alertDialog.show();
               return false;
           }
       });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItem(Task task) {
        list.add(task);
        notifyItemInserted(list.indexOf(task));
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textTitle,txtData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_Title);
            txtData = itemView.findViewById(R.id.txt_data);



        }

        public void bind(Task task) {
            textTitle.setText(task.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),String.valueOf(getAdapterPosition()) + " : " + task.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
