//  Copyright 2022 Goldman Sachs
//
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.

package org.finos.legend.engine.external.format.flatdata.shared.driver.core;

import org.finos.legend.engine.external.format.flatdata.shared.driver.core.connection.InputStreamConnection;
import org.finos.legend.engine.external.format.flatdata.shared.driver.core.connection.ObjectStreamConnection;
import org.finos.legend.engine.external.format.flatdata.shared.driver.spi.FlatDataProcessingContext;
import org.finos.legend.engine.external.format.flatdata.shared.driver.spi.FlatDataReadDriver;
import org.finos.legend.engine.external.format.flatdata.shared.driver.spi.FlatDataWriteDriver;
import org.finos.legend.engine.external.format.flatdata.shared.model.FlatData;
import org.finos.legend.engine.external.format.flatdata.shared.model.FlatDataSection;
import org.finos.legend.engine.external.format.flatdata.shared.validation.FlatDataDefect;
import org.finos.legend.engine.external.format.flatdata.shared.validation.FlatDataValidator;

import java.util.ArrayList;
import java.util.List;

public class DelimitedWithoutHeadingsDriverDescription extends DelimitedDriverDescription implements FlatDataValidator
{
    @Override
    public String getId()
    {
        return DelimitedWithoutHeadingsReadDriver.ID;
    }

    @Override
    public FlatDataReadDriver newReadDriver(FlatDataSection section, FlatDataProcessingContext context)
    {
        if (!(context.getConnection() instanceof InputStreamConnection))
        {
            throw new RuntimeException("Invalid connection type for this driver");
        }
        return new DelimitedWithoutHeadingsReadDriver(section, context);
    }

    @Override
    public <T> FlatDataWriteDriver<T> newWriteDriver(FlatDataSection section, FlatDataProcessingContext context)
    {
        if (!(context.getConnection() instanceof ObjectStreamConnection))
        {
            throw new RuntimeException("Invalid connection type for this driver");
        }
        return new DelimitedWithoutHeadingsWriteDriver(section, context);
    }

    @Override
    public List<FlatDataDefect> validate(FlatData store, FlatDataSection section)
    {
        List<FlatDataDefect> defects = new ArrayList<>();
        section.getRecordType().getFields().forEach(field ->
        {
            if (field.getAddress() != null && !field.getAddress().matches("\\d+"))
            {
                defects.add(new FlatDataDefect(store, section, "Invalid address for '" + field.getLabel() + "' (Expected column number)"));
            }
        });
        return defects;
    }

    @Override
    public boolean isSelfDescribing()
    {
        return false;
    }
}