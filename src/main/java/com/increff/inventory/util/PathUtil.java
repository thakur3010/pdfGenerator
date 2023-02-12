package com.increff.inventory.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PathUtil {

    private static String path;

    public static String getPath() {
        return path;
    }

    private static void setPath(String p) {
        path = p;
    }

    public static void init() throws IOException {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "app.properties";
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));
        setPath(appProps.getProperty("invoice.path"));
    }
}
