package io.pivotal.literx;

import reactor.core.publisher.Mono;

/**
 * Learn how to create Mono instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html">Mono
 * Javadoc</a>
 */
public class Part02Mono {

//========================================================================================

  /**
   * Return an empty Mono
   *
   * @return Mono
   */
  Mono<String> emptyMono() {
    return Mono.empty();
  }

//========================================================================================

  /**
   * Return a Mono that never emits any signal
   *
   * @return Mono
   */
  Mono<String> monoWithNoSignal() {
    return Mono.never();
  }

//========================================================================================

  /**
   * Return a Mono that contains a "foo" value
   *
   * @return Mono
   */
  Mono<String> fooMono() {
    return Mono.just("foo");
  }

//========================================================================================

  /**
   * Create a Mono that emits an IllegalStateException.
   *
   * @return Mono
   */
  Mono<String> errorMono() {
    return Mono.error(new IllegalStateException());
  }

}
