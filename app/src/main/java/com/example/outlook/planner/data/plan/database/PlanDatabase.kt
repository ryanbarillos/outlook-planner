package com.example.outlook.planner.data.plan.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.outlook.planner.data.plan.PlanEntity

/**
 * Database name(s)
 */
const val PLAN_DB_NAME: String = "plan_database"

@Database(
    entities = [PlanEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PlanDatabase: RoomDatabase() {
    abstract fun planDao(): PlanDao
    companion object {
        const val NAME: String = "plan_db"
        @Volatile
        private var Instance: PlanDatabase? = null

        fun getDatabase(context: Context): PlanDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    klass = PlanDatabase::class.java,
                    name = PLAN_DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        /**
                         * To keep reference to the recently
                         * created database instance
                         */
                        Instance = it
                    }
            }
        }
    }

}