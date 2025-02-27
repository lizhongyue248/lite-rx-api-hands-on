package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Learn how to transform values.
 *
 * @author Sebastien Deleuze
 */
public class Part04Transform {

//========================================================================================

  /**
   * Capitalize the user username, firstname and lastname.
   *
   * @param mono mono
   * @return mono
   */
  Mono<User> capitalizeOne(Mono<User> mono) {
    return mono.map(
        user -> new User(
            user.getUsername().toUpperCase(),
            user.getFirstname().toUpperCase(),
            user.getLastname().toUpperCase()
        ));
  }

//========================================================================================

  /**
   * Capitalize the users username, firstName and lastName.
   *
   * @param flux flux
   * @return flux
   */
  Flux<User> capitalizeMany(Flux<User> flux) {
    return flux.map(
        user -> new User(
            user.getUsername().toUpperCase(),
            user.getFirstname().toUpperCase(),
            user.getLastname().toUpperCase()
        ));
  }

//========================================================================================

  /**
   * Capitalize the users username, firstName and lastName using #asyncCapitalizeUser.
   *
   * @param flux flux
   * @return flux
   */
  Flux<User> asyncCapitalizeMany(Flux<User> flux) {
    return flux.flatMap(this::asyncCapitalizeUser);
  }

  Mono<User> asyncCapitalizeUser(User u) {
    return Mono.just(new User(
        u.getUsername().toUpperCase(),
        u.getFirstname().toUpperCase(),
        u.getLastname().toUpperCase()
    ));
  }

}
