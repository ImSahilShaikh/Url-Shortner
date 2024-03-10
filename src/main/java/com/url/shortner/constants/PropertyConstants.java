package com.url.shortner.constants;

public class PropertyConstants {
    public static final String DB_COLLECTION_NAME = "#{@environment.getProperty('mongodb.collection.name')}";
}
