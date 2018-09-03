package hopto.org.slazhy.service;

import hopto.org.slazhy.data.Player;
import hopto.org.slazhy.repository.PlayerRepository;
import org.springframework.stereotype.Component;

@Component
public class PlayerService {

    private final PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public Player addPlayer(Player player){
        return repository.save(player);
    }

}
