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

package org.apache.shardingsphere.data.pipeline.migration.distsql.handler.query;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ShowMigrationSourceStorageUnitsExecutorTest {
    
    @Test
    void assertGetColumnNames() {
        ShowMigrationSourceStorageUnitsExecutor executor = new ShowMigrationSourceStorageUnitsExecutor();
        Collection<String> columns = executor.getColumnNames();
        assertThat(columns.size(), is(12));
        Iterator<String> iterator = columns.iterator();
        assertThat(iterator.next(), is("name"));
        assertThat(iterator.next(), is("type"));
        assertThat(iterator.next(), is("host"));
        assertThat(iterator.next(), is("port"));
        assertThat(iterator.next(), is("db"));
        assertThat(iterator.next(), is("connection_timeout_milliseconds"));
        assertThat(iterator.next(), is("idle_timeout_milliseconds"));
        assertThat(iterator.next(), is("max_lifetime_milliseconds"));
        assertThat(iterator.next(), is("max_pool_size"));
        assertThat(iterator.next(), is("min_pool_size"));
        assertThat(iterator.next(), is("read_only"));
        assertThat(iterator.next(), is("other_attributes"));
    }
}
