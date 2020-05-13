/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.metrics.prometheus.impl.counter;

import io.prometheus.client.Counter;
import org.apache.shardingsphere.metrics.api.CounterMetricsTracker;
import org.apache.shardingsphere.metrics.enums.MetricsLabelEnum;

/**
 * Shadow hit counter metrics tracker.
 */
public final class ShadowHitTotalCounterMetricsTracker implements CounterMetricsTracker {
    
    private static final Counter SHADOW_HIT_TOTAL = Counter.build()
            .name("shadow_hit_total")
            .help("the number of times hit the shadow database")
            .register();
    
    @Override
    public void inc(final double amount, final String... labelValues) {
        SHADOW_HIT_TOTAL.inc(amount);
    }
    
    @Override
    public String metricsLabel() {
        return MetricsLabelEnum.SHADOW_HIT_TOTAL.getName();
    }
}

