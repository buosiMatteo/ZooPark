package ZooPark;

import ZooPark.ZooPark;

import java.util.ArrayList;
import java.util.List;

public class ZooParkDB {
    public static List<ZooPark> zooParkList = new ArrayList<>();

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zooParkList.size(); i++) {
            sb.append(String.format("The first zoo is %s",zooParkList.get(i)));
        }
        return sb.toString();
    }
}
