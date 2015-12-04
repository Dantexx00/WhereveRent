package co.edu.udea.cmovil.gr02.whereverent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * Created by dante on 9/11/15.
 */
//Clase para acceder a la base de datos.
public class DbHelper extends SQLiteOpenHelper {
    //Constructor del dbHelper que crea un ayudador con acceso a la base especificada en el PropertyContract
    public DbHelper(Context context){
        super(context,PropertyContract.DB_NAME,null,PropertyContract.DB_VERSION);
    }
    @Override
    //El onCreate, crea la tabla property si esta ya no existe
    public void onCreate(SQLiteDatabase db) {
        String sql=String.format("create table %s (%s int primary key, %s text, %s text, %s text," +
                " %s text, %s text, %s text, %s text, %s double, %s double, %s text)",PropertyContract.TABLE,PropertyContract.Column.ID,
                PropertyContract.Column.CIUDAD,PropertyContract.Column.TIPO,PropertyContract.Column.AREA,
                PropertyContract.Column.MODO,PropertyContract.Column.CONTACTO,PropertyContract.Column.DESCRIPCION,
                PropertyContract.Column.PRECIO,PropertyContract.Column.LATITUD,PropertyContract.Column.LONGITUD,
                PropertyContract.Column.PAIS);
        db.execSQL(sql);
    }
    @Override
    //No se
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+PropertyContract.TABLE);
        onCreate(db);
    }
    //Metodo que devuelve el Id de la ultima propiedad.
    public int getLastIdProperty(){
        SQLiteDatabase db=this.getWritableDatabase();
        String columnas[]={PropertyContract.Column.ID};
        ArrayList<Property> propiedades=new ArrayList<>();
        Cursor c=db.query(PropertyContract.TABLE,columnas,null,null,null,null,null);
        if(c.moveToLast()){
            return c.getInt(0);
        }
        return 0;
    }
    //Metodo que devuelve todas las propiedades
    public ArrayList<Property> getAllProperties(){
        String columnas[]={PropertyContract.Column.ID,PropertyContract.Column.CIUDAD,PropertyContract.Column.TIPO,PropertyContract.Column.AREA,
                PropertyContract.Column.MODO,PropertyContract.Column.CONTACTO,PropertyContract.Column.DESCRIPCION,PropertyContract.Column.PRECIO,
                PropertyContract.Column.LATITUD,PropertyContract.Column.LONGITUD,PropertyContract.Column.PAIS};
        //Creo la instancia de la base en modo lectura y obtengo las propiedades con las columnas deseadas por medio del cursor
        SQLiteDatabase db=this.getReadableDatabase();
        ArrayList<Property> propiedades=new ArrayList<>();
        Cursor c=db.query(PropertyContract.TABLE,null,null,null,null,null,null);
        //Recorro la base sacando obteniendo los valores para las propiedades.
        if(c.moveToFirst()){
            int cont=0;
            do{
                cont++;
                Property p=new Property();
                p.setId(c.getInt(c.getColumnIndex(PropertyContract.Column.ID)));
                p.setCiudad(c.getString(c.getColumnIndex(PropertyContract.Column.CIUDAD)));
                p.setTipo(c.getString(c.getColumnIndex(PropertyContract.Column.TIPO)));
                p.setArea(c.getString(c.getColumnIndex(PropertyContract.Column.AREA)));
                p.setModo(c.getString(c.getColumnIndex(PropertyContract.Column.MODO)));
                p.setContacto(c.getString(c.getColumnIndex(PropertyContract.Column.CONTACTO)));
                p.setDescripcion(c.getString(c.getColumnIndex(PropertyContract.Column.DESCRIPCION)));
                p.setPrecio(c.getString(c.getColumnIndex(PropertyContract.Column.PRECIO)));
                p.setLatitud(c.getDouble(c.getColumnIndex(PropertyContract.Column.LATITUD)));
                p.setLongitud(c.getDouble(c.getColumnIndex(PropertyContract.Column.LONGITUD)));
                p.setPais(c.getString(c.getColumnIndex(PropertyContract.Column.PRECIO)));
                propiedades.add(p);
            }while(c.moveToNext());
            System.out.println("cont: "+cont);
        }
        return propiedades;
    }
    //Metodo para guardar una propiedad.
    public void saveProperty(int id,String ciudad,String tipo,String area,String modo,String contacto,String descripcion,
                             String precio,double latitud,double longitud,String pais){
        //Se crea el dbHelper, se obtiene la base de datos con permisos de escritura y el content value.
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        //Se ingresan en el content value los datos a ingresar.
        values.clear();
        values.put(PropertyContract.Column.ID, id);
        values.put(PropertyContract.Column.CIUDAD, ciudad);
        values.put(PropertyContract.Column.TIPO, tipo);
        values.put(PropertyContract.Column.AREA, area);
        values.put(PropertyContract.Column.MODO, modo);
        values.put(PropertyContract.Column.CONTACTO, contacto);
        values.put(PropertyContract.Column.DESCRIPCION, descripcion);
        values.put(PropertyContract.Column.PRECIO, precio);
        values.put(PropertyContract.Column.LATITUD,latitud);
        values.put(PropertyContract.Column.LONGITUD,longitud);
        values.put(PropertyContract.Column.PAIS,pais);
        //Se inserta en la base de datos
        db.insertWithOnConflict(PropertyContract.TABLE, null, values, SQLiteDatabase.CONFLICT_IGNORE);
    }
    //Metodo que devuelve una propiedad de acuerdo a su latitud y longitud
    public Property findPropertyByLocation(double latitud,double longitud){
        String query = "Select * FROM " + PropertyContract.TABLE + " WHERE " + PropertyContract.Column.LATITUD + " = " + latitud +
                " AND "+PropertyContract.Column.LONGITUD+" = "+longitud;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);
        Property p=new Property();
        if(c.moveToFirst()) {
            System.out.println("entro");
            p.setId(c.getInt(c.getColumnIndex(PropertyContract.Column.ID)));
            p.setCiudad(c.getString(c.getColumnIndex(PropertyContract.Column.CIUDAD)));
            p.setTipo(c.getString(c.getColumnIndex(PropertyContract.Column.TIPO)));
            p.setArea(c.getString(c.getColumnIndex(PropertyContract.Column.AREA)));
            p.setModo(c.getString(c.getColumnIndex(PropertyContract.Column.MODO)));
            p.setContacto(c.getString(c.getColumnIndex(PropertyContract.Column.CONTACTO)));
            p.setDescripcion(c.getString(c.getColumnIndex(PropertyContract.Column.DESCRIPCION)));
            p.setPrecio(c.getString(c.getColumnIndex(PropertyContract.Column.PRECIO)));
            p.setLatitud(c.getDouble(c.getColumnIndex(PropertyContract.Column.LATITUD)));
            p.setLongitud(c.getDouble(c.getColumnIndex(PropertyContract.Column.LONGITUD)));
            p.setPais(c.getString(c.getColumnIndex(PropertyContract.Column.PAIS)));
        }return p;
    }
    public String[] getMyInmuebles(){
        SQLiteDatabase db=this.getWritableDatabase();//Obtener instancia de BD
        String inmuebles[];
        Cursor c = db.query(PropertyContract.TABLE, null, null, null, null, null, null);
        inmuebles = new String[c.getCount()];
        int i=0;
        if (c.getCount() > 0) {
            while (c.moveToNext()) {
                inmuebles[i] ="Ciudad o provincia: "+c.getString(c.getColumnIndex(PropertyContract.Column.CIUDAD))+"\nPais: "+
                        c.getString(c.getColumnIndex(PropertyContract.Column.PAIS))+"\nPrecio: "+
                        c.getString(c.getColumnIndex(PropertyContract.Column.PRECIO))+"\nTipo: "+
                        c.getString(c.getColumnIndex(PropertyContract.Column.TIPO))+"\nModo: "+
                        c.getString(c.getColumnIndex(PropertyContract.Column.MODO));
                i++;
            }
        }
        return inmuebles;
    }
}
