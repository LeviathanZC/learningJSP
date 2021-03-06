package by.zercomp.application.model.dao;

public class ColumnName {
    //Users
    public static String USER_ID = "users.id";
    public static String LOGIN = "login";
    public static String EMAIL = "email";
    public static String PASSWORD = "pw_hash";
    public static String ROLE = "role";
    public static String FIRST_NAME = "firstName";
    public static String LAST_NAME = "lastName";
    public static String BIRTH_DATE = "birthDate";

    //User roles
    public static String ROLE_ID = "user_role.role_id";
    public static String ROLE_NAME = "role_name";

    //Orders
    public static String ORDER_ID = "order_id";
    public static String ORDER_USER_ID = "user_id";
    public static String ORDER_DATE = "order_date";
    public static String ORDER_STATUS = "status_code";
    public static String ORDER_DELIVERY = "delivery_id";

    //Order status
    public static String STATUS_CODE = "status_code";
    public static String STATUS_NAME = "status_name";

    //Products
    public static String PRODUCT_ID = "product_id";
    public static String PRODUCT_NAME = "name";
    public static String PRODUCT_CATEGORY = "category_id";
    public static String DESCRIPTION = "description";
    public static String PRICE = "price";
    public static String PRODUCT_BRAND = "brand_id";
    public static String QUANTITY = "quantity";

    //Brands
    public static String BRAND_ID = "brand_id";
    public static String BRAND_NAME = "brand_name";

    //Categories
    public static String CATEGORY_ID = "category_id";
    public static String CATEGORY_NAME = "category_name";
    public static String CATEGORY_DESCRIPTION = "category_desc";

}