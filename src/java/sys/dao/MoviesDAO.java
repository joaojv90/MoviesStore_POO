package sys.dao;

import java.util.List;
import sys.model.Movie;

public interface MoviesDAO {
    
    public List<Movie> select();
    public void insert(Movie movie);
    public void update(Movie movie);
    public void delete(Movie movie);
    
}
