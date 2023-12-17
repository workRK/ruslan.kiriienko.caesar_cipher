package com.javarush;

import java.util.Scanner;

public class CLI {
    private final Scanner scanner = new Scanner(System.in);

    CLI() {}

    String promptForCommand() {
        System.out.println("Введіть команду (ENCRYPT, DECRYPT, BRUTE_FORCE):");
        return scanner.nextLine();
    }

    String promptForFilePath() {
        System.out.println("Введіть шлях до файлу:");
        return scanner.nextLine();
    }

    int promptForKey() {
        System.out.println("Введіть ключ:");
        return Integer.parseInt(scanner.nextLine());
    }

    void close() {
        scanner.close();
    }
}
