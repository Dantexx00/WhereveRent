package co.edu.udea.cmovil.gr02.whereverent;

import android.provider.BaseColumns;

//Clase para guardar las constantes necesarias de la base de datos.
public class PropertyContract {
    public static final String DB_NAME = "whereverent.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE = "property";

    public class Column{
        public static final String ID = BaseColumns._ID;
        public static final String PAIS = "pais";
        public static final String CIUDAD = "ciudad";
        public static final String TIPO = "tipo";
        public static final String AREA = "area";
        public static final String MODO = "modo";
        public static final String CONTACTO = "contacto";
        public static final String DESCRIPCION = "descripcion";
        public static final String PRECIO = "precio";
        public static final String LATITUD ="latitud";
        public static final String LONGITUD ="longitud";
    }
}
