<!---
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License. See accompanying LICENSE file.
-->

# Compose files for local performance tests

This directory contains docker-compose definition for an ozone cluster where
all the metrics are saved to a prometheus instance, and profiling and Jaeger
tracing is turned on and set up.

Prometheus follows a pull based approach where the metrics are published
 on a HTTP endpoint.

Prometheus compatible metrics endpoint can be enabled by setting `hdds.prometheus.endpoint.enabled` property to `true`

## How to start

Start the cluster with `docker-compose`

```
docker-compose up -d
```

Scale datanodes up:

```
docker-compose up -d --scale datanode=3
```

You can enter to the SCM container and start a freon test:

```
docker-compose exec scm bash
ozone freon ockg -n1000
```

Or you can start freon instances in containers (to make it possible to scale them up):
If all the datanodes are started, start the freon instance:

```
docker-compose -f docker-compose.yaml -f freon-ockg.yaml up --scale datanode=3 -d
```

## How to use

You can check the ozone web ui:

OzoneManager: http://localhost:9874
SCM: http://localhost:9876

You can check the ozone metrics from the prometheus web ui.

http://localhost:9090/graph

You can view Grafana dashboards at:

http://localhost:3000

Default dashboards available are:
Ozone - Object Metrics
Ozone - RPC Metrics

You can access the Jaeger UI at:
http://localhost:16686