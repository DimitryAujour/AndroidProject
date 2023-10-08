import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "deliveryApp.db";
    private static final int DATABASE_VERSION = 1;

    // Routes Table
    private static final String TABLE_ROUTES = "Routes";
    private static final String COLUMN_ROUTE_ID = "route_id";
    private static final String COLUMN_DELIVERY_PERSON_ID = "delivery_person_id";

    // Deliverers Table
    private static final String TABLE_DELIVERERS = "Deliverers";
    private static final String COLUMN_DELIVERER_ID = "deliverer_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_PHONE = "phone";

    // Subscriptions Table
    private static final String TABLE_SUBSCRIPTIONS = "Subscriptions";
    private static final String COLUMN_SUBSCRIPTION_ID = "subscription_id";
    private static final String COLUMN_CUSTOMER_NAME = "customer_name";
    private static final String COLUMN_SUBSCRIPTION_PRODUCT_TYPE = "subscription_product_type";  // Renamed
    private static final String COLUMN_QUANTITY = "quantity";

    // Products Table
    private static final String TABLE_PRODUCTS = "Products";
    private static final String COLUMN_PRODUCT_ID = "product_id";
    private static final String COLUMN_PRODUCT_NAME = "product_name";
    private static final String COLUMN_PRODUCT_TYPE_NAME = "product_type_name";  // Renamed

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create Routes table
        String createRoutesTable = "CREATE TABLE " + TABLE_ROUTES + "(" +
                COLUMN_ROUTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DELIVERY_PERSON_ID + " INTEGER);";
        db.execSQL(createRoutesTable);

        // Create Deliverers table
        String createDeliverersTable = "CREATE TABLE " + TABLE_DELIVERERS + "(" +
                COLUMN_DELIVERER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_ADDRESS + " TEXT, " +
                COLUMN_PHONE + " TEXT);";
        db.execSQL(createDeliverersTable);

        // Create Subscriptions table
        String createSubscriptionsTable = "CREATE TABLE " + TABLE_SUBSCRIPTIONS + "(" +
                COLUMN_SUBSCRIPTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CUSTOMER_NAME + " TEXT, " +
                COLUMN_ADDRESS + " TEXT, " +
                COLUMN_SUBSCRIPTION_PRODUCT_TYPE + " TEXT, " +  // Updated
                COLUMN_QUANTITY + " INTEGER, " +
                COLUMN_ROUTE_ID + " INTEGER);";
        db.execSQL(createSubscriptionsTable);


        // Create Products table
        String createProductsTable = "CREATE TABLE " + TABLE_PRODUCTS + "(" +
                COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PRODUCT_NAME + " TEXT, " +
                COLUMN_PRODUCT_TYPE_NAME + " TEXT);";  // Updated
        db.execSQL(createProductsTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // You can implement upgrading database logic here when needed
    }
}
