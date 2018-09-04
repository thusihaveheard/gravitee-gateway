/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.gateway.services.healthcheck.rule;

import io.gravitee.definition.model.Endpoint;
import io.gravitee.definition.model.services.healthcheck.HealthCheckService;
import io.gravitee.definition.model.services.healthcheck.Step;
import io.gravitee.definition.model.services.schedule.Trigger;
import io.gravitee.gateway.services.healthcheck.EndpointRule;

import java.util.List;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author GraviteeSource Team
 */
public class DefaultEndpointRule implements EndpointRule {

    private final String api;
    private final Endpoint endpoint;
    private final HealthCheckService service;
    private final String endpointGroupName;

    public DefaultEndpointRule(final String api, final Endpoint endpoint, final HealthCheckService service,
                               final String endpointGroupName) {
        this.api = api;
        this.endpoint = endpoint;
        this.service = service;
        this.endpointGroupName = endpointGroupName;
    }

    @Override
    public String api() {
        return api;
    }

    @Override
    public Endpoint endpoint() {
        return endpoint;
    }

    @Override
    public Trigger trigger() {
        return service.getTrigger();
    }

    @Override
    public List<Step> steps() {
        return service.getSteps();
    }

    @Override
    public String endpointGroupName() {
        return endpointGroupName;
    }
}
