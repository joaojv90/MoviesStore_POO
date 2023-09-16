package sys.model;
// Generated 15/09/2023 11:12:03 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Movie generated by hbm2java
 */
public class Movie  implements java.io.Serializable {


     private Integer idMovie;
     private String nameMovie;
     private String mainActor;
     private String genderMovie;
     private Date launch;
     private Integer score;

    public Movie() {
    }

	
    public Movie(String nameMovie) {
        this.nameMovie = nameMovie;
    }
    public Movie(String nameMovie, String mainActor, String genderMovie, Date launch, Integer score) {
       this.nameMovie = nameMovie;
       this.mainActor = mainActor;
       this.genderMovie = genderMovie;
       this.launch = launch;
       this.score = score;
    }
   
    public Integer getIdMovie() {
        return this.idMovie;
    }
    
    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
    }
    public String getNameMovie() {
        return this.nameMovie;
    }
    
    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }
    public String getMainActor() {
        return this.mainActor;
    }
    
    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }
    public String getGenderMovie() {
        return this.genderMovie;
    }
    
    public void setGenderMovie(String genderMovie) {
        this.genderMovie = genderMovie;
    }
    public Date getLaunch() {
        return this.launch;
    }
    
    public void setLaunch(Date launch) {
        this.launch = launch;
    }
    public Integer getScore() {
        return this.score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
    }




}


