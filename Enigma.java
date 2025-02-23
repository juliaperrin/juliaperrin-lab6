public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        //TODO
        int messageLength = message.length();
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = 0; i < messageLength; i++) {
           char originalChar = message.charAt(i); //gets current character in the message (pre-decryption)
           int outerIndex1 = rotors[2].indexOf(originalChar); //finds index of character in outer rotor
           char midChar = rotors[1].charAt(outerIndex1); //find the character on the middle rotor aligned with the encrypted character on the outer
           int outerIndex2 = rotors[2].indexOf(midChar); //finds the position on the outer rotor for the previously found character
           char outerChar = rotors[2].charAt(outerIndex2); //finds the character at that positionally aligns with the previous on the outer rotor
           int innerIndex = rotors[0].indexOf(outerChar); //finds the index of the previously found character
           char decryptedChar = rotors[0].charAt(innerIndex); //finds the decrypted character by finding the aligning 
           
           decryptedMessage.append(decryptedChar); 
           
           rotate();
           
           System.out.println("Encrypted: " + originalChar + " | Outer: " + outerIndex +
                   " | Middle: " + middleChar + " | Inner: " + decryptedChar); //DEBUG

        }
        return decryptedMessage.toString();
    }


    
    public String encrypt(String message){
        //TODO
        int messageLength = message.length();
        StringBuilder encryptedMessage = new StringBuilder(); //build a string to store the encryption
        for (int i = 0; i < messageLength; i++) {
           char originalChar = message.charAt(i); //get current character in the message (Pre-encryption)
           int innerIndex = rotors[0].indexOf(originalChar); //gets index of where character is in the inner rotor
           char outerRotorChar = rotors[2].charAt(innerIndex); //finds the character at the same index in the outer rotor
           int midIndex = rotors[1].indexOf(outerRotorChar); //gets index of character from outer rotor on the middle rotor
           char midRotorChar = rotors[1].charAt(midIndex); //Finds the character at that index on the middle rotor 
           int outerIndex = rotors[2].indexOf(midRotorChar); //finds index on outer rotor of character from middle rotor
           char encryptedChar = rotors[2].charAt(outerIndex); //finds the final encrypted character at the outer rotor
           
           encryptedMessage.append(encryptedChar);
           
           rotate(); //call rotate method to rotate after every encrypted character
           System.out.println("Original: " + originalChar + " | Inner: " + innerIndex +
                   " | Middle: " + middleChar + " | Outer: " + outerChar); //DEBUG


        }
        
        return encryptedMessage.toString();
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
