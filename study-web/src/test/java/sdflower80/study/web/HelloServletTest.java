package sdflower80.study.web;

import org.junit.Test;

import java.io.*;
import java.util.Date;

import static org.junit.Assert.*;

public class HelloServletTest {

    @Test
    public void test() throws IOException {
        File f = new File("/Users/sdflower/Downloads/fail.csv");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String line;
        while((line = br.readLine()) != null) {
            if (line.contains("orderId=") && line.contains("배송지 변경 실패") && line.contains("IllegalStateException")) {
                System.out.println(line);
            }
        }
    }

    @Test
    public void test_date() {
        Date date = new Date(1582510018000L);
        System.out.printf("%1$tF %1$tT", date);
    }

}