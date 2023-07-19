#include <stdio.h>

// Function to perform Caesar cipher encryption
void caesarCipherEncrypt(char *message, int key) {
    char ch;
    int i;

    for (i = 0; message[i] != '\0'; ++i) {
        ch = message[i];

        // Encrypt uppercase letters
        if (ch >= 'A' && ch <= 'Z') {
            ch = ch + key;

            if (ch > 'Z') {
                ch = ch - 'Z' + 'A' - 1;
            }

            message[i] = ch;
        }
        // Encrypt lowercase letters
        else if (ch >= 'a' && ch <= 'z') {
            ch = ch + key;

            if (ch > 'z') {
                ch = ch - 'z' + 'a' - 1;
            }

            message[i] = ch;
        }
    }
}

int main() {
    char message[100];
    int key;

    printf("Enter a message to encrypt: ");
    fgets(message, sizeof(message), stdin);

    printf("Enter the key: ");
    scanf("%d", &key);

    caesarCipherEncrypt(message, key);

    printf("Encrypted message: %s\n", message);

    return 0;
}
