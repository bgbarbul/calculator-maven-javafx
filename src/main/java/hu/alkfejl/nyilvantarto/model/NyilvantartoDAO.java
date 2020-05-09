package hu.alkfejl.nyilvantarto.model;

import java.util.List;
import hu.alkfejl.nyilvantarto.model.bean.Szemely;

public interface NyilvantartoDAO {

    boolean addSzemely(Szemely szemely);
    List<Szemely> listSzemely();

}