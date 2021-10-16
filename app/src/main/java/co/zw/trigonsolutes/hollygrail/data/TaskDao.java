package co.zw.trigonsolutes.hollygrail.data;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.zw.trigonsolutes.hollygrail.model.TaskModel;



@Dao
public interface TaskDao {

    @Insert
    void insertTask (TaskModel taskModel );

    @Query( "DELETE FROM todoList")
    void deleteAll();

    @Query(" SELECT * FROM todoList")
    LiveData<List<TaskModel>> getTasks();


    @Query(" SELECT * FROM todoList WHERE todoList.task_id == :id")
    LiveData<TaskModel> getTask(long id);

    @Update
    void update (TaskModel taskModel);

    @Delete
    void delete (TaskModel taskModel);

}
