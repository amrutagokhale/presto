/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.plugin.jdbc;

import com.facebook.presto.spi.SchemaTableName;
import com.facebook.presto.spi.security.ConnectorAccessControl;
import com.facebook.presto.spi.security.Identity;
import com.facebook.presto.spi.security.Privilege;

import javax.inject.Inject;

import static com.facebook.presto.spi.security.AccessDeniedException.denyDropTable;
import static java.util.Objects.requireNonNull;

public class NoAccessControl
        implements ConnectorAccessControl
{
    private final boolean allowDropTable;

    @Inject
    public NoAccessControl(JdbcMetadataConfig jdbcMetadataConfig)
    {
        requireNonNull(jdbcMetadataConfig, "jdbcMetadataConfig is null");
        allowDropTable = jdbcMetadataConfig.isAllowDropTable();
    }

    @Override
    public void checkCanCreateTable(Identity identity, SchemaTableName tableName)
    {
    }

    @Override
    public void checkCanDropTable(Identity identity, SchemaTableName tableName)
    {
        if (!allowDropTable) {
            denyDropTable(tableName.toString());
        }
    }

    @Override
    public void checkCanRenameTable(Identity identity, SchemaTableName tableName, SchemaTableName newTableName)
    {
    }

    @Override
    public void checkCanAddColumn(Identity identity, SchemaTableName tableName)
    {
    }

    @Override
    public void checkCanRenameColumn(Identity identity, SchemaTableName tableName)
    {
    }

    @Override
    public void checkCanSelectFromTable(Identity identity, SchemaTableName tableName)
    {
    }

    @Override
    public void checkCanInsertIntoTable(Identity identity, SchemaTableName tableName)
    {
    }

    @Override
    public void checkCanDeleteFromTable(Identity identity, SchemaTableName tableName)
    {
    }

    @Override
    public void checkCanCreateView(Identity identity, SchemaTableName viewName)
    {
    }

    @Override
    public void checkCanDropView(Identity identity, SchemaTableName viewName)
    {
    }

    @Override
    public void checkCanSelectFromView(Identity identity, SchemaTableName viewName)
    {
    }

    @Override
    public void checkCanCreateViewWithSelectFromTable(Identity identity, SchemaTableName viewName, SchemaTableName tableName)
    {
    }

    @Override
    public void checkCanCreateViewWithSelectFromView(Identity identity, SchemaTableName viewName)
    {
    }

    @Override
    public void checkCanSetCatalogSessionProperty(Identity identity, String propertyName)
    {
    }

    @Override
    public void checkCanGrantTablePrivilege(Identity identity, Privilege privilege, SchemaTableName tableName)
    {
    }

    @Override
    public void checkCanRevokeTablePrivilege(Identity identity, Privilege privilege, SchemaTableName tableName)
    {
    }
}
