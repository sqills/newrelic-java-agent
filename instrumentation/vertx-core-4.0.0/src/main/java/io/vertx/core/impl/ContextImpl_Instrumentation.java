/*
 *
 *  * Copyright 2020 New Relic Corporation. All rights reserved.
 *  * SPDX-License-Identifier: Apache-2.0
 *
 */

package io.vertx.core.impl;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.vertx.instrumentation.VertxCoreUtil;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Promise;
import io.vertx.core.spi.metrics.PoolMetrics;

@Weave(originalName = "io.vertx.core.impl.ContextImpl")
abstract class ContextImpl_Instrumentation {

    static <T> Future<T> executeBlocking(ContextInternal context,
            Handler<Promise<T>> blockingCodeHandler,
            WorkerPool workerPool, TaskQueue queue) {
        VertxCoreUtil.storeToken(blockingCodeHandler);
        return Weaver.callOriginal();
    }

    private static void lambda$executeBlocking$1(PoolMetrics poolMetrics, Object obj,
            ContextInternal context, Promise result, Handler handler, Future future) {
        VertxCoreUtil.storeToken(handler);
        Weaver.callOriginal();
    }

    @Trace(async = true)
    private static void lambda$null$0(Handler handler, Promise result, Promise result2) {
        VertxCoreUtil.linkAndExpireToken(handler);
        Weaver.callOriginal();
    }
}
