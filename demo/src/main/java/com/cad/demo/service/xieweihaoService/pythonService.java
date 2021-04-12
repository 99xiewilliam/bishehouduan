package com.cad.demo.service.xieweihaoService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class pythonService {
    public int startSelenium(String keyword, String fileName, String pageTo) {
        int judge = 0;
        try {
            String[] args1 = new String[] { keyword, fileName, pageTo };
            Process pr = Runtime.getRuntime().exec("python /Users/xiexiaohao/PycharmProjects/pythonProject/python_selenuim/new_main.py");
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            pr.waitFor();
            judge = 1;
            System.out.println("end");
        }catch (Exception e) {
            System.out.println(e);
        }
        return judge;
    }
}
