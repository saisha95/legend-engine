// Copyright 2022 Goldman Sachs
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

package org.finos.legend.engine.persistence.components.physicalplan;

import java.util.ArrayList;
import java.util.List;

public class PhysicalPlanNodes<T> implements PhysicalPlanNode
{
    private final List<T> nodes = new ArrayList<>();

    public List<T> nodes()
    {
        return nodes;
    }

    @Override
    public void push(Object node)
    {
        nodes.add((T) node);
    }
}
