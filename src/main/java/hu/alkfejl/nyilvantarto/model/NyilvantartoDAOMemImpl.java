package hu.alkfejl.nyilvantarto.model;

import hu.alkfejl.nyilvantarto.model.bean.Szemely;

import java.util.ArrayList;
import java.util.List;

public class NyilvantartoDAOMemImpl implements NyilvantartoDAO {

    List<Szemely> szemelyek = new ArrayList<Szemely>();

    @Override
    public boolean addSzemely(Szemely szemely) {
        for (Szemely s : szemelyek) {
            if (s.getEmail().equals(szemely.getEmail()))
                return false;
        }
        return szemelyek.add(szemely);
    }

    @Override
    public List<Szemely> listSzemely() {
        return szemelyek;
    }
}

