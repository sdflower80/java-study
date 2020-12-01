package sdflower80.study.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStream {

    public void emptyMapEntrySet() {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.isEmpty());

        List<Map.Entry<String, String>> collect = map.entrySet().stream().collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void main(String[] args) {
        new MapStream().emptyMapEntrySet();
    }
}
