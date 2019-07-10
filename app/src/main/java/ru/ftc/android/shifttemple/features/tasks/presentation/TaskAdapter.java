package ru.ftc.android.shifttemple.features.tasks.presentation;

import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.ftc.android.shifttemple.R;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;

public final class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {

    private final List<Task> tasks = new ArrayList<>();
    private final LayoutInflater inflater;
    private final SelectTaskListener selectTaskListener;

    TaskAdapter(Context context, SelectTaskListener selectTaskListener){
        inflater = LayoutInflater.from(context);
        this.selectTaskListener = selectTaskListener;
    }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        final View itemView = inflater.inflate(R.layout.task_item,parent,false);
        return new TaskHolder(itemView, selectTaskListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position){
        holder.bind(tasks.get(position));
    }

    @Override
    public int getItemCount(){return tasks.size();}

    public void setTasks(List<Task> taskList){
        tasks.clear();
        tasks.addAll(taskList);
        notifyDataSetChanged();
    }

    class TaskHolder extends RecyclerView.ViewHolder{
        private final TextView shortDescriptionView;
        private final TextView longDescriptionView;
        private final SelectTaskListener selectTaskListener;

        TaskHolder(View view, SelectTaskListener selectTaskListener){
            super(view);
            this.selectTaskListener = selectTaskListener;
            shortDescriptionView = view.findViewById(R.id.task_item_short_description);
            longDescriptionView = view.findViewById(R.id.task_item_full_description);
        }

        void bind(final Task task){
            String toPrint = task.getDescriptionFull();
            shortDescriptionView.setText(task.getDescriptionShort());
            if(toPrint.length()>20)
            {
                toPrint = toPrint.substring(0,17);
                toPrint+="...";
            }
            longDescriptionView.setText(toPrint);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectTaskListener.onTaskSelect(task);
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    selectTaskListener.onTaskLongClick(task);
                    return true;
                }
            });
        }
    }

    interface SelectTaskListener{

        void onTaskSelect(Task task);

        void onTaskLongClick(Task task);
    }

}
