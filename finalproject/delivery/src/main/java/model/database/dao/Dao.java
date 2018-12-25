package model.database.dao;

import java.util.List;

public interface Dao<T> {

    List<T>[] getAll();
}
