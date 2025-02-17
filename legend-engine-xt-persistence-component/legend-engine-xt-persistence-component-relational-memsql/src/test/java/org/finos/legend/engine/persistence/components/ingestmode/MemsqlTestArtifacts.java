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

package org.finos.legend.engine.persistence.components.ingestmode;

public class MemsqlTestArtifacts
{
    public static String expectedBaseTableCreateQuery = "CREATE REFERENCE TABLE IF NOT EXISTS `mydb`.`main`(" +
            "`id` INTEGER," +
            "`name` VARCHAR(256)," +
            "`amount` DOUBLE," +
            "`biz_date` DATE," +
            "PRIMARY KEY (`id`, `name`))";

    public static String expectedBaseTableCreateQueryWithUpperCase = "CREATE REFERENCE TABLE IF NOT EXISTS `MYDB`.`MAIN`" +
            "(`ID` INTEGER," +
            "`NAME` VARCHAR(256)," +
            "`AMOUNT` DOUBLE," +
            "`BIZ_DATE` DATE," +
            "PRIMARY KEY (`ID`, `NAME`))";

    public static String expectedBaseTablePlusDigestCreateQuery = "CREATE REFERENCE TABLE IF NOT EXISTS `mydb`.`main`(" +
            "`id` INTEGER," +
            "`name` VARCHAR(256)," +
            "`amount` DOUBLE," +
            "`biz_date` DATE," +
            "`digest` VARCHAR(256)," +
            "PRIMARY KEY (`id`, `name`))";

    public static String expectedBaseTablePlusDigestCreateQueryWithUpperCase = "CREATE REFERENCE TABLE IF NOT EXISTS `MYDB`.`MAIN`(" +
            "`ID` INTEGER," +
            "`NAME` VARCHAR(256)," +
            "`AMOUNT` DOUBLE," +
            "`BIZ_DATE` DATE," +
            "`DIGEST` VARCHAR(256)," +
            "PRIMARY KEY (`ID`, `NAME`))";

    public static String expectedBaseTableCreateQueryWithNoPKs = "CREATE REFERENCE TABLE IF NOT EXISTS `mydb`.`main`(" +
            "`id` INTEGER," +
            "`name` VARCHAR(256)," +
            "`amount` DOUBLE," +
            "`biz_date` DATE," +
            "`digest` VARCHAR(256))";

    public static String expectedBaseTableCreateQueryWithAuditAndNoPKs = "CREATE REFERENCE TABLE IF NOT EXISTS `mydb`.`main`" +
            "(`id` INTEGER,`name` VARCHAR(256),`amount` DOUBLE,`biz_date` DATE,`digest` VARCHAR(256),`batch_update_time` DATETIME)";

    public static String expectedBaseTablePlusDigestPlusUpdateTimestampCreateQuery = "CREATE REFERENCE TABLE IF NOT EXISTS `mydb`.`main`(" +
            "`id` INTEGER," +
            "`name` VARCHAR(256)," +
            "`amount` DOUBLE," +
            "`biz_date` DATE," +
            "`digest` VARCHAR(256)," +
            "`batch_update_time` DATETIME," +
            "PRIMARY KEY (`id`, `name`, `batch_update_time`))";

    public static String expectedStagingCleanupQuery = "DELETE FROM `mydb`.`staging` as stage";

    public static String expectedDropTableQuery = "DROP TABLE IF EXISTS `mydb`.`staging` CASCADE";

    public static String cleanUpMainTableSql = "DELETE FROM `mydb`.`main` as sink";
    public static String cleanupMainTableSqlUpperCase = "DELETE FROM `MYDB`.`MAIN` as sink";

    public static String expectedMainTableBatchIdBasedCreateQuery = "CREATE REFERENCE TABLE IF NOT EXISTS `mydb`.`main`(" +
            "`id` INTEGER,`name` VARCHAR(256),`amount` DOUBLE,`biz_date` DATE,`digest` VARCHAR(256)," +
            "`batch_id_in` INTEGER,`batch_id_out` INTEGER,PRIMARY KEY (`id`, `name`, `batch_id_in`))";

    public static String expectedMetadataTableCreateQuery = "CREATE REFERENCE TABLE IF NOT EXISTS batch_metadata" +
            "(`table_name` VARCHAR(255)," +
            "`batch_start_ts_utc` DATETIME," +
            "`batch_end_ts_utc` DATETIME," +
            "`batch_status` VARCHAR(32)," +
            "`table_batch_id` INTEGER)";

    public static String expectedMetadataTableCreateQueryWithUpperCase = "CREATE REFERENCE TABLE IF NOT EXISTS BATCH_METADATA" +
            "(`TABLE_NAME` VARCHAR(255)," +
            "`BATCH_START_TS_UTC` DATETIME," +
            "`BATCH_END_TS_UTC` DATETIME," +
            "`BATCH_STATUS` VARCHAR(32)," +
            "`TABLE_BATCH_ID` INTEGER)";

