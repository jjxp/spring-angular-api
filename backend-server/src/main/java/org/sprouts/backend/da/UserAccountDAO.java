package org.sprouts.backend.da;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.sprouts.model.UserAccount;

public interface UserAccountDAO extends CrudRepository<UserAccount, Integer> {

    UserAccount findByUsername(String username);

}
