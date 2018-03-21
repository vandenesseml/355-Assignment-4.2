package vcu.edu.thesaurus;

/**
 * Created by Max Vandenesse on 3/21/2018.
 */

public class Thesaurus {
    String searchTerm, synonym, antonym;

    public void setSearchTerm(String searchTerm){
        this.searchTerm=searchTerm;
    }
    public void setSynonym(String synonym){
        this.synonym=synonym;
    }
    public void setAntonym(String antonym){
        this.antonym=antonym;
    }
    public String gettSearchTerm(){
        return searchTerm;
    }
    public String gettSynonym(){
        return synonym;
    }
    public String getAntonym(){
        return antonym;
    }


}
