// Copyright 2021 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.engine.protocol.pure.v1.model.executionPlan.nodes;

import org.finos.legend.engine.protocol.pure.v1.model.packageableElement.store.service.model.HttpMethod;
import org.finos.legend.engine.protocol.pure.v1.model.packageableElement.store.service.model.SecurityScheme;
import org.finos.legend.engine.protocol.pure.v1.model.packageableElement.store.service.model.ServiceParameter;

import java.util.List;

public class RestServiceExecutionNode extends ExecutionNode
{
    public String url;
    public HttpMethod method;
    public String mimeType;
    public List<ServiceParameter> params;
    public RequestBodyDescription requestBodyDescription;
    public List<SecurityScheme> securitySchemes;

    @Override
    public <T> T accept(ExecutionNodeVisitor<T> executionNodeVisitor)
    {
        return executionNodeVisitor.visit(this);
    }
}
