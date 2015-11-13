package co.edu.udea.cmovil.gr02.whereverent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dante on 9/11/15.
 */
public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context){
        super(context,PropertyContract.DB_NAME,null,PropertyContract.DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql=String.format("create table %s (%s int primary key, %s text, %s text, %s text," +
                " %s text, %s text, %s text, %s text, %s double, %s double)",PropertyContract.TABLE,PropertyContract.Column.ID,
                PropertyContract.Column.CIUDAD,PropertyContract.Column.TIPO,PropertyContract.Column.AREA,
                PropertyContract.Column.MODO,PropertyContract.Column.CONTACTO,PropertyContract.Column.DESCRIPCION,
                PropertyContract.Column.PRECIO,PropertyContract.Column.LATITUD,PropertyContract.Column.LONGITUD);
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+PropertyContract.TABLE);
        onCreate(db);
    }
}
