package hopto.org.slazhy.repository;

import hopto.org.slazhy.data.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
}
