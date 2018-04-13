package Ej3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainEj3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Heap<String> queue = new Heap<>();

        while (true) {
            System.out.println("1 to enqueue, 2 to dequeue, 3 to exit");
            String line = br.readLine();

            if (line.equals("1")) {
                System.out.println("Enter value to enqueue: ");
                String value = br.readLine();
                System.out.println("Enter priority to enqueue: ");
                Double priority = Double.parseDouble(br.readLine());
                queue.enqueue(value, priority);
            }
            else if (line.equals("2")) {
                String v = queue.dequeue();
                if (v != null) {
                    System.out.println(v);
                }
            }
            else if (line.equals("3")){
                System.exit(0);
            }
            else{
                System.out.println("Select a valid option");
            }
        }
    }
}
