package co.zw.trigonsolutes.hollygrail.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity (tableName = "todoList")
public class TaskModel {


    @ColumnInfo (name = "task_id")
    @PrimaryKey(autoGenerate =  true)
    public long Id;
    public String task;
    @ColumnInfo (name = "due_date")
    public Date duedate;
    @ColumnInfo (name = "created_date")
    public Date dateCreated;
    public Priority priority;
    @ColumnInfo (name = "is_done")
    public boolean isDone;

    public TaskModel(String task, Date duedate, Date dateCreated, Priority priority, boolean isDone) {
        this.task = task;
        this.duedate = duedate;
        this.dateCreated = dateCreated;
        this.priority = priority;
        this.isDone = isDone;
    }

    public TaskModel() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "Id=" + Id +
                ", task='" + task + '\'' +
                ", duedate=" + duedate +
                ", dateCreated=" + dateCreated +
                ", priority=" + priority +
                ", isDone=" + isDone +
                '}';
    }
}
