package hu.alkfejl.nyilvantarto.model;

import hu.alkfejl.nyilvantarto.model.bean.Szemely;

import java.util.ArrayList;
import java.util.List;

public class NyilvantartoDAOMemImpl implements NyilvantartoDAO {

    List<Szemely> szemelyek = new ArrayList<Szemely>();
    @Override
    public boolean addSzemely(Szemely szemely) {
        return false;
    }

    @Override
    public List<Szemely> listSzemely() {
        return szemelyek;
    }
}
