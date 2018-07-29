package com.sujeetkumar.catapp.migrations.files;

import com.sujeetkumar.catapp.migrations.AbstractMigration;
import com.sujeetkumar.catapp.migrations.DatabaseTableName;

// used from MigrationUtils reflection call
@SuppressWarnings("unused")
public class Migration1 extends AbstractMigration {

    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public void addStatements() {
        statements.add("CREATE TABLE " + DatabaseTableName.CATS + "(" +
                "   id TEXT PRIMARY KEY," +
                "   image_url TEXT," +
                "   provider_name TEXT" +
                ");");
    }
}
