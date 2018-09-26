package tricktactoe.ui.text;

import tricktactoe.Symbol;

public class TextSymbol implements Symbol<String> {

    private String symbol = null;

    public TextSymbol(String symbol) {
        setSymbol(symbol);
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public boolean equals(Object o) {
        if (null != o && o instanceof TextSymbol) {
            TextSymbol symbol = (TextSymbol) o;
            if (symbol.getSymbol().equals(this.getSymbol()))
                return true;
        }
        return false;
    }

    public String toString() {
        return this.getSymbol();
    }

}
