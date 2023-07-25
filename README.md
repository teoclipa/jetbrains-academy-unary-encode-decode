# jetbrains-academy-unary-encode-decode#

This is a Java project that implements the Chuck Norris Cipher for encoding and decoding text. It offers a console-based interaction for users to input their strings to be encoded or decoded. 

Here's a brief summary of the functionalities:

## Encode
- Takes a user-input string and converts each character to its binary representation.
- Applies the Chuck Norris Cipher to the binary string and produces an encoded string. The Chuck Norris Cipher works by replacing '1's and '0's in the binary string with '0' and '00', respectively, and prepending the length of the consecutive segment of '1's or '0's.

## Decode
- Takes a user-input encoded string. The input string must follow the specific format created by the encoding process. If not, the program will deem it as an invalid encoded string.
- The decoder reverses the process of encoding by splitting the encoded string into blocks and transforming it back into binary form, then the binary into the original text.

## Exit
- The program will keep running until the user enters the 'exit' command, which gracefully terminates the program.

This project is very straightforward to use and provides an effective implementation of the Chuck Norris Cipher. Whether you're learning about ciphers, need a quick way to encrypt/decrypt text using the Chuck Norris Cipher, or simply want to explore a fascinating piece of coding, this project has you covered.
