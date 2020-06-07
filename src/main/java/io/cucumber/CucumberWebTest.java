package io.cucumber;

import java.io.IOException;

public class CucumberWebTest {

    public static void main(String[] args) throws IOException {
        int n = 1; //liczba testow
        for (int i = 1; i <= n; i++) {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "mvn test");
            pb.start();
        }
    }
}
