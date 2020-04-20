package hu.alkfejl.nyilvantarto.controller;

import java.util.List;

import hu.alkfejl.nyilvantarto.model.NyilvantartoDAO;
import hu.alkfejl.nyilvantarto.model.NyilvantartoDAOMemImpl;
import hu.alkfejl.nyilvantarto.model.bean.Szemely;

public class NyilvantartoControllerImpl implements NyilvantartoController {

    private NyilvantartoDAO dao = new NyilvantartoDAOMemImpl();

    @Override
    public boolean addSzemely(Szemely szemely) {
        return dao.addSzemely(szemely);
    }

    @Override
    public List<Szemely> listSzemely() {
        return dao.listSzemely();
    }

}