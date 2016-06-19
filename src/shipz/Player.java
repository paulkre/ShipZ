package shipz;

import shipz.util.GameEventSource;

public abstract class Player extends GameEventSource implements Runnable {
    private String _name;
    private int _x;
    private int _y;
    private byte _result;
    private boolean _turn;

    private boolean _end;

    public Player(){
        this("Player");
    }

    public Player(String name) {
        _name = name;
        _end = false;
        _turn = false;
    }

    public String name() {
        return _name;
    }





    protected void setX(int x) {
        _x = x;
    }

    protected void setY(int y) {
        _y = y;
    }

    protected void setResult(byte res) {
        _result = res;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    public byte getResult() {
        return _result;
    }




    /**
     * Rückgabeinformationen der Verwaltung über den aktuellen Status,
     * nachdem man das Feld beschossen hat.
     *
     * @param yCoord Y-Koordinate
     * @param xCoord X-Koordinate
     * @param result Ergebnis der beschossenen Y- und X-Koordinaten. Klassen werten für sich das Ergebnis aus
     *               und führen entsprechende Aktionen aus.
     *
     */
    public abstract void shootResult (int yCoord, int xCoord, byte result);



    public void shootField(int x, int y, byte result) {}

    public void turn() {
        _turn = true;
    }

    public boolean isMyTurn() {
        if(_turn) {
            _turn = false;
            return true;
        } else return false;
    }

	public void end() {
        _end = true;
    }

    protected boolean isEnd() {
        return _end;
    }
}
