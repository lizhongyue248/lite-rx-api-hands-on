package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Learn how to turn Reactive API to blocking one.
 *
 * @author Sebastien Deleuze
 */
public class Part10ReactiveToBlocking {

//========================================================================================

  /**
   * Return the user contained in that Mono.
   *
   * @param mono mono
   * @return User
   */
	User monoToValue(Mono<User> mono) {
		return mono.block();
	}

//========================================================================================

  /**
   * Return the users contained in that Flux.
   *
   * @param flux flux
   * @return Iterable
   */
	Iterable<User> fluxToValues(Flux<User> flux) {
		return flux.toIterable();
	}

}
