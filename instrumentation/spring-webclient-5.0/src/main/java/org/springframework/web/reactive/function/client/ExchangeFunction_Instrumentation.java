/*
 *
 *  * Copyright 2020 New Relic Corporation. All rights reserved.
 *  * SPDX-License-Identifier: Apache-2.0
 *
 */

package org.springframework.web.reactive.function.client;

import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.agent.instrumentation.spring_webclient.Util;
import reactor.core.publisher.Mono;

@Weave(type = MatchType.Interface, originalName = "org.springframework.web.reactive.function.client.ExchangeFunction")
public class ExchangeFunction_Instrumentation {

    public Mono<ClientResponse> exchange(ClientRequest request) {

        Mono<ClientResponse> response = Weaver.callOriginal();

        return Util.reportAsExternal(request, response);
    }
}
