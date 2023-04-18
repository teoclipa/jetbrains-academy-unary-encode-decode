package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Please input operation (encode/decode/exit):");
            String operation = scanner.nextLine();

            switch (operation) {
                case "encode" -> {
                    System.out.println("Input string:");
                    String input = scanner.nextLine();
                    String binary = getBinaryString(input);
                    String output = encode(binary);
                    System.out.println("Encoded string:\n" + output);
                }
                case "decode" -> {
                    System.out.println("Input encoded string: ");
                    String encodedInput = scanner.nextLine();
                    if (!encodedInput.replaceAll("0", "").trim().isEmpty()) {
                        System.out.println("Encoded string is not valid.");
                        break;
                    }
                    String[] blocks = encodedInput.split(" ");
                    if (!(blocks[0].equals("0") || blocks[0].equals("00"))) {
                        System.out.println("Encoded string is not valid.");
                        break;
                    }
                    if (blocks.length % 2 == 1) {
                        System.out.println("Encoded string is not valid.");
                        break;
                    }
                    String decoded = decode(blocks);
                    if (decoded.trim().isEmpty()) {
                        System.out.println("Encoded string is not valid.");
                        break;
                    }
                    if(decoded.length() == 1){
                        System.out.println("Encoded string is not valid.");
                        break;
                    }

                    System.out.println("Decoded string:");
                    System.out.println(decoded);
                }
                case "exit" -> {
                    System.out.println("Bye!");
                    running = false;
                }
                default -> System.out.println("There is no '" + operation + "' operation");
            }
        }
    }

    private static String encode(String binary) {
        int currentPosition = 0;
        char previousChar = '-';

        StringBuilder output = new StringBuilder();

        while (currentPosition < binary.length()) {
            char c = binary.charAt(currentPosition++);

            if (c == previousChar) {
                output.append("0");
            } else {
                output.append(c == '0' ? " 00 0" : " 0 0");
            }

            previousChar = c;
        }

        return output.toString();
    }

    private static String getBinaryString(String input) {
        StringBuilder binary = new StringBuilder();

        for (char c : input.toCharArray()) {
            binary.append(String.format("%7s", Integer.toBinaryString(c)).replace(" ", "0"));
        }
        return binary.toString();
    }

    private static String decode(String[] blocks) {
        StringBuilder binaryBuilder = new StringBuilder();
        for (int i = 0; i < blocks.length; i += 2) {
            int blockValue = blocks[i].equals("0") ? 1 : 0;
            int blockLength = blocks[i + 1].length();
            binaryBuilder.append(String.valueOf(blockValue).repeat(blockLength));
        }
        String binary = binaryBuilder.toString();

        if (binary.length() % 7 != 0) {
            return "";
        }
        // Split binary into groups of 7 bits and convert to chars
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 7) {
            String binaryChar = binary.substring(i, Math.min(i + 7, binary.length()));
            char c = (char) Integer.parseInt(binaryChar, 2);
            resultBuilder.append(c);
        }
        return (resultBuilder.toString());
    }
}
