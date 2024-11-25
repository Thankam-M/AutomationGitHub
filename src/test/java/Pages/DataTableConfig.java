package Pages;

import io.cucumber.datatable.DataTable;

import java.util.Map;

public class DataTableConfig {

    public  DataTableConfig()
    {}

    public static String TableValues(DataTable dataTable, String key){
        return (String) dataTable.asMap(String.class,String.class).get(key);
    }
    public static String TableValues(Map<String,String> map, String key){
        return (String) map.get(key);
    }
}
