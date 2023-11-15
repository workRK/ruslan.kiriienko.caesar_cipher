# Caesar Cipher Program 
by Ruslan Kiriienko

![Java Version](https://img.shields.io/badge/Java-v1.8%2B-orange)
![License](https://img.shields.io/badge/License-MIT-blue)

Ця програма реалізує шифр Цезаря для шифрування та дешифрування текстових файлів.

## Властивості

- Шифрування та дешифрування за допомогою шифру Цезаря.
- Підтримка англійської та української мов.
- Підтримка режиму брут-форс для автоматичного підбору ключа.

## Використання

1. **Шифрування файлу:**
    ```bash
    java -jar myApp.jar ENCRYPT "path/to/file.txt" 10
    ```

2. **Дешифрування файлу:**
    ```bash
    java -jar myApp.jar DECRYPT "path/to/encrypted_file.txt" 10
    ```

3. **Брут-форс:**
    ```bash
    java -jar myApp.jar BRUTE_FORCE "path/to/encrypted_file.txt"
    ```

## Користування через консоль

Якщо ви використовуєте консоль, передайте аргументи командного рядка під час запуску програми.

```bash
java -jar myApp.jar [COMMAND] "path/to/file.txt" [KEY]
```
## Вимоги

- Java 8 або новіше.

## Ліцензія

Цей проект розповсюджується під ліцензією MIT - подробиці в [LICENSE](LICENSE) файлі.

**Зауваження:** Замість `myApp.jar`, вкажіть ім'я вашого JAR файлу.

🚀 Дякуємо за використання нашої програми! Якщо у вас є які-небудь питання або пропозиції, будь ласка, відкривайте нові issues або створюйте pull requests.

