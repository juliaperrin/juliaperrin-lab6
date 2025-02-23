public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        //TODO
        char char27 = rotorValues.charAt(26); //Find last character
        rotorValues = char27 + rotorValues.substring(0, 26); //remove last character, add to beginning, shift everything to the right
        return rotorValues.charAt(0) == startChar; //Returns true if the rotor is back at starting position
               
    }
    

    public int indexOf(char c){
        //TODO
        int index = rotorValues.indexOf(c);
        return index;
    }

    public char charAt(int idx){
        //TODO
        char foundHere = rotorValues.charAt(idx);
        return foundHere;
    }
}
    
