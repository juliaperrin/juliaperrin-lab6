public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while (rotorValues.charAt(0) != startChar) { //makes sure rotor starts at correct position
           rotate();
        }
        System.out.println("Initialized rotor: " + rotorValues + " with start char: " + startChar);

            
    }
    
    public boolean rotate(){
        //TODO
        rotorValues = rotorValues.charAt(rotorValues.length() - 1) + rotorValues.substring(0, rotorValues.length() - 1);
        return rotorValues.charAt(0) == startChar;       
    }
    

    public int indexOf(char c){
        //TODO
        int index = rotorValues.indexOf(c);
        return index;
    }

    public char charAt(int idx){
        //TODO
        if (idx >= 0 && idx < rotorValues.length()) {
           char foundHere = rotorValues.charAt(idx);
           return foundHere;
        }
        throw new IllegalArgumentException("Index out of bounds: " + idx);
    }
}
    
