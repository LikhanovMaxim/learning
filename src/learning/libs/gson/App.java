package learning.libs.gson;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class App {

    public static void main(String[] args) {

    }

    private void readJson() throws FileNotFoundException {
        String path = "PATH TO YOUR JSON FILE";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();
        Object json = gson.fromJson(bufferedReader, Object.class);

        System.out.println(json.getClass());
        System.out.println(json.toString());
    }


}
