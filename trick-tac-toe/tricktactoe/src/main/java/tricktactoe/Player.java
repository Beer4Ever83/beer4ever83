package tricktactoe;

public class Player {

    private String name;
    private Symbol placeholder;

    public Player(String name, Symbol placeholder) {
        setName(name);
        setPlaceholder(placeholder);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlaceholder(Symbol placeholder) {
        this.placeholder = placeholder;
    }

    public String getName() {
        return this.name;
    }

    public Symbol getPlaceholder() {
        return this.placeholder;
    }

    public boolean equals(Object o) {
        if (null != o && o instanceof Player) {
            Player p = (Player) o;
            if (p.getName().equals(this.getName())) {
                if (this.getPlaceholder() == null) {
                    if (p.getPlaceholder() == null) {
                        return true;
                    }
                } else if (p.getPlaceholder().equals(this.getPlaceholder())) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        String out = "";
        out += "Player name: \"" + this.name + "\"";
        out += ", placeholder: \"" + (this.placeholder == null ? "<none>" : this.placeholder) + "\"\n";
        return out;
    }
}
