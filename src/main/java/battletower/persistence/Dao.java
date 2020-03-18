package battletower.persistence;

import java.util.List;

public interface Dao<T>
{
    public T findById(Integer id);

    public List findAll();

    public T update(T dto);

    public T create(T dto);

    public void delete(Integer id);

}
