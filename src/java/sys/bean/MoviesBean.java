package sys.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import sys.dao.MoviesDAO;
import sys.impl.MoviesDAOImpl;
import sys.model.Movie;

@ManagedBean
@Named(value = "moviesBean")
@ViewScoped
public class MoviesBean {

    private Movie movie = null;
    private List<Movie> movies = null;
    
    public MoviesBean(){    
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Movie> getMovies() {
        MoviesDAO data = new MoviesDAOImpl();
        this.movies = data.select();
        return movies;
    }
    
    public void prepareMovie(){
        this.movie = new Movie();
    }
    
    public void insertMovie(){
        MoviesDAO data = new MoviesDAOImpl();
        data.insert(movie);
    }
    
    public void upDateMovie(){
        MoviesDAO data = new MoviesDAOImpl();
        data.update(movie);
        this.movie = new Movie();
    }
    
    public void deleteMovie(){
        MoviesDAO data = new MoviesDAOImpl();
        data.delete(movie);
        this.movie = new Movie();
    }

    public void setMovies(List<Movie> movies) {        
        this.movies = movies;
    }
    
}
