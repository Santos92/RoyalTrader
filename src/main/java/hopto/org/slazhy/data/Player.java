package hopto.org.slazhy.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    protected Player(){

    }

    public Player(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
