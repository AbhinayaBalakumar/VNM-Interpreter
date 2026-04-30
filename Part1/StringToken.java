åpublic class StringToken extends Token {
    public String value;
    
    public StringToken(int kind, String image) {
        this.kind = kind;
        this.image = image;
        // Remove surrounding quotes and process escape sequences
        String content = image.substring(1, image.length() - 1);
        this.value = processEscapeSequences(content);
    }
    
    private String processEscapeSequences(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '\\' && i + 1 < str.length()) {
                char next = str.charAt(i + 1);
                switch (next) {
                    case 'n': result.append('\n'); i++; break;
                    case 't': result.append('\t'); i++; break;
                    case '\"': result.append('\"'); i++; break;
                    case '\\': result.append('\\'); i++; break;
                    default: result.append(c); break;
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
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

