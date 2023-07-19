//66 - Dhiraj Kapse
//19 July 2023
#include <iostream>
#include <string>
using namespace std;

// Function to perform Caesar cipher encryption
string caesarCipherEncrypt(const string& message, int key) {
    string encryptedMessage = "";

    for (char ch : message) {
        if (isalpha(ch)) {
            char base = islower(ch) ? 'a' : 'A';
            char encryptedChar = ((ch - base + key) % 26) + base;
            encryptedMessage += encryptedChar;
        } else {
            encryptedMessage += ch;
        }
    }

    return encryptedMessage;
}

// Function to perform Caesar cipher decryption
string caesarCipherDecrypt(const string& message, int key) {
    return caesarCipherEncrypt(message, 26 - key);
}

int main() {
    int choice;
    string message;
    int key;

    cout << "Caesar Cipher Encryption/Decryption" << endl;
    cout << "----------------------------------" << endl;

    cout << "Enter 1 for encryption\nEnter 2 for decryption: ";
    cin >> choice;

    cin.ignore(); // Ignore the newline character

    cout << "Enter the message: ";
    getline(cin, message);

    cout << "Enter the key: ";
    cin >> key;

    if (choice == 1) {
        string encryptedMessage = caesarCipherEncrypt(message, key);
        cout << "Encrypted message: " << encryptedMessage << endl;
    } else if (choice == 2) {
        string decryptedMessage = caesarCipherDecrypt(message, key);
        cout << "Decrypted message: " << decryptedMessage << endl;
    } else {
        cout << "Invalid choice! Please enter 1 for encryption or 2 for decryption." << endl;
    }

    return 0;
}
