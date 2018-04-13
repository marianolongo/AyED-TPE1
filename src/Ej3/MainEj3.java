package Ej3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainEj3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Heap<String> heap = new Heap<>();

        while (true) {
            System.out.println("Press 1 to enqueue" + "\n" + "Press 2 to dequeue " + "\n" +"Press 3 to exit");
            String line = bufferedReader.readLine();

            if (line.equals("1")) {
                System.out.println("Enter an ELEMENT to enqueue: ");
                String value = bufferedReader.readLine();
                System.out.println("Enter a PRIORITY for the element to enqueue: ");
                Double priority = Double.parseDouble(bufferedReader.readLine());
                heap.enqueue(value, priority);
            }
            else if (line.equals("2")) {
                String v = heap.dequeue();
                if (v != null) {
                    System.out.println();
                    System.out.println("The element dequeued: " + v);
                    System.out.println();
                }
            }
            else if (line.equals("3")){
                System.exit(0);
            }
            else{
                System.out.println("Try again");
            }
        }
    }
}
