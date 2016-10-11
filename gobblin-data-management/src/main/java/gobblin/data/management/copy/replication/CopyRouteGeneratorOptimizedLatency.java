/*
 * Copyright (C) 2014-2016 LinkedIn Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the
 * License at  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied.
 */

/**
 * Used to generate the {@link CopyRoute} based on the {@link DataFlowTopology} optimized for latency.
 * 
 * In Pull mode, query multiple data sources and pick the data source with the highest watermark
 */
package gobblin.data.management.copy.replication;

import java.util.Collections;
import java.util.List;

import com.google.common.base.Optional;

import gobblin.annotation.Alias;


/**
 * In Pull mode, Optimized for data replication latency: pick the highest watermark from all the data sources
 * @author mitu
 *
 */

@Alias(value = "OptimizedLatency")
public class CopyRouteGeneratorOptimizedLatency extends CopyRouteGeneratorOptimizer {
  /**
   * 
   * @param routes
   * @return the {@link CopyRoute} which has the highest watermark
   */
  @Override
  public Optional<CopyRoute> getOptimizedCopyRoute(List<CopyRoute> routes) {
    CopyRoute preferred = Collections.max(routes, new CopyRouteComparatorBySourceWatermark());
    return Optional.of(preferred);
  }
}
