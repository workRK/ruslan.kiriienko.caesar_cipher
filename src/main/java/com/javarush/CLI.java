package com.javarush;

import java.util.Scanner;

public class CLI {
    private Scanner scanner;

    public CLI() {
        scanner = new Scanner(System.in);
    }

    public String promptForCommand() {
        System.out.println("Введіть команду (ENCRYPT, DECRYPT, BRUTE_FORCE):");
        return scanner.nextLine();
    }

    public String promptForFilePath() {
        System.out.println("Введіть шлях до файлу:");
        return scanner.nextLine();
    }

    public int promptForKey() {
        System.out.println("Введіть ключ:");
        return Integer.parseInt(scanner.nextLine());
    }

    public void close() {
        scanner.close();
    }
}
