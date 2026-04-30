public class IdNumToken extends Token {
    public String value;
    
    public IdNumToken(int kind, String image) {
        this.kind = kind;
        this.image = image;
        this.value = image;
    }
    
    @Override
    public Object getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return value;
    }
}

