/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.portfolio.client.api.v2.search;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.apache.fineract.infrastructure.core.service.PagedRequest;
import org.apache.fineract.portfolio.client.service.search.domain.ClientSearchData;
import org.apache.fineract.portfolio.client.service.search.domain.ClientTextSearch;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Path("/v2/clients")
@Component
@Tag(name = "ClientSearchV2")
@RequiredArgsConstructor
public class ClientSearchV2ApiResource implements ClientSearchV2Api {

    private final ClientSearchV2ApiDelegate delegate;

    @Override
    @POST
    @Path("search")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    @Operation(summary = "Search Clients by text")
    public Page<ClientSearchData> searchByText(@Parameter PagedRequest<ClientTextSearch> request) {
        return delegate.searchByText(request);
    }
}
