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

package org.apache.shardingsphere.data.pipeline.opengauss.prepare.datasource;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.data.pipeline.core.preparer.datasource.option.DialectPipelineJobDataSourcePrepareOption;

import java.util.Arrays;
import java.util.Collection;

/**
 * Pipeline job data source prepare option for openGauss.
 */
@Slf4j
public final class OpenGaussPipelineJobDataSourcePrepareOption implements DialectPipelineJobDataSourcePrepareOption {
    
    @Override
    public boolean isSupportIfNotExistsOnCreateSchema() {
        return false;
    }
    
    @Override
    public Collection<String> getIgnoredExceptionMessages() {
        return Arrays.asList("multiple primary keys for table", "already exists");
    }
    
    @Override
    public String getDatabaseType() {
        return "openGauss";
    }
}
