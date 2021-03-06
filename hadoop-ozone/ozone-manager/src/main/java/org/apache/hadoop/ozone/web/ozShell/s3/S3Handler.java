/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.hadoop.ozone.web.ozShell.s3;

import org.apache.hadoop.hdds.cli.HddsVersionProvider;
import org.apache.hadoop.ozone.web.ozShell.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;

/**
 * Common interface for S3 command handling.
 */
@CommandLine.Command(mixinStandardHelpOptions = true,
    versionProvider = HddsVersionProvider.class)
public class S3Handler extends Handler {
  protected static final Logger LOG = LoggerFactory.getLogger(S3Handler.class);

  @CommandLine.Option(names = {"--om-service-id"},
      required = false,
      description = "OM Service ID is required to be specified for OM HA" +
          " cluster")
  private String omServiceID;

  public String getOmServiceID() {
    return omServiceID;
  }
}
