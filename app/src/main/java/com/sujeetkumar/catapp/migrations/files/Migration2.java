package com.sujeetkumar.catapp.migrations.files;

import com.sujeetkumar.catapp.migrations.AbstractMigration;
import com.sujeetkumar.catapp.migrations.DatabaseTableName;

// used from MigrationUtils reflection call
@SuppressWarnings("unused")
public class Migration2 extends AbstractMigration {

    @Override
    public int getVersion() {
        return 2;
    }

    @Override
    public void addStatements() {
        addStatement("ALTER TABLE " + DatabaseTableName.CATS + " ADD COLUMN name TEXT");
    }
}
