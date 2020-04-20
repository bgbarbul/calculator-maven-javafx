package hu.alkfejl.nyilvantarto.model;

import hu.alkfejl.nyilvantarto.model.bean.Szemely;
import java.util.List;

public interface NyilvantartoDAO {
    boolean addSzemely(Szemely szemely);
    List<Szemely> listSzemely();
}
