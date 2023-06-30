package sdflower80.study.web;

import org.junit.Test;

import java.io.*;
import java.util.Date;

import static org.junit.Assert.*;

public class HelloServletTest {

    @Test
    public void test_date() {
        Date date = new Date(1582510018000L);
        System.out.printf("%1$tF %1$tT", date);
    }

}