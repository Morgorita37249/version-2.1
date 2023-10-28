package crv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public abstract class DataBase {
    public static Map<Long, List<String>> UsersData = new HashMap<>();
    static {
        // נו ןאנ ג UsersData
        for (int i = 0; i <= 12; i++) {
            UsersData.put((long) i, Arrays.asList(String.valueOf(i), String.valueOf(501 + i)));
        }
    }
}