    public static String expectedMainTableBatchIdBasedCreateQueryWithUpperCase = "CREATE REFERENCE TABLE IF NOT EXISTS `MYDB`.`MAIN`" +
            "(`ID` INTEGER,`NAME` VARCHAR(256),`AMOUNT` DOUBLE,`BIZ_DATE` DATE,`DIGEST` VARCHAR(256)," +
            "`BATCH_ID_IN` INTEGER,`BATCH_ID_OUT` INTEGER,PRIMARY KEY (`ID`, `NAME`, `BATCH_ID_IN`))";

    public static String expectedMetadataTableIngestQuery = "INSERT INTO batch_metadata (`table_name`, `table_batch_id`, `batch_start_ts_utc`, `batch_end_ts_utc`, `batch_status`)" +
            " (SELECT 'main',(SELECT COALESCE(MAX(batch_metadata.`table_batch_id`),0)+1 FROM batch_metadata as batch_metadata WHERE batch_metadata.`table_name` = 'main'),'2000-01-01 00:00:00',CURRENT_TIMESTAMP(),'DONE')";

    public static String expectedMetadataTableIngestQueryWithUpperCase = "INSERT INTO BATCH_METADATA (`TABLE_NAME`, `TABLE_BATCH_ID`, `BATCH_START_TS_UTC`, `BATCH_END_TS_UTC`, `BATCH_STATUS`)" +
            " (SELECT 'main',(SELECT COALESCE(MAX(batch_metadata.`TABLE_BATCH_ID`),0)+1 FROM BATCH_METADATA as batch_metadata WHERE batch_metadata.`TABLE_NAME` = 'main'),'2000-01-01 00:00:00',CURRENT_TIMESTAMP(),'DONE')";
    
    public static String expectedMetadataTableIngestQueryWithPlaceHolders = "INSERT INTO batch_metadata (`table_name`, `table_batch_id`, `batch_start_ts_utc`, `batch_end_ts_utc`, `batch_status`) " +
            "(SELECT 'main',{BATCH_ID_PATTERN},'{BATCH_START_TS_PATTERN}','{BATCH_END_TS_PATTERN}','DONE')";

    public static String expectedMainTableCreateQuery = "CREATE REFERENCE TABLE IF NOT EXISTS `mydb`.`main`" +
            "(`id` INTEGER," +
            "`name` VARCHAR(256)," +
            "`amount` DOUBLE," +
            "`biz_date` DATE," +
            "`digest` VARCHAR(256)," +
            "`batch_id_in` INTEGER," +
            "`batch_id_out` INTEGER," +
            "`batch_time_in` DATETIME," +
            "`batch_time_out` DATETIME," +
            "PRIMARY KEY (`id`, `name`, `batch_id_in`, `batch_time_in`))";

    public static String expectedMainTableCreateQueryWithUpperCase = "CREATE REFERENCE TABLE IF NOT EXISTS `MYDB`.`MAIN`" +
            "(`ID` INTEGER," +
            "`NAME` VARCHAR(256)," +
            "`AMOUNT` DOUBLE," +
            "`BIZ_DATE` DATE," +
            "`DIGEST` VARCHAR(256)," +
            "`BATCH_ID_IN` INTEGER," +
            "`BATCH_ID_OUT` INTEGER," +
            "`BATCH_TIME_IN` DATETIME," +
            "`BATCH_TIME_OUT` DATETIME," +
            "PRIMARY KEY (`ID`, `NAME`, `BATCH_ID_IN`, `BATCH_TIME_IN`))";

    public static String expectedMainTableTimeBasedCreateQuery = "CREATE REFERENCE TABLE IF NOT EXISTS `mydb`.`main`(" +
            "`id` INTEGER,`name` VARCHAR(256),`amount` DOUBLE,`biz_date` DATE,`digest` VARCHAR(256)," +
            "`batch_time_in` DATETIME,`batch_time_out` DATETIME,PRIMARY KEY (`id`, `name`, `batch_time_in`))";

    public static String expectedMainTableTimeBasedCreateQueryWithUpperCase = "CREATE REFERENCE TABLE IF NOT EXISTS `MYDB`.`MAIN`" +
            "(`ID` INTEGER,`NAME` VARCHAR(256),`AMOUNT` DOUBLE,`BIZ_DATE` DATE,`DIGEST` VARCHAR(256)," +
            "`BATCH_TIME_IN` DATETIME,`BATCH_TIME_OUT` DATETIME,PRIMARY KEY (`ID`, `NAME`, `BATCH_TIME_IN`))";

}
