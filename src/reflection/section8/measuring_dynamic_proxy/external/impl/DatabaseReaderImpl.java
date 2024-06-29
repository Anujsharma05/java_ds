package reflection.section8.measuring_dynamic_proxy.external.impl;

import java.io.IOException;
import reflection.section8.measuring_dynamic_proxy.external.DatabaseReader;

public final class DatabaseReaderImpl implements DatabaseReader {
    @Override
    public int countRowsInTable(String tableName) throws InterruptedException, IOException {
        System.out.println(String.format("DatabaseReaderImpl - counting rows in table %s", tableName));
//        Thread.sleep(1000);
//        return 50;
        throw new IOException("Error while counting rows in table: " + tableName);
    }

    @Override
    public String[] readRow(String sqlQuery) throws InterruptedException {
        System.out.println(String.format("DatabaseReaderImpl - Executing SQL query : %s", sqlQuery));

        Thread.sleep(1500);
        return new String[]{"column1", "column2", "column3"};
    }
}
