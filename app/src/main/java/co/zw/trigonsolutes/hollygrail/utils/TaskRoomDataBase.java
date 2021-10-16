package co.zw.trigonsolutes.hollygrail.utils;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import co.zw.trigonsolutes.hollygrail.data.TaskDao;
import co.zw.trigonsolutes.hollygrail.model.TaskModel;

@Database(entities = {TaskModel.class}, version = 1 , exportSchema = false)
public abstract class TaskRoomDataBase extends RoomDatabase {

    public static final String DATABASE_NAME = "todoList";
    public static final int NUMBER_OF_THREADS = 4;
    public static volatile TaskRoomDataBase  INSTANCE;
    public static final ExecutorService dbWriterExecuter =  Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public static final  RoomDatabase.Callback sRoomDatabaseCallBack =
            new RoomDatabase.Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    dbWriterExecuter.execute(() -> {


                    });
                }
            };

    public static TaskRoomDataBase getDatabase(final Context context){
        if (INSTANCE == null){

            synchronized (TaskRoomDataBase.class){

                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TaskRoomDataBase.class, DATABASE_NAME )
                            .addCallback(sRoomDatabaseCallBack)
                            .build();

                }
            }
        }

      return INSTANCE;
    }

public abstract TaskDao taskDao();

}
