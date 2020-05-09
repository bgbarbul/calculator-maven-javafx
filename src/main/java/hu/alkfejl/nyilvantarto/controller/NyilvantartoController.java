package hu.alkfejl.nyilvantarto.controller;

import hu.alkfejl.nyilvantarto.model.bean.Szemely;

import java.util.List;

public interface NyilvantartoController {
    boolean addSzemely(Szemely szemely);
    List<Szemely> listSzemely();
}
