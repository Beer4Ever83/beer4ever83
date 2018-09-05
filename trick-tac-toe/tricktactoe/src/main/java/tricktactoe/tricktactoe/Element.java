package tricktactoe.tricktactoe;

public class Element {

    private Player p;

    public Element() {
        this.p = null;
    }

    public void setPlayer(Player p) {
        this.p = p;
    }

    public Player getPlayer() {
        return this.p;
    }

    public boolean equals(Object o) {
        if (o instanceof Player) {
            Player p = (Player) o;
            if (p.equals(this.getPlayer()))
                return true;
        }
        return false;
    }

}
