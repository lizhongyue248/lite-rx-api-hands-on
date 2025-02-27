/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.pivotal.literx;

import io.reactivex.BackpressureStrategy;
import java.util.concurrent.CompletableFuture;

import io.pivotal.literx.domain.User;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Learn how to adapt from/to RxJava 2 Observable/Single/Flowable and Java 8+ CompletableFuture.
 *
 * Mono and Flux already implements Reactive Streams interfaces so they are natively
 * Reactive Streams compliant + there are {@link Mono#from(Publisher)} and {@link Flux#from(Publisher)}
 * factory methods.
 *
 * For RxJava 2, you should not use Reactor Adapter but only RxJava 2 and Reactor Core.
 *
 * @author Sebastien Deleuze
 */
public class Part09Adapt {

//========================================================================================

  /**
   * Adapt Flux to RxJava Flowable.
   *
   * @param flux flux
   * @return Flowable
   */
	Flowable<User> fromFluxToFlowable(Flux<User> flux) {
		return Flowable.fromPublisher(flux);
	}

  /**
   * Adapt RxJava Flowable to Flux.
   *
   * @param flowable flowable
   * @return Flux
   */
	Flux<User> fromFlowableToFlux(Flowable<User> flowable) {
		return Flux.from(flowable);
	}

//========================================================================================

  /**
   * Adapt Flux to RxJava Observable.
   *
   * @param flux flux
   * @return Observable
   */
	Observable<User> fromFluxToObservable(Flux<User> flux) {
		return Observable.fromPublisher(flux);
	}

  /**
   * Adapt RxJava Observable to Flux.
   *
   * @param observable observable
   * @return Flux
   */
	Flux<User> fromObservableToFlux(Observable<User> observable) {
		return Flux.from(observable.toFlowable(BackpressureStrategy.BUFFER));
	}

//========================================================================================

  /**
   * Adapt Mono to RxJava Single.
   *
   * @param mono mono
   * @return Single
   */
	Single<User> fromMonoToSingle(Mono<User> mono) {
		return Single.fromPublisher(mono);
	}

  /**
   * Adapt RxJava Single to Mono.
   *
   * @param single single
   * @return Mono
   */
	Mono<User> fromSingleToMono(Single<User> single) {
		return Mono.from(single.toFlowable());
	}

//========================================================================================

  /**
   * Adapt Mono to Java 8+ CompletableFuture.
   *
   * @param mono mono
   * @return CompletableFuture
   */
	CompletableFuture<User> fromMonoToCompletableFuture(Mono<User> mono) {
		return mono.toFuture();
	}

  /**
   * Adapt Java 8+ CompletableFuture to Mono.
   *
   * @param future future
   * @return Mono
   */
	Mono<User> fromCompletableFutureToMono(CompletableFuture<User> future) {
		return Mono.fromFuture(future);
	}

}
