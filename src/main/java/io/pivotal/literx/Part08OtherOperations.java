package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Learn how to use various other operators.
 *
 * @author Sebastien Deleuze
 */
public class Part08OtherOperations {

//========================================================================================

  /**
   * Create a Flux of user from Flux of username, firstname and lastname.
   *
   * @param usernameFlux  Flux
   * @param firstnameFlux Flux
   * @param lastnameFlux  Flux
   * @return Flux
   */
  Flux<User> userFluxFromStringFlux(Flux<String> usernameFlux, Flux<String> firstnameFlux,
      Flux<String> lastnameFlux) {
    return Flux.zip(usernameFlux, firstnameFlux, lastnameFlux)
        .map(tuple -> new User(tuple.getT1(), tuple.getT2(), tuple.getT3()));
  }

//========================================================================================

  /**
   * Return the mono which returns its value faster.
   *
   * @param mono1 mono
   * @param mono2 mono
   * @return mono
   */
  Mono<User> useFastestMono(Mono<User> mono1, Mono<User> mono2) {
    return Mono.first(mono1, mono2);
  }

//========================================================================================

  /**
   * Return the flux which returns the first value faster.
   *
   * @param flux1 flux
   * @param flux2 flux
   * @return flux
   */
  Flux<User> useFastestFlux(Flux<User> flux1, Flux<User> flux2) {
    return Flux.first(flux1, flux2);
  }

//========================================================================================

  /**
   * Convert the input Flux<User> to a Mono<Void> that represents the complete signal of the flux.
   *
   * @param flux flux
   * @return Mono
   */
  Mono<Void> fluxCompletion(Flux<User> flux) {
    return flux.then();
  }

//========================================================================================

  /**
   * Return a valid Mono of user for null input and non null input user (hint: Reactive Streams do
   * not accept null values).
   *
   * @param user user
   * @return Mono
   */
  Mono<User> nullAwareUserToMono(User user) {
    return Mono.justOrEmpty(user);
  }

//========================================================================================

  /**
   * Return the same mono passed as input parameter, expect that it will emit User.SKYLER when
   * empty.
   *
   * @param mono mono
   * @return mono
   */
  Mono<User> emptyToSkyler(Mono<User> mono) {
    return mono.defaultIfEmpty(User.SKYLER);
  }

}
