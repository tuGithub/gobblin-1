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
package gobblin.runtime.api;

import gobblin.annotation.Alpha;

/**
 * Main class instantiated by the JVM or running framework. Reads application level
 *  configurations, instantiates and runs the Gobblin instance driver.
 */
@Alpha
public interface GobblinInstanceLauncher extends StandardRunControls {
  /**
   * Creates a new Gobblin instance to run Gobblin jobs.
   * @throws IllegalStateException if {@link #isRunning()} is false.*/
  GobblinInstanceDriver getDriver() throws IllegalStateException;
}
