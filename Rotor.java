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
        rotorValues = rotorValues.substring(1) + rotorValues.charAt(0); //Left shift rotation
        return rotorValues.charAt(0) == startChar;       
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
    
